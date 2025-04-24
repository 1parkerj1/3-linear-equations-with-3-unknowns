import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] matrixArr = new double[4][4];
        String[] matrixVar = {"x", "y", "z", "b"};

        System.out.println("\nEnter numbers in a 3x3 matrix in this order (row = 'X', 'Y', 'Z', 'Constant'):\n");

        double determinant = findDeterminant(matrixArr);
        while (determinant == 0) {
            System.out.println("determinant is 0, enter different coefficients...\n");
            setMatrix(matrixArr, matrixVar);
            determinant = findDeterminant(matrixArr);
            matrixArr[0][0] = determinant;
        }

        findDxyz(matrixArr);
        cramersRule(matrixArr);

        System.out.println("Determinant: " + determinant + "\n");
        showArray(matrixArr, matrixVar);
    }

    public static void setMatrix(double[][] matrixArr, String[] matrixVar) {
        Scanner scan = new Scanner(System.in);

        for (int row = 1; row <= 3; row++) {
            System.out.println("Enter values for equation " + row + ": ");

            for (int col = 1; col <= 3; col++) {
                System.out.print(matrixVar[col - 1] + " coefficient: ");
                matrixArr[row][col] = getInput(scan);
            }

            System.out.print("constant " + matrixVar[3] + ": ");
            matrixArr[row][0] = getInput(scan);

            System.out.println();
        }
    }

    public static double getInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input, Enter a number: ");
            }
        }
    }

    public static void showArray(double[][] matrixArr, String[] matrixVar) {
        System.out.println("stored matrix: ");
        for (int i = 0; i < matrixArr.length; i++) {
            for (int j = 0; j < matrixArr[i].length; j++) {
                System.out.print(matrixArr[i][j] + " ");
            }
            System.out.println();
        }
    }


    // math algorithms

    /**
     * rule of Sarrus to get the determinant
     *
     * @param matrixArr - matrix array
     * @return matrix array
     */
    public static double findDeterminant(double[][] matrixArr) {

        return  (matrixArr[1][1] * matrixArr[2][2] * matrixArr[3][3]) +
                (matrixArr[1][2] * matrixArr[2][3] * matrixArr[3][1]) +
                (matrixArr[1][3] * matrixArr[2][1] * matrixArr[3][2]) -
                (matrixArr[3][1] * matrixArr[2][2] * matrixArr[1][3]) -
                (matrixArr[3][2] * matrixArr[2][3] * matrixArr[1][1]) -
                (matrixArr[3][3] * matrixArr[2][1] * matrixArr[1][2]);
    }

    /**
     * uses findDeterminant() to get Dx, Dy, Dz
     * after using swapColumn() to put the constants
     * column into the x, y and z column
     *
     * @param matrixArr - matrix array
     * @return matrix array
     */
    public static double[][] findDxyz(double[][] matrixArr) {
        for (int i = 1; i < matrixArr[0].length; i++) {
            double[][] tempArr = swapColumn(matrixArr, i, 0);
            double determinant = findDeterminant(tempArr);
            matrixArr[0][i] = determinant;

            // revert back to the original state except for elements in first row
            swapColumn(matrixArr, 0, i);
        }
        return matrixArr;
    }

    /**
     * cramers rule
     *
     * @param matrixArr - matrix array
     * @return matrix array
     */
    public static double[][] cramersRule(double[][] matrixArr) {
        // Cramer's rule
        for (int i = 1; i < matrixArr.length; i++) {
            double num = matrixArr[0][i] / matrixArr[0][0];
            BigDecimal rounded = new BigDecimal(num).setScale(3, RoundingMode.HALF_UP);
            matrixArr[0][i] = rounded.doubleValue();
        }
        return matrixArr;
    }

    /**
     * swap the constants column into each column of the coeff matrix
     *
     * @param matrixArr - matrix array
     * @return matrix array
     */
    public static double[][] swapColumn(double[][] matrixArr, int col, int col2) {
        // swap constants column into each coeff column (except elements in first row)
        for (int i = 1; i < matrixArr.length; i++) {
            double tempCol = matrixArr[i][col2];
            matrixArr[i][col2] = matrixArr[i][col];
            matrixArr[i][col] = tempCol;
        }
        return matrixArr;
    }



}