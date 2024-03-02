import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        String line = "";
        try {
            File file = new File("matrixDimensions.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> dimensions = new ArrayList<Integer>();
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                dimensions.add(Integer.valueOf(line));
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("No file named 'matrixDimensions.txt' found");
        } catch (NumberFormatException e){
            System.out.println("Input file contains non-numerical char: " + line);
        }
    }

    public void Matrix_Chain_Order(ArrayList<Integer> p){
        int n = p.size() - 1;

        // Create multiplication counts array with initial values of 0
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                m[i][j] = 0;
            }
        }

        

    }
}