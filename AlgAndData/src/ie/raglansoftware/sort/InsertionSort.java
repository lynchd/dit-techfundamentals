package ie.raglansoftware.sort;
/**
 * @author David Lynch
 */
public class InsertionSort 
	implements IntegerArraySort
{
	public int[] sort(int[] inputArray) {
		/** For each key in the array **/
		for (int currentKeyPointer = 1; 
			 currentKeyPointer<inputArray.length; 
			 currentKeyPointer++) {
			/** Store the current key, as it may be over-written by the shuffle **/
			int currentKey = inputArray[currentKeyPointer];
			/** Use another pointer to shift the previous elements forward if required 
			 *  Start this as the element to the immediate left in the array
			 * **/
			int shiftPointer = currentKeyPointer-1;
			/**
			 * While we have not hit the left bound of the array and while the examined
			 * value is greater than the current key
			 */
			while (shiftPointer>0 && inputArray[shiftPointer]>currentKey) {
				/**
				 * Shift the element right
				 */
				inputArray[shiftPointer+1]=inputArray[shiftPointer];
				shiftPointer=shiftPointer-1;
			}
			/** Finally place the current key in it's new-found slot **/
			inputArray[shiftPointer+1]=currentKey;
		}
		return inputArray;
	}

}
