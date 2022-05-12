package br.com.lojaintegrada.cart.repository;

import br.com.lojaintegrada.cart.model.Coupon;
import br.com.lojaintegrada.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class CouponRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public CouponRepository(@Qualifier("restTemplateProduct") RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Coupon getCouponById(String id){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("run.mocky.io")
                .path("/v3/")
                .pathSegment(id)
                .build();

        return restTemplate.getForEntity(uriComponents.toUriString(), Coupon.class).getBody();
    }
}
