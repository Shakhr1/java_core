package school.sorokin.javacore.oop.testing.model;

public record Order(int id, String productName, int quantity, double unitPrice) {
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
}
