package ie.dit.architecture;

public class ByteManipulation {
	/**
	 * Bitwise way of negating a byte. Invert the bits and add 1, for example
	 * changes 1 to -1.
	 */
	public static byte twosCompliment(byte value) {
		byte inversion = (byte)~value;
		byte twosCompliment = (byte)((int)inversion+1);
		return twosCompliment;
	}
}


