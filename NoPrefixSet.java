/* 
Given N strings. Each string contains only lowercase letters from a-j(both inclusive). The set of N strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.

Input Format 
First line contains N, the number of strings in the set. 
Then next N lines follow, where ith line contains ith string.
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }
    
    public TrieNode root;
    
    Solution(){
        root = new TrieNode();
    }    
    
    public String add(String word){
        TrieNode curr = root;
        int count = 0;
        for(int i = 0;i<word.length();++i){
            char c = word.charAt(i);
            if(curr.endOfWord){                
                return "BAD SET";
            }
            if(curr.children[c-97]!=null){
                ++count;
            } else{
                curr.children[c-97] = new TrieNode();
            }
            curr = curr.children[c-97];
        }
        curr.endOfWord = true;
        if(count == word.length()){
            return "BAD SET";
        }
        return "GOOD SET";
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int line = Integer.parseInt(br.readLine().trim());
            String str = "";
            boolean badSetFound = false;
            for(int i=0;i<line;++i){
                str = br.readLine().trim();
                String res = s.add(str);
                //System.out.println(str+" "+res);
                if(res.equals("BAD SET")){
                    System.out.println("BAD SET");
                    System.out.println(str);
                    badSetFound = true;
                    break;
                }
            }
            if(!badSetFound){
                System.out.println("GOOD SET");
             }
                
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}