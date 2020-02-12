import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Sorts with 375 elements
        DocumentMethods.generateRandomData(3000, "data.txt");
        List<Integer> Insertion = DocumentMethods.getDataArray("data.txt");  // Values for the insertion sort
        List<Integer> numberArray = DocumentMethods.getDataArray("data.txt");    // Same values for other sorts

        // Makes a list of lists that holds the values used for each sort
        List<List> mainData = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            mainData.add(numberArray);
        }

        List<Integer> listResult = SortMethods.insertionSort(Insertion);
        SortMethods.mergeSort(mainData.get(0));
        SortMethods.radixSort(mainData.get(1));
        SortMethods.selectionSort(mainData.get(2));
        SortMethods.quickSort(mainData.get(3), 0, numberArray.size() - 1);


        // Sort results
        System.out.println("Sort type");
        System.out.println("Insertion  " + listResult);
        System.out.println("Merge      " + mainData.get(0));
        System.out.println("Radix      " + mainData.get(1));
        System.out.println("Selection  " + mainData.get(2));
        System.out.println("Quick      " + mainData.get(3));

    }
}
