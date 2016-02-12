import java.util.Arrays;

public class Bike {
	private String color;
	private int price;
	private int size;
	
	public Bike (String color, int price){
		this.color = color;
		this.price = price;
	}
	
	public Bike (String color, int size, int price){
		if (Arrays.asList(Constants.COLORS).contains(color)){
		this.color = color;
		}else{
			this.color = "unpainted";
		}
	
	if (size < Constants.MIN_SIZE) {
		this.size = Constants.MIN_SIZE;
	} else if (size > Constants.MAX_SIZE) {
		this.size = Constants.MAX_SIZE; 
		} else { this.size = size; }


if (price < Constants.MIN_PRICE) {
	this.price = Constants.MIN_PRICE; }
	else if (price > Constants.MAX_PRICE) {
	this.price = Constants.MAX_PRICE; }
	else { this.price = price;

	}

	}
public String getColor() {
	return this.color;
}

public int getPrice() {
	return this.price;
}

public int getSize(){
	return this.size;
}

public static void add(Bike bike) {
	// TODO Auto-generated method stub
	
}

}