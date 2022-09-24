package lab_ObjectAndClass_stopWatch;

import java.util.Random;

public class StopWatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = new int[100000];
		StopWatch stp = new StopWatch();
		Random rndm = new Random();
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = rndm.nextInt(100);
		}
		
		
		selectionSort(numbers);
		stp.stop();
		
		System.out.println("Sorting 100,000 numbers (gernerated randomly in the range of 0 to 100)" + stp.getElapsedTime());

	}
	
	  /** The method for sorting the numbers */
	  public static void selectionSort(int[] list) {
		    for (int i = 0; i < list.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      int currentMin = list[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < list.length; j++) {
		        if (currentMin > list[j]) {
		          currentMin = list[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        list[currentMinIndex] = list[i];
		        list[i] = currentMin;
		      }
		    }
		  }


}
