
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusStudentTest {
	private double[][] dataSet1 = {{1,2,3},
									{4,5},
									{6,7,8}};
	
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
	void testCalculateHolidayBonus() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(3000.0, result[0], .001);
			assertEquals(4000.0, result[1], .001);
			assertEquals(15000.0, result[2], .001);
			
			double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet3);
			assertEquals(14000.0, result1[0], .001);
			assertEquals(1000.0, result1[1], .001);
			assertEquals(4000.0, result1[2], .001);
			assertEquals(13000.0, result1[3], .001);
			
			double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet4);
			assertEquals(9000.0, result2[0], .001);
			assertEquals(6000.0, result2[1], .001);
			assertEquals(6000.0, result2[2], .001);
			assertEquals(10000.0, result2[3], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
			System.out.println("PROGRAMMER : NIKITTA JOAN");
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3), .001);
		assertEquals(31000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet4), .001);
	}

}
