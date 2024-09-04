package com.example.shopbooks.controller;

import com.example.shopbooks.dto.BookDto;
import com.example.shopbooks.service.impl.BookAdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller()
public class ControllerBook {
    public final BookAdminServiceImpl bookAdminServiceImpl;

    public ControllerBook(BookAdminServiceImpl bookAdminServiceImpl) {
        this.bookAdminServiceImpl = bookAdminServiceImpl;
    }

    @GetMapping("/bookList")
    public String findAll(Model model) {
        List<BookDto> bookList = bookAdminServiceImpl.findAll();
        model.addAttribute("bookList", bookList);
        return "book-list";
    }

    @GetMapping("/bookSave")
    public String registerBook(Model modelAndView) {
        modelAndView.addAttribute("book", new BookDto());
        return "book-save";
    }

    @PostMapping("/book-save")
    public String saveBookDB(BookDto book) {
        bookAdminServiceImpl.bookSave(book);
        return "redirect:/bookList";
    }

    @GetMapping("/bookDelete")
    public String deleteBookBD(Long id) {
        bookAdminServiceImpl.findById(id);
        bookAdminServiceImpl.deleteById(id);
        return "redirect:/bookList";
    }
}
