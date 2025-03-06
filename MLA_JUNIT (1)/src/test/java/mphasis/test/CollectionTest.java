package mphasis.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

public class CollectionTest {
	
	@Test
	public void testListOfNumbers()
	{
		List<Integer> li = Arrays.asList(9,8,7,6,5);
		List<Integer> exptData = Arrays.asList(9,8,7,6,5);
		
		// method1 : assertEquals(exptData, li);
		// method2 : assertThat(li, is(exptData));
		// assertThat(li, hasItems(9));
		// assertThat(li.size(), is(6));
//		assertThat(li, IsEmptyCollection.empty());
	}
	
	@Test
	public void testCollectionObjects()
	{
		List<Product1> li1 = Arrays.asList(
				new Product1("banana",5),
				new Product1("apple",7)
				);
	}
	
	
	
}
