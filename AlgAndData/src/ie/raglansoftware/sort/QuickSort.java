package ie.raglansoftware.sort;

import ie.raglansoftware.util.Sorting;

/**
 * @author David Lynch (C) 2011
 */
public class QuickSort 
	implements IntegerArraySort
{	
	@Override
	public int[] sort(int[] inputArray) {
		quicksort(inputArray,0,inputArray.length-1);
		return inputArray;
	}
	
	/**
	 * Partition the elements in the array denoted by the specified bounds around a pivot 
	 * such that each element in the sub-array [l...p-1] is <= the pivot value which in turn
	 * is <= every value in the right sub-array [p+1...r]
	 * 
	 * @param inputArray 		The array to partition in-place
	 * @param leftPointer 		A left limit (l) 
	 * @param rightPointer 		A right limit (r)
	 * @return pivotLocation 	The new pivot location which bounds the left and right sub-arrays
	 */
	protected int partition(int[] inputArray, int leftPointer, int rightPointer) {  
		/** The pivot is the right most element **/
		int pivot = inputArray[rightPointer];
		
		/** Initialise the base pointer. This will define the limit at maintenance of 
		 *  the partition that satisfies the loop invariant */
		int basePointer = leftPointer-1; 
		
		/** For each element between the bounds */
		for (int currentPointer=leftPointer; 
			 currentPointer<rightPointer;
		     currentPointer++) 
		{
			/** if this element is <= the value of the pivot */
			if(inputArray[currentPointer]<=pivot) 
			{
				/** move the base pointer up */
				basePointer++;
				Sorting.exchange(inputArray,basePointer,currentPointer);
			}
		}
		/** Put the pivot in place */
		Sorting.exchange(inputArray,basePointer+1,rightPointer);
		/** Return the new pivot location */
		return basePointer+1; 
	}
	
	
	/**
	 * A partition implementation that randomises the selection of the pivot
	 * @see partition(int[],int,int)
	 */
	protected int randomizedPartition(int[] inputArray, int leftPointer, int rightPointer) 
	{  
		int pivotPointer = random(leftPointer,rightPointer);
		/** Our implementation expects the pivot to sit at the right-most bound */
		Sorting.exchange(inputArray, rightPointer, pivotPointer);
		return partition(inputArray,leftPointer,rightPointer);
	}
	
	/**
	 * Given an input array of integers bound by limits quicksort the array with random 
	 * selection of the pivot
	 * @param inputArray
	 * @param leftPointer
	 * @param rightPointer
	 */
	protected void randomizedQuicksort(int[] inputArray, int leftPointer, int rightPointer) {
		if (leftPointer<rightPointer) {
			int pivotPointer = randomizedPartition(inputArray, leftPointer, rightPointer);
			randomizedQuicksort(inputArray,leftPointer,pivotPointer-1);
			randomizedQuicksort(inputArray,pivotPointer+1,rightPointer);
		}
	}
	
	/**
	 * Given an input array of integers bounded by limits quicksort the array.
	 * @param inputArray
	 * @param leftPointer
	 * @param rightPointer
	 */
	protected void quicksort(int[] inputArray, int leftPointer,int rightPointer) {
		if (leftPointer<rightPointer) {
			int pivotPointer = partition(inputArray, leftPointer, rightPointer);
			quicksort(inputArray, leftPointer, pivotPointer-1);
			quicksort(inputArray, pivotPointer+1, rightPointer);
		}
	}
	
	/**
	 * @param lower
	 * @param upper
	 * @return a random number between lower and upper bounds
	 */
	protected int random(int lower, int upper) {
		int range = upper-lower;
		int random = (int)(Math.random()*10000);
		return lower+(random%range);
	}
}
