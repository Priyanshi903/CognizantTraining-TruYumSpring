package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.*;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {

	private MenuItemService menuItemService;

	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
		// System.out.println("inside test");
	}

	@Test
	public void testGetMenuItemListAdminSize() {
		assertEquals(5, menuItemService.getMenuItemListAdmin().size());
	}

	@Test
	public void testGetMenuItemListAdminContainsSandwich() {
		MenuItem menuItem = new MenuItem(1, "Sandwich", (float) 99.00, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		boolean isSandwich = false;
		for (MenuItem m : menuItemService.getMenuItemListAdmin()) {
			isSandwich = m.equals(menuItem);
			if (isSandwich)
				break;
		}
		assertTrue(isSandwich);
	}

	@Test
	public void testGetMenuItemListCustomerSize() {
		assertEquals(3, menuItemService.getMenuItemListCustomer().size());
	}

	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		MenuItem menuItem = new MenuItem(4, "French Fries", (float) 57.00, false, DateUtil.convertToDate("02/07/2017"),
				"Starter", true);
		boolean isFrenchFries = true;
		for (MenuItem m : menuItemService.getMenuItemListCustomer()) {
			isFrenchFries = m.equals(menuItem);
			System.out.println(isFrenchFries);
			if (isFrenchFries)
				break;
		}
		assertFalse(isFrenchFries);
	}

	@Test
	public void testGetMenuItem() {
		assertEquals(1, menuItemService.getMenuItem(1).getId());
	}

	@Test
	public void testModifyMenuItem() {
		boolean isModified=true;
		MenuItem menuItem = new MenuItem(4, "French Fries", (float) 57.00, false, DateUtil.convertToDate("02/07/2017"),
				"Starter", true);
		menuItem.setName("fries");

		menuItemService.modifyMenuItem(menuItem);
		for (MenuItem m : menuItemService.getMenuItemListAdmin()) {
			 isModified = m.getName().equals("fries");
			 if(isModified)
				 break;
		}
		assertTrue(isModified);
	}

}
