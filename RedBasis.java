public class Red extends PictureColor { 
	double percentTotalRed = 0.0;
	int valueTotalRed = 0;
	public Red(int xdim, int ydim, int mainScale) {
		super(xdim, ydim, mainScale);
	}
	
	public double calculateRedPercentage(PictureColor importPicCol) {
		
		int[][] redList = importPicCol.RedListGet();
		int[][] blueList = importPicCol.BlueListGet();
		int[][] greenList = importPicCol.GreenListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				if(redList[widthIndex][heightIndex] > greenList[widthIndex][heightIndex] && redList[widthIndex][heightIndex] > blueList[widthIndex][heightIndex]) {
					percentTotalRed++;
				}
				
			}
		}
		percentTotalRed = (percentTotalRed/(redList.length  * redList[0].length)) * 100;
		return percentTotalRed;
	}
	public int calculateTotalValue(PictureColor importPicCol) {
		int[][] redList = importPicCol.RedListGet();
		for(int widthIndex = 0; widthIndex < super.RedListGet().length; widthIndex++) {
			for(int heightIndex = 0; heightIndex < super.RedListGet()[widthIndex].length; heightIndex++) {
				valueTotalRed += redList[widthIndex][heightIndex];
		}
	}
		return valueTotalRed;
	}
	@Override
	public String toString() {
		return "Percentage of image that is red: " + percentTotalRed + "%. \n Total red value: " + valueTotalRed;
	}
}
