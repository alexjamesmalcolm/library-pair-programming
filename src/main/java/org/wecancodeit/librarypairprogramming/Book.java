package org.wecancodeit.librarypairprogramming;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;

	private String title;
	@ManyToOne
	private Genre genre;

	@ManyToMany
	private Collection<Author> authors;

	@SuppressWarnings("unused")
	private Book() {
	}

	public Book(String title, Genre genre) {// , Author...authors) {
		this.title = title;
		this.genre = genre;
		// this.authors = new HashSet<>(asList(authors));
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return id + ":" + title + ", " + genre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Book other = (Book) obj;
		return id == other.id;
	}

	public long getId() {
		return id;
	}
}
