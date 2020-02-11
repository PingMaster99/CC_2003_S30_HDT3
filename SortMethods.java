import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SortMethods {
    public void selectionSort(int[] unsortedData) {

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

        if(data.size() > 1) {
            int middle = data.size()/2;
            int end = data.size();
            List<Integer> firstHalf = data.subList(start, middle);
            List<Integer> secondHalf = data.subList(middle, end);

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
}
