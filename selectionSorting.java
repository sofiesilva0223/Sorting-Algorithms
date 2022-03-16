import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/*@author: Sofia Silva
 * Class: CS 146
 * Problem 2, Homework 2
 * Date: Feb 24, 2022
 * Description of program: The input file reads 50 integers to an array called arr2. These integers are sorted with Selection Sort.
 * The program accepts any file and any number of integers in the file.
 * Output: 
 * Before Selection Sort: [97, 72, 97, 49, 76, 88, 97, 9, 100, 57, 35, 73, 18, 85, 33, 49, 94, 72, 74, 22, 8, 21, 61, 34, 75, 54, 43, 26, 28, 79, 60, 10, 4, 63, 48, 89, 83, 18, 45, 51, 93, 17, 84, 47, 20, 9, 32, 96, 82, 70]
 * After Selection Sort: [4, 8, 9, 9, 10, 17, 18, 18, 20, 21, 22, 26, 28, 32, 33, 34, 35, 43, 45, 47, 48, 49, 49, 51, 54, 57, 60, 61, 63, 70, 72, 72, 73, 74, 75, 76, 79, 82, 83, 84, 85, 88, 89, 93, 94, 96, 97, 97, 97, 100]
 */

public class selectionSorting {
	/*@precondition: unsorted integer array
	 *@postcondition: sorted integer array by Selection Sort
	 *@param: int a[] (integer array)
	 *@return: nothing
	*/
	public static void selectionSort(int arrVal[]){
		int size = arrVal.length;			//gets size of array
		for (int i = size-1; i>= 1; i--) {	//accesses values in array
			int maxIndex = i;				//gets last value of array
			for(int j = 0; j <= i; j++) {		//access value in array
				if(arrVal[j] >= arrVal[maxIndex]) {	//compare a value with last value
					maxIndex = j;			//saves larger value of the comparision
				}
			int temp = arrVal [maxIndex];		//swaps maximum element with last value of array
			arrVal[maxIndex] = arrVal[i];
			arrVal[i] = temp;		
			}
			
		}
	}
	/*This function reads the file integers and stores them into a string array.
	 The string array is converted into a int array and prints the integer values from the 
	 integer array.
	 *@throws IOException
	 *@param: fil (the name of file)
	 *@return: arr2
	*/
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
			System.out.println("Before Selection Sort: "+Arrays.toString(arr2)); //prints array contents
			break;
		}
		return arr2; //returns the converted int array that had the file's values
			
		}
	
	public static void main(String[] args)throws IOException {
		String[] s2= (readArr2("arr2-1.txt"));   //contents of readArr1 function is stored into a string array
		int a[]=Stream.of(s2).mapToInt(Integer::parseInt).toArray(); //string array is converted to int to be stored into new integer array
		selectionSort(a); //calls Selection Sort 
		System.out.println("After Selection Sort: "+Arrays.toString(a));
	
	}

}
