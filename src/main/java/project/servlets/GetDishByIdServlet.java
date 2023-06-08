package project.servlets;

import project.Path;
import project.client.RestaurantClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getById")
public class GetDishByIdServlet extends HttpServlet {
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
        Long id = new Long(request.getParameter("id"));
        request.setAttribute("dish", RestaurantClient.server.selectDishById(id));
        RequestDispatcher disp = request.getRequestDispatcher(Path.DISH);
        disp.forward(request, response);
    }
}
