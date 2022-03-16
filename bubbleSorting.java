import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*@author: Sofia Silva
 * Class: CS 146
 * Problem 1, Homework 2
 * Date: Feb 24, 2022
 * Description of program: The input file reads 50 integers to an array called arr1. These integers are sorted with Bubble Sort.
 * The program accepts any file and any number of integers in the file.
 * Output: 
 * Before Bubble Sort: [76, 54, 47, 88, 64, 26, 59, 97, 71, 9, 97, 8, 79, 20, 77, 83, 65, 62, 76, 65, 92, 80, 36, 33, 59, 40, 96, 90, 94, 10, 38, 16, 52, 26, 35, 100, 53, 98, 19, 50, 62, 59, 74, 36, 10, 96, 89, 38, 76, 63]
 * After Bubble Sort: [8, 9, 10, 10, 16, 19, 20, 26, 26, 33, 35, 36, 36, 38, 38, 40, 47, 50, 52, 53, 54, 59, 59, 59, 62, 62, 63, 64, 65, 65, 71, 74, 76, 76, 76, 77, 79, 80, 83, 88, 89, 90, 92, 94, 96, 96, 97, 97, 98, 100]
 */

	public class bubbleSorting {
		
		/*@precondition: unsorted integer array
		 *@postcondition: sorted integer array by Bubble Sort
		 *@param: int arr[] (integer array)
		 *@return: nothing
		*/
		static void bubbleSort (int arrVals[]) { //takes in integer array
			int size = arrVals.length;				//length of array assigned to int varible called size
			for (int i = 0; i < size-1; i++) {		//access each array element
				for (int j = 0; j < size - 1; j++) { 	
					if (arrVals[j] > arrVals [j+1]) {		//compares adajecent values, 
						int temp = arrVals [j];		//swaps elements if not in correct order
						arrVals [j] = arrVals [j+1];
						arrVals [j+1] = temp;	
					}			
				}	
			}
			
		}
		/*This function reads the file integers and stores them into a string array.
		 The string array is converted into a int array and prints the integer values from the 
		 integer array.
		 *@throws IOException
		 *@param: fil (the name of file)
		 *@return: arr1
		*/
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
				System.out.println("Before Bubble Sort: "+Arrays.toString(arr1)); //prints array contents
				break;
			}
			return arr1; //returns the converted int array that had the file's values
				
			}
		/*@throws IOException
		 */
		public static void main(String[] args) throws IOException {
			String[] s= (readArr1("arr1-2.txt"));   //contents of readArr1 function is stored into a string array
			int a[]=Stream.of(s).mapToInt(Integer::parseInt).toArray(); //string array is converted to int to be stored into new integer array
			bubbleSort(a); //calls bubbleSort 
			System.out.println("After Bubble Sort: "+Arrays.toString(a));
			
		}
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
