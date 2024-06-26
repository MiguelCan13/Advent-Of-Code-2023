import java.util.*;
import java.io.*;

public class day08{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day08.dat"));
        pt2();

    }

    public static int pt1(){
        String LR = in.nextLine();
        in.nextLine();

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while(in.hasNextLine()){
            String[] t = in.nextLine().split("\\W+");

            map.put(t[0], new String[]{t[1],t[2]});
        }

        String current = "AAA";
        int steps = 0;
        while(!current.equals("ZZZ")){
            int s = steps % LR.length();
            String dir = LR.substring(s, s+1);
            if(dir.equals("L")){
                current = map.get(current)[0];
            }else{
                current = map.get(current)[1];
            }
            steps++;
        }
        return steps;

    }
    public static void pt2(){
        String LR = in.nextLine();
        in.nextLine(); // throw away

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while(in.hasNextLine()) {
            //String[] t = in.nextLine().replaceAll("[(),=]","").split("[\\s]+");
            String[] u = in.nextLine().split("\\W+");
            map.put(u[0], new String[]{u[1],u[2]});
        }

        
        boolean done = false;
        ArrayList<String> dests = new ArrayList<String>();
        for(String k : map.keySet()) {
            if(k.endsWith("A")) {
                dests.add(k);
            }
        }

        HashMap<String, ArrayList<Integer>> cycles = new HashMap<String, ArrayList<Integer>>();
       
        for(String k : dests) {
            int step = 0;

            String curr = k;
            while(true) {            
                int s = step % LR.length();
                String dir = LR.substring(s,s+1);
                step++;
                if(dir.equals("L"))
                    curr = map.get(curr)[0];
                else
                    curr = map.get(curr)[1];

                if(curr.endsWith("Z")) {
                    if(cycles.containsKey(curr))
                        cycles.get(curr).add(step);
                    else {
                        cycles.put(curr, new ArrayList<Integer>());
                        cycles.get(curr).add(step);
                    }
                    if(cycles.get(curr).size() == 10) break;
                }
            }
        }
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for(String k : cycles.keySet()) {
            vals.add(cycles.get(k).get(0));
        }
        System.out.println(vals);
        long LCM = vals.get(0);
        for(int i = 1; i < vals.size(); i++) {
            LCM = lcm(LCM, vals.get(i));

        }

        System.out.println(LCM);
    }
    public static long lcm(long a, long b) {
        long r = a * b;
        return r / gcd(a,b);
    }
    
    public static long gcd(long a, long b) {
        if(a < b) return gcd(b, a);

        if(b == 0) return a;

        return gcd(b, a %b);
    }
}