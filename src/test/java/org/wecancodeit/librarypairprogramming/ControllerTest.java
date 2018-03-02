package org.wecancodeit.librarypairprogramming;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

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
	private Book book;

	@Mock
	private Book anotherBook;

	@Mock
	private GenreRepository genreRepo;

	@Mock
	private AuthorRepository authorRepo;

	@Mock
	private Model model;

	@Mock
	private BookRepository bookRepo;

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
		assertThat(templateName, is("all-genres-view"));
	}

	@Test
	public void shouldAddAuthorsToModel() {
		Collection<Author> allAuthors = asList(author, anotherAuthor);
		when(authorRepo.findAll()).thenReturn(allAuthors);

		underTest.showAuthors(model);

		verify(model).addAttribute("authors", allAuthors);
	}

	@Test
	public void shouldHaveShowAuthorsReturnAllAuthorsView() {
		String templateName = underTest.showAuthors(model);
		assertThat(templateName, is("all-authors-view"));
	}

	@Test
	public void shouldAddBooksToModel() {
		Collection<Book> allBooks = asList(book, anotherBook);
		when(bookRepo.findAll()).thenReturn(allBooks);
		
		underTest.showBooks(model);
		
		verify(model).addAttribute("books", allBooks);
	}
}
