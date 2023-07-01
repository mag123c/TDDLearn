package mag1c.cafekiosk.spring.domain.stock;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mag1c.cafekiosk.spring.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumbers;

    private int quantity;

    @Builder
    public Stock(String productNumbers, int quantity) {
        this.productNumbers = productNumbers;
        this.quantity = quantity;
    }

    public static Stock create(String productNumber, int quantity) {
        return Stock.builder()
                .productNumbers(productNumber)
                .quantity(quantity)
                .build();
    }
}
