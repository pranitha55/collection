package com.capgemini.librarymanagementsystem.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class BookDataBase {
	
	/*
	 * static List<Book> book=new ArrayList<Book>(); public static final
	 * HashMap<Integer,ArrayList<Book>> hm=new HashMap<Integer,ArrayList<Book>>();
	 * 
	 * 
	 * Book b1=new Book(1,"java","bloch","eleventh"); Book b2=new
	 * Book(1,"Drawing","rsagarwal","eighth"); Book b3=new
	 * Book(1,"Chemistry","opgupta","seventh");
	 */
	Book b=new Book();
	
	public static final LinkedList<Book> BOOK=new LinkedList<Book>();
	public static final LinkedList<Admin> ADMIN=new LinkedList<Admin>();
	public static final LinkedList<User> USER=new LinkedList<User>();
	public static final LinkedList<RequestBean> REQUEST = new LinkedList<RequestBean>();
	
	

	
	
	

}
