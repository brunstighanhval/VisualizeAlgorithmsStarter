package visualizealgorithms.bll.algorithm.sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author spangsberg
 */
public class QuickSort extends GenericAlgorithm {
    public QuickSort() {
        super("QuickSort", "5", AlgorithmType.SORTING);
    }
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    /**
     * Starter method including time measurement
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int[] quickSort(int[] arr, int low, int high) {
        Instant start = Instant.now();

        sort(arr, low, high);

        Instant finish = Instant.now();

        long elapsedTime = Duration.between(start, finish).toMillis();

        System.out.println("Finished QuickSort on " + arr.length + " items in " + elapsedTime + " ms");
        return arr;
    }

    @Override
    public void doWork() {
        int[] arr = (int[]) super.getData();
        quickSort(arr, 0, arr.length - 1);

    }
}