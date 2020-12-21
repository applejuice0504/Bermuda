public class Schiff {
	
	private int x=0, y=0;
	private boolean istGefunden=false;
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Prüft ob sich das Schiff an den Input Koordinaten befindet
	public boolean isPos(int x, int y) {
		if (this.x == x && this.y == y) 
			return true;
		else {
			return false;
		} 
	}
	
	//setzt istGefunden auf wahr
	public void aufdecken() {
		this.istGefunden = true;
	}
	
	public boolean istGefunden() {
		return this.istGefunden;
	}
	
}