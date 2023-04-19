import java.awt.AWTException;
import java.awt.Robot;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException, AWTException  {
      // Test Images:
	  // https://www.newshub.co.nz/home/lifestyle/2019/11/dog-years-are-a-myth-2-year-old-dogs-already-middle-aged-scientists/_jcr_content/par/video/image.dynimg.1280.q75.jpg/v1574572358818/GETTY-labrador-puppy-1120.jpg (1280 x 731)
	  // https://cdn.theculturetrip.com/wp-content/uploads/2018/10/norway-has-some-impressive-mountains--benjamin-zocholl-den-norske-turistforening-dnt.jpg (960 x 640)
	  
	  // Creates Robot
	   Robot Hal = new Robot();
	   
       // Creates Scanner and asks for user URL input and image dimensions
	   
	   Scanner URLInput = new Scanner(System.in);
	   System.out.println("Input your image (URL)");
	   String UserURLInput = URLInput.nextLine();
	   System.out.println("Input image X-Dimension");
	   int UserDimX = URLInput.nextInt();
	   System.out.println("Input image Y-Dimension");
	   int UserDimY = URLInput.nextInt();
	   System.out.println("Input Scale (Lower Values May Lead to Extreme Wait Times. Higher Values Should Be Considered Estimates)");
	   int scale = URLInput.nextInt();
	   System.out.println("Print out all values? (boolean)");
	   boolean printAllValues = URLInput.nextBoolean();
	   
	   // Creates new PictureColor object and Primary Color Objects
	   PictureColor picCol = new PictureColor(UserDimX, UserDimY, scale);
	   Red redFunction = new Red(UserDimX, UserDimY, scale);
	   Blue blueFunction = new Blue(UserDimX, UserDimY, scale);
	   Green greenFunction = new Green(UserDimX, UserDimY, scale);
	   
       URL dogImage = new URL(UserURLInput);
       
       //Develops an image variable using the ImageIo docs
       BufferedImage bufferedImage = ImageIO.read(dogImage);

       ImageIcon imageIcon = new ImageIcon(bufferedImage);
       
       //Cool frame thing
       JFrame jFrame = new JFrame();
       jFrame.setLayout(new FlowLayout());
       jFrame.setSize(UserDimX, UserDimY);
       jFrame.setLocation(0, 0);
       JLabel jLabel = new JLabel();
       jLabel.setIcon(imageIcon);
       jFrame.add(jLabel);
       jFrame.setVisible(true);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       Hal.delay(3000);
       for(int width = 0; width < UserDimX; width += scale) {
    	   for(int height = 0; height < UserDimY; height += scale) {
    		   if(printAllValues) {
    			   System.out.println(Hal.getPixelColor(width, height).getRed() + " , " + Hal.getPixelColor(width, height).getGreen() + " , " + Hal.getPixelColor(width, height).getBlue());
    		   }
    		   picCol.RedListAdd(width / scale, height / scale, Hal.getPixelColor(width, height).getRed());
    		   picCol.GreenListAdd(width / scale, height / scale, Hal.getPixelColor(width, height).getGreen());
    		   picCol.BlueListAdd(width / scale, height / scale, Hal.getPixelColor(width, height).getBlue());
    	   }
       }
       jFrame.setVisible(false);
       Hal.delay(1500);
       
       System.out.println("\n\n\nCompiling data...");
       double redPercentage = redFunction.calculateRedPercentage(picCol);
       double greenPercentage = greenFunction.calculateGreenPercentage(picCol);
       double bluePercentage = blueFunction.calculateBluePercentage(picCol);
       double totalPercentage = redPercentage + greenPercentage + bluePercentage;
       System.out.println("Total number of pixels analyzed: " + ((UserDimX / scale) * (UserDimY / scale)));
       System.out.println("Percentage of image that is red: " + redPercentage + "%." + "\n Total value red: " + redFunction.calculateTotalValue(picCol));
       System.out.println("Percentage of image that is green: " + greenPercentage + "%." + "\n Total value green: " + greenFunction.calculateTotalValue(picCol) + "\n Max Y-Value of Green: " + greenFunction.yMaxGreen(picCol));
       System.out.println("Percentage of image that is blue: " + bluePercentage + "%." + "\n Total value blue: " + blueFunction.calculateTotalValue(picCol));
       System.out.println("Percentage of image that is white, grey, or black: " + (100-totalPercentage) + "%.");
          
  }
}
