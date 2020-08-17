import java.util.*;  
public class stacklast{  
public static void main(String[] args) {  
    int choice=0;  
    Scanner sc = new Scanner(System.in);     
    Queue<Integer> q = new LinkedList<Integer>();
    do{
        System.out.println("Choice 1 : Insert\nChoice 2 : Delete\nChoice 3 : Display\nAny other choice : Exit");  
        //System.out.println("Enter your choice");        
        choice = sc.nextInt();  
        switch(choice)  
        {  
            case 1:  
            {   
                System.out.println("Enter the element to be inserted");
                int a=sc.nextInt();
                q.add(a);
                //Fill your code here  
                break;  
            }
            case 2:
			{
                
		        try{
    				System.out.println("The element "+q.remove()+" is deleted from queue ");
				}
				catch(NoSuchElementException e){
					System.out.println("The queue is empty");
				}
				break;
			}
            case 3:  
            {  
                //Fill your code here
                System.out.println("The elements in the queue are");
				System.out.println(q);
                break;  
            }  
            default:  
            {  
                System.exit(0);  
                break; 
            }    
    }
    }while(choice<4);
}
}  
