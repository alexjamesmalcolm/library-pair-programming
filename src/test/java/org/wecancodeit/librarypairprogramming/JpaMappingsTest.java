package org.wecancodeit.librarypairprogramming;

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
}
