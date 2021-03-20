package br.com.acme.service;

import java.util.List;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.dto.ResponsetDTO;
import br.com.acme.dto.StoreUpdateDTO;

public interface StoreService {
	ResponsetDTO insertStore(RequestInsertDTO req);
	
	ResponsetDTO updateStore(StoreUpdateDTO req);
	
	List<ResponseSearchStoreDTO> searchStoreName(String param) throws Exception;
	
	List<ResponseSearchStoreDTO> searchStoreAddress(String param) throws Exception;
}
