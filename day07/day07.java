import java.util.*;
import java.io.*;

public class day07{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day07.dat"));
        System.out.println(pt2());
    }

    public static int compare(String other){
        String result = "";
        //System.out.println(other);
        while(other.length() != 0){
            int befores = other.length();
            char firstchar = other.charAt(0);
            other = other.replaceAll("["+firstchar+"]","");
            //System.out.println(other);
            int afters = other.length();
            result += befores-afters;
        }
        //System.out.println(result);
        switch (result.length()) {
            case 1:
                return 7;
            case 2:
                if(result.contains("4")){
                    return 6;
                } 
                    return 5;
            case 3:
                if(result.contains("3")){
                    return 4;
                }
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            default:
                return -1;
        }
    }

    public static Long pt1(){
        ArrayList<ArrayList<String>> sorted = new ArrayList<ArrayList<String>>();
        String order = "23456789TJQKA";
        String line = "";

        while(in.hasNextLine()){
            line = in.nextLine();
            //System.out.println(line);
            String card = line.substring(0, line.indexOf(" "));
            String point = line.substring(line.indexOf(" ") + 1);
            if(sorted.size() == 0){
                sorted.add(new ArrayList<String>());
                sorted.get(0).add(card);
                sorted.get(0).add(point);
            } else{
                int currhand = compare(card);
                System.out.println(card + " " + currhand);
                for(int i = 0; i < sorted.size(); i++){
                    String arraycard = sorted.get(i).get(0);
                    int arraynum = compare(arraycard);
                    //System.out.println(arraynum + " " + currhand);
                    if(currhand < arraynum){
                        sorted.add(i, new ArrayList<String>());
                        sorted.get(i).add(card);
                        sorted.get(i).add(point);
                        break;
                    } else if(currhand == arraynum){
                        for(int x = 0; x < card.length(); x++){
                            //System.out.println(card);
                            if(order.indexOf(arraycard.charAt(x)) > order.indexOf(card.charAt(x))){
                                sorted.add(i, new ArrayList<String>());
                                sorted.get(i).add(card);
                                sorted.get(i).add(point);
                                i = sorted.size();
                                break;
                            } else if(order.indexOf(arraycard.charAt(x)) < order.indexOf(card.charAt(x))){
                                //System.out.println("here");
                                break;
                            }
                            if(x == card.length()-1){
                                sorted.add(new ArrayList<String>());
                                sorted.get(sorted.size()-1).add(card);
                                sorted.get(sorted.size()-1).add(point);
                                i = sorted.size();
                                break;
                            }
                        }
                    } if(i == sorted.size()-1){
                        sorted.add(new ArrayList<String>());
                        sorted.get(sorted.size()-1).add(card);
                        sorted.get(sorted.size()-1).add(point);
                        break;
                    }
                }
            }
            /* 
            System.out.println(sorted.size());
            for(ArrayList<String> x : sorted){
                System.out.println(x.toString());
            }
            System.out.println();
            */
            
        }
        
        long sum = 0L;
        for(int i = 0; i < sorted.size(); i++){
            sum += Integer.parseInt(sorted.get(i).get(1)) * (i+1);
        }
        return sum;
    }

    public static int comparetwo(String other){
        ArrayList<Integer> result = new ArrayList<Integer>();
        System.out.println("other: " + other);
        int numJ = 0;
        for(int i = 0; i < other.length(); i++){
            if(other.charAt(i) == 'J'){
                other = other.substring(0, i) + other.substring(i+1);
                i--;
                numJ++;
            }
        }
        while(other.length() != 0){
            int befores = other.length();
            char firstchar = other.charAt(0);
            other = other.replaceAll("["+firstchar+"]","");
            //System.out.println(other);
            int afters = other.length();
            //System.out.println(befores-afters + " " + other + " " + other.length());
            result.add(befores-afters);
        }
        Collections.sort(result);
        System.out.println("Before " + result.toString());
        if(numJ > 0){
            if(result.size() == 0){
                result.add(numJ);
            } else{
                result.set(result.size()-1, result.get(result.size()-1) + numJ);
            }
        }
        System.out.println("After " + result.toString());
        //System.out.println("result size: " + result.size());
        switch (result.size()) {
            case 1:
                return 7;
            case 2:
                if(result.contains(4)){
                    return 6;
                } 
                    return 5;
            case 3:
                if(result.contains(3)){
                    return 4;
                }
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            default:
                return -1;
        }
    }

    public static long pt2(){
        ArrayList<ArrayList<String>> sorted = new ArrayList<ArrayList<String>>();
        String order = "J23456789TQKA";
        String line = "";

        while(in.hasNextLine()){
            line = in.nextLine();
            //System.out.println(line);
            String card = line.substring(0, line.indexOf(" "));
            String point = line.substring(line.indexOf(" ") + 1);
            if(sorted.size() == 0){
                sorted.add(new ArrayList<String>());
                sorted.get(0).add(card);
                sorted.get(0).add(point);
            } else{
                int currhand = comparetwo(card);
                //System.out.println("card/currhand: " + card + " " + currhand);
                for(int i = 0; i < sorted.size(); i++){
                    String arraycard = sorted.get(i).get(0);
                    int arraynum = comparetwo(arraycard);
                    //System.out.println(arraynum + " " + currhand);
                    if(currhand < arraynum){
                        sorted.add(i, new ArrayList<String>());
                        sorted.get(i).add(card);
                        sorted.get(i).add(point);
                        break;
                    } else if(currhand == arraynum){
                        for(int x = 0; x < card.length(); x++){
                            //System.out.println(card);
                            if(order.indexOf(arraycard.charAt(x)) > order.indexOf(card.charAt(x))){
                                sorted.add(i, new ArrayList<String>());
                                sorted.get(i).add(card);
                                sorted.get(i).add(point);
                                i = sorted.size();
                                break;
                            } else if(order.indexOf(arraycard.charAt(x)) < order.indexOf(card.charAt(x))){
                                //System.out.println("here");
                                break;
                            }
                            if(x == card.length()-1){
                                sorted.add(new ArrayList<String>());
                                sorted.get(sorted.size()-1).add(card);
                                sorted.get(sorted.size()-1).add(point);
                                i = sorted.size();
                                break;
                            }
                        }
                    } if(i == sorted.size()-1){
                        sorted.add(new ArrayList<String>());
                        sorted.get(sorted.size()-1).add(card);
                        sorted.get(sorted.size()-1).add(point);
                        break;
                    }
                }
            }
            
            System.out.println(sorted.size());
            for(ArrayList<String> x : sorted){
                System.out.println(x.toString());
            }
            System.out.println();
            
            
        }
        
        long sum = 0L;
        for(int i = 0; i < sorted.size(); i++){
            sum += Integer.parseInt(sorted.get(i).get(1)) * (i+1);
        }
        return sum;
    }
}