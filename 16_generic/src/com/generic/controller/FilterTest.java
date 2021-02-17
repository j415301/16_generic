package com.generic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.generic.model.dao.BookDao;
import com.generic.model.vo.Book;

public class FilterTest {
	
	public static void main(String[] args) {
		
		//������ 20000�� �̻��� �͸� ���
		List<Book> result = filter(BookDao.getTotalBook(), (Book b) -> b.getPrice()>20000);
		System.out.println(result);
		
		//¦���� ���
		List<Integer> intData = Arrays.asList(new Integer[] {1,2,3,4,5,6});//�迭�� ����Ʈ�� ����
		List<Integer> intResult = filter(intData, (Integer i) -> i%2==0);
		System.out.println(intResult);
		
		//���� '��'���� ����� ���
		List<String> names = Arrays.asList(new String[] {"������","������","�����","�迹��","������"});
		List<String> nameResult = filter(names, (String name1) -> name1.charAt(0)=='��');
		System.out.println(nameResult);
	}
	
	//book �����͸� ���ǿ� ���� �˻��ϴ� �޼ҵ� ����
	//���ǿ� ���� book data�� ���͸��ؼ� �������� ��
	public static <T> List<T> filter(List<T> data, Predicate<T> filter){
		                                           //lamda�� ���� functional interface
		List<T> result = new ArrayList();
		for(T b : data) {
			if(filter.test(b)) {
				result.add(b);
			}
		}
		return result;
	}

}
