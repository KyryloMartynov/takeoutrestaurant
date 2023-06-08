package project.entity;

import java.util.Date;

public class Order {
    protected Long id;
    protected Double price;
    protected String status;
    protected Client fkClient;
    protected Dish fkDish;
    protected Date date;
    protected Date createDate;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getFkClient() {
        return fkClient;
    }

    public void setFkClient(Client fkClient) {
        this.fkClient = fkClient;
    }

    public Dish getFkDish() {
        return fkDish;
    }

    public void setFkDish(Dish fkDish) {
        this.fkDish = fkDish;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
