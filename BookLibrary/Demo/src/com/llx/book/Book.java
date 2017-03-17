package com.llx.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Book {
	int bookNumer;      //书的编号
	String bookName;    //书的名称
	double bookPrice;    //书的价格
	int bookCount;    //书的数量
	public Book() {
		this.bookNumer = 1;
		this.bookName = "平凡的世界";
		this.bookPrice = 30.5;
		this.bookCount = 5;
	}
	

}
class BorrowBook{
	String studentId;   //学生的学号
	String studentName;   //学生的姓名
	int bookNumer;      //书的编号
	String bookName;    //书的名称
	int bookCount;    //书的数量
	String bookdate;  //定义借阅时间
	String dobook;   //借书还书的
	public BorrowBook(String studentId, String studentName, int bookNumer,
			String bookName, String bookdate, String dobook) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.bookNumer = bookNumer;
		this.bookName = bookName;
		this.bookdate = bookdate;
		this.dobook = dobook;
	}
	
	
	
}

class Admin{
	String adminId;  //管理员账号
	String adminPassword;  //管理员密码
	public Admin() {
		this.adminId = "Main";
		this.adminPassword = "asd123";
	}
	
	

}
class Student{
	String studentId;   //学生的学号
	String studentName;   //学生的姓名
	String studentPassword;   //普通账号密码
	List borrowlist = new ArrayList(); //每个学生借阅的书信息
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPassword="
				+ studentPassword + "]";
	}
	
	
	
}
class Coll{
	Set<Book> booklist = new HashSet<Book>();   //书的集合
	Set<Student> studentlist = new TreeSet<Student>(new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return -1;
		}
	});   //学生的集合
	Map<String,List> map = new HashMap<String, List>(); //借了书又还了的信息
	List<BorrowBook> borrowinfoemation = new ArrayList<BorrowBook>(); //所有的借阅的信息
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coll other = (Coll) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}
	
	
}
