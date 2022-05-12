package br.com.lojaintegrada.cart.unit;

import br.com.lojaintegrada.cart.dto.CartDTO;
import br.com.lojaintegrada.cart.repository.CartRepository;
import br.com.lojaintegrada.cart.repository.ProductRepository;
import br.com.lojaintegrada.cart.service.CalculatorService;
import br.com.lojaintegrada.cart.service.CartService;
import br.com.lojaintegrada.cart.service.CouponService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static br.com.lojaintegrada.cart.TestUtils.createCartExample;
import static org.easymock.EasyMock.createMock;

@SpringBootTest
public class CartServiceTest {

    private static CartService cartService;
    private static CartDTO cartExample;


    @BeforeAll
    static void setUp(){
        CartRepository cartRepository = createMock(CartRepository.class);
        ProductRepository productRepository = createMock(ProductRepository.class);
        CalculatorService calculatorService = createMock(CalculatorService.class);
        CouponService couponService = createMock(CouponService.class);
        cartService = new CartService(cartRepository, productRepository, calculatorService, couponService);
        cartExample = createCartExample();
    }

    @Test
    void retorna_um_carrinho_com_todos_os_produtos(){
        //
    }
}
