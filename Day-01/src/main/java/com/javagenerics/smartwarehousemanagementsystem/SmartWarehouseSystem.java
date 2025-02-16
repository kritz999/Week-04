package com.javagenerics.smartwarehousemanagementsystem;

import java.util.ArrayList;
import java.util.List;


    // Abstract class representing a Warehouse Item
    abstract class WarehouseItem {
        private String name;

        public WarehouseItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + ": " + name;
        }
    }

    // Specific types of warehouse items
    class Electronics extends WarehouseItem {
        public Electronics(String name) {
            super(name);
        }
    }

    class Groceries extends WarehouseItem {
        public Groceries(String name) {
            super(name);
        }
    }

    class Furniture extends WarehouseItem {
        public Furniture(String name) {
            super(name);
        }
    }

    // Generic Storage class to store items of a specific type
    class Storage<T extends WarehouseItem> {
        private List<T> items;

        public Storage() {
            this.items = new ArrayList<>();
        }

        public void addItem(T item) {
            items.add(item);
        }

        public T retrieveItem(int index) {
            if (index >= 0 && index < items.size()) {
                return items.remove(index);
            }
            return null;
        }

        public List<T> getItems() {
            return items;
        }

        public void displayItems() {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    // Utility class with a wildcard method to display all warehouse items
    class WarehouseUtility {
        public static void displayAllItems(List<? extends WarehouseItem> items) {
            for (WarehouseItem item : items) {
                System.out.println(item);
            }
        }
    }


    public class SmartWarehouseSystem {
        public static void main(String[] args) {
            // Storage for different categories
            Storage<Electronics> electronicsStorage = new Storage<>();
            Storage<Groceries> groceriesStorage = new Storage<>();
            Storage<Furniture> furnitureStorage = new Storage<>();

            // Adding items
            electronicsStorage.addItem(new Electronics("Laptop"));
            electronicsStorage.addItem(new Electronics("Smartphone"));

            groceriesStorage.addItem(new Groceries("Rice"));
            groceriesStorage.addItem(new Groceries("Milk"));

            furnitureStorage.addItem(new Furniture("Chair"));
            furnitureStorage.addItem(new Furniture("Table"));

            // Display individual storage
            System.out.println("Electronics Storage:");
            electronicsStorage.displayItems();

            System.out.println("\nGroceries Storage:");
            groceriesStorage.displayItems();

            System.out.println("\nFurniture Storage:");
            furnitureStorage.displayItems();


            System.out.println("\nDisplaying all items using wildcard method:");
            WarehouseUtility.displayAllItems(electronicsStorage.getItems());
            WarehouseUtility.displayAllItems(groceriesStorage.getItems());
            WarehouseUtility.displayAllItems(furnitureStorage.getItems());
        }
    }






