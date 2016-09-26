/* 
Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered 0 to (N-1) (both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

Input Format

The first line will contain the value of N.
The next N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Pump{
        int capacity = 0;
        int distance2NextPump = 0;
        Pump right;
        Pump left;
        int index;        
        
        Pump(int capacity, int distance2NextPump, int index) {
            this.capacity = capacity;
            this.distance2NextPump = distance2NextPump;
            this.index = index;
        }
    }
    
    public int findMinIndex(Queue<Pump> q) {
        int index = 0;
        int carry = 0;
        int capacity = 0;
        int distance = 0;
        boolean found = false;
        Pump curr = null;
        int diff = 0;
        
        while(!q.isEmpty()) {
            
            curr = q.poll();
            capacity = curr.capacity;
            distance = curr.distance2NextPump;            
            diff = carry + (capacity - distance);
            if(diff > 0) {
                carry = diff;
            } else if(diff < 0) {
                carry = 0;
                found = false;
            }
            
            if(diff > 0 && !found) {
                index = curr.index;
                found = true;
            }
         }
        
        return index;
    }
    
    
    
    public static void main(String[] args) {
        Solution s = new Solution();
        BufferedReader br = null;
        Queue<Pump> q = new LinkedList<Pump>();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int line = Integer.parseInt(br.readLine().trim());
            String[] data = null;                        
            for(int i=0;i<line;++i){
                data = br.readLine().split(" ");                
                Pump head = new Pump(Integer.parseInt(data[0].trim()), 
                                     Integer.parseInt(data[1].trim()), i);
                q.add(head);
            } 
               System.out.println(s.findMinIndex(q));
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}