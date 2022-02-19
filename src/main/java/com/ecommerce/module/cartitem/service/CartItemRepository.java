package com.ecommerce.module.cartitem.service;

import com.ecommerce.module.cartitem.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface CartItemRepository  extends JpaRepository<CartItem, UUID> {

	Optional<CartItem> findByCartIdAndItemId(UUID cartId, UUID itemId);
}
