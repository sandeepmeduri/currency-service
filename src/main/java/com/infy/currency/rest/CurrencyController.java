package com.infy.currency.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.currency.dto.CurrencyDTO;
import com.infy.currency.service.CurrencyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sandeep_Meduri
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "CurrencyController, REST APIs that deal with Currency DTO")
public class CurrencyController {

	private CurrencyService service;

	@Autowired
	public CurrencyController(CurrencyService service) {
		this.service = service;
	}

	/**
	 * @return
	 */
	@GetMapping("/currencyrate")
	@ApiOperation(value = "Fetch all the Currency Exchange Rates", response = CurrencyDTO.class, tags = "fetchexchangerates")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched the exchange rates successfully"),
			@ApiResponse(code = 404, message = "exchange details not found") })
	public HttpEntity<List<CurrencyDTO>> getAllExchangeRates() {
		List<CurrencyDTO> dto = service.getExchangeRates();
		return ResponseEntity.ok(dto);
	}

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/currencyrate/from/{from}/to/{to}")
	@ApiOperation(value = "Fetch Currency Exchange Rate for specific source and dest", response = CurrencyDTO.class, tags = "fetchexchangerate")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched the exchange rates successfully"),
			@ApiResponse(code = 404, message = "exchange details not found") })
	public HttpEntity<CurrencyDTO> getSpecificExchangeRate(@PathVariable String from, @PathVariable String to) {
		CurrencyDTO dto = service.getSpecificExchangeRate(from, to);
		return ResponseEntity.ok(dto);
	}

}
