
public abstract class Animal {
		protected String latinName;
		private String friendlyName = "noname";

		public Animal(String latinName) {
			this.latinName = latinName; 
		}
	
		public abstract String getInfo();
		public void setFriendlyName(String name){
			this.latinName = latinName;
		}
		
		public String getFriendlyName(){
			return this.friendlyName;
		}

	}