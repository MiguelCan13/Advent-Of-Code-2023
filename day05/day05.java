import java.io.*;
import java.util.*;
public class day05{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day05.dat"));
        System.out.println(pt2() + "***");
        
    }

    public static Long pt1() throws IOException{
        Long lowestloc = Long.MAX_VALUE;
        String line = "";
        int count = 0;
        ArrayList<ArrayList<Long>> nums = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> seeds = new ArrayList<Long>();

        line = in.nextLine();
        line = line.substring(7);
        Scanner seedsca = new Scanner(line);
        while(seedsca.hasNext()){
            seeds.add(Long.parseLong(seedsca.next()));
        } 
        seedsca.close();
        Long nextnum = 0L;
        line = in.nextLine();
        line = in.nextLine();
        for(int j = 0; j < 20; j++){               // change conditional to however many seeds you have
            nextnum = seeds.remove(0);
            for(int i = 0; i < 7; i++){
                if(line.contains("map:")){
                    line = in.nextLine();
                    while(!line.contains("$")){                    
                        Scanner linesca = new Scanner(line);
                        nums.add(new ArrayList<Long>());
                        nums.get(count).add((Long.parseLong(linesca.next())));
                        nums.get(count).add((Long.parseLong(linesca.next())));
                        nums.get(count).add((Long.parseLong(linesca.next())));
                        line = in.nextLine();
                        count++;
                    }
                    line = in.nextLine();
                    count = 0;
                    String result = "";
                    for(int l = 0; l < nums.size(); l++){
                        for(int p = 0; p < nums.get(l).size(); p++){
                            result += nums.get(l).get(p) + " ";
                        }
                        result += "\n";
                    }
                    for(int x = 0; x < nums.size(); x++){
                        if(nums.get(x).get(1) <= nextnum && nums.get(x).get(1) + nums.get(x).get(2) >= nextnum){
                            nextnum +=(nums.get(x).get(0)-nums.get(x).get(1));
                            x = nums.size();
                        }
                    }
                    nums = new ArrayList<ArrayList<Long>>();
                }
            }
            if(nextnum < lowestloc){
                lowestloc = nextnum;
            }
            in = new Scanner(new File("day05.dat"));
            line = in.nextLine();
            line = in.nextLine();
            line = in.nextLine();

        }
        return lowestloc;
    }

    /*
     Starting from the lowest location, loop through the seeds by 1,000,000 to check if any range contains that number
     if not, get the next smallest location 
     if so, check that range by 100,000;keep getting smaller until you find the exact value)
      - hopefully this works 
     */
    public static Long pt2()throws IOException{
        Long lowestloc = Long.MAX_VALUE;
        String line = "";
        int count = 0;
        ArrayList<ArrayList<Long>> nums = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> aseeds = new ArrayList<Long>();
        ArrayList<ArrayList<Long>> locations = new ArrayList<ArrayList<Long>>();

        line = in.nextLine();
        line = line.substring(7);
        Scanner seedsca = new Scanner(line);
        while(seedsca.hasNext()){
            aseeds.add(Long.parseLong(seedsca.next()));
        } 

        int tempcount = 0;
        Scanner day05sca = new Scanner(new File("day05pt2.dat"));
        while(day05sca.hasNextLine()){
            locations.add(new ArrayList<Long>());
            String[] loclines = day05sca.nextLine().split(" ");
            for(int i = 0 ; i < loclines.length; i++){
                locations.get(tempcount).add(Long.parseLong(loclines[i]));
            }
            tempcount++;
            
        }
        
        Long smallestloc = Long.MAX_VALUE;
        int smallestrow = -1;
        for(int i = 0; i < locations.size(); i++){
            if(locations.get(i).get(1) < smallestloc){
                smallestloc = locations.get(i).get(1);
                smallestrow = i;
            }            
        }
        System.out.println(smallestloc);
 
        for(int i = 0; i < aseeds.size(); i+=2){
            Long num = aseeds.get(i);
            Long range = aseeds.get(i+1);
            if(num <= smallestloc && num + range >= smallestloc){
                //recurse 10000, 1000, 100 ect
                
            } 
        }
        
        seedsca.close();
        Long nextnum = 0L;
        line = in.nextLine();
        line = in.nextLine();

        int o = aseeds.size();
        for(int j = 0; j < o; j+=2){    
            Long num = aseeds.get(j);
            Long range = aseeds.get(j+1);
            for(int r = 0; r < range; r+=100000){
                nextnum = num+r;
                System.out.println(nextnum);
                for(int i = 0; i < 7; i++){
                    if(line.contains("map:")){
                        line = in.nextLine();
                        while(!line.contains("$")){                    
                            Scanner linesca = new Scanner(line);
                            nums.add(new ArrayList<Long>());
                            nums.get(count).add((Long.parseLong(linesca.next())));
                            nums.get(count).add((Long.parseLong(linesca.next())));
                            nums.get(count).add((Long.parseLong(linesca.next())));
                            line = in.nextLine();
                            count++;
                        }
                        line = in.nextLine();
                        count = 0;
                        /* 
                        String result = "";
                        for(int l = 0; l < nums.size(); l++){
                            for(int p = 0; p < nums.get(l).size(); p++){
                                result += nums.get(l).get(p) + " ";
                            }
                            result += "\n";
                        }
                        System.out.println(result);
                        */
                        for(int x = 0; x < nums.size(); x++){
                            if(nums.get(x).get(1) <= nextnum && nums.get(x).get(1) + nums.get(x).get(2) >= nextnum){
                                nextnum +=(nums.get(x).get(0)-nums.get(x).get(1));
                                x = nums.size();
                            }
                        }
                        nums = new ArrayList<ArrayList<Long>>();
                    }
                }
                if(nextnum < lowestloc){
                    lowestloc = nextnum;
                }
                in = new Scanner(new File("day05.dat"));
                line = in.nextLine();
                line = in.nextLine();
                line = in.nextLine();
            }

        }
        return lowestloc;
    }
}