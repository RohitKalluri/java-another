import java.util.*;
class lab 
{
	static int partition(int arr[], int low, int high) 
	{ 
        int pivot = arr[high];
        System.out.println("---------------------");
        System.out.println("Pivot element is :- "+pivot);
		int i = (low-1); 
		for (int j=low; j<high; j++) 
		{ 
			if (arr[j] < pivot) 
			{ 
				i++; 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
        } 
        
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
        arr[high] = temp; 
        
        System.out.println("elements in First partition are :- ");
        for(int j=0;j<i+1;j++) System.out.print(arr[j]+" ");
        System.out.println();
        System.out.println("elements in the Second partition are :- ");
        for(int j=i+2;j<arr.length;j++) System.out.print(arr[j]+" ");
        System.out.println();
		return i+1; 
	} 

	static void quickSort(int arr[], int low, int high) 
	{ 
        int pi;
		if (low < high) 
		{
            pi = partition(arr, low, high); 
			quickSort(arr, low, pi-1); 
			quickSort(arr, pi+1, high); 
		} 
	} 
	public static void main(String args[]) 
	{ 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of Array");
        int n=sc.nextInt();
        System.out.println("Enter Array Elements :- ");
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++) arr[i]=sc.nextInt();
        quickSort(arr, 0, arr.length-1);
        System.out.println("---------------------");
        System.out.println("Sorted Array is :- ");
        System.out.println(Arrays.toString(arr));
        sc.close();
	} 
}