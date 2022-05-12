package br.com.lojaintegrada.cart.repository;

import br.com.lojaintegrada.cart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    MongoTemplate mongoTemplate;

    @Autowired
    public CartRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public Cart createCart() {
        return mongoTemplate.insert(new Cart());
    }

    public Cart getCart(String id){
        return mongoTemplate.findById(id, Cart.class);
    }

    public Cart updateCart(Cart cart) {
        return mongoTemplate.save(cart);
    }
}
