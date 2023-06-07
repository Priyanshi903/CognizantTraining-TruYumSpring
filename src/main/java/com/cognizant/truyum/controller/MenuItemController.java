package com.cognizant.truyum.controller;

import javax.annotation.Generated;

//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.cognizant.truyum.dao.SystemException;
import com.cognizant.truyum.service.MenuItemService;

public class MenuItemController {
	
	@Autowired
	MenuItemService menuItemService;
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	
	public String showMenuItemListAdmin(ModelMap model) throws SystemException{
		
	}

}
