package com.onehack.recommendation;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onehack.recommendation.controller.ProductsController;
import com.onehack.recommendation.dao.Brands;
import com.onehack.recommendation.dao.ProductDetails;
import com.onehack.recommendation.dao.ProductDetailsRepository;
import com.onehack.recommendation.dao.ProductPurchase;
import com.onehack.recommendation.dao.ProductPurchaseRepository;
import com.onehack.recommendation.dao.RepairHistory;
import com.onehack.recommendation.dao.RepairHistoryRepository;
import com.onehack.recommendation.dao.User;
import com.onehack.recommendation.dao.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneHackRecommendationApplicationTests {

	private Logger log = LoggerFactory.getLogger(ProductsController.class);

	@Autowired
	ProductDetailsRepository productDetailRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RepairHistoryRepository repairHistoryRepository;
	@Autowired
	ProductPurchaseRepository productPurchaseRepository;

	User user;

	//@Test
	@Before
	public void user() {
		log.info("======================= userRepository test ==================");
		user = new User();
		user.setEmail("pcpandey8@mail.com");
		user.setName("Prakash Pandey");
		user.setPhone(9403678957L);
		user.setPassword("PCP100");
		//userRepository.save(user);
		//productDetailRepository.findAll().forEach(action -> log.info(action.toString()));
	}

	//@Test
	public void productDetails() {
		log.info("======================= productDetails test ==================");
		JSONObject metaData = new JSONObject();
		metaData.put("door", 2);
		metaData.put("star", 2);
		metaData.put("capacity", 320);
		metaData.put("warranty", 5);
		metaData.put("stars", 3.5);
		ProductDetails productDetails = new ProductDetails();
		productDetails.setBrand(Brands.Godrej.getBrands());
		productDetails.setCost(1);
		productDetails.setModelNumber(2500);
		productDetails.setName("Mountain fridge");
		productDetails.setMetaInfo(metaData.toString());
		productDetails.setImageUrl("https://5.imimg.com/data5/CX/DW/MY-40755438/usha-mixer-grinder-4-jar-500x500.jpg");
		productDetailRepository.save(productDetails);
		productDetailRepository.findAll().forEach(action -> log.info(action.toString()));
	}

	@Test
	public void userHistory() {
		log.info("======================= userHistory test ==================");
		RepairHistory repairHistory = new RepairHistory();
		repairHistory.setCustomerCost(200);
		repairHistory.setInsuranceClaimed(120);
		repairHistory.setTotalCost(1000);
		repairHistory.setUser(user);
		repairHistory.setRequestRaised(new Date());
		repairHistory.setRequestCompleted(new Date());
		repairHistory.setModelId(1000);

		repairHistoryRepository.save(repairHistory);
		repairHistoryRepository.findAll().forEach(action -> log.info(action.toString()));
	}

	//@Test
	public void productPurchase() {
		log.info("======================= productPurchase test ==================");
		ProductPurchase productPurchase = new ProductPurchase();
		productPurchase.setUser(user);
		productPurchase.setBrand(Brands.Whirlpool.getBrands());
		productPurchase.setCategory("Cooling");
		productPurchase.setBoughtOn(new Date());
		productPurchase.setPrice(2500);
		productPurchaseRepository.save(productPurchase);
		productPurchaseRepository.findAll().forEach(action -> log.info(action.toString()));
	}

}
