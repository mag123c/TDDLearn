package mag1c.cafekiosk.spring.api.controller.product.dto.request;

import lombok.Getter;
import mag1c.cafekiosk.spring.domain.product.ProductSellingStatus;
import mag1c.cafekiosk.spring.domain.product.ProductType;

@Getter
public class ProductCreateRequest {

    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

}
