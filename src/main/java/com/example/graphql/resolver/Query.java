package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repo.AuthorRepository;
import com.example.graphql.repo.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {

  private final BookRespository bookRespository;

  private final AuthorRepository authorRepository;

  @Autowired
  public Query(BookRespository bookRespository,
      AuthorRepository authorRepository) {
    this.bookRespository = bookRespository;
    this.authorRepository = authorRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return this.authorRepository.findAll();
  }

  public Iterable<Book> findAllBooks() {
    return this.bookRespository.findAll();
  }

  public Long countAuthors() {
    return this.authorRepository.count();
  }

  public Long countBooks() {
    return this.bookRespository.count();
  }

}
