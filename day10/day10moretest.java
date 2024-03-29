import java.io.*;
import java.util.*;

public class day10moretest {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File("day10.dat"));

        // Define the loop as a 2D character array
        char[][] loop = new char[10][10];

        // Read the loop from the console
        for (int i = 0; i < loop.length-1; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < row.length()-1; j++) {
                loop[i][j] = row.charAt(j);
            }
        }
        for(char[] x : loop){
            for(char y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }

        // Count the enclosed tiles
        int enclosedTiles = 0;
        for (int i = 0; i < loop.length; i++) {
            for (int j = 0; j < loop[i].length; j++) {
                if (isEnclosedTile(loop, i, j)) {
                    enclosedTiles++;
                }
            }
        }

        // Print the enclosed area
        System.out.println("The area enclosed by the loop is: " + enclosedTiles + " tiles.");

        scanner.close();
    }

    private static boolean isEnclosedTile(char[][] loop, int row, int col) {
        // Check if the tile is not part of the loop boundary
        if (loop[row][col] != '.') {
            return false;
        }

        // Check if the tile has at least one path to the outside
        boolean hasPath = false;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue; // Skip checking the current tile
                }

                int newRow = row + dy;
                int newCol = col + dx;

                // Check if the new position is within the loop and not a boundary
                if (isValidPosition(loop, newRow, newCol) && loop[newRow][newCol] != '.') {
                    hasPath = true;
                    break;
                }
            }
        }

        return !hasPath; // If no path found, the tile is enclosed
    }

    private static boolean isValidPosition(char[][] loop, int row, int col) {
        return row >= 0 && row < loop.length && col >= 0 && col < loop[0].length;
    }
}