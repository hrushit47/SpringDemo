package com.junitproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath mymath= new MyMath();
	
	@BeforeEach
	public void before() {
		System.out.println("Before");
	}
	
	@AfterEach
	public void after() {
		System.out.println("After");
	}
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	@Test
	public void sum_of_numbers() {
		System.out.println("Test1");
		int result=mymath.sum(new int[] {1,2,3});
		assertEquals(6,result);
		
		}
	
	
	@Test
	public void sum_of_1numbers() {
		System.out.println("Test2");

		int result=mymath.sum(new int[] {3});
		assertEquals(3,result);
		
		}

}
/*
 * Inline Function
 
@Test
public void sum_of_numbers() {
	assertEquals(6,mymath.sum(new int[] {1,2,3}));	
	}

@Test
public void sum_of_1numbers() {		
	assertEquals(3,mymath.sum(new int[] {3}));
	}

*/