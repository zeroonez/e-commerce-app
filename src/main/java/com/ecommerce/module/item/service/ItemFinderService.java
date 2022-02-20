package com.ecommerce.module.item.service;

import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemFinderService {

	private final ItemRepository itemRepository;

	public ItemFinderService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Item getById(UUID id) throws ItemNotFoundException {
		return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
	}

	public Set<Item> getAllByIds(Set<UUID> itemIds) {
		return new HashSet<>(itemRepository.findAllById(itemIds));
	}

	public Set<Item> getAll() {
		return new HashSet<>(itemRepository.findAll());
	}

}
