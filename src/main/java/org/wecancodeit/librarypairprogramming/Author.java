package org.wecancodeit.librarypairprogramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	private String lastName;

	@ManyToMany
	private Collection<Book> books;

	@SuppressWarnings("unused")
	private Author() {
	}

	public Author(String firstName, String lastName, Book... books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new HashSet<>(Arrays.asList(books));
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getId() {
		return id;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		return id + ":" + firstName + ", " + lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((Author) obj).id;
	}

}
