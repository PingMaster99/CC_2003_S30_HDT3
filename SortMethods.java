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

                    if(value >= sortedList.get(i)) {
                        indexPosition = i + 1;
                    }
                }

                sortedList.add(indexPosition, value);
                indexPosition = 0;
            }
        return sortedList;
    }


    // Llama a merge
    /*
    public static List<Integer> mergeSort(List<Integer> data) {
        if(data.size() == 1) {
            return data;
        } else {
            return divideLists(data);
        }
    }*/

    public static List<Integer> mergeSort(List<Integer> data) {
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

            mergeSort(firstHalf);
            mergeSort(secondHalf);
            sorted = merge(firstHalf, secondHalf, data);
        }

        return sorted;
    }

    public static List<Integer> merge(List<Integer> firstHalf, List<Integer> secondHalf, List<Integer> data) {
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

        return data;
    }

    public static int quickSortDivide(List<Integer> data, int low, int high) {
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



    public static int getMaxValue(List<Integer> list) {
        int maxValue = list.get(0);
        for(int i = 1; i < list.size(); i++){
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

    public static List<Integer> countSort(List<Integer> list, int exponent) {

        int originalSize= list.size();
        int[] sorted = new int[originalSize];
        int[] countingList = new int[10];
        Arrays.fill(countingList, 0);

        for(int i = 0; i < originalSize; i++) {
            countingList[(list.get(i) / exponent) % 10]++;
        }

        for(int i = 1; i < 10; i++) {
            countingList[i] += countingList[i - 1];
        }
        for (int i = originalSize - 1; i >= 0; i--)
        {
            sorted[countingList[(list.get(i)/exponent)%10 ] - 1] = list.get(i);
            countingList[ (list.get(i)/exponent)%10 ]--;
        }

        for (int i = 0; i < originalSize; i++) {
            list.set(i, sorted[i]);
        }
        return list;
    }
}
