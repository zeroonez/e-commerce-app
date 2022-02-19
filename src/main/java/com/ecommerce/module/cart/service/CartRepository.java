package com.ecommerce.module.cart.service;

import com.ecommerce.module.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface CartRepository extends JpaRepository<Cart, UUID> {
}
