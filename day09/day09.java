import java.util.*;
import java.io.*;

public class day09{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day09.dat"));
        System.out.println(pt2());
    }

    public static int pt1(){
        int sum = 0;
        String line = "";
        ArrayList<ArrayList<Integer>> nums;
        while(in.hasNextLine()){
            nums = new ArrayList<ArrayList<Integer>>();
            //gets first line
            line = in.nextLine();
            Scanner linesca = new Scanner(line);
            nums.add(new ArrayList<Integer>());
            while(linesca.hasNextInt()){
                nums.get(0).add(linesca.nextInt());
            }
            linesca.close();

            //fills 2D array with rows
            while(true){
                nums.add(new ArrayList<Integer>());
                int arrayindex = nums.size()-2;
                for(int i = 0; i < nums.get(arrayindex).size()-1; i++){
                    int second = nums.get(arrayindex).get(i+1);
                    int first = nums.get(arrayindex).get(i);
                    nums.get(arrayindex+1).add(second-first);
                }
                boolean cancont = true;
                for(int x : nums.get(arrayindex+1)){
                    if(x != 0){
                        cancont = false;;
                    }
                }
                if(cancont){
                    break;
                }
            }
            
            //extrapolates
            for(int i = nums.size()-1; i >=0; i--){
                if(i == nums.size()-1){
                    nums.get(i).add(0);
                } else{
                    nums.get(i).add((nums.get(i+1).get(nums.get(i+1).size()-1) + (nums.get(i).get(nums.get(i).size()-1))));
                }
            }

            sum += nums.get(0).get(nums.get(0).size()-1);

            for(ArrayList<Integer> x : nums){
                for(int y : x){
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return sum;
    }

    public static int pt2(){
        int sum = 0;
        String line = "";
        ArrayList<ArrayList<Integer>> nums;
        while(in.hasNextLine()){
            nums = new ArrayList<ArrayList<Integer>>();
            //gets first line
            line = in.nextLine();
            Scanner linesca = new Scanner(line);
            nums.add(new ArrayList<Integer>());
            while(linesca.hasNextInt()){
                nums.get(0).add(linesca.nextInt());
            }
            linesca.close();

            //fills 2D array with rows
            while(true){
                nums.add(new ArrayList<Integer>());
                int arrayindex = nums.size()-2;
                for(int i = 0; i < nums.get(arrayindex).size()-1; i++){
                    int second = nums.get(arrayindex).get(i+1);
                    int first = nums.get(arrayindex).get(i);
                    nums.get(arrayindex+1).add(second-first);
                }
                boolean cancont = true;
                for(int x : nums.get(arrayindex+1)){
                    if(x != 0){
                        cancont = false;;
                    }
                }
                if(cancont){
                    break;
                }
            }
            
            //extrapolates
            for(int i = nums.size()-1; i >=0; i--){
                if(i == nums.size()-1){
                    nums.get(i).add(0);
                } else{
                    nums.get(i).add(0, ((nums.get(i).get(0))- nums.get(i+1).get(0)));
                }
            }

            sum += nums.get(0).get(0);
            
            for(ArrayList<Integer> x : nums){
                for(int y : x){
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return sum;
    }
}