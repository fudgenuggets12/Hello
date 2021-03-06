package Working;

public class QuickSort {

		//Element 0 keeps track of Comparisons, Element 1 keeps track of movements, and Element 2 keeps track of time.
		static long[] threeVals = {0, 0, 0};

	public static long[] quickSort(int[] list){


		//Time before sorting is completed
		long st = System.nanoTime();

		quickSort(list, 0, list.length - 1);


			long et = System.nanoTime();
		//Calculates runtime of the sorting by subtracting the time at the end from the time at the start
		threeVals[2] = et - st;
		//Returns comparisons, movements, and total time in that order;
		return threeVals;
	}

	public static void quickSort(int[] list, int first, int last){
		if(last > first){
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex + 1, last);
		}
	}


	/** partition the list array **/
	public static int partition(int[] list, int first, int last){
		int pivot = list[first];
		threeVals[1]++;
		int low = first +1;
		int high = last;

		while(high>low){

			while(low <= high && list[low] <= pivot){
				threeVals[0]++;
				low++;
			}	


			while( low <= high && list[high]> pivot) {
				high--;
				threeVals[0]++;
				}
			

			if(high > low){
				//thereis amovement done
				threeVals[1]+=3;

				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while(high > first && list[high] >= pivot) {
			high--;
			threeVals[0]++;
		}
		threeVals[0]+=1;
		if(pivot > list[high]){
			//another movement done
			threeVals[1]+=2;

			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else{
			return first;
		}
	}

}

