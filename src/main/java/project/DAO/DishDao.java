package project.DAO;

import project.entity.Category;
import project.entity.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    private static final String SQL_ADD_DISH =
            "INSERT INTO `dish`(name,portion,price,fk_category,id) values(?,?,?,?,?)";
    private static final String FIND_BY_ID = "Select * from dish where id=?";
    private static final String FIND_ALL = "Select * from dish";
    private static final String DELETE =
            "delete from dish where id =?";


    public boolean insert(Dish dish) {
        boolean res = false;
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement(SQL_ADD_DISH,
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            stmp.setString(1, dish.getName());
            stmp.setString(2, dish.getPortion());
            stmp.setDouble(3, dish.getPrice());
            stmp.setLong(4, dish.getCategory().getId());
            stmp.setLong(5,dish.getId());
            if (stmp.executeUpdate() > 0) {
                res = true;
                con.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            res = false;
        }

        return res;
    }

    public Dish findById(Long id) {
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement(FIND_BY_ID);
        ) {
            stmp.setLong(1, id);
            ResultSet rs = stmp.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return null;
    }

    public List<Dish> findAll() {
        List<Dish> temp = new ArrayList<>();
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement(FIND_ALL);
        ) {
            ResultSet rs = stmp.executeQuery();
            while (rs.next()) {
                temp.add(mapRow(rs));
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return temp;
    }

    public boolean deleteById(Long id) {
        boolean res = false;
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement(DELETE,
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            stmp.setLong(1, id);
            if (stmp.executeUpdate() > 0) {
                res = true;
                con.commit();
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            res = false;
        }
        return res;
    }

    public Category findCategoryById(Long id) {
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmp = con.prepareStatement("Select * from category where id=?")
        ) {
            stmp.setLong(1, id);
            ResultSet rs = stmp.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setId(id);
                category.setName(rs.getString("name"));
                return category;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return null;
    }

    public Dish mapRow(ResultSet rs) {
        try {
            Dish dish = new Dish();
            dish.setId(rs.getLong("id"));
            dish.setName(rs.getString("name"));
            dish.setPortion(rs.getString("portion"));
            dish.setPrice(rs.getDouble("price"));
            dish.setCategory(findCategoryById(rs.getLong("fk_category")));
            return dish;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
