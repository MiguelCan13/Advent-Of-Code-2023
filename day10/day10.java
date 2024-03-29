import java.util.*;
import java.io.*;

public class day10 {
    private static Scanner in;
    private static String[][] maze;
    private static int max = 0;
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("day10r.dat"));
        pt1();
    }
    
    public static void pt1(){
        String line = in.nextLine();
        int[] startcord = new int[2];
        maze = new String[line.length()][line.length()];
        for(int x = 0; x < maze.length; x++){
            for(int y = 0; y < line.length(); y++){
                String cha = line.charAt(y) + "";
                maze[x][y] = cha;
                if(cha.equals("S")){
                    startcord[0] = x;
                    startcord[1] = y;
                }
            }
            if(in.hasNextLine()) line = in.nextLine();
        }
        

        Queue<int[]> locations = new LinkedList<int[]>();
        locations.add(startcord);
        int count = 0;
        int distance = 0;
        while(!locations.isEmpty()){
            int[] currloc = locations.remove();
            String currchar = maze[currloc[0]][currloc[1]];
            if(currchar.equals("S")){
                if(maze[currloc[0]-1][currloc[1]].matches("[|7F]")) locations.add(new int[]{currloc[0]-1, currloc[1]}); //up
                if(maze[currloc[0]][currloc[1]+1].matches("[-7J]")) locations.add(new int[]{currloc[0], currloc[1]+1}); //right
                if(maze[currloc[0]+1][currloc[1]].matches("[|LJ]")) locations.add(new int[]{currloc[0]+1, currloc[1]}); //down
                if(maze[currloc[0]][currloc[1]-1].matches("[-FL]")) locations.add(new int[]{currloc[0], currloc[1]-1}); //left
            } else if(currchar.equals("|")){
                locations.add(new int[]{currloc[0]-1, currloc[1]});
                locations.add(new int[]{currloc[0]+1, currloc[1]});
            } else if(currchar.equals("-")){
                locations.add(new int[]{currloc[0], currloc[1]+1});
                locations.add(new int[]{currloc[0], currloc[1]-1});
            } else if(currchar.equals("L")){
                locations.add(new int[]{currloc[0]-1, currloc[1]});
                locations.add(new int[]{currloc[0], currloc[1]+1});
            } else if(currchar.equals("J")){
                locations.add(new int[]{currloc[0]-1, currloc[1]});
                locations.add(new int[]{currloc[0], currloc[1]-1});
            } else if(currchar.equals("7")){
                locations.add(new int[]{currloc[0], currloc[1]-1});
                locations.add(new int[]{currloc[0]+1, currloc[1]});
            } else if(currchar.equals("F")){
                locations.add(new int[]{currloc[0], currloc[1]+1});
                locations.add(new int[]{currloc[0]+1, currloc[1]});
            } 

            if(!currchar.equals("#")){
                count++;
                if(count % 2 == 0){
                    distance++;
                }
            }
            maze[currloc[0]][currloc[1]] = "#";
            /* 
            for(String[] x : maze){
                    for (String y : x){
                        System.out.print(y + " ");
                    }
                System.out.println();
            }
            System.out.println(count + " " + distance + "\n");
            */
        }

        System.out.println(distance);
    }

    public static void pt2(){
        
    }
}
