
public class Cat extends Mammal {
		private int numberOfLifes;

		public Cat(String latinName, int gestationTime, int numberOfLifes) {
			super(latinName, gestationTime);  
			this.numberOfLifes = numberOfLifes; 
		}
		
		public int getNumberOfLifes() {
			return this.numberOfLifes;
		}
		
		public void setNumberOfLifes(int i) {
			this.numberOfLifes = i;
		}
		
		@Override
		public String getInfo() {
			String info = "The cat with the latin name \""+ latinName+ "\" nurses for " + gestationTime +" months and has " + getNumberOfLifes() +" lives." + "\n";
			return info;

}
		
}