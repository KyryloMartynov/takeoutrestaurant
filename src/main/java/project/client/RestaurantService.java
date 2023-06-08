package project.client;

import project.entity.Dish;
import project.entity.Order;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RestaurantService {
    @WebMethod
    void insertOrder(Order order);

    @WebMethod
    Order selectOrderById(Long id);

    @WebMethod
    Order[] selectOrdersByStatus(String status);

    @WebMethod
    boolean changeStatus(Long id, String status);

    @WebMethod
    Order[] selectByClient(Long id);

    @WebMethod
    void insertDishInOrder(Long dishId,Long orderId);

    @WebMethod
    Dish[] selectDishesInOrder(Long id);

    @WebMethod
    boolean deleteDishInOrder(Long dishId,Long orderId);

    @WebMethod
    Dish[] selectDishes();

    @WebMethod
    Dish selectDishById(Long id);

    @WebMethod
    void insertDish(Dish dish);


    @WebMethod
    boolean deleteDish(Long dishId);
}
