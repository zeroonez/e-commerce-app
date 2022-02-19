package com.ecommerce.module.item.service;

import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.command.CreateItemCommand;
import com.ecommerce.module.item.service.command.DecreaseItemStockCommand;
import com.ecommerce.module.item.service.command.IncreaseItemStockCommand;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ItemService {

	private final ItemRepository itemRepository;
	private final ItemFinderService itemFinderService;

	public ItemService(ItemRepository itemRepository, ItemFinderService itemFinderService) {
		this.itemRepository = itemRepository;
		this.itemFinderService = itemFinderService;
	}

	public Item createItem(@Valid CreateItemCommand command) {
		Item item = new Item();
		item.setName(command.getName());
		item.setDescription(command.getDescription());
		item.setPrice(command.getPrice());
		item.setStock(command.getStock());
		return itemRepository.save(item);
	}

	public Item increaseItemStock(@Valid IncreaseItemStockCommand command) throws ItemNotFoundException {
		Item item = itemFinderService.getById(command.getItemId());
		item.setStock(item.getStock() + command.getStockToAdd());
		return itemRepository.save(item);
	}

	public Item decreaseItemStock(@Valid DecreaseItemStockCommand command) throws ItemNotFoundException {
		Item item = itemFinderService.getById(command.getItemId());
		int currentStock = item.getStock() - command.getStockToRemove();
		item.setStock(Math.max(currentStock, 0));
		return itemRepository.save(item);
	}
}
