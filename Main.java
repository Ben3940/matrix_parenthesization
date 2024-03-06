import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main{
    public static void main(String[] args){
        String line = "";
        try {
            File file = new File("matrixDimensions.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> dimensions = new ArrayList<Integer>();
            while (scanner.hasNextLine()){
                try {
                    line = scanner.next();
                    dimensions.add(Integer.valueOf(line));
                } catch (NoSuchElementException e){
                    continue;
                } catch (NumberFormatException e){
                    System.out.println("Input file contains non-numerical char: " + line);
                    scanner.close();
                    return;
                }
            }
            int n = dimensions.size() - 1;
            System.out.println(n);
            // Create multiplication counts array with initial values of 0
            int[][] m = new int[n+1][n+1];
            int[][] s = new int[n+1][n+1];
            for (int i = 0; i <= n; i++){
                for (int j = 0; j <= n; j++){
                    m[i][j] = 0;
                    s[i][j] = 0;
                }
            }

            // Consider L consecutive matrices to parenthesize
            for (int L = 2; L <= n; L++){
                // Split matricies into L pairs, from first matrix to n - L + 1 matrix
                for (int i = 1; i <= (n - L + 1); i++){
                    int j = i + L - 1;
                    
                    // Considers "k" ways to parenthesize matrices given L pairs((L = 2, k = 1), (L = 3, k = 2), etc.)
                    for (int k = i; k < j; k++){
                        int multi_counts = m[i][k] + m[k+1][j] + dimensions.get(i-1) * dimensions.get(k) * dimensions.get(j);
                        // System.out.println("L: " + L + " j: " + j + " k: " + k + " Counts: " + multi_counts);
                        if (m[i][j] != 0){
                            if (multi_counts < m[i][j]){
                                m[i][j] = multi_counts;
                                s[i][j] = k;
                            }
                        } else {
                            m[i][j] = multi_counts;
                            s[i][j] = k;
                        }
                    }
                    PrintOptimalParens(m, s);
                }
            }

            PrintInfixPostfix(s, 1, n);
            
            

            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("No file named 'matrixDimensions.txt' found");
        }
    }

    public static void PrintOptimalParens(int[][] m, int[][] s){
        System.out.println("m array (1 to n)");
        for (int i = 1; i < m.length;i++){
            for (int j = 1; j < m[i].length; j++){
                System.out.printf("%5d ", m[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("s array (1 to n)");
        for (int i = 1; i < s.length;i++){
            for (int j = 1; j < s[i].length; j++){
                System.out.printf("%5d ", s[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void PrintInfixPostfix(int[][] s, int i, int j){
        
        if (i == j){
            System.out.print("A" + i);
            return;
        }

        System.out.print("(");
        PrintInfixPostfix(s, i, s[i][j]);
        System.out.print("*");
        PrintInfixPostfix(s, s[i][j] + 1, j);
        System.out.print(")");


    }
}