package com.dsoumaila.app.repository;

import com.dsoumaila.app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Book repository
 */
@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {
}
