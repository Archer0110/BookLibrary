package com.llx.book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Function {
	static Scanner sca = new Scanner(System.in);

	static boolean adminIn(Admin a) { // 管理员登录
		System.out.println("请输入账号：");
		String adminId = sca.next();
		if (a.adminId.equals(adminId)) { // 判断账号是否正确
			for (int j = 0; j < 3; j++) {
				System.out.println("请输入密码：");
				String adminPassword = sca.next();
				if (a.adminPassword.equals(adminPassword)) { // 判断密码是否正确
					System.out.println("Main小组成员你好！");
					System.out
							.println("------------------------------------------------------------");
					return true;
				} else {
					System.out.println("密码错误，请检查输入大小写问题");
				}
			}
			System.out.println("密码错误三次，已退出");
			System.out
					.println("------------------------------------------------------------");
			return false;
		}
		System.out.println("账号有误！");
		System.out
				.println("------------------------------------------------------------");
		return false;
	}

	static boolean Passin(Coll c) { // 学生登陆
		Scanner sca = new Scanner(System.in);
		Iterator l = c.studentlist.iterator();
		System.out.println("请输入账号：");
		String studentId = sca.next();
		while (l.hasNext()) { // 遍历集合
			Student stu = (Student) l.next();
			if (stu.studentId.equals(studentId)) { // 判断账号是否正确
				for (int j = 0; j < 3; j++) {
					System.out.println("请输入密码：");
					String studentPassword = sca.next();
					if (stu.studentPassword.equals(studentPassword)) { // 判断密码是否正确
						System.out.println(stu.studentName + "你好！");
						return true;
					} else {
						System.out.println("密码错误，请检查输入大小写问题");
					}
				}
				System.out.println("密码错误三次，已退出！");
				System.out.println("------------------------------------------------------------");
				return false;
			}
		}
		System.out.println("该学号不存在，如果是新生，请点击新生报道");
		System.out.println("------------------------------------------------------------");
		return false;
	}

	static void Idadd(Coll c) { // 注册
		Student stu = new Student();
		Scanner sca = new Scanner(System.in);
		boolean flag2 = false;
		loop: for (int i = 0; i < 3; i++) {
			System.out.println("请输入6-12位的学号：");
			String studentId = sca.next(); // 输入学号
			if (studentId.length() >= 6 && studentId.length() <= 12) {
				Iterator l = c.studentlist.iterator();
				boolean flag = true;
				while (l.hasNext()) { // 遍历集合
					Student stu1 = (Student) l.next();
					if (stu1.studentId.equals(studentId)) {
						flag = false;
					}
				}
				if (flag) {
					stu.studentId = studentId; // 存入Id
					System.out.println("请输入名字：");
					String studentName = sca.next(); // 输入名字
					stu.studentName = studentName; // 存入名字
					boolean flag1 = true;
					loop1: while (flag1) {
						System.out.println("请输入6-8位的密码：");
						String studentPassword = sca.next(); // 输入密码
						if (studentPassword.length() >= 6
								&& studentPassword.length() <= 8) {
							flag = false;
							System.out.println("请再次输入密码：");
							String s1 = sca.next();
							if (studentPassword.equals(s1)) {
								stu.studentPassword = studentPassword; // 存入密码
							} else {
								System.out.println("密码不同，请重新输入：");
								continue loop1;
							}

							c.studentlist.add(stu);
							System.out.println("注册成功！");
							System.out.println("------------------------------------------------------------");
							break loop;
						} else {
							System.out.println("密码格式错误，请重新输入！");
						}
					}
				} else {
					System.out.println("该学号已存在");
				}
			}
			System.out.println("学号应为6-12位");
			if (i == 2) {
				flag2 = true;
			}
		}
		if (flag2) {
			System.out.println("捣什么乱！滚犊子！");
			System.out.println("------------------------------------------------------------");
		}
	}

	public static void printAll(Coll c) { // 查看全部借阅信息
		Iterator l = c.borrowinfoemation.iterator();
		while (l.hasNext()) {
			BorrowBook b = (BorrowBook) l.next();
			System.out.println("时间：" + b.bookdate); // 打印时间
			System.out.println("学号：" + b.studentId); // 打印学生学号
			System.out.println("姓名：" + b.studentName); // 打印学生姓名
			System.out.println("书编：" + b.bookNumer); // 打印书的编号
			System.out.println("书名：" + b.bookName); // 打印书的名字
			System.out.println("操作类型：" + b.dobook); // 打印借书还是还书
			System.out.println("----------------------------------");
		}
	}

	public static void addbook(HashSet<Book> booklist) {  //添加图书信息
		Scanner sca = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		dd: do {
			Book booklist1 = new Book();
			System.out.println("请输入您要添加书的编号"); // 输入编号
			int t = sca.nextInt();
			Iterator<Book> it = booklist.iterator();
			while (it.hasNext()) {
				Book book1 = it.next(); // 接受返回
				if (book1.bookNumer == t) {
					System.out.println("编号重复，请重新选择功能");
					flag1 = false;
					break dd;
				}
			}
			if (flag1) {
				booklist1.bookNumer = t;
				System.out.println("请输入您要添加书的名字");
				booklist1.bookName = sca.next();
				System.out.println("请输入您要添加书的价格");
				booklist1.bookPrice = sca.nextDouble();
				System.out.println("请输入您要添加书的数量");
				booklist1.bookCount = sca.nextInt();
			}
			booklist.add(booklist1);
			System.out.println("按1 继续添加图书，按任意键退出");
			String a = sca.next();
			if (a.equals("1")) {
				flag = true;
			} else {
				return;
			}
		} while (flag);

	}

	public static void Delebook(HashSet<Book> booklist) { // 删除图书
		while (true) {
			boolean flag = false;
			boolean flag1 = true;
			Book book = new Book();
			Iterator<Book> it = booklist.iterator();
			if (it.hasNext() == false) {
				System.out.println("一本书也没有耶...");
				return;
			}
			System.out.println("请输入你要删除的图书的编号：");
			int c = sca.nextInt();
			Iterator<Book> it1 = booklist.iterator();        //查找有无此书，输出此书信息
			while (it1.hasNext()) { // 迭代循环
				Book book1 = it1.next();// 用Book类来接收当前迭代时的对象
				if (book1.bookNumer == c) {
					System.out.println("图书编号：" + book1.bookCount);
					System.out.println("图书名字：" + book1.bookName);
					System.out.println("图书租金：" + book1.bookPrice);
					System.out.println("图书库存：" + book1.bookCount);
					flag1 = true;
					flag =false;
					book = book1;
				}
			}
			if(flag1){
				boolean b = booklist.remove(book);
				if (b == true) {
					System.out.println("已删除!!");
				} else {
					System.out.println("删除失败 ！！");
				}
				System.out.println("------------------------------------------------------------");
			}
			
		    if (flag) {
		    	System.out.println("好像并没有这本书啊~~");
		    	System.out.println("------------------------------------------------------------");
		    }
		    System.out.println("是否继续删除图书\r\n继续请输入：end退出\t輸入其他內容继续查找");
		    String a = sca.next();
		    if (a.equals("end")) {
		    	return;
		    }
		}
	}
	
	public static void seebook(HashSet<Book> booklist) {// 查找图书
		boolean flag=true;
		while (true) {
			Iterator<Book> it = booklist.iterator();
			// boolean flage = true;
			if (it.hasNext() == false) {
				System.out.println("一本书也没有耶...");
				return;
			}
			System.out.println("请输入你要查找图书的编号");
			String c = sca.next();
			for (int i = 0; i < c.length(); i++) {
				if (c.charAt(i)<48||c.charAt(i)>57) {
					System.out.println("输入错误请重新输入");
					return;
				}
			}
			int d=Integer.parseInt(c);
			Iterator<Book> it1 = booklist.iterator();
			while (it1.hasNext()) { // 迭代循环
				Book book1 = it1.next();// 用Book类来接收当前迭代时的对象
				if (book1.bookNumer == d) {
					System.out.println("图书编号：" + book1.bookNumer);
					System.out.println("图书名字：" + book1.bookName);
					System.out.println("图书租金：" + book1.bookPrice);
					System.out.println("图书库存：" + book1.bookCount);
					System.out.println("------------------------------");
					flag=false;
				} 		
			}
			if(flag){
				System.out.println("好像并没有这本书啊");
			}
			System.out.println("是否继续查找图书\r\n继续请输入：end退出\t输入其他內容继续查找");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}
		}
	}
		
	public static void changebook(HashSet<Book> booklist) {// 修改图书
		while (true) {
		boolean flage=true;//用于判断是否有该编号的书
		System.out.println("请输入你要修改图书的编号");
		String a = sca.next();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i)<48||a.charAt(i)>57) {
				System.out.println("输入错误请重新输入");
				return;
			}
		}
		int e=Integer.parseInt(a);
		Iterator<Book> it = booklist.iterator();
		while (it.hasNext()) {
			Book book1 = it.next();// 或得当前迭代的对象并放在book1里
     		if (book1.bookNumer == e) {// 判断书的编号
     			boolean flage2=false;//用于判断修改成功后打印信息
				flage=false;
				System.out.println("请输入你要修改的项目  \r\n编号：1\t名称：2\t价格：3\t数量：4 ");
				String b = sca.next();
				if (!b.equals("1") && !b.equals("2") && !b.equals("3")&& !b.equals("4")) {// 误操作判断
					System.out.println("输入错误");
					return;
				}else{
					switch (b) {
					case "1":
						System.out.println("请输入修改后的编号");
						String c=sca.next();
						for (int i = 0; i < c.length(); i++) {
							if (c.charAt(i)<48||c.charAt(i)>57) {
								System.out.println("输入错误请重新输入");
								return;
							}
						}
						int j=Integer.parseInt(c);
						boolean flage1=true;//用于判断是否重复
						Iterator<Book> it2 = booklist.iterator();
						while (it2.hasNext()) {
							Book book2 = it2.next();
							if (book2.bookNumer == j) {// 判断编号是否重复
								System.out.println("编号重复，请重新输入");
								flage1=false;
								break;
							} 
						}
						if (flage1) {
							book1.bookNumer = j;
							System.out.println("修改成功，修改后的信息为\r\n");
							flage2=true;
						}
						break;
					case "2":
						System.out.println("请输入修改后的名称");
						book1.bookName = sca.next();
						System.out.println("修改成功，修改后的信息为\r\n");
						flage2=true;
						break;
					case "3":
						System.out.println("请输入修改后的价格");
						book1.bookPrice = sca.nextDouble();
						System.out.println("修改成功，修改后的信息为\r\n");
						flage2=true;
						break;
					case "4":
						System.out.println("请输入修改后的数量");
						String f = sca.next();
						for (int i = 0; i < f.length(); i++) {
							if (f.charAt(i)<48||f.charAt(i)>57) {
								System.out.println("输入错误请重新输入");
								return;
							}
						}
						int r=Integer.parseInt(f);
						if (r<0) {
							System.out.println("输入错误");
							break;
						}else{
							book1.bookCount =r;
						    System.out.println("修改成功，修改后的信息为\r\n");
						    flage2=true;
						    break;
						}
					default:
						break;
					}
				}
				if (flage2) {
				System.out.println("图书编号：" + book1.bookNumer);
				System.out.println("图书名字：" + book1.bookName);
				System.out.println("图书租金：" + book1.bookPrice);
				System.out.println("图书库存：" + book1.bookCount);
				System.out.println("------------------------------");
			    }
			}
			
		}
		if (flage) {
			System.out.println("好像并没有这本书");
		}
		System.out.println("输入：end退出\t输入任意内容继续");
		String o=sca.next();
		if (o.equals("end")) {
			return;// 退出该方法
			}
	}
}
	
	public void printStu(Coll coll) { // 查看全部学生信息
		Iterator look = coll.studentlist.iterator(); // 迭代器循环
		while (look.hasNext()) {
			Student s1 = (Student) look.next();
			System.out.println(s1.studentId);
			System.out.println(s1.studentName);
			for (int i = 0; i < s1.borrowlist.size(); i++) {
				System.out.println(s1.borrowlist.get(i));
			}
		}
	}
	
	public static void seestudent(TreeSet<Student> studentlist) {// 查找学生信息
		boolean flage=false;
		while (true) {
			Iterator<Student> it = studentlist.iterator();
			if (it.hasNext() == false) {
				System.out.println("目前还没有学生啊...");
				return;
			}
			System.out.println("请输入你要查找学生的编号或姓名");
			Iterator<Student> it1 = studentlist.iterator();
			String c = sca.next();
			while (it1.hasNext()) { // 迭代循环
				Student student1 = it1.next();// 用Book类来接收当前迭代时的对象
				if (student1.studentId.equals(c)|| student1.studentName.equals(c)) {
					System.out.println("学生学号：" + student1.studentId);
					System.out.println("学生名字：" + student1.studentName);
					System.out.println("学生密码：" + student1.studentPassword);
					System.out.println("------------------------------------------------------------");
					flage=false;
					break;
				}
			}
			if (flage) {
				System.out.println("好像并没有这个学生啊");
			}
			System.out.println("是否继续查找学生\r\n继续请输入：end退出\t数入其他內容继续查找");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}
		}
	}

	public static void AddStudent(TreeSet<Student> studentlist) {// 添加学生
		Scanner sca = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		dd: do {
/*		Set<Student> stu = new TreeSet<Student>(new Comparator<Student>() {

			public int compare(Student stu1, Student stu2) {
				if (stu1.studentId.equals(stu2.studentId)) {
					return stu1.studentName.compareTo(stu2.studentName);
				} else {
					return stu1.studentPassword.compareTo(stu2.studentPassword);
				}

			}

		});*/

			Set<Student> stu = new TreeSet<Student>();
		
			Student studentlist1 = new Student();
			System.out.println("请输入您要添加学生的学号"); // 输入编号
			String t = sca.next();
			Iterator<Student> it = studentlist.iterator();
			while (it.hasNext()) {
				Student student1 = it.next(); // 接受返回
				if (student1.studentId.equals(t)) {
					System.out.println("学号重复，请重新选择功能");
					flag1 = false;
					break dd;
				}
			}
			if (flag1) {
				studentlist1.studentId = t;
				System.out.println("请输入您要添加学生的名字");
				studentlist1.studentName = sca.next();
				System.out.println("请输入您要添加学生的密码");
				studentlist1.studentPassword = sca.next();
			}
			
			stu.add(studentlist1);
			for (Student stus : stu) {
				studentlist.add( stus);
			}
			System.out.println("按1 继续添加学生，按任意键退出");
			String a = sca.next();
			if (a.equals("1")) {
				flag = true;
			} else {
				return;
			}
		} while (flag);
		

	}

	public static void changeStudent(TreeSet<Student> studentlist) {// 修改学生
		while (true) {
			boolean flage=true;//用于标记是否有该编号的学生
			System.out.println("请输入你要修改学生的编号或姓名");
			String a = sca.next();
			Iterator<Student> it = studentlist.iterator();
			while (it.hasNext()) {
				Student studentlist1 = it.next();// 或得当前迭代的对象并放在book1里
	     		if (studentlist1.studentId.equals(a)||studentlist1.studentName.equals(a)) {// 判断学号或姓名是否相同
	     			boolean flage2=false;//用于判断修改成功后打印信息
					flage=false;
					System.out.println("请输入你要修改的项目  \r\n学生学号：1\t学生姓名：2");
					String b = sca.next();
					if (!b.equals("1") && !b.equals("2")) {// 误操作判断
						System.out.println("输入错误");
						return;
					}else{
						switch (b) {
						case "1":
							System.out.println("请输入修改后的学生学号");
							String c=sca.next();
							boolean flage1=true;//用于判断是否重复
							Iterator<Student> it2 = studentlist.iterator();
							while (it2.hasNext()) {
								Student studentlist2 = it2.next();
								if (studentlist2.studentId.equals(c)) {// 判断编号是否重复
									System.out.println("已有该学号学生，请重新输入");
									flage1=false;
									break;
								} 
							}
							if (flage1) {
								studentlist1.studentId = c;
								System.out.println("修改成功，修改后的信息为\r\n");
								flage2=true;
							}
							break;
						case "2":
							System.out.println("请输入修改后的学生姓名");
							studentlist1.studentName = sca.next();
							System.out.println("修改成功，修改后的信息为\r\n");
							flage2=true;
							break;
						default:
							break;
						}
					}
					if (flage2) {
					System.out.println("学生学号：" + studentlist1.studentId);
					System.out.println("学生姓名：" + studentlist1.studentName);
					System.out.println("------------------------------");
				    }
				}	
			}
			if (flage) {
				System.out.println("好像并没有这个学生");
			}
			System.out.println("输入：end退出\t输入任意内容继续");
			String e=sca.next();
			if (e.equals("end")) {
				return;// 退出该方法
			}
		}
	}

	
	public static void deleStudent(TreeSet studentlist) { // 删除学生信息
		while (true) {
			boolean flag = true;
			boolean flag1 = false;
			Student student1 = new Student();
			Iterator<Student> it = studentlist.iterator();  //迭代循环
			if (it.hasNext() == false) {
				System.out.println("一个人没有耶...");
				return;
			}
			System.out.println("请输入你要删除的学生的学号：");
			String c = sca.next();
			Iterator<Student> it1 = studentlist.iterator();//重新迭代
			while (it1.hasNext()) { // 迭代循环
				Student student = it1.next();// 用student类来接收当前迭代时的对象
				if (student.studentId.equals(c)) {
					System.out.println("学生的学号：" + student.studentId);
					System.out.println("学生的姓名：" + student.studentName);
					System.out.println("学生的密码：" + student.studentPassword);
					flag1 = true;
					flag = false;
					it1.remove();
					student1 = student;
				}
			}
			if (flag1) {                     //在集合中把它删掉
				
					System.out.println("已删除学生！！");
			}
				 else {
					System.out.println("删除失败 ！！");
				}
				System.out.println("------------------------------------------------------------");
			
			if (flag) {
				System.out.println("好像并没有这个人啊~~");
			}
			System.out.println("是否继续删除学生\r\n继续请输入：end退出\t輸入其他內容继续查找");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}

		}

	}

	public static void checkbook(Coll c){   //      查看全部图书
			Iterator i = c.booklist.iterator();	
			if(i.hasNext() == false){
				System.out.println("还没有书哦~");
				System.out.println("------------------------------------------------------------");
			}
			while(i.hasNext()){
				Book b = (Book)i.next();
				System.out.println("编号:"+b.bookNumer);
				System.out.println("书名:"+b.bookName);
				System.out.println("价格:"+b.bookPrice);
				System.out.println("数量:"+b.bookCount);	
				System.out.println("------------------------------------------------------------");
			}				
		}	

	public static void printStudent(Coll stu) { // 查看全部学生
		Iterator look = stu.studentlist.iterator();
		if(look.hasNext() == false){
			System.out.println("还没又学生报道哦~");
			System.out.println("------------------------------------------------------------");
		}
		while (look.hasNext()) {
			Student s1 = (Student) look.next();
			System.out.println(s1.studentId);
			System.out.println(s1.studentName);
			for (int i = 0; i < s1.borrowlist.size(); i++) {
				System.out.println(s1.borrowlist.get(i));
				System.out.println("------------------------------------------------------------");
			}
		}
	}

	public static void borrwoBook(Coll coll) {    //借阅图书
		Scanner sca = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		String stNm = null;
		double boPr = 0;
		List<Book> lis = null;
		
		String stId =null;
		int boId = 0;
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String bookdate = sdf.format(date);
      do{
		System.out.println("请输入学生的ID：");
		 stId = sca.next();
		// 得到学生信息
		Iterator<Student> its = coll.studentlist.iterator();
		while (its.hasNext()) {
			Student stu = its.next();
			if (stu.studentId.equals(stId)) {
				System.out.println("找到学生信息");
				flag = false;
				stNm = stu.studentName;
				lis = stu.borrowlist;
				if(stu.borrowlist.size()>=5){
					System.out.println("你不能再借书了，已经借了5本了！请先归还。");
					flag2=false;
				}
			}
		}
		if (flag) {
			System.out.println("没找到学生信息");
		}
           }while(flag);
		// 借书开始
      if(flag2){
		System.out.println("请输入要借书的名字：");
		// 判断书库中是否有该图书

		loop: do {
			String boNm = sca.next();
			Iterator<Book> itb = coll.booklist.iterator();
			while (itb.hasNext()) {
				Book book = itb.next();
				if (boNm.equals(book.bookName) && book.bookCount > 0) {
					System.out.println("该书还有库存,借书成功！");
					flag1 = false;
					book.bookCount--;// 书库书本减少一本
					boId = book.bookNumer;
					boPr = book.bookPrice;
					// 将书存入学生集合的list
					Iterator<Student> its1 = coll.studentlist.iterator();
					while (its1.hasNext()) {
						Student stu1 = its1.next();
						// 找到list
						if (stu1.studentId.equals(stId)) {
							// 开始存入
							Book bo = new Book();
							bo.bookName = boNm;
							bo.bookCount = 1;
							bo.bookNumer = boId;
							bo.bookPrice = boPr;
							stu1.borrowlist.add(bo);
						}
					}
					// 将借书信息存入借阅信息
					if (coll.map.containsKey(stNm)) {
						Set<String> se = coll.map.keySet();
						for (String str : se) {
							if (str.equals(stNm)) {
								coll.map.get(str).add(lis);
							}
						}
					} else {
						// 没有信息就添加一个
						coll.map.put(boNm, lis);
					}

					
					// //将借书信息记入总信息表中
					coll.borrowinfoemation.add(new BorrowBook(stId, stNm, boId,
							boNm, bookdate, "借书"));
					break loop;
				}
			}
			// 没有图书的处理
			if (flag1) {
				System.out.println("你要查找的书没有或者库存为0,  1继续 2退出");
				int i=sca.nextInt();
				if(i==2){
					break loop;
				}else if(i==1){
					System.out.println("请输入书名：");
				}
			}
		} while (true);
      }
	}
	
	
	public static void giveBack(Coll coll){         //归还图书
		Scanner sca = new Scanner(System.in);
		//获取还书时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String bookdate = sdf.format(date);
		String boNm=null;
		int boNu=0;
		String stId=null;
		String stNm=null;
		
		int fl=0;
		System.out.println("请输入学生ID");
		stId=sca.next();
	loop:do{
			
			 System.out.println("归还的书名：");
			 boNm=sca.next();
			 //查找学生信息
			Iterator<Student> its=coll.studentlist.iterator();
			while(its.hasNext()){
				Student stu=its.next();
				//找到学生
				if(stId.equals(stu.studentId)){
				  stNm=stu.studentName;
				  //查看学生书包
				  Iterator<Book> itb=stu.borrowlist.iterator();
				  while(itb.hasNext()){
					  Book book=itb.next();
					  if(book.bookName.equals(boNm)){
						  //找到书本
						  itb.remove();
						  break loop;
					  }else{
						  fl=1;
						  //没有找到书本
					  }
				  }
				}else{
					//没有找到学生
					fl=2;
				}
			}
			if(fl!=0){
				if(fl==2){
					System.out.println("输入的学生Id有误");
					System.out.println("*****************");
					System.out.println("请输入学生ID:");
					stId=sca.next();
				}else if(fl==1){
					System.out.println("你没有借这本书，请从新输入书名，别捣乱");
				}
			}
		}while(true);
		
		//将书还回书库
		Iterator<Book> itb1=coll.booklist.iterator();
		while(itb1.hasNext()){
			Book bo=itb1.next();
			if(bo.bookName.equals(boNm)){
				bo.bookCount++;  //还书
				boNu=bo.bookNumer;
			}
		}
		//将还书信息记入总信息表中
		coll.borrowinfoemation.add(new BorrowBook(stId, stNm, boNu , boNm, bookdate, "还书"));
		//将借书借阅信息消除
	      Set<String> set=coll.map.keySet();
	      for(String str:set){
	    	  if(str.equals(stNm)){
	    		  if(coll.map.get(str).size()==1){
	    			  	coll.map.get(str).remove(0);
	    		  }else{
	    			    Iterator it=coll.map.get(str).iterator();
	    			    while(it.hasNext()){
	    			    	Book bo=(Book)it.next();
	    			    	if(bo.bookName.equals(boNm)){
	    			    		it.remove();
	    			    	}
	    			    	
	    			    }
	    		  }
	    	  }
	      }
	      System.out.println("归还成功，欢迎下次订阅");
	}

}
