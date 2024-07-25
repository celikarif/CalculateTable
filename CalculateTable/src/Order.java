public class Order {

  private int orderId;
  private int itemId;
  private int quantity;
  private double unitPrice;


  public Order(int orderId, int itemId, int quantity, double unitPrice) {
    this.orderId = orderId;
    this.itemId = itemId;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }


}
