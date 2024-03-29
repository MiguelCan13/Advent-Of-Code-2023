import java.util.*;
import java.io.*;

public class day12{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day12.dat"));
        pt1();

    }

    public static void pt1(){
        String line = "";
        String[] order;
        while(in.hasNextLine()){
            line = in.nextLine();
            order = line.replaceAll("[^0-9]", "").split(""); 
            line = line.replaceAll("[0-9/w,]", "");
            System.out.println(line + "\n" + Arrays.toString(order));

            int permutations = 0;
            while(true){
                
            }
        }
    }
    public static void pt2(){
        
    }
}