package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		Beverage coffee = new Cappuccino();
		System.out.println("Plain Cappuccino: " + coffee.cost());
		Beverage withMilk = new Milk(coffee);
		System.out.println("Cappuccino + Milk: " + withMilk.cost());
		Beverage withMilkSugar = new Sugar(withMilk);
		System.out.println("Cappuccino + Milk + Sugar: " + withMilkSugar.cost());
		
		

	}

}