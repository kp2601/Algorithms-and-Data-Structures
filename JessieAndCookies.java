/* 
Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value KK. To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness =(1× Least sweet cookie + 2× 2nd least sweet cookie).
He repeats this procedure until all the cookies in his collection have a sweetness =K=K. You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness =K=K. Print -1-1 if this isn't possible.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Integer first, second;
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        
        PriorityQueue<Integer> cookies = new PriorityQueue<Integer>();
        for (int i=0; i<n; i++) {
            cookies.add(sc.nextInt());
        }
        
        while(true) {
            if (cookies.peek() >= k) {
                System.out.println(count);
                return;
            }
            
            if (cookies.size() > 1) { 
              cookies.add(cookies.remove() + 2*cookies.remove());
              count++;
            } else {
                break;
            }
        }
        System.out.println("-1");
    }
}
