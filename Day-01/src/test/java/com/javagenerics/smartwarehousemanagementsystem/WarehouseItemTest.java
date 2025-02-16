package com.javagenerics.smartwarehousemanagementsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class WarehouseItemTest {
    @Test
    void testAddItem() {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Electronics laptop = new Electronics("Laptop");
        electronicsStorage.addItem(laptop);

        assertEquals(1, electronicsStorage.getItems().size());
        assertEquals("Laptop", electronicsStorage.getItems().get(0).getName());
    }

    // 2. Test retrieving an item from Storage
    @Test
    void testRetrieveItem() {
        Storage<Groceries> groceriesStorage = new Storage<>();
        Groceries rice = new Groceries("Rice");
        groceriesStorage.addItem(rice);

        Groceries retrievedItem = groceriesStorage.retrieveItem(0);
        assertNotNull(retrievedItem);
        assertEquals("Rice", retrievedItem.getName());
        assertEquals(0, groceriesStorage.getItems().size());  // Ensure item was removed
    }

    // 3. Test retrieving an item with an invalid index
    @Test
    void testRetrieveInvalidIndex() {
        Storage<Furniture> furnitureStorage = new Storage<>();
        Furniture chair = new Furniture("Chair");
        furnitureStorage.addItem(chair);

        assertNull(furnitureStorage.retrieveItem(5));  // Invalid index
    }

    // 4. Test displaying all items using wildcard method
    @Test
    void testDisplayAllItems() {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone"));
        electronicsStorage.addItem(new Electronics("Tablet"));

        // Redirecting System.out to capture console output (Optional)
        assertDoesNotThrow(() -> WarehouseUtility.displayAllItems(electronicsStorage.getItems()));
    }

    // 5. Test the toString method of WarehouseItem
    @Test
    void testWarehouseItemToString() {
        Electronics smartphone = new Electronics("Smartphone");
        assertEquals("Electronics: Smartphone", smartphone.toString());

        Furniture table = new Furniture("Table");
        assertEquals("Furniture: Table", table.toString());
    }
}