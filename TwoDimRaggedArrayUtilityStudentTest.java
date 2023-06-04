import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;
class TwoDimRaggedArrayUtilityStudentTest {
	private double[][] dataSet1 = {{1,2,3},
									{4,5},
									{6,7,8,9}};
	private double[][] dataSet2 = {{7.0,2.0,9.0,4.0},
									{5.0},
									{8.0,1.0,3.0},
									{11.0,6.0,7.0,2.0}};
	private double[][] dataSet3 = {{7.2,2.5,9.3,4.8},
									{5.9},
									{8.1,1.7,3.3},
									{11.6,6.9,7.3,2.7}};
	private double[][] dataSet4 = {{-2.5,-5.3,6.1},
									{-4.4,8.2},
									{2.3,-7.5},
									{-4.2,7.3,-5.9,2.6}};


	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadFile() throws FileNotFoundException {
	        File file = new File("dataSet2.txt");
	        double[][] actual = TwoDimRaggedArrayUtility.readFile(file);
	        assertEquals(dataSet2.length, actual.length);
	        for (int i = 0; i < dataSet2.length; i++) {
	            assertArrayEquals(dataSet2[i], actual[i], 0.001);
	        }
	        System.out.println("PROGRAMMER : NIKITTA JOAN");
	}

	@Test
	void testWriteToFile() throws FileNotFoundException {
		double[][] data = {{2.0, 4.0, 6.0}, 
							{8.0, 5.0}, 
							{61.0, 10.0, 12.0, 9.0}};

        File outputFile = new File("testFile.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        assertTrue(outputFile.exists());
        assertFalse(outputFile.isDirectory());

        Scanner scanner = new Scanner(outputFile);
        assertEquals("2.0 4.0 6.0 ", scanner.nextLine());
        assertEquals("8.0 5.0 ", scanner.nextLine());
        assertEquals("61.0 10.0 12.0 9.0 ", scanner.nextLine());
        assertFalse(scanner.hasNextLine());
        scanner.close();
	}

	@Test
	void testGetTotal() {
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(65.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
		assertEquals(71.3,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
		assertEquals(-3.3,TwoDimRaggedArrayUtility.getTotal(dataSet4),.001);
	}

	@Test
	void testGetAverage() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		assertEquals(5.417,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
		assertEquals(5.942,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
		assertEquals(-0.3,TwoDimRaggedArrayUtility.getAverage(dataSet4),.001);
	}

	@Test
	void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		assertEquals(22.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
		assertEquals(28.5,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
		assertEquals(-1.7,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,0),.001);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,1),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,1),.001);
		assertEquals(7.5,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,3),.001);
		assertEquals(-8.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,0),.001);
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,1),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet2,0),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInRow(dataSet3,3),.001);
		assertEquals(6.1,TwoDimRaggedArrayUtility.getHighestInRow(dataSet4,0),.001);
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3,3));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet4,0));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(4.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,1),.001);
		assertEquals(2.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet2,0),.001);
		assertEquals(2.7,TwoDimRaggedArrayUtility.getLowestInRow(dataSet3,3),.001);
		assertEquals(-5.3,TwoDimRaggedArrayUtility.getLowestInRow(dataSet4,0),.001);
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,1));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2,0));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet3,3));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet4,0));
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,1),.001);
		assertEquals(6.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2,1),.001);
		assertEquals(4.8,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet3,3),.001);
		assertEquals(2.3,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet4,0),.001);
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,1));
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2,1));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet3,3));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet4,0));
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2,1),.001);
		assertEquals(2.7,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3,3),.001);
		assertEquals(-4.4,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4,0),.001);
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2,1));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3,3));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4,0));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInArray(dataSet4),.001);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet2),.001);
		assertEquals(1.7,TwoDimRaggedArrayUtility.getLowestInArray(dataSet3),.001);
		assertEquals(-7.5,TwoDimRaggedArrayUtility.getLowestInArray(dataSet4),.001);
	}

}
