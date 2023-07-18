package com.manager.author.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.manager.author.api.models.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
	List<Book> findByNameContainingAndDescriptonContaining(String name, String descripton);
}
