package com.manager.author.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.manager.author.api.models.Author;
import com.manager.author.api.repository.AuthorRepository;


@RestController
@RequestMapping(value = "/api/author")
@CrossOrigin(origins="*")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	private static Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Author>> getAuthor (){
		
		logger.info("AuthorController.getAuthor: consulting list");
		List<Author> list = new ArrayList<>();
		try {
			list = this.authorRepository.findAll();
			if(list.isEmpty()) {
				logger.error("AuthorController.getAuthor: list Empty");
				return ResponseEntity.notFound().build();
			}			
		} catch (Exception e) {
			logger.error("AuthorController.getAuthor error msg: {}",e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
		logger.info("AuthorController.getAuthor: Result {}",list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Author> getAuthor (@PathVariable("id") Long id){
		logger.info("AuthorController.getAuthor: query by id");
		Optional<Author> author = Optional.of(new Author());
		
		try {
			 author = this.authorRepository.findById(id);			
			if(!author.isPresent()) {
				logger.error("AuthorController.getAuthor: Empty");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Not Found");
			}
		} catch (Exception e) {
			logger.error("AuthorController.getAuthor: msgError: {}",e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
		
		logger.info("AuthorController.getAuthor: Result: {}",author.get());
		return ResponseEntity.ok(author.get());
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Author saveAuthor (@Validated @RequestBody Author author) {
		logger.info("AuthorController.saveAuthor: saving a resource");
		
		try {
			if(author.getName()==null || author.getName().isBlank()) {
				logger.error("AuthorController.saveAuthor: MsgError: name not set");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"name not set");
			}
		} catch (Exception e) {
			logger.error("AuthorController.saveAuthor: ErrorMsg: {}",e.getMessage());
		}
		
		logger.info("AuthorController.saveAuthor: Result: {}",author);
		return this.authorRepository.save(author);
	}
	
	@PutMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Author updateAuthor (@Validated @RequestBody Author author) {		
		logger.info("AuthorController.updateAuthor: updating a resource");
		if(author.getName()==null || author.getName().isBlank()) {
			logger.error("AuthorController.updateAuthor: name not set");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"name not set");
		}		
		logger.info("AuthorController.updateAuthor: Result: {}",author);
		return this.authorRepository.save(author);
	}
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAuthor (@PathVariable Long id) {
		logger.info("AuthorController.deleteAuthor: deleting a resource id: ",id);		
		try {
			this.authorRepository.deleteById(id);
		} catch (DataIntegrityViolationException exception) {
			logger.error("AuthorController.deleteAuthor: Cannot delete or update a parent row: a foreign key constraint fails");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Cannot delete or update a parent row: a foreign key constraint fails");
		}catch (Exception e) {
			logger.error("AuthorController.deleteAuthor: ErrorMsg: ",e.getMessage());
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage());
		}		
	}
	
	@GetMapping("/search/contains/{name}")
	public ResponseEntity<List<Author>> getAuthorByName (@PathVariable String name){
		logger.info("AuthorController.getAuthorByName: consulting list");
		List<Author> list = new ArrayList<>();
		try {
			list = this.authorRepository.findByNameContains(name);
			if(list.isEmpty()) {
				logger.error("AuthorController.getAuthorByName: list empty");
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			logger.error("AuthorController.getAuthorByName: ErrorMsg: ",e.getMessage());
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
		logger.info("AuthorController.getAuthorByName: Result: {}",list);
		return ResponseEntity.ok(list);
	}
}
