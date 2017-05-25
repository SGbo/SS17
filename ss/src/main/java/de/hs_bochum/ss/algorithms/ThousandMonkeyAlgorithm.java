package de.hs_bochum.ss.algorithms;

import java.util.Random;

import de.hs_bochum.ss.exception.CoordinateOutOfBoundsException;
import de.hs_bochum.ss.exception.IsLockedException;
import de.hs_bochum.ss.exception.IsOutOfRangeException;
import de.hs_bochum.ss.interfaces.ISodokuSolver;
import de.hs_bochum.ss.model.Field;

public class ThousandMonkeyAlgorithm implements ISodokuSolver{

	@Override
	public void solve(Field sudoku) throws CoordinateOutOfBoundsException, IsLockedException, IsOutOfRangeException {
		Random rand = new Random();
		do{
		for(int y = 0; y < 9; y++){
			for(int x = 0; x < 9; x++){
				if(!sudoku.isFieldLocked(x, y)){
					sudoku.setFieldValue((byte) (rand.nextInt(8)+1), x, y);
				}
			}
		}
		print(sudoku);
		}while(!sudoku.isValid());
	}

	@Override
	public void nextStep() {
		// TODO Auto-generated method stub
		
	}
	
	private void print(Field sudoku) throws CoordinateOutOfBoundsException{
		for(int y = 0; y < 9; y++){
			for(int x = 0; x < 9; x++){
				System.out.print(sudoku.getFieldValue(x, y) + " ");
			}
			System.out.println();
		}
	}

}
