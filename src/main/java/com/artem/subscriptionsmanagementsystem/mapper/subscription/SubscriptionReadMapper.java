package com.artem.subscriptionsmanagementsystem.mapper.subscription;

import com.artem.subscriptionsmanagementsystem.database.entity.Subscription;
import com.artem.subscriptionsmanagementsystem.dto.order.OrderReadDto;
import com.artem.subscriptionsmanagementsystem.dto.subscription.SubscriptionReadDto;
import com.artem.subscriptionsmanagementsystem.mapper.Mapper;
import com.artem.subscriptionsmanagementsystem.mapper.item.ItemReadMapper;
import com.artem.subscriptionsmanagementsystem.mapper.order.OrderReadMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionReadMapper implements Mapper<Subscription, SubscriptionReadDto> {

    private final ItemReadMapper itemReadMapper;
    private final OrderReadMapper orderReadMapper;

    @Override
    public SubscriptionReadDto map(Subscription object) {
        List<OrderReadDto> orders = object.getOrders().stream()
            .map(orderReadMapper::map)
            .toList();

        return new SubscriptionReadDto(
            object.getId(),
            itemReadMapper.map(object.getItem()),
            orders
        );
    }
}
