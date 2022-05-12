package br.com.lojaintegrada.cart.service;

import br.com.lojaintegrada.cart.model.Cart;
import br.com.lojaintegrada.cart.model.Coupon;
import br.com.lojaintegrada.cart.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class CalculatorService {

    public Cart calculateTotals(Cart cart){
        BigDecimal subTotalValue = calculateSubTotal(cart.getProductList());
        cart.setSubTotal(subTotalValue);
        cart.setTotal(calculateTotal(subTotalValue, cart.getCoupon()));
        return cart;
    }

    private BigDecimal calculateSubTotal(List<Product> productList){
        BigDecimal subTotalValue = new BigDecimal("0.00");
        for (Product product : productList) {
            subTotalValue = subTotalValue.add(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
        }
        return subTotalValue;
    }

    private BigDecimal calculateTotal(BigDecimal subTotal, Coupon coupon){
        return Objects.isNull(coupon) ? subTotal : subTotal.subtract(coupon.getDiscount());
    }
}
