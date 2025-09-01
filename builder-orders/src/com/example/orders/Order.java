package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = new ArrayList<>(builder.lines); // defensive copy
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return Collections.unmodifiableList(lines); }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public static class Builder {
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line == null) throw new IllegalArgumentException("Order line cannot be null");
            lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents())); // defensive copy
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            // Validate required fields
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalStateException("Order ID is required");
            }
            if (customerEmail == null || !EMAIL_PATTERN.matcher(customerEmail).matches()) {
                throw new IllegalStateException("Valid customer email is required");
            }
            if (lines.isEmpty()) {
                throw new IllegalStateException("Order must have at least one line");
            }
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalStateException("Discount must be between 0 and 100");
            }
            
            return new Order(this);
        }
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
