package beverages_decorator;

public abstract class BeverageDecorator extends Beverage{
	public final Beverage beverage;
	public BeverageDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
	public abstract int cost();
}
