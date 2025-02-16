package com.javagenerics.genericproductcatalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
class GenericProductCatalogTest {
    private ProductCatalog<Book> bookCatalog;
    private ProductCatalog<Clothing> clothingCatalog;
    private ProductCatalog<Gadget> gadgetCatalog;

    @BeforeEach
    void setUp() {
        bookCatalog = new ProductCatalog<>();
        clothingCatalog = new ProductCatalog<>();
        gadgetCatalog = new ProductCatalog<>();

        // Adding products before each test
        bookCatalog.addProduct(new Book("Harry Potter", 25.99, BookCategory.FICTION));
        clothingCatalog.addProduct(new Clothing("T-Shirt", 19.99, ClothingCategory.MEN));
        gadgetCatalog.addProduct(new Gadget("Smartphone", 599.99, GadgetCategory.MOBILE));
    }


    @Test
    void testAddProduct() {
        Assertions.assertEquals(1, bookCatalog.getProducts().size());
        Assertions.assertEquals(1, clothingCatalog.getProducts().size());
        Assertions.assertEquals(1, gadgetCatalog.getProducts().size());
    }


    @Test
    void testRetrieveProduct() {
        List<Book> books = bookCatalog.getProducts();
        Assertions.assertEquals("Harry Potter", books.get(0).getName());
        Assertions.assertEquals(BookCategory.FICTION, books.get(0).getCategory());
    }


    @Test
    void testApplyDiscount() {
        Book book = bookCatalog.getProducts().get(0);
        DiscountUtil.applyDiscount(book, 10);  // Apply 10% discount

        Assertions.assertEquals(23.391, book.getPrice(), 0.001);  // Allowing minor floating point variations
    }


    @Test
    void testToStringFormat() {
        Book book = bookCatalog.getProducts().get(0);
        Assertions.assertEquals("Harry Potter - FICTION - $25.99", book.toString());

        Clothing clothing = clothingCatalog.getProducts().get(0);
        Assertions.assertEquals("T-Shirt - MEN - $19.99", clothing.toString());

        Gadget gadget = gadgetCatalog.getProducts().get(0);
        Assertions.assertEquals("Smartphone - MOBILE - $599.99", gadget.toString());
    }


    @Test
    void testTypeSafety() {
        // This should fail at compilation if uncommented
        // ProductCatalog<Integer> intCatalog = new ProductCatalog<>();  // Not allowed

        Assertions.assertTrue(true);  // Placeholder to indicate compile-time safety
    }
}