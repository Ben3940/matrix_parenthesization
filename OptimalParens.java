import java.util.ArrayList;

public class OptimalParens {

    public void PrintMSTables(int[][] m, int[][] s){
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
    
    public void PrintOptimalParens(int[][] s, int i, int j){
        if (i == j){
            System.out.print("A" + i);
            return;
        }

        System.out.print("(");
        PrintOptimalParens(s, i, s[i][j]);
        System.out.print("*");
        PrintOptimalParens(s, s[i][j] + 1, j);
        System.out.print(")");
    }

    public void PrintPostfix(int[][] s, int i, int j){
        if (i == j){
            System.out.print("A" + i);
            return;
        }

        PrintPostfix(s, i, s[i][j]);
        PrintPostfix(s, s[i][j] + 1, j);
        System.out.print("*");
    }

    public void PrintMatrixDimensions(ArrayList<Integer> dimensions){
        for (int i = 0; i < dimensions.size() - 1; i++){
            System.out.printf("Matrix %d: %d x %d\n", i + 1, dimensions.get(i), dimensions.get(i + 1));
        }
    }
}
