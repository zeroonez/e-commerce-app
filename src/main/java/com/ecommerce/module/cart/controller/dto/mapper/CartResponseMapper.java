package com.ecommerce.module.cart.controller.dto.mapper;

import com.ecommerce.module.cart.controller.dto.CartResponse;
import com.ecommerce.module.cart.entity.Cart;
import com.ecommerce.module.cartitem.controller.dto.CartItemResponse;
import com.ecommerce.module.cartitem.controller.dto.CartItemResponseMapper;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CartResponseMapper {

	private final CartItemResponseMapper cartItemResponseMapper;

	public CartResponseMapper(CartItemResponseMapper cartItemResponseMapper) {
		this.cartItemResponseMapper = cartItemResponseMapper;
	}

	public CartResponse mapSingle(Cart cart) throws ItemNotFoundException {
		Set<CartItemResponse> cartItemResponses = cartItemResponseMapper.mapSet(cart.getCartItemIds());
		return new CartResponse(cart.getId(), cartItemResponses);
	}
}
