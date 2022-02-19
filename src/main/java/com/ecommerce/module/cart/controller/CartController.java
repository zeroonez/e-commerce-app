package com.ecommerce.module.cart.controller;

import com.ecommerce.module.cart.controller.dto.CartResponse;
import com.ecommerce.module.cart.controller.dto.mapper.CartResponseMapper;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import com.ecommerce.module.cart.service.CartService;
import com.ecommerce.module.cart.service.command.AddItemToCartCommand;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

	private final CartService cartService;
	private final CartResponseMapper cartResponseMapper;

	public CartController(CartService cartService, CartResponseMapper cartResponseMapper) {
		this.cartService = cartService;
		this.cartResponseMapper = cartResponseMapper;
	}

	@PostMapping
	public CartResponse createCart() throws ItemNotFoundException {
		return cartResponseMapper.mapSingle(cartService.createCart());
	}

	@PostMapping("/{cartId}/addItem")
	public CartResponse addItemToCart(
			@PathVariable UUID cartId,
			@RequestBody AddItemToCartCommand command
	) throws CartNotFoundException, ItemNotFoundException {
		command.setCartId(cartId);
		return cartResponseMapper.mapSingle(cartService.addItemToCart(command));
	}
}
