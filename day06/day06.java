import java.util.*;
import java.io.*;
public class day06{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day06.dat"));
        System.out.println(pt2());
    }

    public static int pt1(){
        ArrayList<Integer> times = new ArrayList<Integer>();
        ArrayList<Integer> distance = new ArrayList<Integer>();
        int record = 0;
        int time = 0;

        String line = in.nextLine().substring(11);
        Scanner linesca = new Scanner(line);
        while(linesca.hasNext()){
            times.add(Integer.parseInt(linesca.next()));
            System.out.println(times.toString());
        }
        line = in.nextLine().substring(11);
        linesca = new Scanner(line);
        while(linesca.hasNext()){
            distance.add(Integer.parseInt(linesca.next()));
        }
        int[] mutiples = new int[times.size()];
        System.out.println(mutiples.length);
        for(int i = 0; i < times.size(); i++){
            record = distance.get(i);
            time = times.get(i);
            for(int x = 0; x < time; x++){
                if((time-x) * x > record){
                    mutiples[i]++;
                }
            }
        }
        int sum = 1;
        for(int x : mutiples){
            sum *= x;
        }
        return sum;
    }
    public static Long pt2(){
        String times = "";
        String distance = "";

        String line = in.nextLine().substring(11);
        Scanner linesca = new Scanner(line);
        while(linesca.hasNext()){
            times += linesca.next();
        }
        line = in.nextLine().substring(11);
        linesca = new Scanner(line);
        while(linesca.hasNext()){
            distance += linesca.next();
        }
        Long time = Long.parseLong(times);
        Long record = Long.parseLong(distance);

        System.out.println(time + " " + record);
        Long mutiples = 0L;
        for(Long x = 0L; x < time; x++){
            if((time-x) * x > record){
                mutiples++;
            }
        }
        return mutiples;
    }
}