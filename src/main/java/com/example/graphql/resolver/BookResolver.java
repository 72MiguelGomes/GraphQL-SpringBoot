package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repo.AuthorRepository;
import java.text.MessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  private final AuthorRepository authorRepository;

  @Autowired
  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Book book) {
    return this.authorRepository.findOne(book.getAuthor().getId());
  }

  public String getDescription(Book book) {
    return MessageFormat.format("{0} - {1}", book.getId(), book.getTitle());
  }
}
