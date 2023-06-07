package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void testAddCartItem() {
		CartDao cartDao = null;

		try {
			cartDao = new CartDaoCollectionImpl();
			cartDao.addCartItem(1, 1);
			// cartDao.addCartItem(1, 2);
			List<MenuItem> cartDetails = cartDao.getAllCartItems(1);
			cartDetails.stream().forEach(c -> System.out.println("Item added to cart:\n" + c));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(cartDetails);

	}

	public static void testGetAllCartItems() {
		CartDao cartDao = null;
		try {
			cartDao = new CartDaoCollectionImpl();
			List<MenuItem> cartDetails = cartDao.getAllCartItems(1);
			System.out.println("All cart items:");
			cartDetails.stream().forEach(c -> System.out.println(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		// System.out.println("in test remove cart block");

		try {
			cartDao.removeCartItem(1, 1);
			List<MenuItem> cartDetails = cartDao.getAllCartItems(1);
			cartDetails.stream().forEach(c -> System.out.println("Left cart items after removal:\n" + c));
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();

	}

}
