import java.util.Scanner;
 
public class day10test
{
    public static double area(int[][] arr)
    {
        int n = arr.length;
        /** copy initial point to last row **/
        arr[n - 1][0] = arr[0][0];
        arr[n - 1][1] = arr[0][1];
 
        double det = 0.0;
        /** add product of x coordinate of ith point with y coordinate of (i + 1)th point **/
        for (int i = 0; i < n - 1; i++){
            det += (double)(arr[i][1] * arr[i + 1][0]);
            det -= (double)(arr[i][0] * arr[i+1][1]);
        }
        det = Math.abs(det) /2;    
        det -= (arr.length-1) / 2;
        det += 1;
        return det;        
    }

    public static void main (String[] args) 
    {
        int n = 12; // num of points
 
        int[][] arr = {{1,1},{1,7},{4,7},{4,5},{2,5},{2,2},{8,2},{8,5},{6,5},{6,7},{9,7},{9,1},{0,0}};
 
        System.out.println("\nArea = "+ area(arr));
    }
}

	//double X[] = {1, 1, 4, 4, 2, 2, 8, 8, 6, 6, 9, 9};
	//double Y[] = {1, 7, 7, 5, 5, 2, 2, 5, 5, 7, 7, 1};