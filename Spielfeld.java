package wilemer.arnold.java;

class Spielfeld {
	
	final int X = 9;
	final int Y = 7;
	private char feld[][] = new char[X][];
	
	Spielfeld() {
		for (int x=0; x<X; x++) {
			feld[x] = new char[Y];
			for (int y=0; y<Y; y++) {
				feld[x][y] = '+';
			}
		}
	}
	
	public char get(int x, int y){
		return feld[x][y];
	}

}