package com.ecommerce.module.item.service;

import com.ecommerce.module.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository  extends JpaRepository<Item, UUID> {
}
