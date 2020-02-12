import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * <h1>DocumentMethods</h1>
 * Methods used to read and generate a document with random data.
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-02-11
 **/
public class DocumentMethods {
    /**
     * This method is used to get a list with the values in a given document
     * @param fileName the name of the file
     * @return List with the values in the document.
     */
    public static List<Integer> getDataArray(String fileName) {
        List<Integer> dataArray = new ArrayList<>();
        String data = "";
        try {
            // Reads the contents of the document
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            String temp = "";
            String bfRead;

            while((bfRead = bf.readLine()) != null) {
                data += bfRead;
            }

        } catch(Exception e) {
            // If file not found
            System.err.println("File not found");
            return dataArray;
        }

        // Makes an array with the data, split every space
        String stringArray[] = data.split(" ");
        int numberArray[] = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++) {
            dataArray.add(i, Integer.parseInt(stringArray[i]));
        }
        // Returns a list with the data.
        return dataArray;
    }

    /**
     * This method is used to generate a document with random numbers.
     * @param length the number of elements to generate
     * @param fileName the name of the file to generate
     */
    public static void generateRandomData(int length, String fileName) {
        try {
            // Specifies encoding and writing
            PrintWriter fileBuilder = new PrintWriter(fileName, "UTF-8");
            // Generates the amount of random numbers specified
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
