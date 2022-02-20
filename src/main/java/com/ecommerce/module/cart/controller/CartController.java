package com.ecommerce.module.cart.controller;

import com.ecommerce.module.cart.controller.dto.CartResponse;
import com.ecommerce.module.cart.controller.dto.mapper.CartResponseMapper;
import com.ecommerce.module.cart.exception.CartNotFoundException;
import com.ecommerce.module.cart.service.CartFinderService;
import com.ecommerce.module.cart.service.CartService;
import com.ecommerce.module.cart.service.command.AddItemToCartCommand;
import com.ecommerce.module.cart.service.command.RemoveOrReduceItemFromCartCommand;
import com.ecommerce.module.cartitem.exception.CartItemNotFoundException;
import com.ecommerce.module.item.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

	private final CartService cartService;
	private final CartFinderService cartFinderService;
	private final CartResponseMapper cartResponseMapper;

	public CartController(CartService cartService,
	                      CartFinderService cartFinderService,
	                      CartResponseMapper cartResponseMapper) {
		this.cartService = cartService;
		this.cartFinderService = cartFinderService;
		this.cartResponseMapper = cartResponseMapper;
	}

	@PostMapping
	public CartResponse createCart() throws ItemNotFoundException {
		return cartResponseMapper.mapSingle(cartService.createCart());
	}

	@GetMapping("/{cartId}")
	public CartResponse getCart(
			@PathVariable UUID cartId
	) throws CartNotFoundException, ItemNotFoundException {
		return cartResponseMapper.mapSingle(cartFinderService.getById(cartId));
	}

	@PostMapping("/{cartId}/addItem")
	public CartResponse addItemToCart(
			@PathVariable UUID cartId,
			@RequestBody AddItemToCartCommand command
	) throws CartNotFoundException, ItemNotFoundException {
		command.setCartId(cartId);
		return cartResponseMapper.mapSingle(cartService.addItemToCart(command));
	}

	@DeleteMapping("/{cartId}/removeItem")
	public CartResponse removeItemFromCart(
			@PathVariable UUID cartId,
			@RequestBody RemoveOrReduceItemFromCartCommand command
	) throws CartNotFoundException, ItemNotFoundException, CartItemNotFoundException {
		command.setCartId(cartId);
		return cartResponseMapper.mapSingle(cartService.removeItemFromCart(command));
	}

	@PostMapping("/{cartId}/reduceItem")
	public CartResponse reduceItemInCart(
			@PathVariable UUID cartId,
			@RequestBody RemoveOrReduceItemFromCartCommand command
	) throws CartNotFoundException, ItemNotFoundException, CartItemNotFoundException {
		command.setCartId(cartId);
		return cartResponseMapper.mapSingle(cartService.reduceItemFromCart(command));
	}

	@PostMapping("/{cartId}/increaseItem")
	public CartResponse increaseItemInCart(
			@PathVariable UUID cartId,
			@RequestBody RemoveOrReduceItemFromCartCommand command
	) throws CartNotFoundException, ItemNotFoundException, CartItemNotFoundException {
		command.setCartId(cartId);
		return cartResponseMapper.mapSingle(cartService.increaseItemFromCart(command));
	}

	@ExceptionHandler(CartNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String cartNotFoundExceptionHandler(CartNotFoundException e){
		return e.getMessage();
	}

	@ExceptionHandler(ItemNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String itemNotFoundExceptionHandler(ItemNotFoundException e){
		return e.getMessage();
	}

	@ExceptionHandler(CartItemNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String cartItemNotFoundExceptionHandler(CartItemNotFoundException e){
		return e.getMessage();
	}
}
