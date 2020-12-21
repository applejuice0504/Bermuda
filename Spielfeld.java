import java.util.Random;

public class SpielFeld {
	
	private final int X = 9;
	private final int Y = 7;
	private final int MAXSCHIFF = 4;
	
	private Schiff schiff[] = new Schiff[MAXSCHIFF];
	private char feld[][] = new char[X][];
	private final char SCHIFF = 'X';
	
	SpielFeld() {
		
		// Leeres Spielfeld anlegen und mit '+' als Wasser belegen
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
		
		//Schiffe zufällig verteilen
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
			schiff[i].setPos(x,y);
		}		
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	//Gibt den Inahlt des Spielfeldes an angefragter Position zurück
	public char getFeld(int x, int y){
		return this.feld[x][y];
	}

	//Durchläuft alle Schiffe und prüft ob alle aufgedeckt wurden
	public boolean alleGefunden() {
		for (Schiff i : schiff) {
			if (!i.istGefunden())	//sobald ein Schiff noch nicht gefunden wurde, können nicht alleGefunden sein...
				return false;
		}
		return true;
	}
	
	//
	public char suche (int x, int y) {
		int index = getSchiffNr(x,y);
		if (index>0) {						//prüfen ob man nicht schon auf ein Schiff getippt hat
			feld[x][y] = SCHIFF;
			schiff[index].aufdecken();
		} else {							//ansonsten in alle Himmelsrichtungen wandern
			int anzahl = 0;
			for (int diffX = -1; diffX <=1; diffX++) {
				for (int diffY = -1; diffY <=1; diffY++) {
					if ( !(diffX == 0 && diffY==0) )	// es dürfen nicht diffX UND diffY 0 sein, ansonten bewegt sich linienLauf nicht
						anzahl += linieLaufen(x,y, diffX, diffY);
				}
			}
			feld[x][y]=(char) ('0' + anzahl);
		}	
		return feld[x][y]; 		
	}
	
	private int linieLaufen(int x, int y, int diffX, int diffY) {
		
		//Schleife solange wir im Feld sind
		while ( x>=0 && x<X && y>=0 && y<Y ) { 
			
			x += diffX;
			y += diffY;
			
			//Prüfen ob an der neuen Posotion ein Schiff ist, falls ja mit return 1 zurück 
			//ansonsten weiter wandern in der while Schleife
			if (getSchiffNr(x,y)>0)
				return 1;
		}
		return 0;
	}
	
	//Gibt zurück wenn an der abgefragten Position ein Schiff liegt
	private int getSchiffNr(int x, int y) {
		for (int i = 0; i < MAXSCHIFF; i++) {
			if (schiff[i].isPos(x,y)) {
				return i;
			}
		}
		return -1;
	}
	
}