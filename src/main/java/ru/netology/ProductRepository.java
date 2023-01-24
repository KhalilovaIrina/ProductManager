package ru.netology;

public class ProductRepository {
    private Product[] items = new Product[0];

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product product : findAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void save(Product product) {
        int tmpId = product.getId();
        if (product == findById(tmpId)) {
            throw new AlreadyExistsException(
                    "Объект с данным ID уже добавлен: " + tmpId
            );
        }
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;
        items = tmp;
    }

    public void removeById(int id) {
        Product need = findById(id);
        if (need == null) {
            throw new NotFoundExeption("Объект с данным ID не найден: " + id);
        } else {
            Product[] tmp = new Product[items.length - 1];
            int copyToIndex = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            items = tmp;
        }
    }

}
