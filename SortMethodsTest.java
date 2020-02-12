import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
/**
 * <h1>SortMethodsTest</h1>
 * Junit tests for the sorts implemented
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-02-11
 **/
public class SortMethodsTest {

    /**
     * These tests check the sorts by using SortMethods
     * method results, and comparing with expected values.
     */
    @org.junit.Test
    public void selectionSort() {
        SortMethods instance = new SortMethods();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        instance.selectionSort(unsorted);
        assertEquals(sorted,unsorted);
    }

    @org.junit.Test
    public void insertionSort() {
        SortMethods instance = new SortMethods();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        unsorted = instance.insertionSort(unsorted);
        assertEquals(sorted,unsorted);
    }

    @org.junit.Test
    public void mergeSort() {
        SortMethods instance = new SortMethods();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        unsorted = instance.mergeSort(unsorted);
        assertEquals(sorted,unsorted);
    }

    @org.junit.Test
    public void quickSort() {
        SortMethods instance = new SortMethods();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        instance.quickSort(unsorted, 0, unsorted.size() - 1);
        assertEquals(sorted,unsorted);
    }

    @org.junit.Test
    public void radixSort() {
        SortMethods instance = new SortMethods();
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> sorted = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        unsorted = instance.radixSort(unsorted);
        assertEquals(sorted,unsorted);
    }
}