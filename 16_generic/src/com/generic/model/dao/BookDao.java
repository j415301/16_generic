package com.generic.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.generic.model.vo.Book;

public class BookDao {
	
	private static List<Book> totalBook = new ArrayList();
	
	static {
		totalBook.add(new Book("one","������",10000,0.2));
		totalBook.add(new Book("two","�����",15000,0.5));
		totalBook.add(new Book("three","������",30000,1.2));
		totalBook.add(new Book("four","�迹��",20000,2.2));
	}
	
	public static List<Book> getTotalBook(){
		return totalBook;
	}

}
