package br.com.lojaintegrada.cart.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "cart")
@Data
public class Cart {

    @Id
    private String id;
    private List<Product> productList;
    private BigDecimal subTotal;
    private BigDecimal total;
    private Coupon coupon;

    public Cart() {
        subTotal = new BigDecimal("0.00");
        total = new BigDecimal("0.00");
    }

    public String getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void includeProduct(Product product){
        if (Objects.isNull(productList))
            this.productList = new ArrayList<>();

        this.productList.add(product);
    }

    public boolean hasNotProduct(){
        return Objects.isNull(this.productList) || this.productList.isEmpty();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void setQuantityByProduct(Integer quantity, Integer productId){
        this.productList.forEach(p -> {
            if(p.getId().equals(productId)){
                p.setQuantity(quantity);
            }
        });
    }
}
