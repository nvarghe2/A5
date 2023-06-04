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

public class HolidayBonus {
	private static final double HIGHEST_BONUS = 5000.0;
	private static final double LOWEST_BONUS = 1000.0;
	private static final double OTHER_BONUS = 2000.0;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonuses = new double[data.length];
		
	    for (int i = 0; i < data.length; i++) 
	    {
	    	for(int j=0; j<data[i].length; j++)
	    	{
	    		double highest=TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
		    	double lowest=TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
	    		if(data[i][j]==highest)
	    		{
	    			bonuses[i]+=HIGHEST_BONUS;
	    		}
	    		else if(data[i][j]==lowest)
	    		{
	    			bonuses[i]+=LOWEST_BONUS;
	    		}
	    		else if(data[i][j]==0)
	    		{
	    			bonuses[i]=0.0;
	    		}
	    		else
	    			bonuses[i]+=OTHER_BONUS;
	    	}
	    }
	    return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total = 0.0;
	    double[] bonuses = calculateHolidayBonus(data);
	    for (double bonus : bonuses) {
	        total += bonus;
	    }
	    return total;
	}
}
