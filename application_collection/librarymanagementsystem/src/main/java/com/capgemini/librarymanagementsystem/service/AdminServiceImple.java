package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;

public class AdminServiceImple implements AdminService {

	private AdminDAO dao = LMSFactory.getAdminDAO();

	@Override
	public boolean registerAdmin(Admin admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public boolean addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int id) {
		return dao.removeBook(id);
	}

	@Override
	public int updateBook(int id) {
		return dao.updateBook(id);
	}

	@Override
	public LinkedList<Book> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<Book> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public LinkedList<Book> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	@Override
	public LinkedList<Book> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public List<User> showUsers() {
		return dao.showUsers();
	}

	@Override
	public List<RequestBean> showRequests() {
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(User user, Book book) {
		return dao.bookIssue(user, book);
	}

	@Override
	public boolean isBookReceived(User user, Book book) {
		return dao.isBookReceived(user, book);
	}

	
	
}
