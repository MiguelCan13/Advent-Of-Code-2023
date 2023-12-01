import java.util.*;
import java.io.*;
public class day1{
    public static Scanner in;
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("day1.dat"));
        System.out.println(pt2());
    }

    public static int pt1(){
        String line = in.nextLine();
        int sum = 0;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '('){
                sum++;
            } else if(line.charAt(i) == ')'){
                sum--;
            }
        }
        return sum;
    }
    public static int pt2(){
        String line = in.nextLine();
        int sum = 0;
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '('){
                sum++;
            } else if(line.charAt(i) == ')'){
                sum--;
            }
            if(sum == -1){
                return i +1;
            }
        }
        return 0;
    }
}