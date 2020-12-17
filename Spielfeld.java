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
		
		// Schiffobjekte anlegen und im Array abspeichern
		for (int i=0; i<MAXSCHIFF; i++) {
			schiff[i] = new Schiff();
		}
				
	}
	
	public char get(int x, int y){
		return feld[x][y];
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
}