public class Demo03 {
    public static void main(String[] args) {
        System.out.println(new ShippingCostCalculator().cost(new Shipment(ShipmentType.EXPRESS, 2.0)));
    }
}
