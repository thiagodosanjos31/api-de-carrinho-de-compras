package br.com.lojaintegrada.cart.dto;

import br.com.lojaintegrada.cart.model.Cart;
import br.com.lojaintegrada.cart.model.Coupon;
import br.com.lojaintegrada.cart.model.Product;
import br.com.lojaintegrada.cart.service.exceptions.ObjectNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDTO {

    private String id;
    private List<Product> productList = new ArrayList<>();
    private BigDecimal total;
    private BigDecimal subTotal;
    private Coupon coupon;

    public CartDTO(Cart cart) {
        try{
            this.id = cart.getId();
            if(Objects.nonNull(cart.getProductList()))
                this.productList.addAll(cart.getProductList());
            this.total = cart.getTotal();
            this.subTotal = cart.getSubTotal();
            this.coupon = cart.getCoupon();
        }catch (NullPointerException e){
            throw new ObjectNotFoundException("Objeto nao encontrado. ID: " + id + ", Tipo: " + Cart.class.getName());
        }
    }

    public String getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
