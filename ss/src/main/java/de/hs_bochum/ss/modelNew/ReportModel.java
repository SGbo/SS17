package de.hs_bochum.ss.modelNew;

public class ReportModel {
	private int diffCount;
	private int writeCount;
	private int invalidCount;
	
	public int getDiffCount() {
		return diffCount;
	}
	
	public void increaseDiffCount() {
		diffCount++;
	}
	
	public int getWriteCount() {
		return writeCount;
	}
	
	public void increaseWriteCount() {
		writeCount++;
	}
	
	public int getInvalidCount() {
		return invalidCount;
	}
	
	public void increaseInvalidCount() {
		invalidCount++;
	}
}
