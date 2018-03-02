package org.wecancodeit.librarypairprogramming;

import static java.util.Arrays.asList;

import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ControllerTest {
	
	@InjectMocks
	private Controller underTest;
	
	@Mock
	private Genre genre;
	
	@Mock
	private Genre anotherGenre;

	@Mock
	private GenreRepository genreRepo;

	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddGenresToModel() {
		Collection<Genre> allGenres = asList(genre, anotherGenre);
		Mockito.when(genreRepo.findAll()).thenReturn(allGenres);
		
		underTest.showGenres(model);
		
		Mockito.verify(model).addAttribute("genres", allGenres);
	}
	
	@Test
	public void shouldHaveShowGenresReturnAllGenresView() {
		String templateName = underTest.showGenres(model);
		Assert.assertThat(templateName, Matchers.is("all-genres-view"));
	}
	
//	@Test
//	public void shouldAddAuthorsToModel() {}
	
	// @Test
	// public void shouldAddBooksToModel() {}
}
