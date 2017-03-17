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

	static boolean adminIn(Admin a) { // ����Ա��¼
		System.out.println("�������˺ţ�");
		String adminId = sca.next();
		if (a.adminId.equals(adminId)) { // �ж��˺��Ƿ���ȷ
			for (int j = 0; j < 3; j++) {
				System.out.println("���������룺");
				String adminPassword = sca.next();
				if (a.adminPassword.equals(adminPassword)) { // �ж������Ƿ���ȷ
					System.out.println("MainС���Ա��ã�");
					System.out
							.println("------------------------------------------------------------");
					return true;
				} else {
					System.out.println("����������������Сд����");
				}
			}
			System.out.println("����������Σ����˳�");
			System.out
					.println("------------------------------------------------------------");
			return false;
		}
		System.out.println("�˺�����");
		System.out
				.println("------------------------------------------------------------");
		return false;
	}

	static boolean Passin(Coll c) { // ѧ����½
		Scanner sca = new Scanner(System.in);
		Iterator l = c.studentlist.iterator();
		System.out.println("�������˺ţ�");
		String studentId = sca.next();
		while (l.hasNext()) { // ��������
			Student stu = (Student) l.next();
			if (stu.studentId.equals(studentId)) { // �ж��˺��Ƿ���ȷ
				for (int j = 0; j < 3; j++) {
					System.out.println("���������룺");
					String studentPassword = sca.next();
					if (stu.studentPassword.equals(studentPassword)) { // �ж������Ƿ���ȷ
						System.out.println(stu.studentName + "��ã�");
						return true;
					} else {
						System.out.println("����������������Сд����");
					}
				}
				System.out.println("����������Σ����˳���");
				System.out.println("------------------------------------------------------------");
				return false;
			}
		}
		System.out.println("��ѧ�Ų����ڣ������������������������");
		System.out.println("------------------------------------------------------------");
		return false;
	}

	static void Idadd(Coll c) { // ע��
		Student stu = new Student();
		Scanner sca = new Scanner(System.in);
		boolean flag2 = false;
		loop: for (int i = 0; i < 3; i++) {
			System.out.println("������6-12λ��ѧ�ţ�");
			String studentId = sca.next(); // ����ѧ��
			if (studentId.length() >= 6 && studentId.length() <= 12) {
				Iterator l = c.studentlist.iterator();
				boolean flag = true;
				while (l.hasNext()) { // ��������
					Student stu1 = (Student) l.next();
					if (stu1.studentId.equals(studentId)) {
						flag = false;
					}
				}
				if (flag) {
					stu.studentId = studentId; // ����Id
					System.out.println("���������֣�");
					String studentName = sca.next(); // ��������
					stu.studentName = studentName; // ��������
					boolean flag1 = true;
					loop1: while (flag1) {
						System.out.println("������6-8λ�����룺");
						String studentPassword = sca.next(); // ��������
						if (studentPassword.length() >= 6
								&& studentPassword.length() <= 8) {
							flag = false;
							System.out.println("���ٴ��������룺");
							String s1 = sca.next();
							if (studentPassword.equals(s1)) {
								stu.studentPassword = studentPassword; // ��������
							} else {
								System.out.println("���벻ͬ�����������룺");
								continue loop1;
							}

							c.studentlist.add(stu);
							System.out.println("ע��ɹ���");
							System.out.println("------------------------------------------------------------");
							break loop;
						} else {
							System.out.println("�����ʽ�������������룡");
						}
					}
				} else {
					System.out.println("��ѧ���Ѵ���");
				}
			}
			System.out.println("ѧ��ӦΪ6-12λ");
			if (i == 2) {
				flag2 = true;
			}
		}
		if (flag2) {
			System.out.println("��ʲô�ң������ӣ�");
			System.out.println("------------------------------------------------------------");
		}
	}

	public static void printAll(Coll c) { // �鿴ȫ��������Ϣ
		Iterator l = c.borrowinfoemation.iterator();
		while (l.hasNext()) {
			BorrowBook b = (BorrowBook) l.next();
			System.out.println("ʱ�䣺" + b.bookdate); // ��ӡʱ��
			System.out.println("ѧ�ţ�" + b.studentId); // ��ӡѧ��ѧ��
			System.out.println("������" + b.studentName); // ��ӡѧ������
			System.out.println("��ࣺ" + b.bookNumer); // ��ӡ��ı��
			System.out.println("������" + b.bookName); // ��ӡ�������
			System.out.println("�������ͣ�" + b.dobook); // ��ӡ���黹�ǻ���
			System.out.println("----------------------------------");
		}
	}

	public static void addbook(HashSet<Book> booklist) {  //���ͼ����Ϣ
		Scanner sca = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		dd: do {
			Book booklist1 = new Book();
			System.out.println("��������Ҫ�����ı��"); // ������
			int t = sca.nextInt();
			Iterator<Book> it = booklist.iterator();
			while (it.hasNext()) {
				Book book1 = it.next(); // ���ܷ���
				if (book1.bookNumer == t) {
					System.out.println("����ظ���������ѡ����");
					flag1 = false;
					break dd;
				}
			}
			if (flag1) {
				booklist1.bookNumer = t;
				System.out.println("��������Ҫ����������");
				booklist1.bookName = sca.next();
				System.out.println("��������Ҫ�����ļ۸�");
				booklist1.bookPrice = sca.nextDouble();
				System.out.println("��������Ҫ����������");
				booklist1.bookCount = sca.nextInt();
			}
			booklist.add(booklist1);
			System.out.println("��1 �������ͼ�飬��������˳�");
			String a = sca.next();
			if (a.equals("1")) {
				flag = true;
			} else {
				return;
			}
		} while (flag);

	}

	public static void Delebook(HashSet<Book> booklist) { // ɾ��ͼ��
		while (true) {
			boolean flag = false;
			boolean flag1 = true;
			Book book = new Book();
			Iterator<Book> it = booklist.iterator();
			if (it.hasNext() == false) {
				System.out.println("һ����Ҳû��Ү...");
				return;
			}
			System.out.println("��������Ҫɾ����ͼ��ı�ţ�");
			int c = sca.nextInt();
			Iterator<Book> it1 = booklist.iterator();        //�������޴��飬���������Ϣ
			while (it1.hasNext()) { // ����ѭ��
				Book book1 = it1.next();// ��Book�������յ�ǰ����ʱ�Ķ���
				if (book1.bookNumer == c) {
					System.out.println("ͼ���ţ�" + book1.bookCount);
					System.out.println("ͼ�����֣�" + book1.bookName);
					System.out.println("ͼ�����" + book1.bookPrice);
					System.out.println("ͼ���棺" + book1.bookCount);
					flag1 = true;
					flag =false;
					book = book1;
				}
			}
			if(flag1){
				boolean b = booklist.remove(book);
				if (b == true) {
					System.out.println("��ɾ��!!");
				} else {
					System.out.println("ɾ��ʧ�� ����");
				}
				System.out.println("------------------------------------------------------------");
			}
			
		    if (flag) {
		    	System.out.println("����û���Ȿ�鰡~~");
		    	System.out.println("------------------------------------------------------------");
		    }
		    System.out.println("�Ƿ����ɾ��ͼ��\r\n���������룺end�˳�\tݔ���������ݼ�������");
		    String a = sca.next();
		    if (a.equals("end")) {
		    	return;
		    }
		}
	}
	
	public static void seebook(HashSet<Book> booklist) {// ����ͼ��
		boolean flag=true;
		while (true) {
			Iterator<Book> it = booklist.iterator();
			// boolean flage = true;
			if (it.hasNext() == false) {
				System.out.println("һ����Ҳû��Ү...");
				return;
			}
			System.out.println("��������Ҫ����ͼ��ı��");
			String c = sca.next();
			for (int i = 0; i < c.length(); i++) {
				if (c.charAt(i)<48||c.charAt(i)>57) {
					System.out.println("�����������������");
					return;
				}
			}
			int d=Integer.parseInt(c);
			Iterator<Book> it1 = booklist.iterator();
			while (it1.hasNext()) { // ����ѭ��
				Book book1 = it1.next();// ��Book�������յ�ǰ����ʱ�Ķ���
				if (book1.bookNumer == d) {
					System.out.println("ͼ���ţ�" + book1.bookNumer);
					System.out.println("ͼ�����֣�" + book1.bookName);
					System.out.println("ͼ�����" + book1.bookPrice);
					System.out.println("ͼ���棺" + book1.bookCount);
					System.out.println("------------------------------");
					flag=false;
				} 		
			}
			if(flag){
				System.out.println("����û���Ȿ�鰡");
			}
			System.out.println("�Ƿ��������ͼ��\r\n���������룺end�˳�\t�����������ݼ�������");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}
		}
	}
		
	public static void changebook(HashSet<Book> booklist) {// �޸�ͼ��
		while (true) {
		boolean flage=true;//�����ж��Ƿ��иñ�ŵ���
		System.out.println("��������Ҫ�޸�ͼ��ı��");
		String a = sca.next();
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i)<48||a.charAt(i)>57) {
				System.out.println("�����������������");
				return;
			}
		}
		int e=Integer.parseInt(a);
		Iterator<Book> it = booklist.iterator();
		while (it.hasNext()) {
			Book book1 = it.next();// ��õ�ǰ�����Ķ��󲢷���book1��
     		if (book1.bookNumer == e) {// �ж���ı��
     			boolean flage2=false;//�����ж��޸ĳɹ����ӡ��Ϣ
				flage=false;
				System.out.println("��������Ҫ�޸ĵ���Ŀ  \r\n��ţ�1\t���ƣ�2\t�۸�3\t������4 ");
				String b = sca.next();
				if (!b.equals("1") && !b.equals("2") && !b.equals("3")&& !b.equals("4")) {// ������ж�
					System.out.println("�������");
					return;
				}else{
					switch (b) {
					case "1":
						System.out.println("�������޸ĺ�ı��");
						String c=sca.next();
						for (int i = 0; i < c.length(); i++) {
							if (c.charAt(i)<48||c.charAt(i)>57) {
								System.out.println("�����������������");
								return;
							}
						}
						int j=Integer.parseInt(c);
						boolean flage1=true;//�����ж��Ƿ��ظ�
						Iterator<Book> it2 = booklist.iterator();
						while (it2.hasNext()) {
							Book book2 = it2.next();
							if (book2.bookNumer == j) {// �жϱ���Ƿ��ظ�
								System.out.println("����ظ�������������");
								flage1=false;
								break;
							} 
						}
						if (flage1) {
							book1.bookNumer = j;
							System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
							flage2=true;
						}
						break;
					case "2":
						System.out.println("�������޸ĺ������");
						book1.bookName = sca.next();
						System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
						flage2=true;
						break;
					case "3":
						System.out.println("�������޸ĺ�ļ۸�");
						book1.bookPrice = sca.nextDouble();
						System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
						flage2=true;
						break;
					case "4":
						System.out.println("�������޸ĺ������");
						String f = sca.next();
						for (int i = 0; i < f.length(); i++) {
							if (f.charAt(i)<48||f.charAt(i)>57) {
								System.out.println("�����������������");
								return;
							}
						}
						int r=Integer.parseInt(f);
						if (r<0) {
							System.out.println("�������");
							break;
						}else{
							book1.bookCount =r;
						    System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
						    flage2=true;
						    break;
						}
					default:
						break;
					}
				}
				if (flage2) {
				System.out.println("ͼ���ţ�" + book1.bookNumer);
				System.out.println("ͼ�����֣�" + book1.bookName);
				System.out.println("ͼ�����" + book1.bookPrice);
				System.out.println("ͼ���棺" + book1.bookCount);
				System.out.println("------------------------------");
			    }
			}
			
		}
		if (flage) {
			System.out.println("����û���Ȿ��");
		}
		System.out.println("���룺end�˳�\t�����������ݼ���");
		String o=sca.next();
		if (o.equals("end")) {
			return;// �˳��÷���
			}
	}
}
	
	public void printStu(Coll coll) { // �鿴ȫ��ѧ����Ϣ
		Iterator look = coll.studentlist.iterator(); // ������ѭ��
		while (look.hasNext()) {
			Student s1 = (Student) look.next();
			System.out.println(s1.studentId);
			System.out.println(s1.studentName);
			for (int i = 0; i < s1.borrowlist.size(); i++) {
				System.out.println(s1.borrowlist.get(i));
			}
		}
	}
	
	public static void seestudent(TreeSet<Student> studentlist) {// ����ѧ����Ϣ
		boolean flage=false;
		while (true) {
			Iterator<Student> it = studentlist.iterator();
			if (it.hasNext() == false) {
				System.out.println("Ŀǰ��û��ѧ����...");
				return;
			}
			System.out.println("��������Ҫ����ѧ���ı�Ż�����");
			Iterator<Student> it1 = studentlist.iterator();
			String c = sca.next();
			while (it1.hasNext()) { // ����ѭ��
				Student student1 = it1.next();// ��Book�������յ�ǰ����ʱ�Ķ���
				if (student1.studentId.equals(c)|| student1.studentName.equals(c)) {
					System.out.println("ѧ��ѧ�ţ�" + student1.studentId);
					System.out.println("ѧ�����֣�" + student1.studentName);
					System.out.println("ѧ�����룺" + student1.studentPassword);
					System.out.println("------------------------------------------------------------");
					flage=false;
					break;
				}
			}
			if (flage) {
				System.out.println("����û�����ѧ����");
			}
			System.out.println("�Ƿ��������ѧ��\r\n���������룺end�˳�\t�����������ݼ�������");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}
		}
	}

	public static void AddStudent(TreeSet<Student> studentlist) {// ���ѧ��
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
			System.out.println("��������Ҫ���ѧ����ѧ��"); // ������
			String t = sca.next();
			Iterator<Student> it = studentlist.iterator();
			while (it.hasNext()) {
				Student student1 = it.next(); // ���ܷ���
				if (student1.studentId.equals(t)) {
					System.out.println("ѧ���ظ���������ѡ����");
					flag1 = false;
					break dd;
				}
			}
			if (flag1) {
				studentlist1.studentId = t;
				System.out.println("��������Ҫ���ѧ��������");
				studentlist1.studentName = sca.next();
				System.out.println("��������Ҫ���ѧ��������");
				studentlist1.studentPassword = sca.next();
			}
			
			stu.add(studentlist1);
			for (Student stus : stu) {
				studentlist.add( stus);
			}
			System.out.println("��1 �������ѧ������������˳�");
			String a = sca.next();
			if (a.equals("1")) {
				flag = true;
			} else {
				return;
			}
		} while (flag);
		

	}

	public static void changeStudent(TreeSet<Student> studentlist) {// �޸�ѧ��
		while (true) {
			boolean flage=true;//���ڱ���Ƿ��иñ�ŵ�ѧ��
			System.out.println("��������Ҫ�޸�ѧ���ı�Ż�����");
			String a = sca.next();
			Iterator<Student> it = studentlist.iterator();
			while (it.hasNext()) {
				Student studentlist1 = it.next();// ��õ�ǰ�����Ķ��󲢷���book1��
	     		if (studentlist1.studentId.equals(a)||studentlist1.studentName.equals(a)) {// �ж�ѧ�Ż������Ƿ���ͬ
	     			boolean flage2=false;//�����ж��޸ĳɹ����ӡ��Ϣ
					flage=false;
					System.out.println("��������Ҫ�޸ĵ���Ŀ  \r\nѧ��ѧ�ţ�1\tѧ��������2");
					String b = sca.next();
					if (!b.equals("1") && !b.equals("2")) {// ������ж�
						System.out.println("�������");
						return;
					}else{
						switch (b) {
						case "1":
							System.out.println("�������޸ĺ��ѧ��ѧ��");
							String c=sca.next();
							boolean flage1=true;//�����ж��Ƿ��ظ�
							Iterator<Student> it2 = studentlist.iterator();
							while (it2.hasNext()) {
								Student studentlist2 = it2.next();
								if (studentlist2.studentId.equals(c)) {// �жϱ���Ƿ��ظ�
									System.out.println("���и�ѧ��ѧ��������������");
									flage1=false;
									break;
								} 
							}
							if (flage1) {
								studentlist1.studentId = c;
								System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
								flage2=true;
							}
							break;
						case "2":
							System.out.println("�������޸ĺ��ѧ������");
							studentlist1.studentName = sca.next();
							System.out.println("�޸ĳɹ����޸ĺ����ϢΪ\r\n");
							flage2=true;
							break;
						default:
							break;
						}
					}
					if (flage2) {
					System.out.println("ѧ��ѧ�ţ�" + studentlist1.studentId);
					System.out.println("ѧ��������" + studentlist1.studentName);
					System.out.println("------------------------------");
				    }
				}	
			}
			if (flage) {
				System.out.println("����û�����ѧ��");
			}
			System.out.println("���룺end�˳�\t�����������ݼ���");
			String e=sca.next();
			if (e.equals("end")) {
				return;// �˳��÷���
			}
		}
	}

	
	public static void deleStudent(TreeSet studentlist) { // ɾ��ѧ����Ϣ
		while (true) {
			boolean flag = true;
			boolean flag1 = false;
			Student student1 = new Student();
			Iterator<Student> it = studentlist.iterator();  //����ѭ��
			if (it.hasNext() == false) {
				System.out.println("һ����û��Ү...");
				return;
			}
			System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
			String c = sca.next();
			Iterator<Student> it1 = studentlist.iterator();//���µ���
			while (it1.hasNext()) { // ����ѭ��
				Student student = it1.next();// ��student�������յ�ǰ����ʱ�Ķ���
				if (student.studentId.equals(c)) {
					System.out.println("ѧ����ѧ�ţ�" + student.studentId);
					System.out.println("ѧ����������" + student.studentName);
					System.out.println("ѧ�������룺" + student.studentPassword);
					flag1 = true;
					flag = false;
					it1.remove();
					student1 = student;
				}
			}
			if (flag1) {                     //�ڼ����а���ɾ��
				
					System.out.println("��ɾ��ѧ������");
			}
				 else {
					System.out.println("ɾ��ʧ�� ����");
				}
				System.out.println("------------------------------------------------------------");
			
			if (flag) {
				System.out.println("����û������˰�~~");
			}
			System.out.println("�Ƿ����ɾ��ѧ��\r\n���������룺end�˳�\tݔ���������ݼ�������");
			String a = sca.next();
			if (a.equals("end")) {
				return;
			}

		}

	}

	public static void checkbook(Coll c){   //      �鿴ȫ��ͼ��
			Iterator i = c.booklist.iterator();	
			if(i.hasNext() == false){
				System.out.println("��û����Ŷ~");
				System.out.println("------------------------------------------------------------");
			}
			while(i.hasNext()){
				Book b = (Book)i.next();
				System.out.println("���:"+b.bookNumer);
				System.out.println("����:"+b.bookName);
				System.out.println("�۸�:"+b.bookPrice);
				System.out.println("����:"+b.bookCount);	
				System.out.println("------------------------------------------------------------");
			}				
		}	

	public static void printStudent(Coll stu) { // �鿴ȫ��ѧ��
		Iterator look = stu.studentlist.iterator();
		if(look.hasNext() == false){
			System.out.println("��û��ѧ������Ŷ~");
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

	public static void borrwoBook(Coll coll) {    //����ͼ��
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
		System.out.println("������ѧ����ID��");
		 stId = sca.next();
		// �õ�ѧ����Ϣ
		Iterator<Student> its = coll.studentlist.iterator();
		while (its.hasNext()) {
			Student stu = its.next();
			if (stu.studentId.equals(stId)) {
				System.out.println("�ҵ�ѧ����Ϣ");
				flag = false;
				stNm = stu.studentName;
				lis = stu.borrowlist;
				if(stu.borrowlist.size()>=5){
					System.out.println("�㲻���ٽ����ˣ��Ѿ�����5���ˣ����ȹ黹��");
					flag2=false;
				}
			}
		}
		if (flag) {
			System.out.println("û�ҵ�ѧ����Ϣ");
		}
           }while(flag);
		// ���鿪ʼ
      if(flag2){
		System.out.println("������Ҫ��������֣�");
		// �ж�������Ƿ��и�ͼ��

		loop: do {
			String boNm = sca.next();
			Iterator<Book> itb = coll.booklist.iterator();
			while (itb.hasNext()) {
				Book book = itb.next();
				if (boNm.equals(book.bookName) && book.bookCount > 0) {
					System.out.println("���黹�п��,����ɹ���");
					flag1 = false;
					book.bookCount--;// ����鱾����һ��
					boId = book.bookNumer;
					boPr = book.bookPrice;
					// �������ѧ�����ϵ�list
					Iterator<Student> its1 = coll.studentlist.iterator();
					while (its1.hasNext()) {
						Student stu1 = its1.next();
						// �ҵ�list
						if (stu1.studentId.equals(stId)) {
							// ��ʼ����
							Book bo = new Book();
							bo.bookName = boNm;
							bo.bookCount = 1;
							bo.bookNumer = boId;
							bo.bookPrice = boPr;
							stu1.borrowlist.add(bo);
						}
					}
					// ��������Ϣ���������Ϣ
					if (coll.map.containsKey(stNm)) {
						Set<String> se = coll.map.keySet();
						for (String str : se) {
							if (str.equals(stNm)) {
								coll.map.get(str).add(lis);
							}
						}
					} else {
						// û����Ϣ�����һ��
						coll.map.put(boNm, lis);
					}

					
					// //��������Ϣ��������Ϣ����
					coll.borrowinfoemation.add(new BorrowBook(stId, stNm, boId,
							boNm, bookdate, "����"));
					break loop;
				}
			}
			// û��ͼ��Ĵ���
			if (flag1) {
				System.out.println("��Ҫ���ҵ���û�л��߿��Ϊ0,  1���� 2�˳�");
				int i=sca.nextInt();
				if(i==2){
					break loop;
				}else if(i==1){
					System.out.println("������������");
				}
			}
		} while (true);
      }
	}
	
	
	public static void giveBack(Coll coll){         //�黹ͼ��
		Scanner sca = new Scanner(System.in);
		//��ȡ����ʱ��
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String bookdate = sdf.format(date);
		String boNm=null;
		int boNu=0;
		String stId=null;
		String stNm=null;
		
		int fl=0;
		System.out.println("������ѧ��ID");
		stId=sca.next();
	loop:do{
			
			 System.out.println("�黹��������");
			 boNm=sca.next();
			 //����ѧ����Ϣ
			Iterator<Student> its=coll.studentlist.iterator();
			while(its.hasNext()){
				Student stu=its.next();
				//�ҵ�ѧ��
				if(stId.equals(stu.studentId)){
				  stNm=stu.studentName;
				  //�鿴ѧ�����
				  Iterator<Book> itb=stu.borrowlist.iterator();
				  while(itb.hasNext()){
					  Book book=itb.next();
					  if(book.bookName.equals(boNm)){
						  //�ҵ��鱾
						  itb.remove();
						  break loop;
					  }else{
						  fl=1;
						  //û���ҵ��鱾
					  }
				  }
				}else{
					//û���ҵ�ѧ��
					fl=2;
				}
			}
			if(fl!=0){
				if(fl==2){
					System.out.println("�����ѧ��Id����");
					System.out.println("*****************");
					System.out.println("������ѧ��ID:");
					stId=sca.next();
				}else if(fl==1){
					System.out.println("��û�н��Ȿ�飬�������������������");
				}
			}
		}while(true);
		
		//���黹�����
		Iterator<Book> itb1=coll.booklist.iterator();
		while(itb1.hasNext()){
			Book bo=itb1.next();
			if(bo.bookName.equals(boNm)){
				bo.bookCount++;  //����
				boNu=bo.bookNumer;
			}
		}
		//��������Ϣ��������Ϣ����
		coll.borrowinfoemation.add(new BorrowBook(stId, stNm, boNu , boNm, bookdate, "����"));
		//�����������Ϣ����
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
	      System.out.println("�黹�ɹ�����ӭ�´ζ���");
	}

}
