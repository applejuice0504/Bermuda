import java.util.Random;

public class SpielFeld {
	
	private final int X = 9;
	private final int Y = 7;
	private final int MAXSCHIFF = 4;
	
	private Schiff schiff[] = new Schiff[MAXSCHIFF];
	private char feld[][] = new char[X][];
	
	SpielFeld() {
		
		// Leeres Spielfeld anlegen und mit + als Wasser belegen
		for (int x=0; x<X; x++) {
			feld[x] = new char[Y];
			for (int y=0; y<Y; y++) {
				feld[x][y] = '+';
			}
		}
		
		// Schiffobjekte anlegen und im Array abspeichern - zunächst leer
		for (int i=0; i<MAXSCHIFF; i++) {
			schiff[i] = new Schiff();
		}
		
		//Schiff zufällig verteilen
		Random zufall = new Random();

		for (int i = 0; i<MAXSCHIFF; i++) {
			//zufällige Koordinaten erzeugen
			int x = Math.abs(zufall.nextInt()) % X;
			int y = Math.abs(zufall.nextInt()) % Y;
			
			//prüfen ob das vorige Schiff die gleichen Koordinaten hat, wenn ja dann neu generieren
			while (i>0 && schiff[i-1].isPos(x,y)) {
				x = Math.abs(zufall.nextInt()) % X;
				y = Math.abs(zufall.nextInt()) % Y;
			}
			
			//Koordinaten setzen
			schiff[i].setX(x);
			schiff[i].setY(y);
		}		
	}
	
	public char getFeld(int x, int y){
		return feld[x][y];
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
}