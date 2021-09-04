package manager;

import domain.Book;
import domain.NotFoundException;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {

    @Test
    public void removeByIdTest() {
        ProductManager pm = new ProductManager(new ProductRepository());
        pm.add(new Book(1, "", 1, "", 1, 1));
        pm.add(new Book(2, "", 1, "", 1, 1));
        pm.add(new Book(3, "", 1, "", 1, 1));

        assertEquals(3, pm.getRepolength());
        pm.removeById(2);
        assertEquals(2, pm.getRepolength());
        pm.removeById(3);
        assertEquals(1, pm.getRepolength());
    }

    @Test
    public void notFoundExcTest() {
        ProductManager pm = new ProductManager(new ProductRepository());
        assertThrows(NotFoundException.class, () -> {
            pm.removeById(-10);
        });


    }

}
