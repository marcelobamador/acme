package br.com.acme.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponsetDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.model.LojaEntity;
import br.com.acme.repository.StoreRepository;
import br.com.acme.service.GeneralService;
import br.com.acme.service.StoreService;
import br.com.acme.util.Util;

@Service
public class StoreServiceImpl implements StoreService {
	
	private static final Logger log = LogManager.getLogger(StoreServiceImpl.class);
	
	@Autowired
	StoreRepository rpStore;
	
	@Autowired
	GeneralService generalService;
	
	@Override
	public ResponsetDTO insertStore(RequestInsertDTO req) {
		ResponsetDTO returnDTO = new ResponsetDTO();
		try {
			log.info("Cadastrando loja: " + req.getStoreName());
			LojaEntity entity = Util.parseStore(req);
			saveStore(entity);
			returnDTO.setCdReturn(200);
			returnDTO.setMessageReturn("Loja cadastrada com sucesso");
		} catch (Exception e) {
			log.info(e.getMessage());
			returnDTO.setCdReturn(400);
			returnDTO.setMessageReturn(e.getMessage());
		}
		return returnDTO;
	}
	
	private void saveStore(LojaEntity entity) throws Exception {
		try {
			rpStore.save(entity);
		} catch (Exception e) {
			throw new Exception("Erro ao inserir loja");
		}
	}

	@Override
	public List<ResponseSearchStoreDTO> searchStoreName(String param) throws Exception {
		List<ResponseSearchStoreDTO> returnListStore = new ArrayList<ResponseSearchStoreDTO>();
		List<LojaEntity> listEntity = new ArrayList<LojaEntity>();
		try {
			listEntity = rpStore.findByNomeLojaIgnoreCaseContaining(param);
			returnListStore = generalService.parseFindAllStore(listEntity);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar loja");
		}
		return returnListStore;
	}

	@Override
	public List<ResponseSearchStoreDTO> searchStoreAddress(String param) throws Exception {
		List<ResponseSearchStoreDTO> returnListStore = new ArrayList<ResponseSearchStoreDTO>();
		List<LojaEntity> listEntity = new ArrayList<LojaEntity>();
		try {
			listEntity = rpStore.findByEnderecoLojaIgnoreCaseContaining(param);
			returnListStore = generalService.parseFindAllStore(listEntity);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar loja");
		}
		return returnListStore;
	}

	@Override
	public ResponsetDTO updateStore(StoreUpdateDTO req) {
		ResponsetDTO returnDTO = new ResponsetDTO();
		try {
			log.info("Cadastrando loja: " + req.getStoreName());
			LojaEntity entity = Util.parseStoreUpdate(req);
			updateStore(entity);
			returnDTO.setCdReturn(200);
			returnDTO.setMessageReturn("Loja alterada com sucesso");
		} catch (Exception e) {
			log.info(e.getMessage());
			returnDTO.setCdReturn(400);
			returnDTO.setMessageReturn(e.getMessage());
		}
		return returnDTO;
	}
	
	private void updateStore(LojaEntity entity) throws Exception {
		try {
			rpStore.save(entity);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar loja");
		}
	}

}
