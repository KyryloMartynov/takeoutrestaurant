package project.entity;

public class OrderHasDish {
    private Order fkOrder;
    private Dish fkDish;

    public Order getFkOrder() {
        return fkOrder;
    }

    public void setFkOrder(Order fkOrder) {
        this.fkOrder = fkOrder;
    }

    public Dish getFkDish() {
        return fkDish;
    }

    public void setFkDish(Dish fkDish) {
        this.fkDish = fkDish;
    }
}
