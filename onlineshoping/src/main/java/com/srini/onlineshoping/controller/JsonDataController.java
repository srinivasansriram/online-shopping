package com.srini.onlineshoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srini.shopingbackend.dao.ProductDAO;
import com.srini.shopingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/all/products")
	
	@ResponseBody
	
	public List<Product> getProductsAllProducts()
	{
		return productDAO.listActiveProducts();
	}

}
