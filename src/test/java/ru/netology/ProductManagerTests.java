package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTests {
    ProductRepository repoMock = Mockito.mock(ProductRepository.class);
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Dune", 500, "Frank Herbert");
    Product phone1 = new Smartphone(2, "Iphone 10", 40_000, "Apple");
    Product book2 = new Book(3, "Dune", 1000, "Frank Herbert");
    Product book3 = new Book(4, "Dune Messiah", 1000, "Frank Herbert");
    Product phone2 = new Smartphone(5, "Iphone 11", 60_000, "Apple");

    @Test

    public void shouldAddProduct1() {
        Product[] items = {book1};
        doReturn(items).when(repoMock).findAll();

        Product[] expected = {book1};
        Product[] actual = repoMock.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductSome() {
        Product[] items = {book1, phone1};
        doReturn(items).when(repoMock).findAll();

        Product[] expected = {book1, phone1};
        Product[] actual = repoMock.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameIfEmpty() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Dune");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByAuthorIfEmpty() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Frank Herbert");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByManufactureIfEmpty() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByNameBookIf1() {

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Dune");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByNamePhoneIf1() {

        manager.add(phone1);

        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("Iphone 10");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByAuthorIf1() {

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Frank Herbert");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByManufactureIf1() {

        manager.add(phone1);

        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByAuthorIfPart() {

        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Herbert");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindByNameIfResultNull() {

        manager.add(book1);
        manager.add(phone1);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Дюна");

        Assertions.assertArrayEquals(expected, actual);

    }

//        @Test
//        public void shouldFindByNameIfResult1 () {
//
//            manager.add(book1);
//            manager.add(phone1);
//
//            Product[] expected = {book1};
//            Product[] actual = manager.searchBy("Dune");
//
//            Assertions.assertArrayEquals(expected, actual);
//
//        }

    @Test
    public void shouldFindByNameIfResultsSome() {

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Dune");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByAuthorIfResultsSome() {

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(book3);
        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Frank Herbert");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByManufactureIfResultsSome() {

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        Product[] expected = {phone1, phone2};
        Product[] actual = manager.searchBy("Apple");

        Assertions.assertArrayEquals(expected, actual);

    }
}

