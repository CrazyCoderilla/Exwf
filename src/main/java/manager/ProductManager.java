package manager;

import domain.NotFoundException;
import domain.Product;
import repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        if (repository.findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        repository.removeById(id);
    }

    public int getRepolength() {
        return repository.findAll().length;
    }

}
