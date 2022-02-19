package com.ecommerce.module.item.controller;

import com.ecommerce.module.item.controller.dto.ItemResponse;
import com.ecommerce.module.item.controller.dto.mapper.ItemResponseMapper;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemService;
import com.ecommerce.module.item.service.command.CreateItemCommand;
import com.ecommerce.module.item.service.command.DecreaseItemStockCommand;
import com.ecommerce.module.item.service.command.IncreaseItemStockCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;
	private final ItemResponseMapper itemResponseMapper;

	public ItemController(ItemService itemService, ItemResponseMapper itemResponseMapper) {
		this.itemService = itemService;
		this.itemResponseMapper = itemResponseMapper;
	}

	@PostMapping
	public ItemResponse createItem(@RequestBody CreateItemCommand command) {
		return itemResponseMapper.mapSingle(itemService.createItem(command));
	}

	@PostMapping("/{itemId}/decreaseStock")
	public ItemResponse decreaseStock(
			@PathVariable UUID itemId,
			@RequestBody DecreaseItemStockCommand command
	) throws ItemNotFoundException {
		command.setItemId(itemId);
		return itemResponseMapper.mapSingle(itemService.decreaseItemStock(command));
	}

	@PostMapping("/{itemId}/increaseStock")
	public ItemResponse increaseStock(
			@PathVariable UUID itemId,
			@RequestBody IncreaseItemStockCommand command
	) throws ItemNotFoundException {
		command.setItemId(itemId);
		return itemResponseMapper.mapSingle(itemService.increaseItemStock(command));
	}
}
