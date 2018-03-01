package org.wecancodeit.librarypairprogramming;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AuthorTest {
	
	@Test
	public void shouldReturnFirstNameLauren() {
		String firstName = "Lauren";
		Author underTest = new Author(firstName, "");
		String returnedName = underTest.getFirstName();
		assertThat(returnedName, is(firstName));
	}
	
	@Test
	public void shouldReturnFirstNameBert() {
		String firstName = "Bert";
		Author underTest = new Author(firstName, "");
		String returnedName = underTest.getFirstName();
		assertThat(returnedName, is(firstName));
	}
	
	@Test
	public void shouldReturnLastNameMalcolm() {
		String lastName = "Malcolm";
		Author underTest = new Author("", lastName);
		String actual = underTest.getLastName();
		assertThat(actual, is(lastName));
	}
}
