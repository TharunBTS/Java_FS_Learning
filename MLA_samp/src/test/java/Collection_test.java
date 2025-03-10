import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;



import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Collection_test {
	
	static List<samp_class> ls;
	
	@BeforeClass
	public static void init()
	{
		ls = Arrays.asList(
				
			new samp_class(1,"ram",21),
			new samp_class(2,"ravi",22),
			new samp_class(3,"raghu",23),
			new samp_class(4,"ragul",24),
			new samp_class(5,"revi",25)
			
			);
	}
	
	@Test
	public void check1()
	{
		String s = "rambo";
		assertThat(ls.size(), is(5));
	}
	
	@Test
	public void check2()
	{
		assertEquals(ls.get(1).getName(), "ravi");
	}
	
	@Test
	public void check3()
	{
		List<samp_class> ls1 = Arrays.asList(
				
				new samp_class(1,"ram",21),
				new samp_class(2,"ravi",22),
				new samp_class(3,"raghu",23),
				new samp_class(4,"ragul",24),
				new samp_class(5,"revi",25)
				
				);
		assertEquals(ls.hashCode(), ls.hashCode());
	}
	
	@Test
	public void testUserId()
	{
		assertThrows(I0llegalArgumentException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				
				samp_class uc = new samp_class();
				uc.setId(-1);
			}
		});
	}
	
}
