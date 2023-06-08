package project.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.entity.Category;
import project.entity.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class DishDaoTest {

    private final DishDao dishDao = new DishDao();

    @BeforeEach
    void setUp() {
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement("delete from dish ;",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            if (stmp.executeUpdate() > 0) {
                con.commit();
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement("delete from dish ;",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            if (stmp.executeUpdate() > 0) {
                con.commit();
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    @Test
    void insert() {
        Dish dish = new Dish(1L, new Category(1L), 100., "test", "test");
        dishDao.insert(dish);
        Assertions.assertEquals(dish, dishDao.findAll().get(0));
    }

    @Test
    void findById() {
        Dish dish = new Dish(1L, new Category(1L), 100., "test", "test");
        dishDao.insert(dish);
        Assertions.assertEquals(dish, dishDao.findById(1L));
    }

    @Test
    void findByIdIfNotExists() {
        Dish dish = new Dish(1L, new Category(1L), 100., "test", "test");
        dishDao.insert(dish);
        Assertions.assertNull(dishDao.findById(2L));
    }

    @Test
    void findAll() {
        Dish dish = new Dish(1L, new Category(1L), 100., "test", "test");
        dishDao.insert(dish);
        Assertions.assertEquals(1, dishDao.findAll().size());
        Assertions.assertEquals(dish, dishDao.findAll().get(0));
    }

    @Test
    void deleteById() {
        Dish dish = new Dish(1L, new Category(1L), 100., "test", "test");
        dishDao.insert(dish);
        dishDao.deleteById(1L);
        Assertions.assertEquals(0, dishDao.findAll().size());
    }

}