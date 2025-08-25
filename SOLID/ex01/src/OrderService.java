public class OrderService {
    TaxService tax = new TaxService();
    EmailClient email = new EmailClient();

    void checkout(String customerEmail, double subtotal) {
        double total = tax.totalWithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}