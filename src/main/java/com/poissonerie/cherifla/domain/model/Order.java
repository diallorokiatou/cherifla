package com.poissonerie.cherifla.domain.model;

public record Order(Product product, Client client, int quantity, DeliveryStatus deliveryStatus, String paymentCode, String note) {
    public Order(OrderBuilder builder) {
        this(builder.product, builder.client, builder.quantity, builder.deliveryStatus, builder.paymentCode, builder.note);
    }

    public static final class OrderBuilder {
        private Product product;
        private Client client;
        private int quantity;
        private DeliveryStatus deliveryStatus;
        private String paymentCode;
        private String note;

        private OrderBuilder() {
        }

        public OrderBuilder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderBuilder withClient(Client client) {
            this.client = client;
            return this;
        }

        public OrderBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderBuilder withDeliveryStatus(DeliveryStatus deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }

        public OrderBuilder withPaymentCode(String paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        public OrderBuilder withNote(String note) {
            this.note = note;
            return this;
        }

        public Order build() {
            return new Order(product, client, quantity, deliveryStatus, paymentCode, note);
        }
    }

}
