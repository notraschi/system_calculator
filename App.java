import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        double[][] mat = new double[Integer.valueOf(args[0])+1][Integer.valueOf(args[0])+1];
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<mat.length-1; i++) {
            for (int j=0; j<mat.length; j++) {
                mat[i][j] = scan.nextDouble();
            }
        }
        scan.close();

        System.out.println("\n \nIl tuo sistema: \n");

        for (int i=0; i<mat.length-1; i++) {
            for (int j=0; j<mat.length; j++) {
                System.out.print(mat[i][j]+"  ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");

        double[] sols = solution(mat, Integer.valueOf(args[0]));
        for (int i=0; i<sols.length; i++) {
            System.out.println("variable " + (i+1) +" --> " +sols[i]);
        }
    }

    public static double[][] mat1(double[][] mat) {
        
        for (int i=0; i<mat.length; i++){

            for (int l=i+1; l<mat.length; l++) {

                double mult = mat[l][i]/mat[i][i];

                for (int c=i; c<mat.length; c++) {

                    mat[l][c] += mat[i][c]*-mult;  //pivot
                }
            }
        }
            
        for (int i=0; i<mat.length; i++){

            double div = mat[i][i];

            for (int j=i; j<mat.length; j++){   //reduction -> division

                mat[i][j] /= div;
            }
        }

        return mat;
    }

    public static double[][] mat2(double[][] mat) {
        
        for (int i=mat.length-2; i>0; i--){

            for (int l=i-1; l>=0; l--) {

                double mult = mat[l][i]/mat[i][i];

                mat[l][mat.length-1] += mat[i][mat.length-1]*-mult;  //pivot but for constants

                for (int c=i; c>=0; c--) {

                    //System.out.println(c);
                    mat[l][c] += mat[i][c]*-mult;  //pivot
                }
            }
        }

        return mat;
    }

    private static double[] solution(double[][] mat, int size) {
        
        double[][] m = mat2(mat1(mat));
        double[] solutions = new double[size];

        for (int i=0;i<m.length-1; i++){

            solutions[i] = Math.round(m[i][m.length-1]*1000.0)/1000.0;
        }

        return solutions;
    }
}
