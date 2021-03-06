package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repo.AuthorRepository;
import com.example.graphql.repo.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

  private final BookRepository bookRepository;

  private final AuthorRepository authorRepository;

  public Mutation(BookRepository bookRepository,
      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Author newAuthor(String firstName, String lastName) {
    final Author author = new Author(firstName, lastName);

    return this.authorRepository.save(author);
  }

  public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {

    Book book = new Book(title, isbn, pageCount, new Author(authorId));

    return this.bookRepository.save(book);
  }

  public boolean deleteBook(Long bookId) {
    this.bookRepository.delete(bookId);
    return true;
  }

  public Book updateBookPageCount(Integer pageCount, Long bookId) {
    final Book book = this.bookRepository.findOne(bookId);

    book.setPageCount(pageCount);

    return this.bookRepository.save(book);
  }
}
