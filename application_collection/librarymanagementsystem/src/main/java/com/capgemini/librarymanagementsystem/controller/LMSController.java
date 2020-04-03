package com.capgemini.librarymanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.exception.LMSException;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.RequestBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LMSFactory;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.validation.Validation;

public class LMSController {
	public static void main(String[] args) {
		doReg();
	}

	public static void doReg() {

		boolean flag = false;

		int regId = 0; 
		String regName = null; 
		long regMobile = 0;
		String regEmail = null;
		String regPassword = null;

		int regId1 = 0; 
		String regName1 = null; 
		long regMobile1 = 0;
		String regEmail1 = null;
		String regPassword1 = null;

		int bookId = 0; 
		String bookAuthor = null; 
		String bookName = null;
		String bookCategory = null;
		String bookPublisherName = null;
		String bookIssuedate = null;
		String bookReturndate = null;

		Validation validation = new Validation();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("----------WELCOME TO LIBRARY-----------");
			System.out.println("Press 1 to Admin Page");
			System.out.println("Press 2 to Student Page");
			System.out.println("-----------------------------------");

			int i = scanner.nextInt();
			switch(i) {
			case 1:
				AdminService service = LMSFactory.getAdminService();
				do{
					System.out.println("-----------------------------------");
					System.out.println("Press 1 to Admin Register");
					System.out.println("Press 2 to Login");
					System.out.println("Press 3 to exit");
					System.out.println("-----------------------------------");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						do {
							try {
								System.out.println("Enter ID :");
								regId = scanner.nextInt();
								validation.validatedId(regId);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Name :");
								regName = scanner.next();
								validation.validatedName(regName);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Mobile :");
								regMobile = scanner.nextLong();
								validation.validatedMobile(regMobile);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Mobile Number  should contains only numbers");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Email :");
								regEmail = scanner.next();
								validation.validatedEmail(regEmail);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Password :");
								regPassword = scanner.next();
								validation.validatedPassword(regPassword);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						Admin bean = new Admin();
						bean.setAdminId(regId);
						bean.setAdminName(regName);
						bean.setMobile(regMobile);
						bean.setAdminEmail(regEmail);
						bean.setAdminPassword(regPassword);

						boolean check = service.registerAdmin(bean);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}	

						break;

					case 2:
						System.out.println("Enter email :");
						String email = scanner.next();
						System.out.println("Enter Password :");
						String password = scanner.next();
						try {
							Admin authBean = service.loginAdmin(email, password);
							System.out.println("Logged in");

							do {
								System.out.println("-----------------------------------");
								System.out.println("Press 1 to Add Books");
								System.out.println("Press 2 to update");
								System.out.println("Press 3 to Search the Book by Author");
								System.out.println("Press 4 to Search the Book by Title");
								System.out.println("Press 5 to Search the Book by Category");
								System.out.println("Press 6 to remove the Books");
								System.out.println("Press 7 to Get the All The Books ");
								System.out.println("Press 8 to Book Issue");
								System.out.println("Press 9 to Show Users");
								System.out.println("Press 10 to Show Requests");
								System.out.println("Press 11 Receive Returned Book");
								System.out.println("Press 12 to main");
								System.out.println("-----------------------------------");
								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:

									do {
										try {
											System.out.println("Enter Book-ID :");
											bookId = scanner.nextInt();
											validation.validatedId(bookId);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Id should contains only digits");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);




									do {
										try {
											System.out.println("Enter Book Name :");
											bookName = scanner.next();
											validation.validatedName(bookName);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Book-Name should contains only Alphabets");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);



									do {
										try {
											System.out.println("Enter Author :");
											bookAuthor = scanner.next();
											validation.validatedName(bookAuthor);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Author Name should contains only Alphabates");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);


									do {
										try {
											System.out.println("Enter Category :");
											bookCategory = scanner.next();
											validation.validatedName(bookCategory);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Book-Category should contains only Alphabates");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);


									do {
										try {
											System.out.println("Enter PublisherName :");
											bookPublisherName = scanner.next();
											validation.validatedName(bookPublisherName);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Book-PublisherName should contains only Alphabates");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

									Book bean1 = new Book();
									bean1.setId(bookId);	
									bean1.setBookName(bookName);
									bean1.setAuthor(bookAuthor);
									bean1.setPublication(bookPublisherName);
									bean1.setCategory(bookCategory);
									//bean1.setIssuedate(bookIssuedate);
									boolean check2 = service.addBook(bean1);
									if(check2) {
										System.out.println("Book Added");
									} else {
										System.out.println("Book already exist");
									}
									break;
								case 2:
									System.out.println("Enter the updated id :");
									int bid= scanner.nextInt();

									Book bean2 = new Book();
									bean2.setId(bid);
									int updated = service.updateBook(bid);
									if (updated != 0) {
										System.out.println("Book is updated");
									} else {
										System.out.println("Book is not updated");
									}
									break;
								case 3:
									System.out.println("Search the book by the Author Name:");
									String author = scanner.next();

									Book bean3 = new Book();
									bean3.setAuthor(author);
									List<Book> bookauthor = service.searchBookByAuthor(author);
									for (Book bookBean : bookauthor) {

										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available written by this author");
										}
									}
									break;
								case 4:
									System.out.println("  Search the book by the Book_Title :");
									String bookTitle = scanner.next();

									Book bean4 = new Book();
									bean4.setBookName(bookTitle);
									List<Book> booktitle = service.searchBookByTitle(bookTitle);
									for (Book bookBean : booktitle) {	
										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available with this title.");
										}
									}
									break;
								case 5:
									System.out.println("Search the book by the Book_Category :");
									String category = scanner.next();

									Book bean5 = new Book();
									bean5.setCategory(category);
									List<Book> bookIds = service.searchBookByCategory(category);
									for (Book bookBean : bookIds) {
										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available with this Id.");
										}
									}
									break;
								case 6:
									System.out.println("Enter the book_Id to delete :");
									int book_Id = scanner.nextInt();
									if (book_Id == 0) {
										System.out.println("Enter the Valid Book_Id");
									} else {
										Book bean6 = new Book();
										bean6.setId(book_Id);
										boolean remove = service.removeBook(book_Id);
										if (remove) {
											System.out.println("The Book is removed");
										} else {
											System.out.println("The Book is not removed");
										}
									}
									break;

								case 7:
									LinkedList<Book> info = service.getBooksInfo();
									for (Book bookBean : info) {

										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("Books info is not present");
										}
									}
									break;
								case 8:
									User userBean2 = new User();
									Book bookBean2 = new Book();
									System.out.println("enter Book Id");
									int bId = scanner.nextInt();
									System.out.println("enter User Id");
									int uId = scanner.nextInt();

									bookBean2.setId(bId);
									userBean2.setId(uId);

									try {
										boolean isIssued = service.bookIssue(userBean2, bookBean2);
										if (isIssued) {
											System.out.println("Book Issued");
										} else {
											System.out.println("Book cannot be issued");
										}

									} catch (Exception e) {
										System.out.println("Invalid data request book cannot be issued");
									}
									break;
								case 9:
									try {
										System.out.println("Users of Library are :");
										System.out.println("-------------------------------");

										List<User> userInfos = service.showUsers();
										for (User infos : userInfos) {

											System.out.println("User id ---------- " + infos.getId());
											System.out.println("User Name -------- " + infos.getName());
											System.out.println("User Email------ " + infos.getEmail());
											System.out.println("User No Of Books Borrowed ------- " + infos.getBooksBorrowed());

										}
									} catch (Exception e) {
										System.out.println("no books present in library");
									}
									break;
								case 10:
									try {
										System.out.println("Requests for Books are :");
										System.out.println("-------------------------------");

										List<RequestBean> requestInfos = service.showRequests();
										for (RequestBean info1 : requestInfos) {

											System.out.println("Book id ---------- " + info1.getBookInfo().getId());
											System.out.println("Book Name -------- " + info1.getBookInfo().getAuthor());
											System.out.println("User id----------- " + info1.getUserInfo().getId());
											System.out.println("User Name -------- " + info1.getUserInfo().getName());
											System.out.println("Book Issued ------" + info1.isIssued());
											System.out.println("Book Returned------" + info1.isReturned());

										}
									} catch (Exception e) {
										System.out.println("no books present in library");
									}
									break;
								case 11:
									System.out.println("Receive Returned Book");
									System.out.println("-----------------------");
									System.out.println("Enter Student Id");
									int user_Id = scanner.nextInt();
									System.out.println("Enter Book Id");
									int book_id = scanner.nextInt();

									User student = new User();
									Book book = new Book();
									student.setId(user_Id);;
									book.setId(book_id);
									boolean isReceive = service.isBookReceived(student, book);
									if(isReceive) {
										System.out.println(" Received Returned book");
									}else {
										System.out.println("Invalid ! Admin unable to receive");
									}
									break;
								case 12:
									doReg();
								default:
									System.out.println("Invalid Choice");
									break;
								}
							} while(true);
						} catch (Exception e) {
							System.out.println("Invalid Credentials");
						}

						break;
					case 3:
						doReg();
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
				} while(true);

			case 2:
				UserService service1 = LMSFactory.getUserService();
				do {
					System.out.println("-----------------------------------");
					System.out.println("Press 1 to Student Register");
					System.out.println("Press 2 to Student Login");
					System.out.println("3 to main");
					System.out.println("-----------------------------------");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						do {
							try {
								System.out.println("Enter ID :");
								regId1 = scanner.nextInt();
								validation.validatedId(regId1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Name :");
								regName1 = scanner.next();
								validation.validatedName(regName1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Mobile :");
								regMobile = scanner.nextLong();
								validation.validatedMobile(regMobile);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Mobile Number  should contains only numbers");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Email :");
								regEmail1 = scanner.next();
								validation.validatedEmail(regEmail1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Password :");
								regPassword1 = scanner.next();
								validation.validatedPassword(regPassword1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (LMSException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						User bean1 = new User();
						bean1.setId(regId1);
						bean1.setName(regName1);
						bean1.setPhone(regMobile1);
						bean1.setEmail(regEmail1);
						bean1.setPassword(regPassword1);

						boolean check = service1.registerUser(bean1);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}
						break;
					case 2:
						System.out.println("Enter email :");
						String email = scanner.next();
						System.out.println("Enter Password :");
						String password = scanner.next();
						try {
							User studentBean = service1.loginUser(email, password);
							System.out.println("Logged in");
							do {
								System.out.println("--------------------------------------------");
								System.out.println("Press 1 to Search the Book by Author");
								System.out.println("Press 2 to Search the Book by Title");
								System.out.println("Press 3 to Search the Book by Id");
								System.out.println("Press 4 to Get the Books Information");
								System.out.println("Press 5 to Request the Book");
								System.out.println("Press 6 to Return the Book");
								System.out.println("Press 7 to main");
								System.out.println("--------------------------------------------");
								int choice2 = scanner.nextInt();
								switch (choice2) {
								case 1:
									System.out.println("Search the book by the Author Name :");
									String author = scanner.next();

									Book bean2 = new Book();
									bean2.setAuthor(author);
									List<Book> bookauthor = service1.searchBookByAuthor(author);
									for (Book bookBean : bookauthor) {

										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available written by this author");
										}
									}
									break;
								case 2:
									System.out.println("Search the book by the Book_Title :");
									String book_Name = scanner.next();

									Book bean3 = new Book();
									bean3.setBookName(book_Name);
									List<Book> booktitle = service1.searchBookByTitle(book_Name);
									for (Book bookBean : booktitle) {	
										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available with this title.");
										}
									}
									break;
								case 3:
									System.out.println("  Search the book by the Book_Category :");
									String book_Category = scanner.next();

									Book bean4 = new Book();
									bean4.setCategory(book_Category);;
									List<Book> bookIds = service1.searchBookByCategory(book_Category);
									for (Book bookBean : bookIds) {
										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("No books are available with this Id.");
										}
									}
									break;

								case 4:
									LinkedList<Book> info = service1.getBooksInfo();
									for (Book bookBean : info) {

										if (bookBean != null) {
											System.out.println("-----------------------------------");
											System.out.println("Book_Id is-->"+bookBean.getId());
											System.out.println("Book_Name is-->"+bookBean.getBookName());
											System.out.println("Book_Author is-->"+bookBean.getAuthor());
											System.out.println("Book_Category is-->"+bookBean.getCategory());
											System.out.println("Book_PublisherName is-->"+bookBean.getPublication());
										} else {
											System.out.println("Books info is not present");
										}
									}
									break;
								case 5:
									System.out.println("Enter book id");
									int bId = scanner.nextInt();
									Book bookBean = new Book();
									bookBean.setId(bId);

									System.out.println("Enter user id");
									int userId = scanner.nextInt();
									User userBean = new User();
									userBean.setId(userId);;

									try {
										RequestBean request = service1.bookRequest(userBean, bookBean);
										System.out.println("Request placed to admin");
										System.out.println("-----------------------------------");
										System.out.println("User Id-----" + request.getUserInfo().getId());
										System.out.println("User name---" + request.getUserInfo().getName());
										System.out.println("Book Id-----" + request.getBookInfo().getId());
										System.out.println("Book Name---" + request.getBookInfo().getBookName());

									} catch (Exception e) {

										System.out.println("Enter valid data or Invalid Request");
									}
									break;
								case 6:

									System.out.println("Returning a book:");
									System.out.println("------------------");
									System.out.println("Enter User Id :");
									int user  = scanner.nextInt();
									System.out.println("Enter Book Id : ");
									int book = scanner.nextInt();
									User userBean7 = new User();
									userBean7.setId(user);;
									Book bookBean7 = new Book();
									bookBean7.setId(book);;

									try {
										RequestBean requestInfo = service1.bookReturn(userBean7, bookBean7);
										System.out.println("Book is Returning to Admin");
										System.out.println("-----------------------------------");
										System.out.println("User Id ------"+requestInfo.getUserInfo().getId());
										System.out.println("Book Id ------"+requestInfo.getBookInfo().getId());
										System.out.println("Is Returning --"+requestInfo.isReturned());

									} catch (Exception e) {
										System.out.println("Invalid Return");
									}

									break;
								case 8:
									doReg();
								default:
									break;
								}
							} while(true);
						} catch (Exception e) {
							System.out.println("Invalid Credentials");
						}
						break;

					case 3:
						doReg();
					default:
						System.out.println("Invalid Choice");
						break;
					}
				} while(true);
			}
		}while(true);

	}

	
}
								

	

				