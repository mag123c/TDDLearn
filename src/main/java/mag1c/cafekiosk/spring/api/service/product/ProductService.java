package mag1c.cafekiosk.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import mag1c.cafekiosk.spring.api.controller.product.dto.request.ProductCreateRequest;
import mag1c.cafekiosk.spring.api.service.product.request.ProductCreateServiceRequest;
import mag1c.cafekiosk.spring.api.service.product.response.ProductResponse;
import mag1c.cafekiosk.spring.domain.product.Product;
import mag1c.cafekiosk.spring.domain.product.ProductRepository;
import mag1c.cafekiosk.spring.domain.product.ProductSellingStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);
    }

    public List<ProductResponse> getSellingProducts(){
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    private String createNextProductNumber() {
        String latestProductNumber = productRepository.findLatestProductNumber();
        if (latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d", nextProductNumberInt);
    }
}
