import java.util.ArrayList;

public class TestBikeStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	ArrayList<Bike> myBikes = new ArrayList<Bike>();
	myBikes.add(new Bike("Purple", 2000, 20));
	myBikes.add(new Bike("Black", 2300, 25));
	myBikes.add(new Bike("White", 2500, 15));
	myBikes.add(new Bike("Pink", 2700, 28));
	myBikes.add(new Bike("Yellow", 2000, 20));
	myBikes.add(new Bike("Green", 2600, 15));
	myBikes.add(new Bike("Red", 2300, 10));
	myBikes.add(new Bike("Brown", 2200, 27));
	myBikes.add(new Bike("Beige", 2000, 20));
	myBikes.add(new Bike("Grey", 2500, 22));
		
		for(Bike bike: myBikes) {
			System.out.println(myBikes);
		}
	}
}