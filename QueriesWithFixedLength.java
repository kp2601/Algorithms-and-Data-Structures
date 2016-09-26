/* 
Consider an -integer sequence, A={a0,a1,a2...an-1}. We perform a query on A by using an integer, d, to calculate the result of the following equation:

									min(0<=i<n)(max(i<=j<i+d) aj)

Given A and d queries (each query consists of an integer, d), print the result of each query on a new line.

Input Format

The first line consists of two space-separated integers describing the respective values of n and q. 
The second line consists of  space-separated integers describing the respective values of a0,a1,a2...an-1. 
Each of the q subsequent lines contains a single integer denoting the value of d for that query.
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
            String[] info = br.readLine().trim().split(" ");
            int N = Integer.parseInt(info[0]);
            int q = Integer.parseInt(info[1]);
            String[] sArr = br.readLine().trim().split(" ");
            int[] iArr = new int[N];
            
            
            for(int i=0;i<N;++i) {
                iArr[i] = Integer.parseInt(sArr[i]);
            }
            for(int i=0;i<q;++i) {                
                int d = Integer.parseInt(br.readLine().trim());                                                
                Deque<Integer> dq = new LinkedList<Integer>();                                                
                int j;                
                int min = Integer.MAX_VALUE;
                for(j=0;j<d;++j){
                    while(!dq.isEmpty() && iArr[j] >= iArr[dq.peekLast()]){
                        dq.pollLast();
                    }
                    dq.addLast(j);
                }                
                for(;j<N;++j){                    
                    min = Math.min(min, iArr[dq.peekFirst()]);
                    while(!dq.isEmpty() && dq.peekFirst() <= j - d) {
                        dq.pollFirst();
                    }
                    
                    while(!dq.isEmpty() && iArr[j] >= iArr[dq.peekLast()]){
                        dq.pollLast();
                    }
                    dq.addLast(j);
                }                
                min = Math.min(min, iArr[dq.peekFirst()]);
                System.out.println(min);
            }
            
        } catch(IOException io) {
            io.printStackTrace();
        }
        
    }
}