/* 
A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element x into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    Stack<String> f = new Stack<String>();
    Stack<String> s = new Stack<String>();
    int count = 0;
    int fsize = 0;
    int ssize = 0;
    
    public void add(String x){        
        ++fsize;
        f.push(x);
    }
    
    public void poll(){        
        if(s.isEmpty()&& f.size() == 1) {
            f.pop();
        } else if(s.isEmpty()) {
            while(!f.isEmpty()) {
                s.push(f.pop());
            }            
            s.pop();
        } else {
            s.pop();
        }
    }
    public void printFirst(){
        if(s.isEmpty()) {
            while(!f.isEmpty()) {
                s.push(f.pop());
            }
            System.out.println(s.peek());
        } else {
            System.out.println(s.peek());
        }
        
     }
    
    
    public static void main(String[] args) {
        BufferedReader br = null;
        Solution s = new Solution();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int lines = Integer.parseInt(br.readLine().trim());
            String[] line = null;
            for(int i=0;i<lines;++i) {
                line = br.readLine().split(" ");
                if(line[0].equals("1")) {                    
                   s.add(line[1]);
                } else if(line[0].equals("2")){
                    s.poll();
                } else {
                    s.printFirst();
                }
            }
        } catch(Exception io) {
            io.printStackTrace();
        }
    }
}