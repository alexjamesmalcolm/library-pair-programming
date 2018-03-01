package org.wecancodeit.librarypairprogramming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;

	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

}
