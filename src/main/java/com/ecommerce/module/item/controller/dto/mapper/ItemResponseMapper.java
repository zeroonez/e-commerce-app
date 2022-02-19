package com.ecommerce.module.item.controller.dto.mapper;

import com.ecommerce.module.item.controller.dto.ItemResponse;
import com.ecommerce.module.item.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemResponseMapper {

	public ItemResponse mapSingle(Item item) {
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setId(item.getId());
		itemResponse.setName(item.getName());
		itemResponse.setDescription(item.getDescription());
		itemResponse.setPrice(item.getPrice());
		itemResponse.setStock(item.getStock());
		return itemResponse;
	}

}
