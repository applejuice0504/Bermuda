import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BermudaMain extends JFrame implements MouseListener {
	
	SpielFeld feld = null;
	final int DISTANZ = 16;
	Insets in;
	boolean spielEnde = false;
	String statusStr = "Spiel beginnt!!!";
	
	public static void main(String[] args) {
		BermudaMain fenster = new BermudaMain();
	}
	
	public BermudaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		feld = new SpielFeld();
		setTitle("Bermuda");
		setSize( (feld.getX()+2)*DISTANZ, (feld.getY()+2)*DISTANZ );
		setVisible(true);
	}
	
	@Override 
	public void paint(Graphics g) {
		in = getInsets();
		g.clearRect(in.left, in.top, getSize().width, getSize().height);
		String str;
		
		for (int i = 0; i < feld.getX(); i++) {
			for (int j = 0; j < feld.getY(); j++) {
				str = String.valueOf(feld.getFeld(i,j));
				g.drawString(str, in.left+(i+1) * DISTANZ, in.top+(j+1) * DISTANZ);
			}
		}
		
		g.drawString(statusStr, in.left, in.top + (feld.getY() + 1) * DISTANZ);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if (!spielEnde) {
			int suchX = (me.getX() - in.left - DISTANZ/2) / DISTANZ;
			int suchY = (me.getY() - in.top - DISTANZ/2) / DISTANZ;
			if (suchX>=0 && suchY>=0 && suchX<feld.getX() && suchY<feld.getY()) {
				char c = feld.suche(suchX,suchY);
				if (c==feld.getSCHIFF()) {
					if (feld.alleGefunden()) {
						spielEnde = true;
						statusStr = "GEWONNEN. Mausklick = Neues Spiel";
					}
				}	
			} 
		} else {
			// wenn spielEnde = true ist aber nochmal geklickt wurde für ein neues Spiel
			spielEnde = false;
			statusStr = "Spiel beginnt!!!";
			feld = new SpielFeld();
		}
		repaint();
		
	}
	public void mouseReleased(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseEntered(MouseEvent me) {}	
	public void mouseExited(MouseEvent me) {}

}