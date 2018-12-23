package sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

	private static int partition(List<Integer> data, int startIndex, int endIndex) {
		int pivot = data.get(endIndex);
	    int i = (startIndex-1);
	 
	    for (int j = startIndex; j < endIndex; j++) {
	        if (data.get(j) <= pivot) {
	            i++;
	 
	            int swapTemp = data.get(i);
	            data.set(i,data.get(j));
	            data.set(j, swapTemp);
	        }
	    }
	 
	    int swapTemp = data.get(i+1);
	    data.set(i+1, data.get(endIndex));
	    data.set(endIndex, swapTemp);
	 
	    System.out.println("Changed list");
		for (int k:data) {
			System.out.print(k);
			System.out.print(",");
		}
	    return i+1;
	}
	
	private static void QuickSort(List<Integer> data, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int partitionIndex = partition(data, startIndex, endIndex);
			QuickSort(data, startIndex, partitionIndex -1);
			QuickSort(data, partitionIndex+1, endIndex);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> unsortedList = Arrays.asList(5,2,10,20,11,1,24,50,11,6,0,59,70);
		System.out.println("unsorted list");
		for (int i:unsortedList) {
			System.out.print(i);
			System.out.print(",");
		}
		QuickSort(unsortedList, 0, unsortedList.size()-1);
		System.out.println("quicksorted list");
		for (int i:unsortedList) {
			System.out.print(i);
			System.out.print(",");
		}

	}

}
