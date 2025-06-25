package data_structures.arrays_strings.set_matrix_zero;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 2, 0 },
                { 3, 8, 5, 2 },
                { 1, 3, 1, 5 }
        };

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // check first row has zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    firstRowHasZero = true;
                    break;
                }
            }
        }

        // check first column has zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }

        }

        // Print result
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
