package com.library.service;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) { this.bookRepository = bookRepository; }
    public void manage() { bookRepository.save(); }
}
