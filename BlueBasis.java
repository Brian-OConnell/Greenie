public class Blue extends PictureColor { 
	double percentTotalBlue = 0.0;
	int valueTotalBlue = 0;
	public Blue(int xdim, int ydim, int mainScale) {
		super(xdim, ydim, mainScale);
	}
	
	public double calculateBluePercentage(PictureColor importPicCol) {
		
		int[][] redList = importPicCol.RedListGet();
		int[][] blueList = importPicCol.BlueListGet();
		int[][] greenList = importPicCol.GreenListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				if(blueList[widthIndex][heightIndex] > greenList[widthIndex][heightIndex] && blueList[widthIndex][heightIndex] > redList[widthIndex][heightIndex]) {
					percentTotalBlue++;
				}
				
			}
		}
		percentTotalBlue = (percentTotalBlue/(blueList.length  * blueList[0].length)) * 100;
		return percentTotalBlue;
	}
	public int calculateTotalValue(PictureColor importPicCol) {
		int[][] blueList = importPicCol.BlueListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				valueTotalBlue += blueList[widthIndex][heightIndex];
		}
	}
		return valueTotalBlue;
	}
	@Override
	public String toString() {
		return "Percentage of image that is blue: " + percentTotalBlue + "%. \n Total blue value: " + valueTotalBlue;
	}
}
