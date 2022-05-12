package br.com.lojaintegrada.cart.service;

import br.com.lojaintegrada.cart.model.Coupon;
import br.com.lojaintegrada.cart.repository.CouponRepository;
import br.com.lojaintegrada.cart.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CouponService {

    CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }

    public Coupon getCouponById(String id) {
        try{
        Coupon coupon = couponRepository.getCouponById(id);
        return coupon.getBeginDate().isBefore(LocalDateTime.now()) && coupon.getEndDate().isAfter(LocalDateTime.now()) ?
                coupon : null;
        }catch (Exception e){
            throw new ObjectNotFoundException("Cupom não está mais disponível!");
        }
    }
}
