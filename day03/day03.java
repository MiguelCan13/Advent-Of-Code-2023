import java.util.*;
import java.io.*;
public class day03{
    public static Scanner in;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day03.dat"));
        System.out.println(pt2());
    }

    public static long pt1(){
        long sum = 0;
        boolean cant = true;
        boolean canb = true;
        boolean cantr = true;
        boolean canbr = true;
        String line = in.nextLine();
        String[][] thing = new String[line.length()][line.length()];
        for(int x = 0; x < line.length(); x++){
            for(int y = 0; y < line.length(); y++){
                thing[x][y] = line.charAt(y) + "";
            }
            line = in.nextLine();
        }
        for(int x = 0; x < thing[0].length; x++){
            for(int y = 0; y < thing[0].length; y++){
                if(thing[x][y].matches("[^A-Za-z0-9^.]")){
                    if((x-1 >= 0 && y-1 >= 0) && (thing[x-1][y-1].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y-1];
                        while(y-1-count >= 0 && thing[x-1][y-1-count].matches("[0-9]")){
                            num = thing[x-1][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x-1][y-1+count].matches("[0-9]")){
                            if(y-1+count == y){
                                cant = false;
                            } 
                            if(y-1+count == y+1){
                                cantr = false;
                            }
                            num = num + thing[x-1][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }


                    }
                    if(cantr && (x-1 >= 0 && y+1 <= thing[0].length-1) && thing[x-1][y+1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y+1];
                        while(y+1-count >= 0 && thing[x-1][y+1-count].matches("[0-9]")){
                            if(y+1-count == y){
                                cant = false;
                            }
                            num = thing[x-1][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x-1][y+1+count].matches("[0-9]")){
                            num = num + thing[x-1][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } if(cant && (x-1 >= 0) && (thing[x-1][y].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y];
                        while(y-count >= 0 && thing[x-1][y-count].matches("[0-9]")){
                            num = thing[x-1][y-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+count <= thing[x].length-1 && thing[x-1][y+count].matches("[0-9]")){
                            num = num + thing[x-1][y+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } if(y-1 >= 0 && thing[x][y-1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x][y-1];
                        while(y-1-count >= 0 && thing[x][y-1-count].matches("[0-9]")){
                            num = thing[x][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x][y-1+count].matches("[0-9]")){
                            num = num + thing[x][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } if(y+1 <= thing[0].length-1 && (thing[x][y+1].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x][y+1];
                        while(y+1-count >= 0 && thing[x][y+1-count].matches("[0-9]")){
                            num = thing[x][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x][y+1+count].matches("[0-9]")){
                            num = num + thing[x][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } if ((x+1 <= thing[0].length-1 && y-1 >= 0) && thing[x+1][y-1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y-1];
                        while(y-1-count >= 0 && thing[x+1][y-1-count].matches("[0-9]")){
                            num = thing[x+1][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x+1][y-1+count].matches("[0-9]")){
                            if(y-1+count == y){
                                canb = false;
                            }
                            if(y-1+count == y+1){
                                canbr = false;
                            }
                            num = num + thing[x+1][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } if(canbr && (x+1 <= thing[0].length-1 && y+1 <= thing[0].length-1) && thing[x+1][y+1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y+1];
                        while(y+1-count >= 0 && thing[x+1][y+1-count].matches("[0-9]")){
                            if(y+1-count == y){
                                canb = false;
                            }
                            num = thing[x+1][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x+1][y+1+count].matches("[0-9]")){
                            num = num + thing[x+1][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    }if(canb && x+1 <= thing[0].length-1 && thing[x+1][y].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y];
                        while(y-count >= 0 && thing[x+1][y-count].matches("[0-9]")){
                            num = thing[x+1][y-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+count <= thing[x].length-1 && thing[x+1][y+count].matches("[0-9]")){
                            num = num + thing[x+1][y+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            sum += Integer.parseInt(num);
                        }
                    } 
                }
                cant = true;
                canb = true;
                canbr = true;
                cantr = true;
            }
        }
        return sum;

    }
    
    public static long pt2(){
        long sum = 0;
        boolean cant = true;
        boolean canb = true;
        boolean cantr = true;
        boolean canbr = true;
        String line = in.nextLine();
        String[][] thing = new String[line.length()][line.length()];
        ArrayList<Integer> tomulti = new ArrayList<Integer>();
        for(int x = 0; x < line.length(); x++){
            for(int y = 0; y < line.length(); y++){
                thing[x][y] = line.charAt(y) + "";
            }
            line = in.nextLine();
        }
        for(int x = 0; x < thing[0].length; x++){
            for(int y = 0; y < thing[0].length; y++){
                if(thing[x][y].matches("[*]")){
                    if((x-1 >= 0 && y-1 >= 0) && (thing[x-1][y-1].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y-1];
                        while(y-1-count >= 0 && thing[x-1][y-1-count].matches("[0-9]")){
                            num = thing[x-1][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x-1][y-1+count].matches("[0-9]")){
                            if(y-1+count == y){
                                cant = false;
                            } 
                            if(y-1+count == y+1){
                                cantr = false;
                            }
                            num = num + thing[x-1][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }


                    }
                    if(cantr && (x-1 >= 0 && y+1 <= thing[0].length-1) && thing[x-1][y+1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y+1];
                        while(y+1-count >= 0 && thing[x-1][y+1-count].matches("[0-9]")){
                            if(y+1-count == y){
                                cant = false;
                            }
                            num = thing[x-1][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x-1][y+1+count].matches("[0-9]")){
                            num = num + thing[x-1][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } if(cant && (x-1 >= 0) && (thing[x-1][y].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x-1][y];
                        while(y-count >= 0 && thing[x-1][y-count].matches("[0-9]")){
                            num = thing[x-1][y-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+count <= thing[x].length-1 && thing[x-1][y+count].matches("[0-9]")){
                            num = num + thing[x-1][y+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } if(y-1 >= 0 && thing[x][y-1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x][y-1];
                        while(y-1-count >= 0 && thing[x][y-1-count].matches("[0-9]")){
                            num = thing[x][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x][y-1+count].matches("[0-9]")){
                            num = num + thing[x][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } if(y+1 <= thing[0].length-1 && (thing[x][y+1].matches("[0-9]"))){
                        String num = "";
                        int count = 1;
                        num += thing[x][y+1];
                        while(y+1-count >= 0 && thing[x][y+1-count].matches("[0-9]")){
                            num = thing[x][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x][y+1+count].matches("[0-9]")){
                            num = num + thing[x][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } if ((x+1 <= thing[0].length-1 && y-1 >= 0) && thing[x+1][y-1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y-1];
                        while(y-1-count >= 0 && thing[x+1][y-1-count].matches("[0-9]")){
                            num = thing[x+1][y-1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y-1+count <= thing[x].length-1 && thing[x+1][y-1+count].matches("[0-9]")){
                            if(y-1+count == y){
                                canb = false;
                            }
                            if(y-1+count == y+1){
                                canbr = false;
                            }
                            num = num + thing[x+1][y-1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } if(canbr && (x+1 <= thing[0].length-1 && y+1 <= thing[0].length-1) && thing[x+1][y+1].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y+1];
                        while(y+1-count >= 0 && thing[x+1][y+1-count].matches("[0-9]")){
                            if(y+1-count == y){
                                canb = false;
                            }
                            num = thing[x+1][y+1-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+1+count <= thing[x].length-1 && thing[x+1][y+1+count].matches("[0-9]")){
                            num = num + thing[x+1][y+1+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    }if(canb && x+1 <= thing[0].length-1 && thing[x+1][y].matches("[0-9]")){
                        String num = "";
                        int count = 1;
                        num += thing[x+1][y];
                        while(y-count >= 0 && thing[x+1][y-count].matches("[0-9]")){
                            num = thing[x+1][y-count] + num;
                            count++;
                        }
                        count = 1;
                        while(y+count <= thing[x].length-1 && thing[x+1][y+count].matches("[0-9]")){
                            num = num + thing[x+1][y+count];
                            count++;
                        }
                        count = 1;
                        num = num.replaceAll("\\D", "");
                        if(num != ""){
                            tomulti.add(Integer.parseInt(num));
                        }
                    } 
                }
                if(tomulti.size() == 2){
                    sum += tomulti.get(0) * tomulti.get(1);
                }
                tomulti.clear();
                cant = true;
                canb = true;
                canbr = true;
                cantr = true;
            }
        }
        return sum;
    }

}