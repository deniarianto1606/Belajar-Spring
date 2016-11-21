/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.srp.service.impl;

import com.learn.srp.entity.Shop;
import com.learn.srp.repositories.ShopRepository;
import com.learn.srp.service.ShopService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 *
 * @author DeNiSa
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    @Transactional
    public Shop create(Shop shop) {
        Shop createdShop = shop;
        return shopRepository.save(createdShop);
    }

    @Override
    @Transactional
    public Shop findById(int id) {
        return shopRepository.findOne(id);
    }

    @Override
    @Transactional
    public Shop delete(int id) throws Exception {
        Shop deletedShop = shopRepository.findOne(id);

        if (deletedShop == null) {
            throw new Exception();
        }

        shopRepository.delete(deletedShop);
        return deletedShop;
    }

    @Override
    @Transactional
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

//    @Override
//    @Transactional
//    public Shop update(Shop shop) throws Exception {
//        Shop updatedShop = shopRepository.findOne(shop.getId());
//
//        if (updatedShop == null) {
//            throw new Exception();
//        }
//
//        updatedShop.setName(shop.getName());
//        updatedShop.setEmplNumber(shop.getEmplNumber());
//        return updatedShop;
//    }

    @Override
    @Transactional
    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

    @Override
    public Shop findByNameAndId(String name, Integer id) {
        return shopRepository.findByNameAndId(name, id);
    }

    @Override
    @Transactional
    public Page<Shop> findAllPageable(Pageable pageRequest) {
        return shopRepository.findAll(pageRequest);
    }

    @Override
    @Transactional
    public Page<Shop> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        Page<Shop> persons = shopRepository.findAll(pageable);
        return persons;
    }

    @Override
    @Transactional
    public Page<Shop> findByNameLike(String name, int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        String q = "%" + name + "%";
        Page<Shop> persons = shopRepository.findByNameLike(q, pageable);
        return persons;
    }

    @Override
    public Shop update(Shop shop) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
