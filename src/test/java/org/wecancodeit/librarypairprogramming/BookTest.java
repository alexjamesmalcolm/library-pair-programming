package org.wecancodeit.librarypairprogramming;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {

	@Test
	public void shouldHaveTitleHeadFirstJava() {
		String title = "Head First Java";
		Book underTest = new Book(title);
		String actual = underTest.getTitle();
		Assert.assertThat(actual, Matchers.is(title));
	}
}
