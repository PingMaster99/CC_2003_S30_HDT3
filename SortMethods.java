import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * <h1>SortMethods</h1>
 * Methods used to implement sorts.
 * The following references were used as a base to generate the sorting algorithms:
 * https://www.geeksforgeeks.org/selection-sort/
 * https://www.geeksforgeeks.org/radix-sort/
 * https://www.geeksforgeeks.org/insertion-sort/
 * https://www.geeksforgeeks.org/merge-sort/
 * https://www.geeksforgeeks.org/quick-sort/
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-02-11
 **/
public class SortMethods {


    /**
     * This method is used to implement the selection sort
     * @param unsortedData the data to be organized
     */
    public static void selectionSort(List<Integer> unsortedData) {
        int minValueIndex;
        int i;

        // Repeats for the length of the original list.
        for(i = 0; i < unsortedData.size() - 1; i++) {
            minValueIndex = i;

            // Finds the minimum value and gets its index
            for(int j = i + 1; j < unsortedData.size(); j++) {
                if(unsortedData.get(j) < unsortedData.get(minValueIndex)){
                    minValueIndex = j;
                }
            }
            // Swaps it into its correct place
            Collections.swap(unsortedData, minValueIndex, i);
        }
    }

    /**
     * This method is used to implement the insertion sort
     * @param data the data to be organized
     * @return list with the sorted data.
     */
    public static List<Integer> insertionSort(List<Integer> data) {
        List<Integer> sortedList = new ArrayList<>();
        int indexPosition = 0;

        // While there are more elements in the original list:
            while(!data.isEmpty()) {
                // Gets the first element
                int value = data.remove(0);

                // Organizes it in the new list
                for(int i = 0; i < sortedList.size(); i++) {
                    if(value >= sortedList.get(i)) {
                        indexPosition = i + 1;
                    }
                }

                sortedList.add(indexPosition, value);
                indexPosition = 0;
            }
        // Returns the sorted list
        return sortedList;
    }

    /**
     * This method is used to implement the merge sort
     * @param data the data to be organized
     * @return list with the sorted data.
     */
    public static List<Integer> mergeSort(List<Integer> data) {
        List<Integer> sorted = new ArrayList<>();
        int start = 0;
        // The lists to divide the original input
        List<Integer> firstHalf = new ArrayList<Integer>();
        List<Integer> secondHalf = new ArrayList<Integer>();

        // Divides the list in two halves
        if(data.size() > 1) {
            int middle = data.size()/2;
            int end = data.size();

            for(int i = 0; i < middle; i++) {
                firstHalf.add(data.get(i));
            }

            for(int j = middle; j<data.size(); j++ ) {
                secondHalf.add(data.get(j));
            }
            // Recursive merge sort
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            // Once finished, calls the merge method
            sorted = merge(firstHalf, secondHalf, data);
        }
        // Returns sorted data.
        return sorted;
    }
    /**
     * This method is used to merge arrays in the merge sort
     * @param firstHalf first half of the list
     * @param secondHalf second half
     * @param  data original data to be sorted
     * @return list with the sorted data.
     */
    private static List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf, List<Integer> data) {
        int firstIndex = 0;
        int secondIndex = 0;
        int sortedIndex = 0;

        // Finds the minimum value on each of the halves and places it on the merged, sorted list
        while(firstHalf.size() > firstIndex && secondHalf.size() > secondIndex) {
            if(firstHalf.get(firstIndex) < secondHalf.get(secondIndex)) {
                data.set(sortedIndex, firstHalf.get(firstIndex));
                firstIndex ++;
            } else {
                data.set(sortedIndex, secondHalf.get(secondIndex));
                secondIndex ++;
            }
            sortedIndex ++;
        }

        // These whiles add the left items.
        while(firstIndex < firstHalf.size()) {
            data.set(sortedIndex, firstHalf.get(firstIndex));
            sortedIndex++;
            firstIndex++;
        }

        while(secondIndex < secondHalf.size()) {
            data.set(sortedIndex, secondHalf.get(secondIndex));
            sortedIndex++;
            secondIndex++;
        }

        // Returns merged and organized data.
        return data;
    }

    /**
     * This method is used to divide lists for the quick sort.
     * @param data the data to be organized
     * @param low lower bound for the list
     * @param high higher bound for the list
     * @return list with the sorted data.
     */
    private static int quickSortDivide(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int itemFromLeft = low - 1;


        // Swaps the elements to organize data to the left or right of the pivot according to if its greater or smaller
        for(int i = low; i < high; i ++) {
            if(data.get(i) < pivot) {
                itemFromLeft++;
                Collections.swap(data, itemFromLeft, i);
            }
        }

        // Swaps the pivot back into place
        Collections.swap(data, itemFromLeft + 1, high);
        return itemFromLeft + 1;
    }

    /**
     * This method is used to implement the quicksort
     * @param data the data to be organized
     * @param low the lower bound of the list
     * @param high the higher bound for the list
     */
    public static void quickSort(List<Integer> data, int low, int high) {
        // If the lower index is less than the higher:
        if(low < high) {
            // Gets the partition index; the pivot, and organizes the list
            int partitionIndex = quickSortDivide(data, low, high);
            // Calls the quicksort again for each partition
            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);
        }

    }


    /**
     * This method gets the biggest value in a list
     * @param list the list that contains the values
     * @return int with the biggest value
     */
    private static int getMaxValue(List<Integer> list) {
        int maxValue = list.get(0);
        // Checks if there's a value grater than the current one (starts with position 0 value)
        for(int i = 1; i < list.size(); i++){
            if(maxValue < list.get(i)) {
                maxValue = list.get(i);
            }
        }
        // Returns the biggest value
        return maxValue;
    }

    /**
     * This method implements the radix sort
     * @param data the list that contains the values
     * @return list with the sorted data
     */
    public static List<Integer> radixSort(List<Integer> data) {
        int maxNumber = getMaxValue(data);
        List<Integer> result = new ArrayList<>();
        // Applies the counting sort for every digit in the largest number
        for(int exponent = 1; maxNumber / exponent > 0; exponent *= 10) {
            result = countSort(data, exponent);
        }
        // Returns the sorted data
        return result;
    }
    /**
     * This method implements the counting sort, used in the radix sort
     * @param list the list that contains the values
     * @param exponent the exponent to see which number position will be analyzed
     * @return list with the sorted data according to the exponent
     */
    private static List<Integer> countSort(List<Integer> list, int exponent) {

        int originalSize= list.size();
        //Creates the arrays used to save values, initializes the one with the count with zeros.
        int[] sorted = new int[originalSize];
        int[] countingList = new int[10];
        Arrays.fill(countingList, 0);

        // Counts the values of each digit from the original list
        for(int i = 0; i < originalSize; i++) {
            countingList[(list.get(i) / exponent) % 10]++;
        }

        // Shifts them so that they are correctly placed
        for(int i = 1; i < 10; i++) {
            countingList[i] += countingList[i - 1];
        }

        // Adds them to the sorted list in the right order
        for (int i = originalSize - 1; i >= 0; i--)
        {
            sorted[countingList[(list.get(i)/exponent)%10 ] - 1] = list.get(i);
            countingList[ (list.get(i)/exponent)%10 ]--;
        }

        // Sets them back into the original list
        for (int i = 0; i < originalSize; i++) {
            list.set(i, sorted[i]);
        }

        // Returns the organized list.
        return list;
    }
}
