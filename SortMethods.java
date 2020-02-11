import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMethods {

    public static void selectionSort(List<Integer> unsortedData) {
        int minValueIndex;
        int i;

        for(i = 0; i < unsortedData.size() - 1; i++) {

            minValueIndex = i;

            for(int j = i + 1; j < unsortedData.size(); j++) {
                if(unsortedData.get(j) < unsortedData.get(minValueIndex)){
                    minValueIndex = j;
                    System.out.println("j " + minValueIndex);
                }
            }
            Collections.swap(unsortedData, minValueIndex, i);
        }
    }

    public static List<Integer> insertionSort(List<Integer> data) {

        List<Integer> sortedList = new ArrayList<>();
        int indexPosition = 0;

            while(!data.isEmpty()) {
                int value = data.remove(0);

                for(int i = 0; i < sortedList.size(); i++) {
                    System.out.println(sortedList.get(i));

                    if(value >= sortedList.get(i)) {
                        indexPosition = i + 1;
                        System.out.println(indexPosition + " Index position");
                    }
                }

                sortedList.add(indexPosition, value);
                System.out.println(sortedList);
                indexPosition = 0;
            }
        return sortedList;
    }


    // Llama a merge
    public static List<Integer> mergeSort(List<Integer> data) {
        if(data.size() == 1) {
            return data;
        } else {
            return divideLists(data);
        }
    }

    private static List<Integer> divideLists(List<Integer> data) {
        List<Integer> sorted = new ArrayList<>();
        int start = 0;
        List<Integer> firstHalf = new ArrayList<Integer>();
        List<Integer> secondHalf = new ArrayList<Integer>();
        if(data.size() > 1) {
            int middle = data.size()/2;
            int end = data.size();

            for(int i = 0; i < middle; i++) {
                firstHalf.add(data.get(i));
            }

            for(int j = middle; j<data.size(); j++ ) {
                secondHalf.add(data.get(j));
            }

            divideLists(firstHalf);
            divideLists(secondHalf);
            sorted = merge(firstHalf, secondHalf, data);
        }

        return sorted;
    }

    private static List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf, List<Integer> data) {
        int firstIndex = 0;
        int secondIndex = 0;
        int sortedIndex = 0;

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

        System.out.println("Data before " + data);
        while(firstIndex < firstHalf.size()) {
            data.set(sortedIndex, firstHalf.get(firstIndex));
            System.out.println("Setting " + firstHalf.get(firstIndex));
            sortedIndex++;
            firstIndex++;
        }

        while(secondIndex < secondHalf.size()) {
            data.set(sortedIndex, secondHalf.get(secondIndex));
            System.out.println("Setting " + secondHalf.get(secondIndex));

            sortedIndex++;
            secondIndex++;
        }

        System.out.println("data " + data);
        return data;
    }

    // Quicksort prototype
    /*public static List<Integer> quickSort(List<Integer> unsortedData) {
        int pivot = unsortedData.get(0);
        System.out.println(pivot + " this is the pivot");
        int itemFromLeft = -100;
        int itemFromRight = unsortedData.size() + 1;
        int control = 0;
        Collections.swap(unsortedData, 0, unsortedData.size() - 1);

        while(itemFromLeft <= itemFromRight && control<unsortedData.size()) {
            for(int i = 0; i < unsortedData.size() - 1; i++) {
                if(unsortedData.get(i) > pivot) {
                    itemFromLeft = i;
                    break;
                }
            }

            for(int i = unsortedData.size() - 2; i >= 0; i--) {
                if(unsortedData.get(i) < pivot) {
                    itemFromRight = i;
                    break;
                }
            }

            if(itemFromLeft != -100 && itemFromRight != unsortedData.size() + 1) {
                Collections.swap(unsortedData, itemFromLeft, itemFromRight);
            }
            control ++;

        }

        if(itemFromLeft != -100 && itemFromRight != unsortedData.size() + 1) {
            Collections.swap(unsortedData, itemFromLeft, unsortedData.size() - 1);
        }



        return unsortedData;
    } */



    private static int quickSortDivide(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int itemFromLeft = low - 1;
        for(int i = low; i < high; i ++) {
            if(data.get(i) < pivot) {
                itemFromLeft++;
                Collections.swap(data, itemFromLeft, i);
            }
        }

        Collections.swap(data, itemFromLeft + 1, high);
        return itemFromLeft + 1;
    }

    public static void quickSort(List<Integer> data, int low, int high) {
        if(low < high) {
            int partitionIndex = quickSortDivide(data, low, high);
            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);
        }

    }


    // 0 - 500 000 minimo 8 muestras para graficas
    public static List<Integer> getDataArray() {
        List<Integer> dataArray = new ArrayList<>();
        String data = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("data.txt"));
            String temp = "";
            String bfRead;

            while((bfRead = bf.readLine()) != null) {
                data += bfRead;
            }

        } catch(Exception e) {

            System.err.println("File not found");
            return dataArray;
        }

        String stringArray[] = data.split(" ");
        int numberArray[] = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++) {
            dataArray.add(i, Integer.parseInt(stringArray[i]));
        }
        return dataArray;
    }

    private static int getMaxValue(List<Integer> list) {
        int maxValue = list.get(0);
        for(int i = 0; i < list.size(); i++){
            if(maxValue < list.get(i)) {
                maxValue = list.get(i);
            }
        }
        return maxValue;
    }

    public static List<Integer> radixSort(List<Integer> data) {
        int maxNumber = getMaxValue(data);
        List<Integer> result = new ArrayList<>();
        for(int exponent = 1; maxNumber / exponent > 0; exponent *= 10) {
            result = countSort(data, exponent);
        }
        return result;
    }

    private static List<Integer> countSort(List<Integer> list, int exponent) {
        List<Integer> sorted = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            sorted.add(0);
        }
        List<Integer> countingList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            countingList.add(0);
        }

        for(int i = 0; i < list.size(); i++) {
            countingList.set((list.get(i)/exponent) % 10, countingList.get((list.get(i)/exponent) % 10) + 1);
        }

        for(int i = 1; i < 10; i++) {
            countingList.set(i,countingList.get(i) + countingList.get(i-1));

        }

        for(int i = list.size() - 1; i >= 0; i--) {
            int value = list.get(i);
            sorted.set(countingList.get(((value/exponent) % 10)) -1, value);
            countingList.set(((list.get(i)/exponent)%10), countingList.get((list.get(i)/exponent)%10) -1);
        }
        System.out.println(sorted + "SoRT");
        return sorted;
    }
//**********************************************************************************************************************

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }






    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // Radix sort
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

}
