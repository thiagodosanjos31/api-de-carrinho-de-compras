package br.com.lojaintegrada.cart.model;

public class CouponInterface {
    String id;
    Integer quantity;
    String name;

    public CouponInterface(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CouponInterface() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
