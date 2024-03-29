import java.util.*;
import java.io.*;

public class day04{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day04.dat"));
        System.out.println(pt2());
    }

    public static int pt1(){
        ArrayList<Integer> winning = new ArrayList<Integer>();
        int correctnums = 0;
        int sum = 0;

        while(in.hasNextLine()){
            String line = in.nextLine().substring(10);
            line = line.replaceAll("[|]", "");
            Scanner n = new Scanner(line);
            for(int i = 0; i < 10; i++){
                winning.add(Integer.parseInt(n.next()));
            }
            for(int i = 0; i < 25; i++){
                if(winning.contains(Integer.parseInt(n.next()))){
                    correctnums++;
                }
            }
            sum += Math.pow(2, correctnums-1);
            correctnums = 0;
            winning.clear();
            
        }
        return sum;
    }

    public static int pt2(){
        ArrayList<Integer> winning = new ArrayList<Integer>();
        HashMap<Integer, Integer> sets = new HashMap<Integer, Integer>();
        int correctnums = 0;
        int sum = 0;
        int cardn = 1;
        for(int i = 1; i < 200; i++){
            sets.put(i, 1);
        }

        while(in.hasNextLine()){
            String line = in.nextLine().substring(10);
            line = line.replaceAll("[|]", "");
            Scanner n = new Scanner(line);
            for(int i = 0; i < 10; i++){
                winning.add(Integer.parseInt(n.next()));
            }
            for(int i = 0; i < 25; i++){
                if(winning.contains(Integer.parseInt(n.next()))){
                    correctnums++;
                }
            }
            for(int i = 1; i <= correctnums; i++){
                sets.put(cardn + i, sets.get(i+cardn) + sets.get(cardn));
            }
            cardn++;
            correctnums = 0;
            winning.clear();
            
        }
        ;
        for(Integer x : sets.keySet()){
            sum += sets.get(x);
        }
        return sum;
    }
}