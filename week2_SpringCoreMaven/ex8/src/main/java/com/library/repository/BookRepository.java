package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	public void manage() {
		System.out.println("managing the repo...");
	}

}
