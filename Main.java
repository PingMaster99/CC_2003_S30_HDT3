import java.util.ArrayList;
import java.util.List;
/**
 * <h1>Main</h1>
 * Main method used to run the sorts on a document with random generated data.
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-02-11
 **/
public class Main {

    public static void main(String[] args) {

        /**
            Generates a document with 3000 random values
            (if you wish to add a different number, change it to the
            desired output. The following arrays are used to save the random data generated.
         */
        DocumentMethods.generateRandomData(3000, "data.txt");
        List<Integer> Insertion = DocumentMethods.getDataArray("data.txt");  // Values for the insertion sort
        List<Integer> numberArray = DocumentMethods.getDataArray("data.txt");    // Same values for other sorts

        // Makes a list of lists that holds the values used for each sort
        List<List> mainData = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            mainData.add(numberArray);
        }

        /**
             Call the different sorts to organize the data.
         */
        List<Integer> listResult = SortMethods.insertionSort(Insertion);    // Insertion empties the original array
        SortMethods.mergeSort(mainData.get(0));
        SortMethods.radixSort(mainData.get(1));
        SortMethods.selectionSort(mainData.get(2));
        SortMethods.quickSort(mainData.get(3), 0, numberArray.size() - 1);


        // Sort results print
        System.out.println("Sort type");
        System.out.println("Insertion  " + listResult);
        System.out.println("Merge      " + mainData.get(0));
        System.out.println("Radix      " + mainData.get(1));
        System.out.println("Selection  " + mainData.get(2));
        System.out.println("Quick      " + mainData.get(3));

        /**
             Call them again with the data already organized
         */
        List<Integer> sortedResult = SortMethods.insertionSort(listResult);
        SortMethods.mergeSort(mainData.get(0));
        SortMethods.radixSort(mainData.get(1));
        SortMethods.selectionSort(mainData.get(2));
        SortMethods.quickSort(mainData.get(3), 0, numberArray.size() - 1);
    }
}
