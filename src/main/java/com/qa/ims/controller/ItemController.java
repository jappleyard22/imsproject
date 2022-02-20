package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.setUtils(utils);	
		}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
			}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a price");
		Double price = utils.getDouble();
		Item item = ItemDAO.create(new Item(itemName, price));
		LOGGER.info("Item Created");
		return item;
	}

	@Override
	public Item update() {
		return items;
	}

	@Override
	public int delete() {
		return 0;
	}

	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

}
