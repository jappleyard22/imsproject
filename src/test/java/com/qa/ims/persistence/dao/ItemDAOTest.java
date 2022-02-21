package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;


public class ItemDAOTest {
	
	private com.qa.ims.persistence.dao.ItemDAO ItemDAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(2L, "jug", (double) 4);
		assertEquals(created, ItemDAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "bowl", ((double) 10)));
		assertEquals(expected, ItemDAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "bowl", ((double) 10)), ItemDAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "bowl", ((double) 10)), ItemDAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(2L, "jug", (double) 4);
		assertEquals(updated, ItemDAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(1, ItemDAO.delete(1));
	}
		
}
