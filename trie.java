/*
 *  Java Program to Implement Trie
 */
 
import java.util.*;

public class trie{
    public static void main(String[] args)
    {            
        Scanner sc=new Scanner(System.in);
        tr t = new tr();
        TrieNode trieNode=new TrieNode(' ');
        System.out.println("Enter the value of n");
        int n=sc.nextInt();      
        n++; 
        String[] strArray=new String[n];
        for(int i=0;i<strArray.length;i++)
        strArray[i]=sc.nextLine();
        t.insert(trieNode, strArray);
        t.display();
        System.out.println("Enter the word to be deleted in trie");
        String str=sc.nextLine();
        if(t.delete(trieNode,str,0)==false) System.out.println(str+" is not able to deleted from trie.");
        else{
            System.out.println(str+"  is deleted from trie.");
            t.display();
        }
        sc.close();
    }
}
class TrieNode 
    {
    char data; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList;
 
    /* Constructor */
    public TrieNode(char c)
    {
        childList = new LinkedList<>();
        isEnd = false;
        data = c;
        count = 0;
    }  
    public TrieNode getChild(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }
    }
class tr
{
    private TrieNode root;
    ArrayList<String> list=new ArrayList<>();
     /* Constructor */
    public tr()
    {
        root = new TrieNode(' '); 
    }
    /* This function is used to insert a word in trie*/
    public void insert(TrieNode node,String[] strArray){
        for(int i=0;i<strArray.length;i++){
            if(checkString(strArray[i])){
                insertx(strArray[i]);
            }
            else
            System.out.println(strArray[i]+" omitted from list");
        }
    }
    public void insertx(String word)
    {
        
        list.add(word);
        if (search(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.getChild(ch);
            if (child != null){
                current = child;
            }
            else 
            {
             // If child not present, adding it io the list
                 current.childList.add(new TrieNode(ch));
                 current = current.getChild(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    /* This function is used to search a word in trie*/
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.getChild(ch) == null)
                return false;
            else
                current = current.getChild(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    /* This function is used to remove function from trie*/
    public void remove(String word)
    {
        if (search(word) == false)
        {
            //System.out.println(word +" does not present in trien");
            //return false;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.getChild(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                list.remove(word);
               // return true;
            } 
            else 
            {
                child.count--;
                current = child;
                //return true;
            }
        }
        current.isEnd = false;
    }
    public boolean delete(TrieNode node,String str,int x){
        if(search(str)){ 
            list.remove(str);
            return true;
        }
        else return false;
    }
  
    public static void printAllWordsInTrie(TrieNode root,String s)
    {
      TrieNode current = root;
      if(root.childList==null || root.childList.size()==0)
       return;
      Iterator<TrieNode> iter=current.childList.iterator();
     while(iter.hasNext())
     {
      TrieNode node= iter.next();
      s+=node.data;
      printAllWordsInTrie(node,s);
      if(node.isEnd==true)
      { 
       System.out.print(" "+s);
       s=s.substring(0,s.length()-1);
      }
      else
      {
       s=s.substring(0,s.length()-1);
      }
     }
      
    }
    public void display(){
        int i=0;
        Collections.sort(list);
        if(i==0){
        System.out.println("The contents of trie are:");
        }
        i++;
        for(String s:list)
        System.out.println(s);

    }
    public boolean checkString(String str){
        boolean flag=true;
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
 