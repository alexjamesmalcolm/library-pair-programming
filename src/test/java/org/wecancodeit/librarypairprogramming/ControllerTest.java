package org.wecancodeit.librarypairprogramming;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	private Author author;
	
	@Mock
	private Author anotherAuthor;

	@Mock
	private GenreRepository genreRepo;
	
	@Mock
	private AuthorRepository authorRepo;

	@Mock
	private Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddGenresToModel() {
		Collection<Genre> allGenres = asList(genre, anotherGenre);
		when(genreRepo.findAll()).thenReturn(allGenres);
		
		underTest.showGenres(model);
		
		verify(model).addAttribute("genres", allGenres);
	}
	
	@Test
	public void shouldHaveShowGenresReturnAllGenresView() {
		String templateName = underTest.showGenres(model);
		Assert.assertThat(templateName, Matchers.is("all-genres-view"));
	}
	
	@Test
	public void shouldAddAuthorsToModel() {
		Collection<Author> allAuthors = asList(author, anotherAuthor);
		when(authorRepo.findAll()).thenReturn(allAuthors);
		
		underTest.showAuthors(model);
		
		verify(model).addAttribute("authors", allAuthors);
	}
	
	// @Test
	// public void shouldAddBooksToModel() {}
}
