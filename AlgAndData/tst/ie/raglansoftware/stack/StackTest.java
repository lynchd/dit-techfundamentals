package ie.raglansoftware.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	private Stack stack;
	
	@Before
	public void setUp() {
		stack = new Stack(100);
	}

	
	@Test public void testPush() 
		throws Exception
	{
		for(int i = 1;i<=100;i++) {
			stack.push(new String("Iteration " + i));
		}
		assertEquals("Iteration 100",stack.pop());
	}
	
	@Test(expected= Exception.class) public void testBelowZeroPop() 
		throws Exception
	{
		stack.pop();
	}
	
	@Test(expected= Exception.class) public void testStackFull() {
		for(int i=0;i<1000;i++) {
			stack.push(i);
		}
	}
}
