/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.srp.service;

import com.learn.srp.entity.Shop;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author DeNiSa
 */
public interface ShopService {

    public Shop create(Shop shop);

    public Shop delete(int id) throws Exception;

    public List<Shop> findAll();

    public Page<Shop> findAllPageable(Pageable pageRequest);

    public Shop update(Shop shop) throws Exception;

    public Shop findById(int id);

    public Shop findByName(String name);

    public Shop findByNameAndId(String name, Integer id);

    public Page<Shop> findAll(int page, int size);

    public Page<Shop> findByNameLike(String name, int page, int size);

}
