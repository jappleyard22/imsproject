package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO itemdao;
	
	@InjectMocks	
	private ItemController itemcontroller;
	
	@Test
	public void testCreate() {
		final String I_NAME = "jug";
		Double PRICE = (double) 4;
		final Item created = new Item(I_NAME, PRICE);

		Mockito.when(utils.getString()).thenReturn(I_NAME);
		Mockito.when(utils.getDouble()).thenReturn(PRICE);
		Mockito.when(itemdao.create(created)).thenReturn(created);

		assertEquals(created, itemcontroller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(itemdao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "mug", ((double) 4)));

		Mockito.when(itemdao.readAll()).thenReturn(items);

		assertEquals(items, itemcontroller.readAll());

		Mockito.verify(itemdao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "knife", ((double) 2));

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getPrice());
		Mockito.when(this.itemdao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.itemcontroller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.itemdao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(itemdao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.itemcontroller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(itemdao, Mockito.times(1)).delete(ID);
	}

}


