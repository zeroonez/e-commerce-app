package com.ecommerce.module.item.controller.dto.mapper;

import com.ecommerce.module.item.controller.dto.ItemResponse;
import com.ecommerce.module.item.entity.Item;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ItemResponseMapper {

	public Set<ItemResponse> mapList(Set<Item> items) {
		return items.stream().map(this::mapSingle).collect(Collectors.toSet());
	}

	public ItemResponse mapSingle(Item item) {
		return new ItemResponse(
				item.getId(),
				item.getName(),
				item.getDescription(),
				item.getPrice(),
				item.getStock()
		);
	}

}
