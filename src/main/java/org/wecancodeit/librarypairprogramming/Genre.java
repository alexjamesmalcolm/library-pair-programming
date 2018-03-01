package org.wecancodeit.librarypairprogramming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private long id;
	private String genre;
	
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
}
