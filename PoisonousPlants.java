/*
There are N plants in a garden. Each of these plants has been added with some amount of pesticide. After each day, if any plant has more pesticide than the plant at its left, being weaker than the left one, it dies. You are given the initial values of the pesticide in each plant. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

Input Format

The input consists of an integer N. The next line consists of N integers describing the array  where  denotes the amount of pesticide in plant .

 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    class Plant {
        int pestLevel = 0;
        int days2Die = 0;
        
        Plant(int pestLevel, int days2Die) {
            this.pestLevel = pestLevel;
            this.days2Die = days2Die;
        }
    }
    
    public int findNumDays(int[] plants) {
        int maxDays = 0;
        int minPestLevel = Integer.MAX_VALUE;
        Stack<Plant> st = new Stack<Plant>();
        for(int p : plants) {
            Plant plant = new Plant(p, 0);
            if(st.isEmpty() || p <= minPestLevel) {                
                st.push(plant);
                minPestLevel = p;
            } else if(plant.pestLevel > st.peek().pestLevel) {
                plant.days2Die = 1;
                st.push(plant);
                maxDays = Math.max(maxDays, plant.days2Die);
            } else {                
                int localMax = 0;
                while(!st.isEmpty() && plant.pestLevel <= st.peek().pestLevel) {
                    int curr = st.pop().days2Die;                    
                    localMax = Math.max(localMax, curr);
                }
                plant.days2Die = localMax + 1;
                maxDays = Math.max(maxDays, plant.days2Die);
                st.push(plant);
            }
        }
        return maxDays;
    }
    
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int lineNum = 0;
        int[] plants = null;
        try {
                while ((line = bi.readLine()) != null) {                
                if(lineNum > 0) {
                    String[] strPlants = line.split(" ");
                    plants = new int[strPlants.length];
                    int index = -1;
                    for(String s : strPlants) {
                        plants[++index] = Integer.parseInt(s);                           
                    }    
                }
               ++lineNum;
           }
            Solution s = new Solution();
            System.out.println(s.findNumDays(plants));
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}