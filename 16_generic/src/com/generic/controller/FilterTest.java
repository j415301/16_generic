package com.generic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.generic.model.dao.BookDao;
import com.generic.model.vo.Book;

public class FilterTest {
	
	public static void main(String[] args) {
		
		//가격이 20000원 이상인 것만 출력
		List<Book> result = filter(BookDao.getTotalBook(), (Book b) -> b.getPrice()>20000);
		System.out.println(result);
		
		//짝수만 출력
		List<Integer> intData = Arrays.asList(new Integer[] {1,2,3,4,5,6});//배열을 리스트로 변경
		List<Integer> intResult = filter(intData, (Integer i) -> i%2==0);
		System.out.println(intResult);
		
		//성이 '김'씨인 사람만 출력
		List<String> names = Arrays.asList(new String[] {"유병승","정유정","김상현","김예진","김태희"});
		List<String> nameResult = filter(names, (String name1) -> name1.charAt(0)=='김');
		System.out.println(nameResult);
	}
	
	//book 데이터를 조건에 따라 검색하는 메소드 생성
	//조건에 따라 book data를 필터링해서 가져오는 것
	public static <T> List<T> filter(List<T> data, Predicate<T> filter){
		                                           //lamda를 위한 functional interface
		List<T> result = new ArrayList();
		for(T b : data) {
			if(filter.test(b)) {
				result.add(b);
			}
		}
		return result;
	}

}
