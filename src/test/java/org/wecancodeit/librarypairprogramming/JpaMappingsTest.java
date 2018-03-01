package org.wecancodeit.librarypairprogramming;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private GenreRepository genreRepo;

	@Resource
	private BookRepository bookRepo;

	@Resource
	private AuthorRepository authorRepo;

	@Test
	public void shouldSuccessfullyInitializeJpa() {
	}

	@Test
	public void shouldSaveAndLoadGenre() {
		Genre genre = new Genre("Fiction");
		genre = genreRepo.save(genre);

		long genreId = genre.getId();

		genre = genreRepo.findOne(genreId);
		assertThat(genreId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveBookToGenreRelationship() {
		Genre genre = new Genre("Fiction");
		genreRepo.save(genre);
		long genreId = genre.getId();

		Book first = new Book("first", genre);
		bookRepo.save(first);

		Book second = new Book("second", genre);
		bookRepo.save(second);

		entityManager.flush();
		entityManager.clear();

		genre = genreRepo.findOne(genreId);
		assertThat(genre.getBooks(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author = authorRepo.save(new Author("firstname", "lastname"));
		long authorId = author.getId();

		author = authorRepo.findOne(authorId);
		assertThat(author.getId(), is(authorId));
	}

	@Test
	public void shouldEstablishAuthorToBookRelationship() {
		Genre nonFiction = genreRepo.save(new Genre("Nonfiction"));
		Book java = bookRepo.save(new Book("Head First Java", nonFiction));
		Book python = bookRepo.save(new Book("Head First Python", nonFiction));

		Author author = new Author("Alex", "Malcolm", java, python);
		author = authorRepo.save(author);
		long authorId = author.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		author = authorRepo.findOne(authorId);
		assertThat(author.getBooks(), containsInAnyOrder(java, python));
	}

}
