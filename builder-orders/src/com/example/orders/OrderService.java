package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        // Order o = new Order(id, email, discount);
        Order o = new Order.Builder(id, email)
                .discountPercent(discount)
                .build();
        // if (lines != null) for (OrderLine l : lines) o.addLine(l);
        // o.setExpedited(expedited);
        // o.setNotes(notes);
        // o.expedited(expedited);
        // o.notes(notes);
        return o;
    }
}
