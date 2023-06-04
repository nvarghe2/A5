/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi 
 * Description: (Give a brief description for each Class)
		 	•	Creating classes based on Javadoc
			•	Two Dimensional Ragged Arrays
			•	Passing arrays to and from methods
			•	Creating a Utility class (static methods)
			•	JUnit testing
			•	Reading from a file
			•	Writing to a file	
			•	Using methods of the utility class within an existing GUI driver class
 * Platform/compiler: Java, Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: NIKITTA JOAN VARGHESE 
*/
import java.io.*;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {
	public static double[][] readFile(File file) throws FileNotFoundException {
		final int MAX_ROW = 10;
	    final int MAX_COLUMN = 10;

	    // Step 1: Read the doubles from the file into a temporary array of Strings
	    String[][] tempArray = new String[MAX_ROW][MAX_COLUMN];
	    int row = 0;
	    Scanner scanner = new Scanner(file);
	    while (scanner.hasNextLine() && row < MAX_ROW) {
	        String line = scanner.nextLine();
	        if (!line.isEmpty()) {
	            String[] values = line.split(" ");
	            int column = 0;
	            for (String value : values) {
	                if (column < MAX_COLUMN) {
	                    tempArray[row][column] = value;
	                    column++;
	                } else {
	                    break;
	                }
	            }
	            row++;
	        }
	    }
	    scanner.close();

	    // Step 2: Find out how many rows there are
	    int numRows = 0;
	    for (String[] rowValues : tempArray) {
	        if (rowValues[0] != null) {
	            numRows++;
	        } else {
	            break;
	        }
	    }

	    // Step 3: Create the array based on the number of rows
	    double[][] array = new double[numRows][];

	    // Steps 4-7: Iterate over each row and create sub-arrays for each row
	    for (int i = 0; i < numRows; i++) {
	        // Step 4: Determine the number of columns for the row
	        int numColumns = 0;
	        for (int j = 0; j < MAX_COLUMN; j++) {
	            if (tempArray[i][j] != null) {
	                numColumns++;
	            } else {
	                break;
	            }
	        }

	        // Step 5: Create the sub-array for the row
	        array[i] = new double[numColumns];

	        // Step 6: Copy values from the temporary array to the sub-array
	        for (int j = 0; j < numColumns; j++) {
	            array[i][j] = Double.parseDouble(tempArray[i][j]);
	        }
	    }

	    return array;
	}
	
	public static void writeToFile(double[][] data, File outPutFile) throws FileNotFoundException {
		try(PrintWriter outPut = new PrintWriter(outPutFile))
		{
			for(int i=0; i< data.length; i++)
			{
				for(int j=0; j< data[i].length; j++)
				{
					outPut.print(data[i][j]+ " ");
				}
				outPut.println();
			}
			outPut.close();
		}
		
	}
	
	public static double getTotal(double[][] data) {
		double total=0.0;
		for(int row=0; row<data.length; row++)
		{
			for(int col=0; col<data[row].length; col++)
			{
				total+=data[row][col];
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] data) {
		double total=0.0;
		int count=0;
		for(int row=0; row<data.length; row++)
		{
			for(int col=0; col<data[row].length; col++)
			{
				total+=data[row][col];
				count++;
			}
		}
		return count>0 ? total/count : 0.0;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double total=0.0;
		if(row>=0 && row<data.length)
		{
			for(int i=0; i<data[row].length; i++)
			{
					total+=data[row][i];
			}
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total=0.0;
		for(int i=0; i<data.length; i++)
		{
			if(col>=0 && col<data[i].length)
			{
			total+=data[i][col];
			}
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		int j= getHighestInRowIndex(data,row);
		return data[row][j];
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = -1;
        double highest = Double.NEGATIVE_INFINITY;
        if (row >= 0 && row < data.length) {
            for (int j = 0; j < data[row].length; j++) {
                if (data[row][j] > highest) {
                    highest = data[row][j];
                    index = j;
                }
            }
        }
        return index;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		int j= getLowestInRowIndex(data, row);
		return data[row][j];
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index=-1;
		double lowestInRow= Double.POSITIVE_INFINITY;
		if(row>=0 && row<data.length)
		{
			for(int j=0; j<data[row].length; j++)
			{
				if(data[row][j]< lowestInRow)
				{
					lowestInRow= data[row][j];
					index= j;
				}
			}
		}
		return index;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		int i= getHighestInColumnIndex(data, col);
		return data[i][col];
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index=-1;
		double highestInCol= Double.NEGATIVE_INFINITY;
		for(int i=0; i<data.length; i++)
		{
			if(col>=0 && col<data[i].length) 
			{
				if(data[i][col]> highestInCol)
				{
					highestInCol= data[i][col];
					index=i;
				}
			}
		}
		return index;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		int i= getLowestInColumnIndex(data, col);
		return data[i][col];
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index=-1;
		double lowestInCol= Double.POSITIVE_INFINITY;
		for(int i=0; i<data.length; i++)
		{
			if(col>=0 && col<data[i].length)
			{
				if(data[i][col]< lowestInCol)
				{
					lowestInCol= data[i][col];
					index=i;
				}
			}
		}
		return index;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highestInArray=Double.NEGATIVE_INFINITY;
		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++)
			{
				if(data[i][j]>highestInArray)
				{
					highestInArray=data[i][j];
				}
			}
		}
		return highestInArray;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowestInArray=Double.POSITIVE_INFINITY;
		for(int i=0; i<data.length; i++)
		{
			for(int j=0; j<data[i].length; j++)
			{
				if(data[i][j]<lowestInArray)
				{
					lowestInArray=data[i][j];
				}
			}
		}
		return lowestInArray;
	}
}
