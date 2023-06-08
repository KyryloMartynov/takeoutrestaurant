package project.entity;

public class DishHasIngridient {
    private Dish fkDish;
    private Ingridient fkIngridient;

    public Dish getFkDish() {
        return fkDish;
    }

    public void setFkDish(Dish fkDish) {
        this.fkDish = fkDish;
    }

    public Ingridient getFkIngridient() {
        return fkIngridient;
    }

    public void setFkIngridient(Ingridient fkIngridient) {
        this.fkIngridient = fkIngridient;
    }
}
