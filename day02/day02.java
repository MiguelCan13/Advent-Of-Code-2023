import java.util.*;
import java.io.*;

public class day02{
    private static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day02.dat"));
        System.out.println(pt1());
    }

    public static int pt1(){
        int sumgame = 0;
        int currgame = 1;
        int currnum = 0;
        boolean ispos = true;

        while(in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
            Scanner n = new Scanner(line);
            String part = "";
            while(n.hasNext()){
                part = n.next();
                if(part.charAt(part.length()-1) == ':'){
                    currgame = Integer.parseInt(part.substring(0, part.length()-1));
                } else if(part.length() <= 2){
                    currnum = Integer.parseInt(part);
                    part = n.next();
                    if(part.charAt(0) == 'r'){
                        if(currnum > 12){
                            ispos = false;
                            System.out.println(currnum + " " + currgame);
                        }
                    }else if(part.charAt(0) == 'g'){
                        if(currnum > 13){
                            ispos = false;
                            System.out.println(currnum +  " " + currgame);
                        }

                    }else if(part.charAt(0) == 'b'){
                        if(currnum > 14){
                            ispos = false;
                            System.out.println(currnum + " " + currgame);
                        }
                    }
                }
            }
            if(ispos){
                sumgame += currgame;
            } else{
                ispos = true;
            }
        }
        return sumgame;
    }
    
    public static int pt2(){
        int sumnums = 0;
        int currnum = 0;

        while(in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
            Scanner n = new Scanner(line);
            String part = "";
            int numB = 0;
            int numR = 0;
            int numG = 0;
            while(n.hasNext()){
                part = n.next();
                if(part.charAt(part.length()-1) == ':'){
                } else if(part.length() <= 2){
                    currnum = Integer.parseInt(part);
                    part = n.next();
                    if(part.charAt(0) == 'r'){
                        if(currnum > numR){
                            numR = currnum;
                        }
                    }else if(part.charAt(0) == 'g'){
                        if(currnum > numG){
                            numG = currnum;
                        }

                    }else if(part.charAt(0) == 'b'){
                        if(currnum > numB){
                            numB = currnum;
                        }
                    }
                }
            }
            sumnums += numB * numR * numG;
        }
        return sumnums;
    }
}