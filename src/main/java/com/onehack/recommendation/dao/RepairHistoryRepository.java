package com.onehack.recommendation.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Prakash Pandey 09-Dec-2017
 *
 */
public interface RepairHistoryRepository extends CrudRepository<RepairHistory, Long> {
	
	RepairHistory findByUserId(Integer id);
}
