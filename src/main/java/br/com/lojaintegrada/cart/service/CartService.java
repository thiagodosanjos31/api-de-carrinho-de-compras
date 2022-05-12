package br.com.lojaintegrada.cart.service;

import br.com.lojaintegrada.cart.dto.CartDTO;
import br.com.lojaintegrada.cart.model.*;
import br.com.lojaintegrada.cart.repository.CartRepository;
import br.com.lojaintegrada.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    CartRepository cartRepository;
    ProductRepository productRepository;
    CalculatorService calculatorService;
    CouponService couponService;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, CalculatorService calculatorService, CouponService couponService){
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.calculatorService = calculatorService;
        this.couponService = couponService;
    }

    public CartDTO createCart(){
        return new CartDTO(cartRepository.createCart());
    }

    public CartDTO getCart(String id) {
        return new CartDTO(cartRepository.getCart(id));
    }

    public CartDTO addProduct(String cartId, ProductInterface productInterface) {
        Cart actualCart = cartRepository.getCart(cartId);
        Product product = productRepository.getProductById(productInterface.getId());
        if (actualCart.hasNotProduct()) {
            actualCart.includeProduct(firstProductCart(productInterface.getQuantity(),product));
        }else{
            Integer quantityProducts = calculateQuantityProduct(actualCart, productInterface.getQuantity(), product.getId());
            actualCart.setQuantityByProduct(quantityProducts, product.getId());
        }
        Cart cartUpdated = calculatorService.calculateTotals(actualCart);
        return new CartDTO(cartRepository.updateCart(cartUpdated));
    }

    private Product firstProductCart(Integer quantity, Product product){
        product.setQuantity(quantity);
        return product;
    }

    private Integer calculateQuantityProduct(Cart cart, Integer quantity, Integer productId){
        return cart.getProductList().stream().filter(p -> p.getId().equals(productId)).mapToInt(Product::getQuantity).sum() + quantity;

    }

    public CartDTO removeProduct(String cartId, Integer productId) {
        Cart actualCart = cartRepository.getCart(cartId);
        actualCart.getProductList().removeIf(product -> product.getId().equals(productId));
        Cart cartUpdated = calculatorService.calculateTotals(actualCart);
        return new CartDTO(cartRepository.updateCart(cartUpdated));
    }

    public CartDTO updateQuantity(String cartId, Integer productId, Integer quantity) {
        Cart actualCart = cartRepository.getCart(cartId);
        actualCart.setQuantityByProduct(quantity, productId);
        return new CartDTO(cartRepository.updateCart(actualCart));
    }

    public CartDTO addCoupon(String cartId, CouponInterface coupon) {
        Cart actualCart = cartRepository.getCart(cartId);
        actualCart.setCoupon(couponService.getCouponById(coupon.getId()));
        Cart cartUpdated = calculatorService.calculateTotals(actualCart);
        return new CartDTO(cartRepository.updateCart(cartUpdated));
    }
}
