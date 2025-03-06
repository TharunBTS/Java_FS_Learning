package mphasis.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class testUserData {
	
//	@Test
//	public void testUserName()
//	{
//		assertThrows(IllegalArgumentException.class, new Executable() {
//			
//			@Override
//			public void execute() throws Throwable {
//				
//				UserClass1 uc = new UserClass1();
//				uc.setName(null);
//			}
//		});
//	}
	
//	@Test
//	public void testUserNameIsSort()
//	{
//		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//				UserClass1 uc = new UserClass1();
//				uc.setName("ro");
//		});
//		
//		assertEquals("username can't be blank", exception.getMessage());
//	}
	
//	@Rule
//	public expectedException exception = expectedException
//	.none();
	
	@Test(expected = IllegalArgumentException.class)
	public void testNameValues()
	{
		UserClass1 uc = new UserClass1();
		uc.setName(null);
	}

}
