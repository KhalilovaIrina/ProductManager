package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTests {
    Product book1 = new Book(1, "Dune", 500, "Frank Herbert");
    Product phone1 = new Smartphone(2, "Iphone 10", 40_000, "Apple");

    @Test
    public void shouldFindAllEmpty() {
        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllOne() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);

        Product[] expected = {book1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllSome() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(phone1);


        Product[] expected = {book1, phone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(phone1);
        repo.removeById(book1.getId());

        Product[] expected = {phone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdBecomeEmpty() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.removeById(book1.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
