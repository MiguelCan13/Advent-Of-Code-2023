import java.util.*;
import java.io.*;

public class day11 {
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day11r.dat"));
        System.out.println(pt2());
        
    }

    public static int pt1(){
        String[] line;
        int count = 1;
        int row = 0;
        ArrayList<ArrayList<String>> stars = new ArrayList<ArrayList<String>>();
        int[] x = new int[140];
        int[] y = new int[140];

        while(in.hasNextLine()){
            stars.add(new ArrayList<String>());
            line = in.nextLine().split("");
            for(int i = 0; i < line.length; i++){
                if(line[i].equals(".")){
                    stars.get(row).add(line[i]);
                    y[i] += 1;
                    x[row] += 1;
                } else{
                    stars.get(row).add(count + "");
                    count++;
                }
            }
            row++;

        }
        for(int i = y.length-1; i >=0; i--){
            if(y[i] == 140){
                for(int k = 0; k < stars.size(); k++){
                    stars.get(k).add(i, ".");
                }
            }
            if(x[i] == 140){
                stars.add(i, new ArrayList<String>());
                for(int k = 0; k < stars.get(0).size(); k++){
                    stars.get(i).add(".");
                }
            }
        }

        int totallen = 0;
        int xdif = 0;
        int ydif = 0;
        HashSet<String> pairs = new HashSet<String>();
        for(int i = 1; i < count; i++){
            for(int k = 1; k < count; k++){
                if(i != k && !pairs.contains(i+" "+k)){
                    //System.out.println();
                    pairs.add(i+" "+k);
                    pairs.add(k + " " + i);
                    for(int o = 0; o < stars.size(); o++){
                        for(int p = 0; p < stars.get(o).size(); p++){
                            if(stars.get(o).get(p).equals(i+"")){
                                xdif -= o;
                                ydif -= p;
                                //System.out.println(o + " " + p);
                            }
                            if(stars.get(o).get(p).equals(k+"")){
                                xdif += o;
                                ydif += p;
                                //System.out.println(o + " " + p);
                            }
                        }
                    }
                    //System.out.println(i + " " + k + " " + (Math.abs(xdif) + Math.abs(ydif)));
                    totallen += (Math.abs(xdif) + Math.abs(ydif));
                    xdif = 0;
                    ydif = 0;
                }
            }
        }
        System.out.println(pairs.size() + " " + count);
        for(ArrayList<String> i : stars){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        return(totallen);
    }

    public static long pt2(){
        String[] line;
        int count = 1;
        int row = 0;
        ArrayList<ArrayList<String>> stars = new ArrayList<ArrayList<String>>();
        int[] x = new int[140];
        int[] y = new int[140];

        while(in.hasNextLine()){
            stars.add(new ArrayList<String>());
            line = in.nextLine().split("");
            for(int i = 0; i < line.length; i++){
                if(line[i].equals(".")){
                    stars.get(row).add(line[i]);
                    y[i] += 1;
                    x[row] += 1;
                } else{
                    stars.get(row).add(count + "");
                    count++;
                }
            }
            row++;

        }

        ArrayList<Integer> xexpansion = new ArrayList<Integer>();
        ArrayList<Integer> yexpansion = new ArrayList<Integer>();
        for(int i = 0; i < y.length; i++){
            if(y[i] == 140){
                yexpansion.add(i);
            }
            if(x[i] == 140){
                xexpansion.add(i);
            }
        }

        long totallen = 0;
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        HashSet<String> pairs = new HashSet<String>();
        for(int i = 1; i < count; i++){
            for(int k = 1; k < count; k++){
                if(i != k && !pairs.contains(i+" "+k)){
                    //System.out.println();
                    pairs.add(i+" "+k);
                    pairs.add(k + " " + i);
                    for(int o = 0; o < stars.size(); o++){
                        for(int p = 0; p < stars.get(o).size(); p++){
                            if(stars.get(o).get(p).equals(i+"")){
                                x1 = o;
                                y1 = p;
                                //System.out.println(o + " " + p);
                            }
                            if(stars.get(o).get(p).equals(k+"")){
                                x2 = o;
                                y2 = p;
                                //System.out.println(o + " " + p);
                            }
                        }
                    }
                    //System.out.println(i + " " + k + " " + (Math.abs(xdif) + Math.abs(ydif)));
                    for(int e = 0; e < xexpansion.size(); e++){
                        if(Math.min(x1, x2) <= xexpansion.get(e) && Math.max(x1, x2) >= xexpansion.get(e)){
                            totallen += 999999;
                        }
                    }
                    for(int e = 0; e < yexpansion.size(); e++){
                        if(Math.min(y1, y2) <= yexpansion.get(e) && Math.max(y1, y2) >= yexpansion.get(e)){
                            totallen += 999999;
                        }
                    }
                    totallen += (Math.abs(x2 - x1) + Math.abs(y2-y1));
                    x1 = 0; x2 = 0; y1 = 0; y2 = 0;
                }
            }
        }
        System.out.println(pairs.size() + " " + count);
        for(ArrayList<String> i : stars){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        return(totallen);
    }

    
}
