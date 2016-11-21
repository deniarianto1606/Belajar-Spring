/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.srp.controller;

import com.learn.srp.entity.Shop;
import com.learn.srp.service.ShopService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author DeNiSa
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

    protected static final int DEFAULT_PAGE_NUM = 1;
    protected static final int DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String newShopPage(Model model) {
        model.addAttribute("shop", new Shop());
        return "/shop/shop_form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewShop(@ModelAttribute @Valid Shop shop,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "/shop/shop_form";
        }

        String message = "New shop " + shop.getName() + " was successfully created.";

        shopService.create(shop);
        return "redirect:/shop/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String shopListPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, Model model) {
        Page<Shop> pagePerson = shopService.findAll((page-1), DEFAULT_PAGE_SIZE);
        model.addAttribute("shopList", pagePerson);
        return "/shop/shop_list";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "id", required = true) Integer id,
            Model model) {
        Shop shop = shopService.findByNameAndId(name, id);
        model.addAttribute("shop", shop);
        return "/shop/shop_detail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editShopPage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("shop-edit");
        Shop shop = shopService.findById(id);
        mav.addObject("shop", shop);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editShop(@ModelAttribute @Valid Shop shop,
            BindingResult result,
            @PathVariable Integer id,
            final RedirectAttributes redirectAttributes) throws Exception {

        if (result.hasErrors()) {
            return new ModelAndView("shop-edit");
        }

        ModelAndView mav = new ModelAndView("redirect:/index.html");
        String message = "Shop was successfully updated.";

        shopService.update(shop);

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteShop(@PathVariable Integer id,
            final RedirectAttributes redirectAttributes) throws Exception {

        ModelAndView mav = new ModelAndView("redirect:/index.html");

        Shop shop = shopService.delete(id);
        String message = "The shop " + shop.getName() + " was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}
