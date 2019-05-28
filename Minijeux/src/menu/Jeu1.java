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
  
public class Jeu1 extends JButton implements MouseListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
private String name;
  private Image img;

  public Jeu1(String str){
    super(str);
    this.name = str;
    try {
      img = ImageIO.read(new File("resources/bbutterflies.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  this.addMouseListener(this); //bouton devient sensible à la souris
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

  //Méthodes obligatoires mais non utilisées ici
  public void mouseClicked(MouseEvent event) { }
  public void mouseEntered(MouseEvent event) { }     
  public void mouseExited(MouseEvent event) { }
  public void mouseReleased(MouseEvent event) {  }   

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) {try {
      img = ImageIO.read(new File("resources/abutterflies.png"));
      Menu.fen.dispose();
      runner.Main.main(null);
      
    } catch (IOException e) {
      e.printStackTrace();
      
    }  
	}


      
}