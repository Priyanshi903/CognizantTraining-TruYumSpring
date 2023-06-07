package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;




public class MenuItemDaoCollectionImplTest {
	public static void testGetMenuItemListAdmin()  {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemAdmin= menuItemDao.getMenuItemListAdmin();
		System.out.println("Menu item list admin:->");
		for(MenuItem m: menuItemAdmin) {
			System.out.println(m);
		} 
	}
	public static void testGetMenuItemListCustomer()  {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemCustomer= menuItemDao.getMenuItemListCustomer();
		System.out.println("Menu item list customer:->");
		for(MenuItem m: menuItemCustomer) {
			System.out.println(m);
		}
	}
	static void testModifyMenuItem() {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
//		System.out.println("testModifyMenuItem block");
		//imp
		MenuItem mobj = new MenuItem(1,"Momos", (float)120.00, true, DateUtil.convertToDate("15/03/2018"), "Starter", true);
		menuItemDao.modifyMenuItem(mobj);
		//doubt:->
		if(menuItemDao.getMenuItem(mobj.getId()).equals(mobj))
			System.out.println("Modification Done!!!");
	}
	void testGetMenuItem() {}


	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

}
