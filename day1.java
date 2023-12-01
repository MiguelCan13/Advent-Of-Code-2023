import java.util.*; //142
import java.io.*;
public class day1{

    public static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day1.dat"));
        System.out.println(pt2());
    }

    public static int pt1(){
        int sum = 0;
        while(in.hasNextLine()){
            String line = in.nextLine();
            line = line.replaceAll("[^\\d.]", "");
            char front = line.charAt(0);
            char back = line.charAt(line.length()-1);
            String num = front + "" + back;
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static int pt2(){
        int sum = 0;
        HashMap<Integer, String> nums = new HashMap<Integer, String>();
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");
        nums.put(6, "six");
        nums.put(7, "seven");
        nums.put(8, "eight");
        nums.put(9, "nine");

        while(in.hasNextLine()){
            String line = in.nextLine();
            for(int i = 1; i < 10; i++){
                while(line.contains(nums.get(i))){
                    int ind = line.indexOf(nums.get(i));
                    line = line.substring(0, ind+1) + i + line.substring(ind+1, line.length());
                }
            }
            line = line.replaceAll("[^\\d.]", "");
            char front = line.charAt(0);
            char back = line.charAt(line.length()-1);
            String num = front + "" + back;
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}