package com.infy.currency.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infy.currency.domain.CurrencyEntity;

/**
 * @author Sandeep_Meduri
 *
 */
public interface CurrencyDAO extends JpaRepository<CurrencyEntity, Integer> {
	
	List<CurrencyEntity> findAll();

	CurrencyEntity findByFromAndTo(String from, String to);
}
