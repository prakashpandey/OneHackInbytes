package com.onehack.recommendation.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onehack.recommendation.dao.ProductDetails;
import com.onehack.recommendation.dao.ProductDetailsRepository;
import com.onehack.recommendation.dao.ProductPurchase;
import com.onehack.recommendation.dao.ProductPurchaseRepository;
import com.onehack.recommendation.dao.RepairHistoryRepository;

/**
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */
@RestController
@RequestMapping("/recommendation")
public class PersonalizationController {

	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	@Autowired
	private ProductPurchaseRepository productPurchaseRepository;

	@Autowired
	private RepairHistoryRepository repairHistoryRepository;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getRecommendation(@RequestParam("id") Long id) {

		Iterable<ProductDetails> productDetailsItr = productDetailsRepository.findAll();
		int averageNumOfProdSold = getAverageProductSoldCount(productDetailsItr);
		int averageProductPrice = getAverageProductPrice(productDetailsItr);

		JSONArray recommendedProducts = new JSONArray();
		for (ProductDetails productDetails : productDetailsItr) {
			JSONObject recommendedProduct = new JSONObject();
			double productPurchasePoints = getProductPurchasePoints(productDetails, averageNumOfProdSold);
			double productCostPoints = getProductCostPoints(productDetails, averageProductPrice);

			/**
			 * Cal score is agile, can add more parameter to calculate
			 * recommendation. Time is short, hence restricting myself to few
			 * verticles.
			 */
			double score = calScore(productPurchasePoints, productCostPoints);
			recommendedProduct.put("score", score);
			recommendedProduct.put("id", productDetails.getId());
			recommendedProduct.put("brand", productDetails.getBrand());
			recommendedProduct.put("cost", productDetails.getCost());
			recommendedProduct.put("image_url", productDetails.getImageUrl());
			recommendedProduct.put("model_number", productDetails.getModelNumber());
			recommendedProduct.put("name", productDetails.getName());
			recommendedProduct.put("phone", productDetails.getModelNumber());
			recommendedProduct.put("meta_info", productDetails.getMetaInfo());
			recommendedProducts.put(recommendedProduct);
		}
		return recommendedProducts.toString();
	}

	private double calScore(double productPurchasePoints, double productCostPoints) {
		return (productPurchasePoints + productCostPoints) * 10;
	}

	public double getProductPurchasePoints(ProductDetails product, int averageNumOfProdSold) {
		double purchaseDeviation = product.getPurchasedCount().doubleValue()
				/ new Integer(averageNumOfProdSold).doubleValue();
		// return Math.log(purchaseDeviation);
		return purchaseDeviation;
	}

	public int getProductDurabilityPoints(ProductDetails product) {
		return 0;
	}

	/**
	 * return negative of integer. More negative the value, more suitable for
	 * recommendation.
	 * 
	 * @param product
	 * @return
	 */
	public double getProductCostPoints(ProductDetails product, int averageProductPrice) {
		double purchaseDeviation = product.getPurchasedCount().doubleValue() / new Integer(averageProductPrice);
		// return Math.log(purchaseDeviation);
		return purchaseDeviation;
	}

	/**
	 * Coming soon...
	 * 
	 * Higher value is better.
	 * 
	 * @param product
	 * @return
	 */
	public int getProductLifePoint(ProductDetails product, double avgLife) {
		return 0;
	}

	/**
	 * Average number of product sold.
	 * 
	 * @param productDetailsItr
	 * @return
	 */
	public int getAverageProductPrice(Iterable<ProductDetails> productDetailsItr) {
		int avgProductPrice = 0;
		for (ProductDetails product : productDetailsItr) {
			avgProductPrice += product.getPurchasedCount();
		}
		return avgProductPrice;
	}

	/**
	 * Average number of product sold.
	 * 
	 * @param productDetailsItr
	 * @return
	 */
	public int getAverageProductSoldCount(Iterable<ProductDetails> productDetailsItr) {
		int totalProductSold = 0;
		for (ProductDetails product : productDetailsItr) {
			totalProductSold += product.getPurchasedCount();
		}
		return totalProductSold;
	}

	/**
	 * Coming soon...
	 * 
	 * @return
	 */
	public Map<Integer, Integer> getDurabilityOfProduct() {
		Map<Integer, Integer> map = new HashMap<>();
		Iterable<ProductPurchase> productPurchaseItr = productPurchaseRepository.findAll();

		for (ProductPurchase product : productPurchaseItr) {
			repairHistoryRepository.findByUserId(product.getUser().getId());
		}
		return null;
	}
}
