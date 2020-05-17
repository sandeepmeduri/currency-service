package com.infy.currency.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.currency.dao.CurrencyDAO;
import com.infy.currency.domain.CurrencyEntity;
import com.infy.currency.dto.CurrencyDTO;

/**
 * @author Sandeep_Meduri
 *
 */
@Service
public class CurrencyService {

	private CurrencyDAO dao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public CurrencyService(CurrencyDAO dao) {
		this.dao = dao;
	}

	/**
	 * @return
	 */
	public List<CurrencyDTO> getExchangeRates() {
		List<CurrencyEntity> exchangeRate = this.dao.findAll();
		return exchangeRate.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	public CurrencyDTO getSpecificExchangeRate(String from, String to) {
		CurrencyDTO dto;
		CurrencyEntity exchangeRate = this.dao.findByFromAndTo(from, to);
		dto = convertToDTO(exchangeRate);
		return dto;
	}

	/**
	 * @param entity
	 * @return
	 */
	private CurrencyDTO convertToDTO(CurrencyEntity entity) {
		CurrencyDTO dto = modelMapper.map(entity, CurrencyDTO.class);
		return dto;
	}

}
