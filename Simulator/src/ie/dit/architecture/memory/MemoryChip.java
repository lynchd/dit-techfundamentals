package ie.dit.architecture.memory;

import ie.dit.architecture.Delay;
import ie.dit.architecture.ByteManipulation;

public class MemoryChip implements Memory {
	
	protected final byte[] memory;
	
	private final int readAccessTimeMs;
	private final int writeAccessTimeMs;
	
	private boolean chipEnabled;
	private boolean readWrite;
	
	private static final boolean READ_ENABLED  = false;
	private static final boolean WRITE_ENABLED = true;
	
	public MemoryChip(int sizeInBytes, 
					  int readAccessTimeMs, 
					  int writeAccessTimeMs) {
		if (readAccessTimeMs>=writeAccessTimeMs) {
			throw new IllegalArgumentException("Read access time must be less than write access time");
		}
		memory = new byte[sizeInBytes];
		chipEnabled = false;
		this.readAccessTimeMs = readAccessTimeMs;
		this.writeAccessTimeMs = writeAccessTimeMs;
	}
	
	@Override
	public byte[] getLocations() {
		return memory;
	}
	
	@Override
	public int getReadAccessTimeMs() {
		return readAccessTimeMs;
	}

	@Override
	public int getWriteAccessTimeMs() {
		return writeAccessTimeMs;
	}

	@Override
	public void chipEnabled(boolean chipEnabled) {
		this.chipEnabled = chipEnabled;	
	}

	@Override
	public void readEnabled(boolean readWrite) {
		this.readWrite = readWrite;
	}

	@Override
	public void write(int location, byte value) throws IllegalAccessError {
		checkEnabled();
		checkReadWrite(WRITE_ENABLED);
		checkValidLocation(location);
		Delay.delay(writeAccessTimeMs);
		memory[location]=value;
	}

	@Override
	public byte read(int location) throws IllegalAccessError {
		checkEnabled();
		checkReadWrite(READ_ENABLED);
		checkValidLocation(location);
		Delay.delay(readAccessTimeMs);
		return memory[location];
	}
	
	private void checkEnabled() 
		throws IllegalAccessError
	{
		if (!chipEnabled)
			throw new IllegalAccessError("Memory is not enabled.");
	}
	
	private void checkReadWrite(boolean test) 
		throws IllegalAccessError
	{
		if(readWrite!=test)
			throw new IllegalAccessError("Operation not permitted. Read/Write flag not correctly set.");
	}
		
	private void checkValidLocation(int location) 
		throws IllegalAccessError
	{
		if (location < 0 || location > getLimit()) {
			throw new IllegalAccessError("Operation out of bounds");
		}
	}
	
	public int getLimit() {
		return memory.length-1;
	}
	
	public static Memory buildFilled32byteMemory(int readAccessTimeMs, int writeAccessTimeMs)
	{
		Memory memory = new MemoryChip(32,readAccessTimeMs,writeAccessTimeMs);
		memory.chipEnabled(true);
		for(int i = 0; i <= memory.getLimit();i++) {
			memory.writeEnable();
			memory.write(i, ByteManipulation.twosCompliment((byte)i));
		}
		return memory;
	}

	@Override
	public void readEnable() {
		this.readWrite = READ_ENABLED;
	}

	@Override
	public void writeEnable() {
		this.readWrite = WRITE_ENABLED;
	}

	@Override
	public void enable() {
		this.chipEnabled = true; 		
	}

	@Override
	public void disable() {
		this.chipEnabled = false;
	}
}
