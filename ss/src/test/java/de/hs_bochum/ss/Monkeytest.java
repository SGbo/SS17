package de.hs_bochum.ss;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hs_bochum.ss.algorithms.ThousandMonkeyAlgorithm;
import de.hs_bochum.ss.model.GridModel;

public class Monkeytest {
	
	private GridModel sudoku = new GridModel();

	
	@Before
	public void setUp() throws Exception {

		
		sudoku.setFieldValueLocked((byte) 2, 1, 0);
		sudoku.setFieldValueLocked((byte) 4, 2, 0);
		sudoku.setFieldValueLocked((byte) 1, 5, 0);
		sudoku.setFieldValueLocked((byte) 5, 7, 0);
		sudoku.setFieldValueLocked((byte) 7, 8, 0);
		
		sudoku.setFieldValueLocked((byte) 7, 4, 1);
		sudoku.setFieldValueLocked((byte) 4, 5, 1);
		
		sudoku.setFieldValueLocked((byte) 8, 0, 2);
		sudoku.setFieldValueLocked((byte) 2, 5, 2);
		sudoku.setFieldValueLocked((byte) 9, 8, 2);
		
		sudoku.setFieldValueLocked((byte) 1, 6, 3);
		sudoku.setFieldValueLocked((byte) 5, 8, 3);
		
		sudoku.setFieldValueLocked((byte) 4, 1, 4);
		sudoku.setFieldValueLocked((byte) 6, 7, 4);
		
		sudoku.setFieldValueLocked((byte) 7, 0, 5);
		sudoku.setFieldValueLocked((byte) 5, 2, 5);
		
		sudoku.setFieldValueLocked((byte) 6, 0, 6);
		sudoku.setFieldValueLocked((byte) 1, 3, 6);
		sudoku.setFieldValueLocked((byte) 2, 8, 6);
		
		sudoku.setFieldValueLocked((byte) 9, 3, 7);
		sudoku.setFieldValueLocked((byte) 5, 4, 7);
		
		sudoku.setFieldValueLocked((byte) 9, 0, 8);
		sudoku.setFieldValueLocked((byte) 1, 1, 8);
		sudoku.setFieldValueLocked((byte) 7, 3, 8);
		sudoku.setFieldValueLocked((byte) 5, 6, 8);
		sudoku.setFieldValueLocked((byte) 3, 7, 8);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSolveFieldIntInt(){
		try {
			new ThousandMonkeyAlgorithm().solve(sudoku);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
