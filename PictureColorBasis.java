public class PictureColor  {
	int[][] allRedPixelValues;
	int[][] allGreenPixelValues;
	int[][] allBluePixelValues;
	int dimensionx;
	int dimensiony;
	int scale;
	public PictureColor(int xdim, int ydim, int mainScale){
		 dimensionx = xdim;
		 dimensiony = ydim;
		 scale = mainScale;
		allRedPixelValues = new int[(dimensionx / mainScale) + 1][(dimensiony / mainScale) + 1];
		allGreenPixelValues = new int[(dimensionx / mainScale) + 1][(dimensiony / mainScale) + 1];
		allBluePixelValues = new int[(dimensionx / mainScale) + 1][(dimensiony / mainScale) + 1];
	}

	public void RedListAdd(int dimx, int dimy, int redValue) {
		allRedPixelValues[dimx][dimy] = redValue;
	}
	
	public void BlueListAdd(int dimx, int dimy, int blueValue) {
		allBluePixelValues[dimx][dimy] = blueValue;
	}
	
	public void GreenListAdd(int dimx, int dimy, int greenValue) {
		allGreenPixelValues[dimx][dimy] = greenValue;
	}
	
	public int[][] RedListGet() {
		 return allRedPixelValues;
	}
	
	public int[][] BlueListGet() {
		return allBluePixelValues;
	}
	
	public int[][] GreenListGet() {
		return allGreenPixelValues;
	}
	
	public int dimensionXGet(){
		return dimensionx;
	}
	
	public int dimensionYGet(){
		return dimensiony;
	}
	
	public int scaleGet() {
		return scale;
	}
	
	public String toString() {
		return "Color Values: " + allRedPixelValues + ", " + allGreenPixelValues + ", " + allBluePixelValues;
	}
}
