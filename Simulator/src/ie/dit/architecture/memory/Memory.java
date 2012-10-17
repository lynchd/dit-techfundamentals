package ie.dit.architecture.memory;

public interface Memory {
	/** Some important performance characteristics */
	public abstract int  getReadAccessTimeMs();
	public abstract int  getWriteAccessTimeMs();
	
	/** Read and chip switches */
	public abstract void chipEnabled(boolean chipEnabled);
	public abstract void readEnabled(boolean readEnabled);
	
	public abstract void readEnable();
	public abstract void writeEnable();
	
	public abstract void enable();
	public abstract void disable();
	
	public abstract byte[] getLocations();

	/** Read and write operations */
	public abstract void write(int location, byte value)
					throws IllegalAccessError;
	public abstract byte read(int location)
					throws IllegalAccessError;
	
	/** The limit of addressable memory*/
	public abstract int  getLimit();
	
}
