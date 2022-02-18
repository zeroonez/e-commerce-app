package com.ecommerce.module.item.service;

import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemFinderService {

	private final ItemRepository itemRepository;

	public ItemFinderService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Item getById(UUID id) throws ItemNotFoundException {
		return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
}
