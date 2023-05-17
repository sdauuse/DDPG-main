package com.hmall.order.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer num;
    private Integer paymentType;
    private Integer addressId;
    private Long itemId;
}
