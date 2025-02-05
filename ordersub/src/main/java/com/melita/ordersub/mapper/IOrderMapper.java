package com.melita.ordersub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.melita.ordersub.domain.dto.OrderDto;
import com.melita.ordersub.model.Order;

@Mapper
public interface IOrderMapper {

  IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);
/* 
  @Mapping(source = "customer", target = "customer")
  @Mapping(source = "installAddress", target = "installAddr")
  @Mapping(source = "productList", target = "productList")
  @Mapping(source = "productList.name", target = "product.name")
  @Mapping(source = "productList.packageName", target = "productList.name")
  @Mapping(source = "preferredDate", target = "preferredDate")
  @Mapping(source = "timeSlotStart", target = "timeSlotStart")
  @Mapping(source = "timeSlotEnd", target = "timeSlotEnd")
  Order toOrderEntity(OrderDto orderDto);

  @Mapping(target = "customer", source = "customer")
  @Mapping(target = "installAddress", source = "installAddr")
  @Mapping(target = "productList", source = "productList")
  @Mapping(target = "productList.name", source = "productList.product.name")
  @Mapping(target = "productList.packageName", source = "productList.name")
  @Mapping(target = "preferredDate", source = "preferredDate")
  @Mapping(target = "timeSlotStart", source = "timeSlotStart")
  @Mapping(target = "timeSlotEnd", source = "timeSlotEnd")
  OrderDto toOrderDto(Order order);
*/
}
