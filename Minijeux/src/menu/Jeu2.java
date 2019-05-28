package menu;



import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
  
public class Jeu2 extends JButton implements MouseListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
private String name;
  private Image img;

  public Jeu2(String str){
    super(str);
    this.name = str;
    try {
      img = ImageIO.read(new File("resources/bspectre.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  this.addMouseListener(this); //bouton devient sensivle � la souris
  }
//modification de l'aspect du bouton
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
    g2d.setPaint(gp);
    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    g2d.setColor(Color.white);
    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 /4), (this.getHeight() / 2) + 5);
  }
//fin
  
//Action du bouton  

  //M�thode appel�e lors du clic de souris
  public void mouseClicked(MouseEvent event) { 
  }

  //M�thode appel�e lors du survol de la souris
  public void mouseEntered(MouseEvent event) { 
	 
	    }
	      
     
  	
  //M�thode appel�e lorsque la souris sort de la zone du bouton
  public void mouseExited(MouseEvent event) { }

  //M�thode appel�e lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) {try {
      img = ImageIO.read(new File("resources/aspectre.png"));
      String options[] = {"Scores", "Menu", "Nouvelle partie"};
      Menu.fen.dispose();
      memory.Jeu.main(options);
      
    } catch (IOException e) {
      e.printStackTrace();
      
    }  
	}

  //M�thode appel�e lorsque l'on rel�che le clic de souris
  public void mouseReleased(MouseEvent event) {
      }       
}