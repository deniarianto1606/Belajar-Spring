/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.srp.repositories;

import com.learn.srp.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DeNiSa
 */
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    public Shop findByName(String name);
    
    public Shop findByNameAndId(String name, Integer id);
    
    public Page<Shop> findByNameLike(String name, Pageable pageable);
}
