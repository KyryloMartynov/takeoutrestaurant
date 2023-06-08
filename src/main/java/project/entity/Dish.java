package project.entity;

import java.util.Objects;

public class Dish {
    protected Long id;
    protected Category category;
    protected Double price;
    protected String name;
    protected String portion;

    public Dish() {
    }

    public Dish(Long id, Category category, Double price, String name, String portion) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.name = name;
        this.portion = portion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(category.getId(), dish.category.getId()) && Objects.equals(price, dish.price) && Objects.equals(name, dish.name) && Objects.equals(portion, dish.portion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, price, name, portion);
    }
}
