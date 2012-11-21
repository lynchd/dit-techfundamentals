package ie.raglansoftware.sort;

import ie.raglansoftware.util.Sorting;
/**
 * @author David Lynch (C) 2011
 */
public class CountingSort 
	implements IntegerArraySort
{
	public int[] sort(int[] inputArray) {
		/** For storing the results */
		int[] result = new int[inputArray.length];
		
		/** Find the largest element in the array */
		int kLargest = Sorting.largest(inputArray);
		/** 
		 * Store an array where index i represents the number and the
		 * value at counts[i] will represent the number of elements that
		 * are specifically less than or equal to that number
		 * Java will automatically initialize these counts to zero 
		 **/
		int counts[] = new int[kLargest];
		/** The first iteration inserts 1 or 0 to the count slot */
		for (int j=0; j<inputArray.length; j++) {
			counts[inputArray[j]-1]=counts[inputArray[j]-1]+1;
		}
		/** This iteration will sum each slot, leaving the count of the
		 *  numbers <= that pointed to the index for the current array
		 */
		for (int i=1; i<kLargest; i++) {
			counts[i]=counts[i]+counts[i-1];
		}
		/** For each element of the input array **/
		for (int j=inputArray.length-1;j >= 0; j--) {
			/** Get the pointer into the count array **/
			int countElementPointer = inputArray[j]-1; // remember arrays start at zero
			/** The result location will be the count of the numbers less than the current element */
			int resultPointer = counts[countElementPointer]-1;
			/** Set the result */
			result[resultPointer]=inputArray[j];
			/** Adjust the count for numbers less than the current pointer */
			counts[countElementPointer]=counts[countElementPointer]+1;
		}
		return result;
	}
}
