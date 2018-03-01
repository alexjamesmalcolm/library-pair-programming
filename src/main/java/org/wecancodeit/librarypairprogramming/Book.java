package org.wecancodeit.librarypairprogramming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	private String title;
	@ManyToOne
	private Genre genre;

	private Book() {}
	
	public Book(String title, Genre genre) {
		this.title = title;
		this.genre = genre;
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
}
