package br.com.acme.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponsetDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.service.GeneralService;
import br.com.acme.service.StoreService;


@RestController
@RequestMapping("cadastro-loja/v1")
public class ApiController {
	
	private static final Logger log = LogManager.getLogger(ApiController.class);
	
	@Autowired
	GeneralService generalService;
	
	@Autowired
	StoreService storeService;
	
	@PostMapping(value = "/insert-store", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponsetDTO insertStore(@RequestBody RequestInsertDTO req, HttpServletRequest request) {
		ResponsetDTO returnDto = new ResponsetDTO();
		try {
			log.info("Iniciando verificação de campos");
			generalService.fieldVerification(req);

			log.info("Iniciando cadastro de adquirente");
			returnDto = storeService.insertStore(req);
		} catch (Exception e) {
			log.error("Erro ao inserir loja");
			returnDto.setMessageReturn(e.getMessage());
			returnDto.setCdReturn(300);
		}
		return returnDto;
	}
	
	@PostMapping(value = "/update-store", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponsetDTO updateStore(@RequestBody StoreUpdateDTO req, HttpServletRequest request) {
		ResponsetDTO returnUpdate = new ResponsetDTO();
		try {
			log.info("Iniciando verificação de campos");
			generalService.fieldVerificationUpdate(req);

			log.info("Iniciando atualização de loja");
			returnUpdate = storeService.updateStore(req);
		} catch (Exception e) {
			log.error("Erro ao inserir loja");
			returnUpdate.setMessageReturn(e.getMessage());
			returnUpdate.setCdReturn(300);
		}
		return returnUpdate;
	}
	
	@GetMapping(value = "/search-store-name", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ResponseSearchStoreDTO> searchStoreName(String param) {
		List<ResponseSearchStoreDTO> returnListStore = new ArrayList<ResponseSearchStoreDTO>();
		try {
			log.info("Iniciando busca de loja por nome");
			returnListStore = storeService.searchStoreName(param);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return returnListStore;
	}
	
	@GetMapping(value = "/search-store-address", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ResponseSearchStoreDTO> searchStoreAddress(String param) {
		List<ResponseSearchStoreDTO> returnListStore = new ArrayList<ResponseSearchStoreDTO>();
		try {
			log.info("Iniciando busca de loja por endereço");
			returnListStore = storeService.searchStoreAddress(param);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return returnListStore;
	}
}
