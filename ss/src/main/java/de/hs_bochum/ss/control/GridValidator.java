package de.hs_bochum.ss.control;

import java.util.HashSet;
import java.util.Set;

import de.hs_bochum.ss.exception.CoordinateOutOfBoundsException;
import de.hs_bochum.ss.modelNew.GridCell;
import de.hs_bochum.ss.modelNew.GridModel;

public class GridValidator {

	private GridModel model;

	public GridValidator(GridModel model) {
		this.model = model;
	}

	public boolean isValid() {
		return checkColumns() && checkRows() && checkSquares();
	}

	public boolean isValid(int x, int y) {
		return checkColumn(x / 3) && checkRow(y / 3) && checkSquare(x / 3, y / 3);
	}
	
	public boolean isValueValid(int x, int y, int value) throws CoordinateOutOfBoundsException {
		// check columns
		for (int xx = 0; xx < 9; xx++) {
			if ((xx != x) && (model.getCellValue(xx, y) == value)) {
				return false;
			}
		}

		// check rows
		for (int yy = 0; yy < 9; yy++) {
			if ((yy != y) && (model.getCellValue(x, yy) == value)) {
				return false;
			}
		}

		// check square
		int x1 = (x / 3) * 3;
		int y1 = (y / 3) * 3;
		for (int xx = x1; xx < x1 + 3; xx++) {
			for (int yy = y1; yy < y1 + 3; yy++) {
				if ((xx != x || yy != y) && (model.getCellValue(xx, yy) == value)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean checkSquares() {
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				if (checkSquare(x, y) == false) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean checkSquare(int x, int y) {
		Set<Integer> valueSet = new HashSet<Integer>();

		GridCell square[][] = model.getSquare(x, y);
		for (int ix = 0; ix < 2; ix++) {
			for (int iy = 0; iy < 2; iy++) {
				if (valueSet.contains(square[ix][iy].getValue())) {
					return false;
				} else {
					valueSet.add(square[ix][iy].getValue());
				}
			}
		}

		return true;
	}

	private boolean checkRows() {
		for (int y = 0; y < 9; y++) {
			if (checkRow(y) == false) {
				return false;
			}
		}

		return true;
	}

	public boolean checkRow(int y) {
		Set<Integer> valueSet = new HashSet<Integer>();

		GridCell row[] = model.getRow(y);
		for (int x = 0; x < 9; x++) {
			if (valueSet.contains(row[x].getValue())) {
				return false;
			} else {
				valueSet.add(row[x].getValue());
			}
		}

		return true;
	}

	private boolean checkColumns() {
		for (int x = 0; x < 9; x++) {
			if (checkColumn(x) == false) {
				return false;
			}
		}
		
		return true;
	}

	public boolean checkColumn(int x) {
		Set<Integer> valueSet = new HashSet<Integer>();

		GridCell col[] = model.getColumn(x);
		for (int y = 0; y < 9; y++) {
			if (valueSet.contains(col[y].getValue())) {
				return false;
			} else {
				valueSet.add(col[y].getValue());
			}
		}

		return true;
	}

}
