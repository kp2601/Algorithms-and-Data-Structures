/* 
This question is designed to help you get a better understanding of basic heap operations. 
You will be given queries of  types:

"1 v" - Add an element  to the heap.
"2 v" - Delete the element  from the heap.
"3" - Print the minimum of all the elements in the heap.
NOTE: It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    List<Integer> lis = new ArrayList<Integer>();
    
    public List<Integer> add(int v){
        if(lis.isEmpty()) {
            lis.add(v);
            return lis;
        }         
        lis.add(v);
        int i = lis.size()-1;
        while(i>0 && lis.get(i/2) > lis.get(i)) {
            int tmp = lis.get(i/2);
            lis.set(i/2, lis.get(i));
            lis.set(i, tmp);
            i /= 2;
        }
        return lis;
    }   
    
    public int delete(int v){
        //System.out.println("deleting "+v+" in "+lis);
        if (lis.isEmpty()){
            return 0;
        } else if(lis.size() == 1) {
            lis.remove(0);
            return 0;
        }         
        int i = lis.indexOf(v);
        if(i == lis.size()-1) {
            lis.remove(i);
            return i;
        }
        int last = lis.remove(lis.size()-1);
        lis.set(i, last);
        lis = minify(lis, i);
        return i;
    }

    public List<Integer> minify(List<Integer> lis, int i){
        int left = 2*i;
        int right = left + 1;
        int size = lis.size();
        int smallest = Integer.MAX_VALUE;
        if(left < size && lis.get(i) > lis.get(left)) {
            smallest = left;
        } else {
            smallest = i;
        } 
        
        if(right < size && lis.get(smallest) > lis.get(right)) {
            smallest = right;
        } 
        
        if(smallest != i){
            int tmp = lis.get(smallest);
            lis.set(smallest, lis.get(i));
            lis.set(i, tmp);
            lis = minify(lis, smallest);
        }
        
        return lis;
    }
    
    public void printMin(){
        if(!lis.isEmpty()) {
            System.out.println(lis.get(0));    
        }        
    }
    
    public static void main(String[] args) {
        try{
            Solution s = new Solution();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int lines = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<lines;++i){
                String[] in = br.readLine().trim().split(" ");
                if(in.length > 1){
                     int v = Integer.parseInt(in[1]);
                     int op = Integer.parseInt(in[0]);
                     if(op == 1){
                         s.add(v);
                         //System.out.println(s.add(v));
                     } else {
                         try{
                            s.delete(v);    
                         } catch(Exception e){
                             System.out.println("failing for "+v+" in "+s.lis);
                         }
                         
                     }
                } else {
                    s.printMin();
                }
                
            }
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}