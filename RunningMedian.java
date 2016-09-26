/* 
The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set {1,2,3}, 2 is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set {1,2,3,4}, 2.5 is the median.
Given an input stream of n integers, you must perform the following task for each ith integer:

Add the ith integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the ith element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e.,12.3 format).

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Solution s = new Solution();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(br.readLine().trim());
            PriorityQueue<Double> mx = new PriorityQueue<Double>(Collections.reverseOrder());
            PriorityQueue<Double> mi = new PriorityQueue<Double>();
            double median = 0;
            String str = "";
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<len;++i){
                double curr = Double.parseDouble(br.readLine().trim());
                if(mx.isEmpty() && mi.isEmpty()){
                    mx.add(curr);
                } else if(mx.peek() < curr){
                    mi.add(curr);
                } else if(mi.isEmpty()){                                       
                    mi.add(mx.poll());
                    mx.add(curr);
                } else {
                    mx.add(curr);                
                }
                
                while(Math.abs(mx.size()-mi.size()) > 1) {
                    if(mx.size() > mi.size()) {
                        mi.add(mx.poll());
                    } else {
                        mx.add(mi.poll());
                    }
                }
                
                if((mx.size() + mi.size()) % 2==0){
                    str = new DecimalFormat("#0.0000").format((mi.peek() + mx.peek())/2);
                    System.out.println(Double.parseDouble(str));
                } else {  
                    if(mx.size() >= mi.size()) {
                        str = new DecimalFormat("#0.0000").format(mx.peek());
                        System.out.println(Double.parseDouble(str));    
                    } else {
                        str = new DecimalFormat("#0.0000").format(mi.peek());
                        System.out.println(Double.parseDouble(str));    
                    }
                    
                }   
            }
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
