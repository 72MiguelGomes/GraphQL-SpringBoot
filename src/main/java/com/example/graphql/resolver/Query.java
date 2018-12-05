package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repo.AuthorRepository;
import com.example.graphql.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {

  private final BookRepository bookRepository;

  private final AuthorRepository authorRepository;

  @Autowired
  public Query(BookRepository bookRepository,
      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return this.authorRepository.findAll();
  }

  public Iterable<Book> findAllBooks() {
    return this.bookRepository.findAll();
  }

  public Long countAuthors() {
    return this.authorRepository.count();
  }

  public Long countBooks() {
    return this.bookRepository.count();
  }

}
