package com.generic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.generic.model.vo.Book;

public class GenericTest {
	
	public static void main(String[] args) {
		//�⺻ ���׸� �˾ƺ���
		//<�ڷ���>���� ���׸��� ���� �ڷ��� ����
		//�ַ� collection, Map �̿� �� ���
		
		//Collection c;
		//ArrayList list;
		
		
		ArrayList<String> names = new ArrayList();//�̸�(String) ���� ����
		names.add("������");
		names.add("�����");
		names.add("������");
		
		//string�� �̸��� �ֱ�� ������ list�� �߸��� ������ ����(int)�� ����
//		names.add(19);
//		for (Object o : names) {
//			String name = (String)o;
//			System.out.println(name.charAt(0));
//		}//compile �������� ���� �ȳ����� runtime �� ���� 
		// -> �̷� ���� �̿��� �����ϱ� ���� generic�� ����ؼ� �ְ��� �ϴ� �ڷ����� ����
		
		//���� generic�� �������� ���?
		//names.add(19);//���� �ִ� �������� ������ �߻��Ǿ� �׶� �׶� ������ �� �� �ֵ��� ��������
		
		for (String a : names) {
			System.out.println(a.charAt(0));
		}//generic ������ ���� names�� String�� �Ǿ����Ƿ� String ���� �޼ҵ嵵 ������ ����ȯ ���� ��� ����
		
		
		
		//books�� ����� å���� �̸��� ���� ���
		//generic ���� �� ���
		ArrayList books = new ArrayList();
		
		books.add(new Book("java�� ����","���ü�",34000,0.5));
		books.add(new Book("���ΰ� �ٴ�","��ֿ���",12000,0.5));
		books.add(new Book("�����","�������丮",10000,0.5));
		
		for (Object o : books) {
			Book b = (Book)o;
			System.out.println(b.getTitle()+" : "+b.getPrice());
		}
		
		
		//generic ���� �� ���
		ArrayList<Book> booksGen = new ArrayList();
		
		booksGen.add(new Book("java�� ����","���ü�",34000,0.5));
		booksGen.add(new Book("���ΰ� �ٴ�","��ֿ���",12000,0.5));
		booksGen.add(new Book("�����","�������丮",10000,0.5));
		
		for (Book o : booksGen) {
			System.out.println(o.getTitle()+" : "+o.getPrice());
		}
		
		
		
		
		
		
		
		
		
		//set���� generic �����ϱ�
		//generic ���� ��
		HashSet set = new HashSet();
		set.add("������");
		set.add("������");
		set.add("����ä");
		set.add("������");
		
		Iterator it = set.iterator();//iterator�� generic ���� ����
		while(it.hasNext()) {
			System.out.println(((String)it.next()).charAt(0));//���� ���
//			System.out.println(it.next());
		}
		
		
		//generic ���� ��
		HashSet<String> set1 = new HashSet();
		set1.add("������");
		set1.add("������");
		set1.add("����ä");
		set1.add("������");
		
		Iterator<String> it2 = set1.iterator();//iterator�� generic ���� ����, hashSet�� �����ϰ� iterator�� �� �ϸ� String ���� itearator���� object�� �ٽ� �ٲ�
		while(it.hasNext()) {
			System.out.println((it2.next()).charAt(0));//���� ���
		}
		
		//�׷��ٸ� iterator�� generic�� �����ϸ� ���ٵ� hashSet���� �ϴ� ������?
		//set�� forEach���� �̿��ؼ� ���� ���� �� ����
		for (String name : set1) {
			System.out.println(name.charAt(0));
		}
		
		
		
		HashSet<Book> bookSet = new HashSet(books);
		for (Book b : bookSet) {
			System.out.println(b);
		}
		
		
		
		
		//Map
		HashMap map = new HashMap();
		map.put(1, "���");
		map.put(2, "��");
		map.put(3, "����");
		
		Set keys = map.keySet();
		Iterator it3 = keys.iterator();
		while (it3.hasNext()) {
			Object key = it3.next();
			System.out.println(map.get(key));
		}
//		System.out.println(map);
		
		
		
		HashMap<Integer, String> map2 = new HashMap();
		map2.put(1, "������");
		map2.put(2, "����");
		map2.put(3, "����");
		
		Set<Integer> keys2 = map2.keySet();
		Iterator<Integer> it4 = keys2.iterator();
		while (it4.hasNext()) {
			int a = it4.next();
			System.out.println(map2.get(a));
		}
		
		
		Set<Map.Entry<Integer, String>> entry = map2.entrySet();
		Iterator<Map.Entry<Integer, String>> itEntry = entry.iterator();
		while (itEntry.hasNext()) {
			Map.Entry<Integer, String> all = itEntry.next();
			System.out.println(all.getKey()+" : "+all.getValue());
		}
		//foreach ���� �׿��ؼ� map ��ü �����ϱ�(���� ���� ���� ��� �� �� ������ ��� ����)
		for (Map.Entry<Integer, String> all : map2.entrySet()) {
			System.out.println(all.getKey()+" : "+all.getValue());
		}
		
		
		
		HashMap<String, Book> booksMap = new HashMap();
		booksMap.put("one", new Book("java�� ����","���ü�",34000,0.5));
		booksMap.put("two", new Book("���ΰ� �ٴ�","��ֿ���",12000,0.5));
		booksMap.put("three", new Book("java","�����",14000,2.5));
		booksMap.put("four", new Book("oracle","������",24000,1.5));
		
		//å�� key���� å �̸�, ����, ���� ���
		for (Map.Entry<String, Book> all : booksMap.entrySet()) {
			System.out.println(all.getKey()+" : "+all.getValue());
		}
		
		
		
		
		//���� ������ ���׸� �̿��ϱ�
		MyGeneric m = new MyGeneric();
		System.out.println(m.getTemp());//null
		
		MyGeneric<Integer> m2 = new MyGeneric();
		System.out.println(m2.getTemp());//null
		m2.setTemp(100);
		System.out.println(m2.getTemp());
		//m2.setTemp("��");//�ȵ�
		
		MyGeneric<String> m3 = new MyGeneric();
		m3.setTemp("��");
		System.out.println(m3.getTemp());
		//m3.setTemp(100);//�ȵ�
		
		MyGeneric<List<Book>> m4 = new MyGeneric();
		m4.setTemp(new ArrayList());
		m4.getTemp().add(new Book("����","ȣȣ",1000,0.4));
		System.out.println(m4.getTemp());
	}

}
