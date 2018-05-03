package com.xlw.test;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;

public class GoodsPicsTest extends BaseTest {

	@Test
	public void testAddGoodsPic() throws URISyntaxException {
		List<Long> addGoodsPics = addGoodsPics();
		assert (addGoodsPics.size() == 3);
	}

	@Test
	public void test() {
	}

}
