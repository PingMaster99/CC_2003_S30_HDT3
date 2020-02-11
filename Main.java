import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numberArray = SortMethods.getDataArray();


        for(int i = 0; i < numberArray.size(); i++) {
            System.out.println(numberArray.get(i));
        }
        List<Integer> sorted = SortMethods.mergeSort(numberArray);
        System.out.println(sorted);


    }
}
