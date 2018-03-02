package org.wecancodeit.librarypairprogramming;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {
	
	@Resource
	private GenreRepository genreRepo;
	
	@Resource
	private AuthorRepository authorRepo;
	
	@Resource
	private BookRepository bookRepo;

	public String showGenres(Model model) {
		Collection<Genre> genres = (Collection<Genre>) genreRepo.findAll();
		model.addAttribute("genres", genres);
		return "genres";
	}

	public String showAuthors(Model model) {
		Collection<Author> authors = (Collection<Author>) authorRepo.findAll();
		model.addAttribute("authors", authors);
		return "authors";
	}

	public String showBooks(Model model) {
		Collection<Book> books = (Collection<Book>) bookRepo.findAll();
		model.addAttribute("books", books);
		return "books";
	}

}
