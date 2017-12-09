package com.onehack.recommendation.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onehack.recommendation.dao.ProductDetailsRepository;
import com.onehack.recommendation.dao.ProductDetails;

/**
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductDetailsRepository productRepository;

	private Logger log = LoggerFactory.getLogger(ProductsController.class);

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllProducts() {
		log.debug("=========== Inside /products/all =========");

		JSONArray responseProdList = new JSONArray();

		Iterable<ProductDetails> itrProducts = productRepository.findAll();
		itrProducts.forEach(product -> {
			JSONObject productDetails = new JSONObject();
			productDetails.put("id", product.getId());
			productDetails.put("brand", product.getBrand());
			productDetails.put("cost", product.getCost());
			productDetails.put("image_url", product.getImageUrl());
			productDetails.put("model_number", product.getModelNumber());
			productDetails.put("name", product.getName());
			productDetails.put("phone", product.getModelNumber());
			productDetails.put("meta_info", product.getMetaInfo());
			responseProdList.put(productDetails);
		});
		return responseProdList.toString();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int addProducts(ProductDetails productDetails) {
		log.debug("=========== Inside /products/save =========");
		productRepository.save(productDetails);
		return 200;
	}
}
