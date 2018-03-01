package org.wecancodeit.librarypairprogramming;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GenreTest {
	
	@Test
	public void shouldHaveGenreFiction() {
		String genre = "Fiction";
		Genre underTest = new Genre(genre);
		String returnedGenre = underTest.getGenre();
		assertThat(returnedGenre, is("Fiction"));
	}
}
