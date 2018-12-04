package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repo.AuthorRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class BookResolver implements GraphQLResolver<Book> {

  private final AuthorRepository authorRepository;

  @Autowired
  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Book book) {
    Optional<Author> authorOpt = this.authorRepository.findById(book.getAuthor().getId());

    // TODO: Fix this
    return authorOpt.orElse(null);
  }
}
