/* 
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains  space-separated integers describing the cylinder heights in stack .
The third line contains  space-separated integers describing the cylinder heights in stack .
The fourth line contains  space-separated integers describing the cylinder heights in stack .
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public int smallestStack(int[] h1, int[] h2, int[] h3) {
        int s1=0;
        int s2=0;
        int s3=0;
        
        Stack<Integer> stack1 = new Stack<Integer>(); 
        Stack<Integer> stack2 = new Stack<Integer>(); 
        Stack<Integer> stack3 = new Stack<Integer>(); 
        for(int i=h1.length - 1 ; i>=0;--i) {
            s1 += h1[i];            
            stack1.push(h1[i]);
        }
        for(int i=h2.length - 1; i>=0;--i) {
            s2 += h2[i];
            stack2.push(h2[i]);
        }
        for(int i=h3.length - 1; i>=0;--i) {
            s3 += h3[i];
            stack3.push(h3[i]);
        }        
        int minEqualHeight = s1;
        while(s1 != s2 || s2 != s3) {            
            
            int minHeight = Math.min(Math.min(s1,s2), s3);
            
            if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                minEqualHeight = 0;
                break;
            }
            
            while(!stack1.isEmpty() && s1 > minHeight) {
                s1 -= stack1.pop();                
            }
            while(!stack2.isEmpty() && s2 > minHeight) {
                s2 -= stack2.pop();
            }
            while(!stack3.isEmpty() && s3 > minHeight) {
                s3 -= stack3.pop();
            }
            minEqualHeight = minHeight;
        }
          System.out.println(minEqualHeight);         
        
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        
        Solution s = new Solution();
        s.smallestStack(h1, h2, h3);
    }
}
