
public class TestCat {

	public static void main(String[] args) {
		System.out.println("Detta är ett test för Cat");
		System.out.println("**Start Test");
		Cat c = new Cat();
		Cat a = new Cat("Brown", "Missen");
		System.out.println("One cat: "+ c.getName()+" and one: "+ a.getName());
	}

}
