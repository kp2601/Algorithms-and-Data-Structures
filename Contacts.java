/* 
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where name is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where partial is a string denoting a partial name to search the application for. It must count the number of contacts starting with partial and print the count on a new line.
Given n sequential add and find operations, perform each operation in order.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;      
        TrieNode(){
            for(int i=0;i<26;++i){
            children[(char)i]=null;            
        }    
      } 
    }
    Map<String, Integer> store = new LinkedHashMap<String, Integer>();
    TrieNode root;    
    Solution() {
        root = new TrieNode();
    }
    
    public void add(String word) {
        TrieNode curr = root;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<word.length();++i){
            sb.append(word.charAt(i));
            String s = sb.toString();
            if(curr.children[word.charAt(i)-97]!=null) {
                store.put(s, store.get(s) + 1);                
            } else{
                curr.children[word.charAt(i)-97]= new TrieNode();
                store.put(s, 1);
            }            
            curr = curr.children[word.charAt(i)-97];
        }
        curr.endOfWord = true;
    }
    
    public int find(String word){        
        return store.get(word)==null?0:store.get(word);
    }
    
    
    public static void main(String[] args) {
        Solution s = new Solution();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int ops = Integer.parseInt(br.readLine().trim());     
            StringBuffer output = new StringBuffer();            
            int findCount=0;
            for(int i=0;i<ops;++i){
                 findCount = 0;
                String[] op = br.readLine().trim().split(" ");
                if(op[0].equals("add")) {
                    s.add(op[1]); 
                } else {
                    ++findCount;
                    String toSearch = op[1];
                    int res = s.find(toSearch);                    
                    output.append(res);
                    if(i<ops - 1){
                        output.append("\n");
                    }
                }
            }
            if(findCount > 0){
                System.out.println(output.toString());    
            }
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
