package br.com.lojaintegrada.cart.model;

public class ProductInterface {

    String id;
    Integer quantity;

    public ProductInterface(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public ProductInterface() {
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
