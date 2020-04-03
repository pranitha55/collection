package com.capgemini.librarymanagementsystem.factory;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.AdminDAOImple;
import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dao.UserDAOImple;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.AdminServiceImple;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.service.UserServiceImple;

public class LMSFactory {
	
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImple();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImple();
	}

	public static UserDAO getUserDAO() {
		return new UserDAOImple();
	}
	public static UserService getUserService() {
		return new UserServiceImple();
	}
	

}
