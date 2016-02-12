
public class Human {
	
	private Dog dog;
	private String name; 
		
		public Human(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name; 
		}
		
		public void buyDog(Dog dog) {
			this.dog = dog;
		}
		
		public String getInfo() {
			if (dog != null) {
				return name + " äger en hund som heter " + dog.getName();
			} else {
				return "äger ingen en hund";
			}	
		}
	}
