package org.wecancodeit.librarypairprogramming;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookTest {

	@Test
	public void shouldHaveTitleHeadFirstJava() {
		String title = "Head First Java";
		Book underTest = new Book(title, null);
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
	
	@Test
	public void shouldHaveTitleHeadFirstPython() {
		String title = "Head First Python";
		Book underTest = new Book(title, null);
		String actual = underTest.getTitle();
		assertThat(actual, is(title));
	}
}
