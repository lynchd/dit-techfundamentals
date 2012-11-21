package ie.raglansoftware.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import ie.raglansoftware.util.Sorting;

public class SortingTests {
	private int[] inputArray;
	private int[] sortedArray;
	
	@Before public void setUp() {
		inputArray  = new int[]  {1,5,10,6,9,3,4};
		sortedArray = new int[]  {1,3,4,5,6,9,10};
	}
	
	@Test public void testMergeSort() {
		testSort(new InsertionSort(), inputArray);
	}
	
	@Test public void testInsertSort() {
		testSort(new InsertionSort(), inputArray);
	}
	
	@Test public void testQuicksort() {
		testSort(new QuickSort(), inputArray);
	}
	
	@Test public void testCountingSort() {
		testSort(new CountingSort(), inputArray);
	}
	
	private void testSort(IntegerArraySort sort, int[] inputArray) {
		int[] result = sort.sort(inputArray);
		System.out.println(Sorting.arrayToString(result));
		assertArrayEquals(sortedArray,result);
	}
	
	
}
