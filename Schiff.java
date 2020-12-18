public class Schiff {
	
	private int x, y;
	private boolean istGefunden;
	
	public boolean istGefunden() {
		return this.istGefunden;
	}
	
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
	
	public boolean isPos(int x, int y) {
		if (this.x == x && this.y == y) 
			return true;
		else {
			return false;
		} 
	}
	
}