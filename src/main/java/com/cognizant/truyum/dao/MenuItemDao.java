package com.cognizant.truyum.dao;
import java.util.*;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;


public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin(); 
	List<MenuItem> getMenuItemListCustomer();
	void modifyMenuItem( MenuItem menuItem);
	MenuItem getMenuItem(long menuItemId); 

}
