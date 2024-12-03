package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/book/insert")
	public void insert() {		
	}
	
	@PostMapping("/book/insert")
	public String insertSumbit(Book book) {		
		service.save(book);
		return "redirect:/";
	}
	
	@PostMapping("/api/book")
	@ResponseBody
	public  String  insertSumbitAPI(@RequestBody Book book) {		
		service.save(book);
		return "ok";
	}
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("list", service.findAll());
		return "book/list";
	}
	
	@GetMapping("/api/books")
	@ResponseBody
	public List<Book> book() {
		return service.findAll();		
	}
}
