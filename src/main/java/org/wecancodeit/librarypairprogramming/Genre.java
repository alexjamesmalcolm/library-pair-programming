package org.wecancodeit.librarypairprogramming;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private long id;
	private String genre;
	
	@OneToMany(mappedBy = "genre")
	private Collection<Book> books;
	
	public Genre() {}

	public Genre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public long getId() {
		return id;
	}

	public Collection<Book> getBooks() {
		return books;
	}
	
	@Override
	public String toString() {
		return id + ":" + genre;
	}
}
