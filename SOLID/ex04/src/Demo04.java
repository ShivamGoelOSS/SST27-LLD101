
public class Demo04 {
    public static void main(String[] args) {
        System.out.println(new PaymentService().pay(new Payment(Provider.UPI, 499)));
    }
}
