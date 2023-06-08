package project.servlets;

import project.Path;
import project.client.RestaurantClient;
import project.entity.Category;
import project.entity.Dish;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDish")
public class AddDishServlet extends HttpServlet {
    private static final long serialVersionUID = 2423353715955164816L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        String command = request.getParameter("command");
        if ("redirect".equals(command)) {
            RequestDispatcher disp = request.getRequestDispatcher(Path.ADD_DISH);
            disp.forward(request, response);
        } else if ("add".equals(command)) {
            System.out.println("add");
            Dish dish = parseDish(request);
            RestaurantClient.server.insertDish(dish);
            response.sendRedirect("/dishes");
        }
    }

    private Dish parseDish(HttpServletRequest request) {
        Dish dish = new Dish();
        dish.setName(request.getParameter("name"));
        dish.setPortion(request.getParameter("portion"));
        dish.setPrice(new Double(request.getParameter("price")));
        dish.setCategory(new Category(new Long(request.getParameter("fk_category"))));
        return dish;
    }
}
