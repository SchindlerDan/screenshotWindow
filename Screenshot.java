import java.awt.AWTException; 
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screenshot extends JPanel{ 
	
    public static final long serialVersionUID = 1L; 
    
    public static void main(String[] args) 
    { 
    	/*
    	 * This for-loop calls the methods for taking a screenshot and
    	 * creating a window every 3 seconds 
    	 */
    	while(true) {
    		try {
    			Thread.sleep(3000); 
        		takeScreenshot();
        		createWindow();
    		} catch (Exception e) {
    			System.out.print("Error Detected");
    		}
    	}
    } 

    /*
     * Method for taking screenshot of the current screen 
     * and saving the image as a file
     */
    private static void takeScreenshot() {
    	try { 
            Robot r = new Robot(); 
  
            // It saves screenshot to desired path 
            String path = "screenshot.jpg"; 
  
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = r.createScreenCapture(capture); 
            ImageIO.write(Image, "jpg", new File(path)); 
            System.out.println("Screenshot saved"); 
        } 
        catch (AWTException | IOException ex) { 
            System.out.println(ex); 
        }
    }


    /*
     * Method for creating a window that displays the previously
     * taken screenshot
     */
    private static void createWindow(){
	//img is the screenshot we took.
	//BufferedImage img = new BufferedImage(0,0,TYPE_INT_ARGB);
	try{    
		BufferedImage img = ImageIO.read(new File("screenshot.jpg"));
		JFrame jf = new JFrame("");
		jf.setUndecorated(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new JLabel(new ImageIcon(img)));
		jf.setVisible(true);
		jf.setExtendedState(jf.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	catch(Exception e){
		System.out.println("error finding screenshot");
		System.exit(1);
	}
	
	
//	JFrame jf = new JFrame("");
//	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	jf.add(new JLabel(new ImageIcon(img)));
//	jf.setVisible(true);
	
	
    }
}


