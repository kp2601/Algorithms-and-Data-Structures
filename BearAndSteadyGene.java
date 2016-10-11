/* problem 
https://www.hackerrank.com/challenges/bear-and-steady-gene
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    int[] count = new int[4];
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int minLength = Integer.MAX_VALUE;
    int req = 0;
    public int getMinimumSubstring(int n, String s)
    {
       req = n/4;
       populate(s);
        if(isSteady()){
            return 0;
        } 
         
        int i=0;
        int j=0;
        --count[map.get(s.charAt(i))];
        while(j<n || isSteady()){
            if(isSteady()){
                minLength = Math.min(minLength, j-i+1);
                ++count[map.get(s.charAt(i))];
                ++i;
            } else if(j<n-1){
                ++j;
                --count[map.get(s.charAt(j))];
            } else{
                break;
            }
        }
        return minLength;
    }   
    
    public void populate(String s){
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        for(int i=0;i<s.length();++i){
            ++count[map.get(s.charAt(i))];
        }
    }
    
    public boolean isSteady(){
        return (count[0]<=req && count[1]<=req && count[2]<=req && count[3]<=req);
    }
    
    public static void main(String[] args) {
        
         try{
            Solution s = new Solution();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();   
            int res = s.getMinimumSubstring(len,str);
            System.out.println(res);           
        } catch(IOException io){
            io.printStackTrace();
        }
        
    }
}
