package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Яблоки", 156);
    Product product2 = new Product(2, "Груши", 305);
    Product product3 = new Product(3, "Виноград", 500);
    Product product4 = new Product(4, "Бананы", 120);

    @Test
    public void СheckingSuccessDeletingExistingElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.findAll();

    }

    @Test
    public void DeletingNonExistentElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }
}
