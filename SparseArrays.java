import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       try{
		BufferedReader br = 
                      new BufferedReader(new InputStreamReader(System.in));		
           String input = "";
           int line = 0;
           int N = 0;
           int Q = 0;
  
           Map<String, Integer> map = new HashMap();
           while((input = br.readLine())!=null){
               if(line < 1){
                N = Integer.parseInt(input);
               }
               else if(line > 0 && line < N + 1){
                   if (!map.containsKey(input))
                       {
                       map.put(input,1);
                   }
                   else{
                       int val = map.get(input);
                       val++;
                       map.put(input,val);
                   }
               }
               else if(line == N+1){
                   Q = Integer.parseInt(input);
               }
               else{
                   int res = map.containsKey(input)? map.get(input):0;
                   System.out.println(res);
               }
               line++;
           }
       }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}