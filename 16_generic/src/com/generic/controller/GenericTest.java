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
		//기본 제네릭 알아보기
		//<자료형>으로 제네릭에 대한 자료형 선언
		//주로 collection, Map 이용 시 사용
		
		//Collection c;
		//ArrayList list;
		
		
		ArrayList<String> names = new ArrayList();//이름(String) 저장 변수
		names.add("유병승");
		names.add("김상현");
		names.add("정유정");
		
		//string인 이름만 넣기로 결정한 list에 잘못된 정보인 나이(int)를 넣음
//		names.add(19);
//		for (Object o : names) {
//			String name = (String)o;
//			System.out.println(name.charAt(0));
//		}//compile 시점에는 에러 안나지만 runtime 시 에러 
		// -> 이런 것을 미연에 방지하기 위해 generic을 사용해서 넣고자 하는 자료형을 지정
		
		//만약 generic을 선언했을 경우?
		//names.add(19);//값을 넣는 시점부터 에러가 발생되어 그때 그때 수정을 할 수 있도록 간편해짐
		
		for (String a : names) {
			System.out.println(a.charAt(0));
		}//generic 선언을 통해 names는 String이 되었으므로 String 관련 메소드도 별도의 형변환 없이 사용 가능
		
		
		
		//books에 저장된 책들의 이름과 가격 출력
		//generic 없을 때 출력
		ArrayList books = new ArrayList();
		
		books.add(new Book("java의 정석","남궁성",34000,0.5));
		books.add(new Book("노인과 바다","헤밍웨이",12000,0.5));
		books.add(new Book("어린왕자","생텍쥐페리",10000,0.5));
		
		for (Object o : books) {
			Book b = (Book)o;
			System.out.println(b.getTitle()+" : "+b.getPrice());
		}
		
		
		//generic 있을 때 출력
		ArrayList<Book> booksGen = new ArrayList();
		
		booksGen.add(new Book("java의 정석","남궁성",34000,0.5));
		booksGen.add(new Book("노인과 바다","헤밍웨이",12000,0.5));
		booksGen.add(new Book("어린왕자","생텍쥐페리",10000,0.5));
		
		for (Book o : booksGen) {
			System.out.println(o.getTitle()+" : "+o.getPrice());
		}
		
		
		
		
		
		
		
		
		
		//set에서 generic 선언하기
		//generic 없을 때
		HashSet set = new HashSet();
		set.add("유병승");
		set.add("김지한");
		set.add("정민채");
		set.add("이진주");
		
		Iterator it = set.iterator();//iterator도 generic 선언 가능
		while(it.hasNext()) {
			System.out.println(((String)it.next()).charAt(0));//성만 출력
//			System.out.println(it.next());
		}
		
		
		//generic 있을 떄
		HashSet<String> set1 = new HashSet();
		set1.add("유병승");
		set1.add("김지한");
		set1.add("정민채");
		set1.add("이진주");
		
		Iterator<String> it2 = set1.iterator();//iterator도 generic 선언 가능, hashSet만 선언하고 iterator에 안 하면 String 값이 itearator에서 object로 다시 바뀜
		while(it.hasNext()) {
			System.out.println((it2.next()).charAt(0));//성만 출력
		}
		
		//그렇다면 iterator만 generic을 선언하면 될텐데 hashSet까지 하는 이유는?
		//set은 forEach문을 이용해서 값을 받을 수 있음
		for (String name : set1) {
			System.out.println(name.charAt(0));
		}
		
		
		
		HashSet<Book> bookSet = new HashSet(books);
		for (Book b : bookSet) {
			System.out.println(b);
		}
		
		
		
		
		//Map
		HashMap map = new HashMap();
		map.put(1, "사과");
		map.put(2, "배");
		map.put(3, "포도");
		
		Set keys = map.keySet();
		Iterator it3 = keys.iterator();
		while (it3.hasNext()) {
			Object key = it3.next();
			System.out.println(map.get(key));
		}
//		System.out.println(map);
		
		
		
		HashMap<Integer, String> map2 = new HashMap();
		map2.put(1, "복숭아");
		map2.put(2, "수박");
		map2.put(3, "딸기");
		
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
		//foreach 문을 잉요해서 map 객체 접근하기(위와 같은 내용 출력 시 더 간단히 출력 가능)
		for (Map.Entry<Integer, String> all : map2.entrySet()) {
			System.out.println(all.getKey()+" : "+all.getValue());
		}
		
		
		
		HashMap<String, Book> booksMap = new HashMap();
		booksMap.put("one", new Book("java의 정석","남궁성",34000,0.5));
		booksMap.put("two", new Book("노인과 바다","헤밍웨이",12000,0.5));
		booksMap.put("three", new Book("java","김상현",14000,2.5));
		booksMap.put("four", new Book("oracle","정유정",24000,1.5));
		
		//책의 key값과 책 이름, 저자, 가격 출력
		for (Map.Entry<String, Book> all : booksMap.entrySet()) {
			System.out.println(all.getKey()+" : "+all.getValue());
		}
		
		
		
		
		//내가 선언한 제네릭 이용하기
		MyGeneric m = new MyGeneric();
		System.out.println(m.getTemp());//null
		
		MyGeneric<Integer> m2 = new MyGeneric();
		System.out.println(m2.getTemp());//null
		m2.setTemp(100);
		System.out.println(m2.getTemp());
		//m2.setTemp("백");//안들어감
		
		MyGeneric<String> m3 = new MyGeneric();
		m3.setTemp("백");
		System.out.println(m3.getTemp());
		//m3.setTemp(100);//안들어감
		
		MyGeneric<List<Book>> m4 = new MyGeneric();
		m4.setTemp(new ArrayList());
		m4.getTemp().add(new Book("하하","호호",1000,0.4));
		System.out.println(m4.getTemp());
	}

}
