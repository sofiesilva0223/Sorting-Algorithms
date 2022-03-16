import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*@author: Sofia Silva
 * Class: CS 146
 * Problem 1 QuickSort, Homework 3
 * Date: March 5, 2022
 * Description of program: Programs reads and then recuirsively sorts the integers from the MyList-1.txt file using QuickSort. 
 * The program then displays the sorted integers in ascending order.
 * Output: 
 * Before Quick Sort: [73, 41, 44, 99, 48, 45, 39, 23, 70, 6, 44, 50, 19, 21, 74, 78, 78, 36, 35, 97, 37, 88, 25, 91, 27, 20, 17, 54, 30, 59, 20, 78, 98, 48, 29, 22, 11, 57, 57, 58, 73, 27, 80, 15, 17, 69, 29, 63, 92, 60, 58, 97, 5, 35, 42, 45, 77, 69, 71, 94, 29, 1, 1, 64, 65, 73, 51, 68, 59, 35]
 * After Quick Sort: [1, 1, 5, 6, 11, 15, 17, 17, 19, 20, 20, 21, 22, 23, 25, 27, 27, 29, 29, 29, 30, 35, 35, 35, 36, 37, 39, 41, 42, 44, 44, 45, 45, 48, 48, 50, 51, 54, 57, 57, 58, 58, 59, 59, 60, 63, 64, 65, 68, 69, 69, 70, 71, 73, 73, 73, 74, 77, 78, 78, 78, 80, 88, 91, 92, 94, 97, 97, 98, 99]
 */
public class quickSorting {
	/*@precondition: unsorted integer array
	 *@postcondition: items less than the pivot are seperated into the lower bound 
	 *and the items more than or equal to the pivot are stored in the upper bound
	 *@param: int a[], int i, int j
	 *@return: m
	*/
	static int partition(int a[],int i, int j) { //i is lower bound, j is upper bound 
		int p=a[i]; //pivot
		int m=i;	
		for(int k=i+1; k<=j; k++) {		//check each element in the unprocessed part
			if (a[k]<p) {
				m++;
				int temp = a[m];
				a[m]=a[k];
				a[k]=temp;
			}
		}
		int temp = a[m];
		a[m]=a[i];
		a[i]=temp;
		return m; // return index of pivot
		
	}
	/*@precondition: pivot of array is decided, values > and <= the pivot are seperated into s1 and s2
	 *@postcondition: sorted array by recusively sorting the 2 portions 
	 *and the item more than or equal to the pivot are stored in the upper bound
	 *@param: int a[], int low, int high
	 *@return: nothing
	*/
	static void quickSort(int a[],int low,int high) {
		if (low<high) {
			int pivotIndex = partition(a, low, high);
			quickSort(a, low, pivotIndex-1);
			quickSort(a, pivotIndex+1, high);
		}
	}
	public static String[] readArr1(String file)throws IOException{
		List<String> fileInfo= new ArrayList<>(); //info of file will be saved here
		BufferedReader brFile = new BufferedReader(new FileReader(file)); //file is read
		String numRead = brFile.readLine(); //file is read line by line
		while (numRead != null) {			// as long as there's numbers in the file, it will be added to the fileInfo arraylist
			fileInfo.add(numRead);
			numRead = brFile.readLine();
			}
		brFile.close();
		//putting arrayList content into a String array
		String[] arr1=fileInfo.toArray(new String[0]);
		int size= arr1.length;
		int [] array1= new int[size];
		while(size>=1) { //as long as the array is not empty, the for loop will exceute 
			for (int i=0;i<size;i++) {
				array1[i]=Integer.parseInt(arr1[i]); //string array is converted to integer array
		}
			System.out.println("Before Quick Sort: "+Arrays.toString(arr1)); //prints array contents
			break;
		}
		return arr1; //returns the converted int array that had the file's values
			
		}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] s2= (readArr1("MyList-1.txt"));   //contents of readArr1 function is stored into a string array
		int a[]=Stream.of(s2).mapToInt(Integer::parseInt).toArray(); //string array is converted to int to be stored into new integer array
		quickSort(a, 0, a.length-1);
		System.out.println("After Quick Sort: "+Arrays.toString(a));
		
	}

}
