package br.com.lojaintegrada.cart.resource;

import br.com.lojaintegrada.cart.dto.CartDTO;
import br.com.lojaintegrada.cart.model.Coupon;
import br.com.lojaintegrada.cart.model.CouponInterface;
import br.com.lojaintegrada.cart.model.ProductInterface;
import br.com.lojaintegrada.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = {"/create"})
    public ResponseEntity<CartDTO> createCart(){
        CartDTO cartDTO = cartService.createCart();
        return ResponseEntity.ok().body(cartDTO);
    }

    @GetMapping(value = {"/{cartId}"})
    public ResponseEntity<CartDTO> getCart(@PathVariable String cartId){
        CartDTO cartDTO = cartService.getCart(cartId);
        return ResponseEntity.ok().body(cartDTO);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartDTO> addProduct(@PathVariable String cartId, @RequestBody ProductInterface product){
        CartDTO cartDTO = cartService.addProduct(cartId, product);
        return ResponseEntity.ok().body(cartDTO);
    }

    @PutMapping("/{cartId}/coupon")
    public ResponseEntity<CartDTO> addCoupon(@PathVariable String cartId, @RequestBody CouponInterface coupon){
        CartDTO cartDTO = cartService.addCoupon(cartId, coupon);
        return ResponseEntity.ok().body(cartDTO);
    }

    @DeleteMapping("/{cartId}/{productId}")
    public ResponseEntity<CartDTO> removeProduct(@PathVariable String cartId, @PathVariable Integer productId){
        CartDTO cartDTO = cartService.removeProduct(cartId, productId);
        return ResponseEntity.ok().body(cartDTO);
    }

    @PatchMapping("/{cartId}/{productId}/{quantity}")
    public ResponseEntity<CartDTO> updateProduct(@PathVariable String cartId, @PathVariable Integer productId, @PathVariable Integer quantity){
        CartDTO cartDTO = cartService.updateQuantity(cartId, productId, quantity);
        return ResponseEntity.ok().body(cartDTO);
    }

}
