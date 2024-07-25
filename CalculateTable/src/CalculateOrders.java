import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class CalculateOrders {

  List<Order> orders = Arrays.asList(
      new Order(1000, 2000, 12, 100.51),
      new Order(1000, 2001, 31, 200),
      new Order(1000, 2002, 22, 150.86),
      new Order(1000, 2003, 41, 250),
      new Order(1000, 2004, 55, 244),
      new Order(1001, 2001, 88, 44.531),
      new Order(1001, 2002, 121, 88.11),
      new Order(1001, 2004, 74, 211),
      new Order(1001, 2002, 14, 88.11),
      new Order(1002, 2003, 2, 12.1),
      new Order(1002, 2004, 3, 22.3),
      new Order(1002, 2003, 8, 12.1),
      new Order(1002, 2002, 16, 94),
      new Order(1002, 2005, 9, 44.1),
      new Order(1002, 2006, 19, 90)
  );


  public double totalPriceSum(){
    double total = orders.stream()
        .mapToDouble(order -> order.getUnitPrice() * order.getQuantity())
        .sum();
    System.out.println("Toplam Tutar: " +total+ " Tl");

    return total;
  }

  public double avaregePrice() {
    double total = totalPriceSum();
    double average = total / orders.size();
    System.out.println("Ortalama Fiyat: " + average + " Tl");
    return average;
  }

  public void averagePricePerProduct() {
    Map<Integer, Double> totalPriceMap = new HashMap<>();
    Map<Integer, Integer> quantityMap = new HashMap<>();

    for (Order order : orders) {
      int itemId = order.getItemId();
      double unitPrice = order.getUnitPrice();
      int quantity = order.getQuantity();

      totalPriceMap.put(itemId, totalPriceMap.getOrDefault(itemId, 0.0) + unitPrice * quantity);
      quantityMap.put(itemId, quantityMap.getOrDefault(itemId, 0) + quantity);
    }

    for (Integer itemId : totalPriceMap.keySet()) {
      double totalPrice = totalPriceMap.get(itemId);
      int totalQuantity = quantityMap.get(itemId);
      double averagePrice = totalPrice / totalQuantity;
      System.out.println("Mal Numarası " + itemId + ", Ortalama Fiyat: " + averagePrice);
    }
  }

  public void itemOrders() {
    Map<Integer, Map<Integer, Integer>> itemOrdersMap = new HashMap<>();

    for (Order order : orders) {
      int itemId = order.getItemId();
      int orderId = order.getOrderId();
      int quantity = order.getQuantity();

      itemOrdersMap
          .computeIfAbsent(itemId, k -> new HashMap<>())
          .put(orderId, itemOrdersMap.get(itemId).getOrDefault(orderId, 0) + quantity);
    }

    for (Map.Entry<Integer, Map<Integer, Integer>> entry : itemOrdersMap.entrySet()) {
      int itemId = entry.getKey();
      System.out.println("Mal Id " + itemId + ":");
      for (Map.Entry<Integer, Integer> orderEntry : entry.getValue().entrySet()) {
        int orderId = orderEntry.getKey();
        int quantity = orderEntry.getValue();
        System.out.println("  Sipariş Numarası " + orderId + ", Adet: " + quantity);
      }
    }
  }

}



