package com.srini.onlineshoping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.srini.onlineshoping.exception.ProductNotFoundException;
import com.srini.shopingbackend.dao.CategoryDAO;
import com.srini.shopingbackend.dao.ProductDAO;
import com.srini.shopingbackend.dto.Category;
import com.srini.shopingbackend.dto.Product;

@Controller

public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = {"/","home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","home");
		
		logger.info("inside PageController index method - INFO");
		logger.debug("inside Pagecontroller index method - DEBUG ");
		
		
		// passing list of categories
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	
	
	@RequestMapping(value ="/about")
	public ModelAndView about()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}
	
	
	@RequestMapping(value ="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","contact us");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	/*
	 * methods to load all products based on the category
	 */
	@RequestMapping(value ="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","All products");
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	
	
	@RequestMapping(value ="/show/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
		ModelAndView mv= new ModelAndView("page");
		
		//categoryDAO  to fetch a single category
		Category category=null;
		
		category= categoryDAO.get(id);
		mv.addObject("title",category.getName());
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value ="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		//---------------
		
		
		
		
		mv.addObject("title",product.getName()); 
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
	
}