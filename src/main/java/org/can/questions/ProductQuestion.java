package org.can.questions;

import org.can.pojo.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductQuestion {

    public static void calculateTotalPrice(List<Order> orderList) {
        double totalPrice = 0;
        for (Order order : orderList) {
            totalPrice += order.getQuantity() * order.getUnitPrice();
        }
        String formattedTotalCost = String.format("%.3f", totalPrice);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("1.a) Malların toplam tutarı: " + formattedTotalCost);
    }


    public static void averagePrice(List<Order> orderList) {
        double totalPrice = 0;
        int totalQuantity = 0;
        for (Order order : orderList) {
            totalPrice += order.getUnitPrice() * order.getQuantity();
            totalQuantity += order.getQuantity();
        }
        double average = totalPrice / totalQuantity;
        String formattedAverage = String.format("%.3f", average);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("1.b) Malların ortalama fiyatı: " + formattedAverage);


    }

    public static void averagePriceOfProduct(List<Order> orderList) {
        Map<Integer, double[]> productTotalsMap = new HashMap<>();

        for (Order order : orderList) {
            productTotalsMap.computeIfAbsent(order.getProductId(), k -> new double[2]);
            double[] totals = productTotalsMap.get(order.getProductId());
            totals[0] += order.getUnitPrice() * order.getQuantity(); // toplam maliyet
            totals[1] += order.getQuantity(); // toplam miktar
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("1.c) Mal bazlı ortalama fiyatlar:");

        // Ortalama fiyatı hesaplayıp yazdırıyoruz
        productTotalsMap.forEach((productId, totals) -> {
            double totalCost = totals[0];
            double totalQuantity = totals[1];
            double averagePrice = totalCost / totalQuantity;
            String formattedAveragePrice = String.format("%.3f", averagePrice);
            System.out.println("Mal bazlı ortalama fiyat -> " + productId + ": " + formattedAveragePrice);
        });
//        Map<Integer, List<Double>> productPriceMap = new HashMap<>();
//        for (Order order : orderList) {
//            if (productPriceMap.containsKey(order.getProductId())) {
//                List<Double> certainProductPriceList = productPriceMap.get(order.getProductId());
//                certainProductPriceList.add(order.getUnitPrice());
//            } else {
//                List<Double> certainProductPriceList = new ArrayList<>();
//                certainProductPriceList.add(order.getUnitPrice());
//                productPriceMap.put(order.getProductId(), certainProductPriceList);
//            }
//        }
//        System.out.println("-------------------------------------------------------------------------------------------------------------");
//        System.out.println("1.c) Mal bazlı ortalama fiyatlar:");
//        productPriceMap.forEach((productId, list) -> {
//            double totalPrice = 0;
//            for (Double unitPrice : list) {
//                totalPrice += unitPrice;
//            }
//
//            double averagePrice = totalPrice / list.size();
//            String formattedAveragePrice = String.format("%.3f", averagePrice);
//
//            System.out.println("Mal bazlı ortalama fiyat -> " + productId + ": " + formattedAveragePrice);
//        });
    }

    public static void quantityOfProduct(List<Order> orderList) {
        Map<Integer, Map<Integer, Integer>> productOrderMap = new HashMap<>();

        for (Order order : orderList) {
            int productId = order.getProductId();
            int orderId = order.getOrderId();
            int quantity = order.getQuantity();
            if (!productOrderMap.containsKey(productId)) {
                productOrderMap.put(productId, new HashMap<>());
            }

            Map<Integer, Integer> orderMap = productOrderMap.get(productId);

            if (orderMap.containsKey(orderId)) {
                orderMap.put(orderId, orderMap.get(orderId) + quantity);
            } else {
                orderMap.put(orderId, quantity);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("1.d) Mal bazlı miktarlar:");
        productOrderMap.forEach((productId, orderMap) -> {
            System.out.println("Mal " + productId + ":");
            orderMap.forEach((orderId, quantity) -> {
                System.out.println("  Sipariş " + orderId + ": " + quantity + " adet");
            });
        });

    }


}
