import java.util.*;

class Cube{
	// anti-clockwise direction 
    public void rotateMatrix( int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) { 
            // Consider elements in group 
            // of 4 in current square 
            for (int y = x; y < N - x - 1; y++) { 
                // Store current cell in 
                // temp variable 
                int temp = mat[x][y]; 
                // Move values from right to top 
                mat[x][y] = mat[y][N - 1 - x]; 
                // Move values from bottom to right 
                mat[y][N - 1 - x] 
                    = mat[N - 1 - x][N - 1 - y]; 
                // Move values from left to bottom 
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x]; 
                // Assign temp to left 
                mat[N - 1 - y][x] = temp; 
            } 
        }
    } 
    
    //For melting of matrix
    /* Melting is done by taking the first column
     * Then two variables top and down
     * top point to the first element of the first column
     * down points to the last element of the first column
     * top and down moves towards each other by iterating the elements in the first column from their position
     * if top founds a 'D' (ie) zero in our case, then it'll change it to -1 to denote space and move to next element
     * if top founds a 'C', top will get assigned to C and wait for down to find a 'D'
     * if down finds a 'D' iterating from the bottom , then down will change the 'D' to 'C' and top will change it's 'C' to space (ie) '-1'
     * and then top will continue to search for another C while continuously changing 'D' to space
     * Thus the first column will be melted and it'll be repeated for the remaining columns
     */
    public void melting(int N, int mat[][]) {
    
    	for(int i=0;i<N;i++) {
    		int top=0;
    	    int down=N-1;
    	  for(int loop=0;loop<N;loop++) {
    		  if(top>down) {
    			  break;
    		  }
    		for(;top<N;top++) {
    			if(mat[top][i]==0) {
    				mat[top][i]=-1; //To denote the space as -1 after C drops
    			}
    			else if(mat[top][i]==1) {
    			   break;
    			}
    		}
    		for(;down>0;down--) {
    			if(mat[down][i]==0) {
    				mat[down][i]=1; //changes down to 1 and top to -1 to make the matrix look melted
    				mat[top][i]=-1; //To denote the space as -1 after C drops
    				top++;
    				down--;
    				break;
    			}
    		}
    		
    	  }
    	}

    }
    
    
    /*For finding the square wall to be fit inside the melted matrix
     * We'll create a 1D array of size N which is the wall_size given as input 
     * Assign all the elements of array from 1 to the input N ex: arr[0]=1, arr[1] = 2 ......arr[N-1]=N
     * We'll use each element of the array as the square wall size to fit into our melted matrix
     * and assign -1 to the respective array[i] if it fits inside our matrix
     * Atlast we'll iterate our fully checked array from the last index arr[N] and if arr[i] matches -1 
     * then we'll return the correspinding array element position as the biggest square to be fitted to our matrix
     * To check if a square fits our matrix, we'll take the first column and iterate from top
     * We'll continue our iteration and count the no.of iterations of spaces in our first column
     * If we find a C instead of a space then we'll stop the iteration and check if no.of iteration == array[i]
     * If it satisfies then we'll increment a new variable called loop and check whether loop == array[i]
     * If it equals then we've successfully fitted a square and assign array[i]=-1 and move on the next element in our array
     * if not then we'll move on to next column till loop==array[i]
     * if no.of iterations < array[i] then we'll move to next column while setting loop back to 0 and check from first 
     * whether we can fit a square. If not we'll not assign -1 to our array.
     */
    public int wall_size(int N,int mat[][]){
    	
    	   int[] arr = new int[N];
    	    for(int i=0;i<N;i++) {
    	    	arr[i]=(i+1);
    	    }
    	    
    	    
    	    
    	    for(int i=0;i<arr.length;i++) {
    	    	int loop=0;
  
    	    	for(int col=0;col<N;col++) {
    	  	    	int count =0;
    	    		for(int row=0;row<N;row++ ) {
    	    			if(count==arr[i]) {
    	    				break;
    	    			}
    	    			if(mat[row][col]==-1) {
    	    			    count++;
    	    			    //For Debugging
    	    			    //System.out.println("column: "+col +"Row: "+row);
    	    			}
    	    			else  if(mat[row][col]==1)
    	    			{
    	    				//For Debugging
    	    				//System.out.println("same");	
    	    				break;
    	    			}
    	    		}
    	    	    if(count<arr[i]) {
    	    	    	//For Debugging
    	    	    	//System.out.println("COUNT:"+count);
    	    	    	loop=0;
    	    	    	
    	    	    }
    	    		if(count==arr[i]) {
    	    			loop++;
    	    			if(loop==arr[i]) {
    	    				//For Debugging
    	    				//System.out.printf("\n Array: %d , column: %d, loop: %d, count: %d \n",arr[i],col,loop,count);
    	    				arr[i]=-1;
    	    				
    	    				break;
    	    			
    	    			}
    	    		}
    	    		
    	    	
    	    	}
    	    }
    	    
    	    
    	    for(int i=(arr.length)-1;i>=0;i--) {
    	    	if(arr[i]==-1) {
    	    		return (i+1);
    	    	}
    	    }
    	    return 0;
    }
    
    //for debugging printing of the matrix 
    public void print(int size,int[][] mat) {
    	System.out.println();
    	for(int i =0;i<size;i++	) {
    		for ( int j=0;j<size;j++) {
    			System.out.print("  "+mat[i][j]+"  ");
    		}
    		System.out.println();
    	}
    }
  
}


//Main class
public class gfg {
 public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 int wall_size = input.nextInt();
	 input.nextLine();
	 String[] bricks = new String[wall_size];
	 int[][] bmatrix = new int[wall_size][wall_size];
	 int[][] bmatrix1 = new int[wall_size][wall_size];

	 
	 //For converting the input to matrix form C=1 and D=0
	 for(int i=0;i<bricks.length;i++) {
		 bricks[i] = input.nextLine();
		for(int j=0;j<bricks.length;j++) {
			if(bricks[i].charAt(j)=='C')
						bmatrix[i][j] = 1;
			else
				bmatrix[i][j]=0;
		}
	 }
	 
	 Cube cubObj = new Cube();
	 
	 int[][] k = new int[2][2];
	 k[0][1]=1;
	 int[][] j = new int[2][2];
	 
	 for(int i=0;i<k.length;i++) {
	 System.arraycopy(k[i]	, 0, j[i], 0, k[0].length);
	 }
	 j[0][1] = 0;
	 System.out.println(k[0][1]);
	 
	
	//Copying bmatrix for rotation and storing it in another bmatrix1
	for(int i=0;i<bmatrix.length;i++) {
	 System.arraycopy(bmatrix[i], 0, bmatrix1[i], 0, bmatrix[0].length);
	}
     cubObj.rotateMatrix(wall_size, bmatrix1);  //rotation happens
	 
     //cubObj.print(wall_size, bmatrix);  -- Print the matrix form of the input
			
	 //Melting 
	 cubObj.melting(wall_size, bmatrix);
	 cubObj.melting(wall_size,bmatrix1);
	 
	 //cubObj.print(wall_size, bmatrix);  -- Print the melted matrix
		
	 int notRotated =  cubObj.wall_size(wall_size, bmatrix); //Identifies the wall_size
	 int rotated = cubObj.wall_size(wall_size, bmatrix1);    //Identifies the wall_size of the rotated matrix
	 
	 //To check the wall_sizes and print the bigger one.
	 if(notRotated>=rotated) {
		 System.out.println(notRotated);
	 }
	 else {
		 System.out.println(rotated);
	 }

   }

}