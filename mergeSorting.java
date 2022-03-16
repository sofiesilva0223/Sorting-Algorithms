import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*@author: Sofia Silva
 * Class: CS 146
 * Problem 2 MergeSort, Homework 3
 * Date: March 5, 2022
 * Description of program: Programs reads and then recuirsively sorts the integers from the MyList-1.txt file using mergeSort. 
 * The program then displays the sorted integers in ascending order.
 * Output: 
 * Before Merge Sort: [73, 41, 44, 99, 48, 45, 39, 23, 70, 6, 44, 50, 19, 21, 74, 78, 78, 36, 35, 97, 37, 88, 25, 91, 27, 20, 17, 54, 30, 59, 20, 78, 98, 48, 29, 22, 11, 57, 57, 58, 73, 27, 80, 15, 17, 69, 29, 63, 92, 60, 58, 97, 5, 35, 42, 45, 77, 69, 71, 94, 29, 1, 1, 64, 65, 73, 51, 68, 59, 35]
 * After Merge Sort: [1, 1, 5, 6, 11, 15, 17, 17, 19, 20, 20, 21, 22, 23, 25, 27, 27, 29, 29, 29, 30, 35, 35, 35, 36, 37, 39, 41, 42, 44, 44, 45, 45, 48, 48, 50, 51, 54, 57, 57, 58, 58, 59, 59, 60, 63, 64, 65, 68, 69, 69, 70, 71, 73, 73, 73, 74, 77, 78, 78, 78, 80, 88, 91, 92, 94, 97, 97, 98, 99]
 */

public class mergeSorting {
	/*@precondition: unsorted integer array
	 *@postcondition: 2 merged subarrays copied into a[]
	 *@param: int a[], int low, int mid, int high
	 *@return: nothing
	*/
	static void merge(int a[], int low, int mid, int high ){
		int n = high-low+1;
		int b[]= new int [n];				//temp array stores result
		int left=low;
		int right =mid+1;
		int bIndex=0;
		
		while(left<=mid && right<=high) {	//merging when both halves have unmerged items
			if(a[left]<= a[right]) {
				b[bIndex++]=a[left++];
			}
			else {
				b[bIndex++]=a[right++];
			}
		}
		while(left<=mid) {					//remaining items from left half are copied into temp array b[]
			b[bIndex++] =a[left++];
		}
		while(right<=high) {				//remaining items right half are copied into temp array b[]
			b[bIndex++]= a[right++];
		}
		for(int k=0;k<n;k++) {				//merged result is put back into a[]
			a[low+k]=b[k];
		}
		
	}
	/*@precondition: 2 merged, unsorted subarrays
	 *@postcondition: 1 sorted array with integers in ascending order
	 *@param: int a[], int low, int high
	 *@return: nothing
	*/
	static void mergeSort(int a[], int low, int high) {
		if (low<high) {
			int mid=(low+high)/2;
			
			mergeSort(a,low,mid);			// divide a[] into both halves and sort using recusrion
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);			//merge both halves of the sorted array
		}	
	}
		
	public static String[] readArr2(String file)throws IOException{
		List<String> fileInfo= new ArrayList<>(); //info of file will be saved here
		BufferedReader brFile = new BufferedReader(new FileReader(file)); //file is read
		String numRead = brFile.readLine(); //file is read line by line
		while (numRead != null) {			// as long as there's numbers in the file, it will be added to the fileInfo arraylist
			fileInfo.add(numRead);
			numRead = brFile.readLine();
			}
		brFile.close();
		//putting arrayList content into a String array
		String[] arr2=fileInfo.toArray(new String[0]);
		int size= arr2.length;
		int [] array2= new int[size];
		while(size>=1) { //as long as the array is not empty, the for loop will exceute 
			for (int i=0;i<size;i++) {
				array2[i]=Integer.parseInt(arr2[i]); //string array is converted to integer array
		}
			System.out.println("Before Merge Sort: "+Arrays.toString(arr2)); //prints array contents
			break;
		}
		return arr2; //returns the converted int array that had the file's values
			
		}

	public static void main(String[] args) throws IOException{
		String[] s2= (readArr2("MyList-1.txt"));   //contents of readArr1 function is stored into a string array
		int a[]=Stream.of(s2).mapToInt(Integer::parseInt).toArray(); //string array is converted to int to be stored into new integer array
		mergeSort(a, 0, a.length-1);
		System.out.println("After Merge Sort: "+Arrays.toString(a));

	}
}
