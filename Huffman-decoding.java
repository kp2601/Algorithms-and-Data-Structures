  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    


void decode(String S ,Node root)
    {
        
        char c[] = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Node start = root;
        for (int i=0;i<c.length; ++i) {
            start = (c[i] == '0')? start.left : start.right;
            if (start.data !='\0') {
                sb.append(start.data);
                start = root;
            }
            
        }        
       System.out.println(sb.toString());
    }
