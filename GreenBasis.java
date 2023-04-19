public class Green extends PictureColor { 
	double percentTotalGreen = 0.0;
	int valueTotalGreen = 0;
	public Green(int xdim, int ydim, int mainScale) {
		super(xdim, ydim, mainScale);
	}
	
	public double calculateGreenPercentage(PictureColor importPicCol) {
		
		int[][] redList = importPicCol.RedListGet();
		int[][] blueList = importPicCol.BlueListGet();
		int[][] greenList = importPicCol.GreenListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				if(greenList[widthIndex][heightIndex] > redList[widthIndex][heightIndex] && greenList[widthIndex][heightIndex] > blueList[widthIndex][heightIndex]) {
					percentTotalGreen++;
				}
				
			}
		}
		percentTotalGreen = (percentTotalGreen/(greenList.length  * greenList[0].length)) * 100;
		return percentTotalGreen;
	}
	public int calculateTotalValue(PictureColor importPicCol) {
		int[][] greenList = importPicCol.GreenListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				valueTotalGreen += greenList[widthIndex][heightIndex];
		}
	}
		return valueTotalGreen;
	}
	
	public int yMaxGreen(PictureColor importPicCol) {
		int[][] greenList = importPicCol.GreenListGet();
		int[][] redList = importPicCol.RedListGet();
		int[][] blueList = importPicCol.BlueListGet();
		int MaxYGreen = importPicCol.dimensionYGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				if(MaxYGreen > heightIndex && greenList[widthIndex][heightIndex] > redList[widthIndex][heightIndex] && greenList[widthIndex][heightIndex] > blueList[widthIndex][heightIndex]) {
					MaxYGreen = heightIndex * importPicCol.scaleGet();
				}
			}
		}
		return MaxYGreen;
	}
	
	@Override
	public String toString() {
		return "Percentage of image that is green: " + percentTotalGreen + "%. \n Total green value: " + percentTotalGreen;
	}
}
