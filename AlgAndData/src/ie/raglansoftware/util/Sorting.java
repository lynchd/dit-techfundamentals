package ie.raglansoftware.util;

public class Sorting {
	public static void exchange(int[] inputArray, int first, int second) {
		int secondElement 	= inputArray[second];
		inputArray[second]	=inputArray[first];
		inputArray[first]	=secondElement;
	}
	
	public static int largest(int[] inputArray) {
		int largest = inputArray[0];
		for (int i = 1; i<inputArray.length;i++) {
			if (inputArray[i]>largest)
				largest=inputArray[i];
		}
		return largest;
	}
	
	public static String arrayToString(int[] inputArray) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < inputArray.length; i++) {
			builder.append(inputArray[i]);
			if (i<inputArray.length-1) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
	}
}
