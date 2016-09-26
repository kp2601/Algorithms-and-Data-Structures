/* 
Given a string,S, of lowercase letters, determine the index of the character whose removal will make S a palindrome. If S is already a palindrome or no such character exists, then print -1. There will always be a valid solution, and any correct answer is acceptable. For example, if S="bcbc", we can either remove 'b' at index 0 or 'c' at index 3.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try{
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<t;++i){
                String s = br.readLine().trim();
                int f = 0;
                int N = s.length();
                if(N == 1){
                    System.out.println(-1);
                } else if(N == 2){
                    System.out.println(0);
                } else{
                    int l = s.length()-1;     
                    boolean found = false;
                    while(f < l){
                        if(s.charAt(f) != s.charAt(l)){
                            found = true;
                            if(l - f < 2){
                                if( l + 1 < N && s.charAt(f) == s.charAt(l+1)) {
                                    System.out.println(l);
                                    break;
                                } else if(f - 1 > -1 && s.charAt(f - 1) == s.charAt(l)) {
                                    System.out.println(f);
                                    break;
                                }
                            } else{
                                if(s.charAt(f) == s.charAt(l-1) && s.charAt(l) == s.charAt(f+1)){
                                    if(s.charAt(f+1) == s.charAt(l-2)){
                                        System.out.println(l);
                                        break;
                                    } else if(s.charAt(l-1) == s.charAt(f+2)){
                                        System.out.println(f);
                                        break;
                                    }
                                }
                                if(s.charAt(f) == s.charAt(l-1)){
                                    System.out.println(l);
                                    break;
                                } else if(s.charAt(l) == s.charAt(f+1)){
                                    System.out.println(f);
                                    break;
                                }
                                
                            }
                        }
                        ++f;
                        --l;
                    }
                    
                    if(!found){
                         System.out.println(-1);
                    }
                }
                
            }
            
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
