public class BermudaMain {
	
		public static void main(String[] args) {
		
		SpielFeld feld = new SpielFeld();
		
		for (int y=0; y<feld.getY(); y++) {
			for (int x=0; x<feld.getX(); x++) {
				System.out.print(" " + feld.getFeld(x, y));
			}
			System.out.println();
		}
		
	}	

}