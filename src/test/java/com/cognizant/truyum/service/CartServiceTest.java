package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class CartServiceTest {
	
	private CartService cartService;
	@Rule 
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		cartService = (CartService) context.getBean("cartService");
		// System.out.println("inside test");
	}
	
	@Test
	public void testAddCartItem() throws CartEmptyException {
		cartService.addCartItem(1, 1);
		List<MenuItem> m = cartService.getAllCartItems(1);
		List<MenuItem> e= new ArrayList<>();
		e.add(new MenuItem(1, "Sandwich", (float)99.00, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true));
		System.out.println(m.get(0).getId());
		System.out.println(e.get(0).getId());
		assertEquals(e,m);
	
	}
	
	@Test
	public void testRemoveCartItem() {
		
	}
	
	
	@Test
	public void testEmptyCart() throws CartEmptyException {
		exceptionRule.expect(CartEmptyException.class);
		exceptionRule.expectMessage("Cart is Empty!!!");
		
		cartService.addCartItem(1, 1);
		List<MenuItem> m = cartService.getAllCartItems(1);
		System.out.println(m);
		cartService.removeCartItem(1, 1);
		m = cartService.getAllCartItems(1);
		System.out.println(m);
		cartService.getAllCartItems(1L);
	}
	


}
