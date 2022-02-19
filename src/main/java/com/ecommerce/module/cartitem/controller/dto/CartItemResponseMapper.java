package com.ecommerce.module.cartitem.controller.dto;

import com.ecommerce.module.cartitem.entity.CartItem;
import com.ecommerce.module.cartitem.service.CartItemFinderService;
import com.ecommerce.module.item.controller.dto.mapper.ItemResponseMapper;
import com.ecommerce.module.item.entity.Item;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import com.ecommerce.module.item.service.ItemFinderService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class CartItemResponseMapper {

	private final ItemFinderService itemFinderService;
	private final ItemResponseMapper itemResponseMapper;
	private final CartItemFinderService cartItemFinderService;

	public CartItemResponseMapper(ItemFinderService itemFinderService, ItemResponseMapper itemResponseMapper, CartItemFinderService cartItemFinderService) {
		this.itemFinderService = itemFinderService;
		this.itemResponseMapper = itemResponseMapper;
		this.cartItemFinderService = cartItemFinderService;
	}

	public CartItemResponse mapSingle(CartItem cartItem) throws ItemNotFoundException {
		Item item = itemFinderService.getById(cartItem.getItemId());
		return new CartItemResponse(
				cartItem.getId(),
				itemResponseMapper.mapSingle(item),
				cartItem.getQuantity()
		);
	}

	public Set<CartItemResponse> mapSet(Set<UUID> cartItemIds) throws ItemNotFoundException {
		Set<CartItem> cartItems = cartItemFinderService.getAllByIds(cartItemIds);
		Set<CartItemResponse> result = new HashSet<>();
		for (CartItem cartItem : cartItems) {
			result.add(this.mapSingle(cartItem));
		}
		return result;
	}

}
