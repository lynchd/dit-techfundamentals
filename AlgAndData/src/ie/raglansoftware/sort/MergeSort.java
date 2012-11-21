package ie.raglansoftware.sort;
/**
 * @author David Lynch
 */
public class MergeSort 
	implements IntegerArraySort
{

	@Override
	public int[] sort(int[] inputArray) {
		mergeSort(inputArray, 0, inputArray.length-1);
		return inputArray;
	}
	
	private void mergeSort(int[] inputArray, int lowBound, int highBound) {
		if (lowBound<highBound) {
			/** Get the middle index **/
			int middle = (lowBound+highBound)/2;
			/** Merge sort the left sub-array including the middle **/
			mergeSort(inputArray,lowBound,middle);
			/** Merge sort the right sub-array **/
			mergeSort(inputArray,middle+1,highBound);
			/** Merge **/
			merge(inputArray,lowBound,middle,highBound);
		}
	}
	
	private void merge(int[] array, int lowBound, int middle, int highBound)
	{
		/**
		 * We need to store a copy of the sorted part of the array so we can merge back into 
		 * the original array
		 */
		int[] temporaryArray = new int[array.length];
		for (int i = 0;i<=highBound;i++) {
			temporaryArray[i]=array[i];
		}
		
		/**
		 * The index into the left sorted sub-array
		 */
		int leftPointer = lowBound;
		/**
		 * The index into the right sorted sub-array
		 */
		int rightPointer = middle+1;
		/**
		 * The index into the original array
		 */
		int resultPointer = lowBound;
		
		/**
		 * While we are within the bounds of the left sub-array and the bounds
		 * of the right sub-array
		 */
		while (leftPointer <= middle && rightPointer <= highBound) {
			/**
			 * Compare the elements at the indexes for each of the sub-arrays
			 */
			if (temporaryArray[leftPointer] <= temporaryArray[rightPointer]) {
				/**
				 * Choosing left if it's smaller or equal
				 */
				array[resultPointer]=temporaryArray[leftPointer];
				leftPointer++;
			}
			else {
				/**
				 * Otherwise choosing right
				 */
				array[resultPointer]=temporaryArray[rightPointer];
				rightPointer++;
			}
			/** Move on to the next target element in the array **/
			resultPointer++;
		}
		
		/**
		 * Because we include the middle element in the left array, we need to ensure
		 * that we finish out the final NIL comparison with the right side after we have
		 * broken out of the above while loop due to the right pointer's expiry
		 */
		while (leftPointer<=middle) {
			array[resultPointer] = temporaryArray[leftPointer];
			resultPointer++;
			leftPointer++;
		}
	}
}
