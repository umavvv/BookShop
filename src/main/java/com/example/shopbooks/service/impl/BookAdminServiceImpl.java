package com.example.shopbooks.service.impl;

import com.example.shopbooks.dto.BookDto;
import com.example.shopbooks.entity.Book;
import com.example.shopbooks.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookAdminServiceImpl {
    private BookDto bookDto = new BookDto();
    public final BookRepository bookRepository;

    public BookAdminServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto bookDtoConvert(Book book) {
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setImage(book.getImage());
        bookDto.setGenre(book.getGenre());
        return bookDto;
    }

    public BookDto findById(Long id) {
        bookRepository.findById(id).get();
        return bookDto;

    }

    public BookDto bookSave(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setImage(bookDto.getImage());
        book.setPrice(bookDto.getPrice());
        bookRepository.save(book);
        return bookDto;
    }

    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(this::bookDtoConvert)
                .collect(Collectors.toList());
    }

    public String deleteById(Long id) {
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
