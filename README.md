# Project Background

Matrices are not _communative_, meaning that the order in which matrices are multiplied, changes the outcome of the multiplication. For example, given matrices A, B, and C, the following expression shows mathematically this lacking property with matrices.

$$A \times B \times C \neq B \times C \times A \neq C \times A \times B $$

Furthermore, placement of parenthesis around matrices to indicate when matrices should be multiplied can result in a different number of multiplications computed overall. Looking back at the example, if each matrix has the dimensions (rows x cols):

- A: [4x5]
- B: [5x3]
- C: [3x7]

Parentheses could be placed in two different ways

$$1: (A \times B) \times C$$
$$2:  A \times (B \times C)$$

These two different placements of parentheses will NOT require the same number of multiplications to compute the final matrix.

In order to multiply two matrices, the number of rows for one matrix must be equal to the number of columns in the other matrix. The number of columns in matrix A equals the number of rows in matrix B, therefore we are able to multiply these two matrices together. Iterating over each column in matrix A, every element in the current column is multiplied with the associated current row of matrix B. So column A1, element 1 is multiplied with row B1, element 1. Column A1, element 2 with row B1, element 2, etc. for all columns and rows. This means that each pair of rows/columns being multiplied requires a total of 5 multiplications. Matrix A's column has 5 elements that are multiplied with the 5 elements from matrix B's row. The results are stored in a new matrix that now has the dimensions of matrix A's rows and matrix B's columns.

$$ A \times B = [4\times5] \times [5\times3] = [4\times3]$$

The total number of multiplications between matrices A and B is:

$$4 \times 3 \times 5 = 60$$

This resulting matrix, with 4 rows and 3 columns, can be multiplied with matrix C because the number of rows in C matchs. The final matrix will have 4 rows and 7 columns and bring the total number of multiplications between elements up to 84 (4 x 3 x 7 = 84)

If the second expression was chosen, wrap matrix B and C in parentheses, then it would've required 140 multiplications in total. The optimal placement of parentheses in the expression is around matrices A and B, then multiply the result by matrix C.

# Project Goal

Given a text file containing dimensions of matrices being multiplied together, the program will compute the expression with the optimal placement of parentheses for the given matrices being multiplied together. It will show the expression written in both a _infix_ and _postfix_ format. Two matrices will be generated with one matrix (matrix M) showing the number of multiplications based on where the parentheses are placed, and the other (matrix S) displayig which matrix to place parentheses around to achieve the optimal number of multiplications.
