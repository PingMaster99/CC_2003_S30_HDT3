import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DocumentMethods {
    // 0 - 500 000 minimo 8 muestras para graficas
    public static List<Integer> getDataArray(String fileName) {
        List<Integer> dataArray = new ArrayList<>();
        String data = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
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

    public static void generateRandomData(int length, String fileName) {
        try {
            PrintWriter fileBuilder = new PrintWriter(fileName, "UTF-8");
            Random randomData = new Random();
            for(int i = 0; i < length; i++) {
                int randomNumber = randomData.nextInt(500001);
                String printingValue = randomNumber + " ";
                fileBuilder.print(printingValue);
            }
            fileBuilder.close();
        } catch (Exception e) {
            System.out.println("File could not be made");
        }

    }
}
