package com.manager.author.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manager.author.api.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findByNameContains(String name);
}
