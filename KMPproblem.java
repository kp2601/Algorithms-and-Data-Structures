import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public String minString(int[] c, int minFreq, int least){
        StringBuilder sb = new StringBuilder();
        char ch = '\0';
        boolean others = false;
        for(int i=0;i<26;++i){
           if(sb.length() == 0){
               if(minFreq == least){
                    if(c[minFreq] == 1){
                        ch = (char)(minFreq + 97);
                        sb.append(ch);
                        --c[minFreq];
                    } else{
                       ch = (char)(minFreq + 97);
                        sb.append(ch);
                        sb.append(ch);
                        c[minFreq] -= 2;                        
                        
                    }
               } else{                   
                   ch = (char)(minFreq + 97);
                   sb.append(ch);
                   --c[minFreq];
               }
           }
            
            if(minFreq == least) {
                while(i!= minFreq && c[i] > 0){
                    ch = (char)(i + 97);
                    sb.append(ch);
                    --c[i];
                    if(c[minFreq] > 0){
                        ch = (char)(minFreq + 97);
                        sb.append(ch);
                        --c[minFreq];
                    }
                }
            } else{
                while(c[i] > 0){
                    ch = (char)(i + 97);
                    sb.append(ch);
                    --c[i];
                }
            }
            
        }
        
       return sb.toString();
    }
    
    public static void main(String[] args) {
        try{
            Solution sol = new Solution();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            
            String[] s = br.readLine().trim().split(" ");
            int[] count = new int[26];
            int least = Integer.MAX_VALUE;
            int minFreq = 0;    
            boolean others = false;
            int countOthers = 0;
            count[0] = Integer.parseInt(s[0]);
            if(count[0] > 0){
                least = 0; 
                ++countOthers;
            }
            for(int i=1;i<26;i++){
                count[i] = Integer.parseInt(s[i]);
                if(count[i] > 0){
                    ++countOthers;
                }
                if(count[i] > 0 && count[minFreq] == 0){
                    minFreq = i;
                    least = i;
                }
                else if(count[i] > 0 && count[minFreq] > count[i]){
                    minFreq = i;                    
                } 
            }            
            
            //System.out.println((char)(minFreq+97)+" "+(char)(least+97));
            if(countOthers < 2){                
                StringBuilder b = new StringBuilder();
                for(int j=0;j<26;++j){
                    while(count[j] > 0){
                    char curr = (char)(j + 97);
                    b.append(curr);
                    --count[j];
                    }    
                }
               System.out.println(b.toString());    
            } else{
                
                String res = sol.minString(count, minFreq, least);
                System.out.println(res);    
            }
            
            
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}