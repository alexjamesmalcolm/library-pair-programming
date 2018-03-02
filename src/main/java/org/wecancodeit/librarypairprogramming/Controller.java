package org.wecancodeit.librarypairprogramming;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class Controller {
	
	@Resource
	private GenreRepository genreRepo;

	public String showGenres(Model model) {
		Collection<Genre> genres = (Collection<Genre>) genreRepo.findAll();
		model.addAttribute("genres", genres);
		return "all-genres-view";
	}

}
