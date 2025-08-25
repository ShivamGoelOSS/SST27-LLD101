public class OrderController {
    void create(String id, OrderRepository repo) {
        // OrderRepository repo = new SqlOrderRepository(); // hard dependency
        repo.save(id);
        System.out.println("Created order: " + id);
    }
}