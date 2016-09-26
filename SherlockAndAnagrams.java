/* 
Given a string S, find the number of "unordered anagrammatic pairs" of substrings.

Input Format 
First line contains T, the number of testcases. Each testcase consists of string S in one line.
Output Format 
For each testcase, print the required answer in one line.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public static boolean isAnag(String p, String q){
        if(p.length() != q.length()){
            return false;
        } 
        
        int[] a = new int[26];
        for(char c: p.toCharArray()){
            ++a[c - 'a'];            
        }
        
        for(char c:q.toCharArray()){
            --a[c-'a'];
            if(a[c-'a'] < 0){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        try{
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int line = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<line;++i){
                int count = 0;
                String s = br.readLine().trim();
                HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
                StringBuilder sb = new StringBuilder(s);
                for(int j=0;j<s.length();++j){                    
                    for(int k=j+1;k<=s.length();++k){
                        String sub = sb.substring(j,k);
                        int subLength = sub.length();
                        if(!map.containsKey(subLength)){
                            List<String> l = new ArrayList<String>();
                            l.add(sub);
                            map.put(subLength, l);
                        } else{
                            List<String> l = map.get(subLength);
                            l.add(sub.toString());
                            map.put(subLength, l);
                        }                        
                    }
                }
                
                for(int key: map.keySet()){
                    List<String> l = map.get(key);
                    for(int j=0;j<l.size();++j){
                        for(int k=j+1;k<l.size();++k){
                            if(isAnag(l.get(j), l.get(k))){
                                ++count;
                            }
                        }
                    }
                }
                System.out.println(count);
            }
            
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}