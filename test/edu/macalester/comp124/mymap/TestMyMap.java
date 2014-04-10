package edu.macalester.comp124.mymap;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Class to test hashmaps.
 * 
 * All the keys are integers because the hashcode function for
 * integers is the identity function.
 * 
 * @author shilad
 *
 */
public class TestMyMap {

    @Test
	public void testPut() {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		map.put(89, "foo");
		map.put(35, "bar");
		map.put(5, "baz");
		assertEquals(4, map.buckets.length);
		assertEquals(3, map.size());
		assertEquals(2, map.buckets[1].size());
		assertEquals(1, map.buckets[3].size());
		
		// Overwrite a key
		map.put(35, "foobar");
		assertEquals(4, map.buckets.length);
		assertEquals(3, map.size());
		assertEquals(2, map.buckets[1].size());
		assertEquals(1, map.buckets[3].size());
	}

    @Test
    public void testGet() {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		map.put(89, "foo");
		map.put(35, "bar");
		map.put(5, "baz");
		assertNull(map.get(3242));
		assertEquals("baz", map.get(5));
		assertEquals("bar", map.get(35));;
		map.put(5, "bazzz");
		assertEquals("bazzz", map.get(5));
	}



    @Test
    public void testExpand() {
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		assertEquals(4, map.buckets.length);
		map.put(89, "foo");
		map.put(35, "bar");
		map.put(5, "baz");
		assertEquals(4, map.buckets.length);

		// Hashtable should expand after two more are added
		map.put(2, "baz");
		map.put(3, "bazz");
		assertEquals(8, map.buckets.length);
		assertEquals(1, map.buckets[1].size());
		assertEquals(1, map.buckets[2].size());
		assertEquals(2, map.buckets[3].size());
		assertEquals(1, map.buckets[5].size());
	}
}
