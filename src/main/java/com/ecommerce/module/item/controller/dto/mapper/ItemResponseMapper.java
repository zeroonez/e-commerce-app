package com.ecommerce.module.item.controller.dto.mapper;

import com.ecommerce.module.item.controller.dto.ItemResponse;
import com.ecommerce.module.item.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemResponseMapper {

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
