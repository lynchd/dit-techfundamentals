package ie.dit.architecture.memory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ie.dit.architecture.ByteManipulation;

public class MemoryChipUnitTest {

	private Memory memory;

	@Before public void setUp() {
		 memory = MemoryChip.buildFilled32byteMemory(50, 75);
	}
	
	@Test public void testWrite() {
		memory.enable();
		memory.writeEnable();
		byte[] locations = memory.getLocations();
		for(int i = 0;i<=memory.getLimit();i++) {
			assertEquals(locations[i],
					ByteManipulation.twosCompliment((byte)i));
		}
	}
	
	@Test public void testRead() { 
		memory.enable();
		memory.readEnable();
		for(int i = 0;i<=memory.getLimit();i++) {
			assertEquals(memory.read(i),
					ByteManipulation.twosCompliment((byte)i));
		}
	}
	
	@Test(expected= IllegalAccessError.class)public void testUpperLimit() { 
		memory.enable();
		memory.writeEnable();
		memory.write(-1, (byte)0xFF);
	}
	
	@Test(expected= IllegalAccessError.class)public void testLowerLimit() { 
		memory.enable();
		memory.writeEnable();
		memory.write(memory.getLimit()+1, (byte)0xFF);
	}
	
	@Test(expected= IllegalAccessError.class) public void testSelect() { 
		memory.disable();
		memory.read(0);
	}
	
	@Test(expected= IllegalAccessError.class) public void testReadWriteCheck() { 
		memory.enable();
		memory.writeEnable();
		memory.read(0);
	}
}

