package Extras;
import java.util.*;

    public class ShoppingCart {
        private Map<String, Double> productPrices = new HashMap<>(); // Stores product prices
        private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // Maintains order
        private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // Sorts by price

        // Add a product to the cart
        public void addProduct(String product, double price, int quantity) {
            productPrices.put(product, price);
            cart.put(product, cart.getOrDefault(product, 0) + quantity);

            // Update price-based sorting
            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        // Remove a product from the cart
        public void removeProduct(String product) {
            if (cart.containsKey(product)) {
                double price = productPrices.get(product);
                cart.remove(product);
                productPrices.remove(product);
                sortedByPrice.get(price).remove(product);
                if (sortedByPrice.get(price).isEmpty()) {
                    sortedByPrice.remove(price);
                }
            }
        }

        // Get cart items in order of addition
        public Map<String, Integer> getCartOrder() {
            return cart;
        }

        // Get products sorted by price
        public Map<Double, List<String>> getProductsSortedByPrice() {
            return sortedByPrice;
        }

        // Calculate total price of items in the cart
        public double getTotalPrice() {
            double total = 0.0;
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                total += productPrices.get(entry.getKey()) * entry.getValue();
            }
            return total;
        }

        public static void main(String[] args) {
            ShoppingCart cart = new ShoppingCart();

            // Adding products
            cart.addProduct("Laptop", 1000.0, 1);
            cart.addProduct("Mouse", 25.0, 2);
            cart.addProduct("Keyboard", 50.0, 1);
            cart.addProduct("Monitor", 300.0, 1);

            // Display Cart
            System.out.println("Cart in order of addition: " + cart.getCartOrder());
            System.out.println("Products sorted by price: " + cart.getProductsSortedByPrice());
            System.out.println("Total Price: $" + cart.getTotalPrice());

            // Removing an item
            cart.removeProduct("Mouse");
            System.out.println("\nAfter removing Mouse:");
            System.out.println("Cart in order of addition: " + cart.getCartOrder());
            System.out.println("Products sorted by price: " + cart.getProductsSortedByPrice());
            System.out.println("Total Price: $" + cart.getTotalPrice());
        }
    }


