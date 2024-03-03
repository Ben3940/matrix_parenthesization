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
            int n = dimensions.size() - 1;

            // Create multiplication counts array with initial values of 0
            int[][] m = new int[n][n];
            int[][] s = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    m[i][j] = 0;
                    s[i][j] = 0;
                }
            }

            // Consider L consecutive matrices to parenthesize
            for (int L = 2; L < n; L++){
                // Split matricies into L pairs, from first matrix to n - L + 1 matrix
                for (int i = 1; i < n - L + 1; i++){
                    int j = i + L - 1;
                    
                    // Considers "k" ways to parenthesize matrices given L pairs((L = 2, k = 1), (L = 3, k = 2), etc.)
                    for (int k = i; k < j - 1; k++){
                        int multi_counts = m[i][k] + m[k+1][j] + dimensions.get(i-1) * dimensions.get(k) * dimensions.get(j);
                        System.out.println("L: " + L + " k: " + k + " Counts: " + multi_counts);
                        if (m[i][j] != 0){
                            m[i][j] = Math.min(multi_counts, m[i][j]);
                            s[i][j] = k;
                        } else {
                            m[i][j] = multi_counts;
                        }
                    }
                }
            }
            
            for (int i = 0; i < m.length;i++){
                for (int j = 0; j < m[i].length; j++){
                    System.out.print(m[i][j] + " ");
                }
                System.out.println("");
            }

            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("No file named 'matrixDimensions.txt' found");
        } catch (NumberFormatException e){
            System.out.println("Input file contains non-numerical char: " + line);
        }
    }

}