package mag1c.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {

    @DisplayName("")
    @Test
    void test(){
        //given
        ProductType givenType1 = ProductType.BAKERY;
        ProductType givenType2 = ProductType.BAKERY;

        //when
        boolean result1 = ProductType.containsStockType(givenType1);
        boolean result2 = ProductType.containsStockType(givenType2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();

    }

}