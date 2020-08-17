import java.util.*;  
public class stcklinked{  
public static void main(String[] args) {  
    int choice=0;  
    Scanner sc = new Scanner(System.in);     
    //System.out.println("Enter the maximum size of the stack");  
    int n=1000;  
    Queue q=new Queue(n);
    do{
        System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nAny other choice : Exit");  
        System.out.println("Enter your choice");        
        choice = sc.nextInt();  
        switch(choice)  
        {  
            case 1:  
            {   
                System.out.println("Enter the element to be pushed");
                int a=sc.nextInt();
                q.enQueue(a);
                //Fill your code here  
                break;  
            }  
            case 2:  
            {  
                //Fill your code here
                int x=q.deQueue();
                if(x!=-1000){
                    System.out.println("The poped element is "+x);
                }
                break;  
            }  
            case 3:  
            {  
		        System.out.print("The contents of the stack are ");
                //Fill your code here 
                q.display();
                //System.out.println("\n");
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

class Queue
{
     int Queue[] ;
     int front, rear, size, len;
 
    /* Constructor */
    public Queue(int n) 
    {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }    
    /*  Function to check if queue is empty */
     boolean isEmpty() 
    {
        return front == -1;
    }    
    /*  Function to check if queue is full */
     boolean isFull() 
    {
        return front==0 && rear == size -1 ;
    }    
    /*  Function to get the size of the queue */
     int getSize()
    {
        return len ;
    }    
    /*  Function to check the front element of the queue */
     int peek() 
    {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        return Queue[front];
    }    
    /*  Function to insert an element to the queue */
     void enQueue(int i) 
    {
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
            throw new IndexOutOfBoundsException("Queue is full");
        else if ( rear + 1 < size)
            Queue[++rear] = i;    
        len++ ;    
    }    
    /*  Function to remove front element from the queue */
    public int deQueue() 
    {
        if (isEmpty()){
           System.out.println("Queue is empty");
           return -1000;
        }
        else 
        {
            len-- ;
            int ele = Queue[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else{
                front++;
            }                
            return ele;
        }        
    }
    /*  Function to display the status of the queue */
    public void display()
    {
        if (len == 0)
        {
            System.out.print("{}");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(Queue[i]+" ");
        System.out.println();        
    }
}