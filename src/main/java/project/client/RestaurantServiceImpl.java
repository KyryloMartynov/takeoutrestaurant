package project.client;

import project.DAO.DishDao;
import project.entity.Dish;
import project.entity.Order;

import javax.jws.WebService;

@WebService(endpointInterface = "project.client.RestaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    private final DishDao dishDao = new DishDao();
    @Override
    public void insertOrder(Order order) {

    }

    @Override
    public Order selectOrderById(Long id) {
        return null;
    }

    @Override
    public Order[] selectOrdersByStatus(String status) {
        return new Order[0];
    }

    @Override
    public boolean changeStatus(Long id, String status) {
        return false;
    }

    @Override
    public Order[] selectByClient(Long id) {
        return new Order[0];
    }

    @Override
    public void insertDishInOrder(Long dishId, Long orderId) {

    }

    @Override
    public Dish[] selectDishesInOrder(Long id) {
        return new Dish[0];
    }

    @Override
    public boolean deleteDishInOrder(Long dishId, Long orderId) {
        return false;
    }

    @Override
    public Dish[] selectDishes() {
        return dishDao.findAll().toArray(new Dish[0]);
    }

    @Override
    public Dish selectDishById(Long id) {
        return dishDao.findById(id);
    }

    @Override
    public void insertDish(Dish dish) {
        dishDao.insert(dish);
    }

    @Override
    public boolean deleteDish(Long dishId) {
        return dishDao.deleteById(dishId);
    }
}

