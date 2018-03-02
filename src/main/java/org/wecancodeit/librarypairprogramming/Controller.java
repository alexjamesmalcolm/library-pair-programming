package org.wecancodeit.librarypairprogramming;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {
	
	@Resource
	private GenreRepository genreRepo;
	
	@Resource
	private AuthorRepository authorRepo;

	public String showGenres(Model model) {
		Collection<Genre> genres = (Collection<Genre>) genreRepo.findAll();
		model.addAttribute("genres", genres);
		return "all-genres-view";
	}

	public void showAuthors(Model model) {
		Collection<Author> authors = (Collection<Author>) authorRepo.findAll();
		model.addAttribute("authors", authors);
	}

}
