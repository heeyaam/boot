package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void findbyname() {
	List<Customer> list = customerRepo.findByName("홍길동");
	System.out.println(list);
	assertEquals("홍길동", list.get(0).getName());
	}
	
	//@Test
	void findall() {
		Iterable<Customer> list =  customerRepo.findAll();
		// list.forEach(cust -> System.out.println(cust.getName()) );
		Iterator<Customer> iter = list.iterator();
		while (iter.hasNext()) {
			Customer cust = iter.next();
			System.out.println(list.iterator().next().getName());
			
		}
	}
	
	//@Test
	void save() {
		Customer cust = new Customer();
		cust.setName("김유신");
		cust.setPhone("011-222");
		Customer result = customerRepo.save(cust);
		assertEquals(cust.getName(), result.getName());
	}

}
