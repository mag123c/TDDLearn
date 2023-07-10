package mag1c.cafekiosk.spring.api.controller.order;

import lombok.RequiredArgsConstructor;
import mag1c.cafekiosk.spring.api.ApiResponse;
import mag1c.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import mag1c.cafekiosk.spring.api.service.order.OrderService;
import mag1c.cafekiosk.spring.api.service.order.response.OrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/api/v1/orders/new")
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody OrderCreateRequest request) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        return ApiResponse.ok(orderService.createOrder(request.toServiceRequest(), registeredDateTime));
    }

}
