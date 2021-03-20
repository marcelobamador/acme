package br.com.acme.util;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.model.LojaEntity;

public class Util {
	public static LojaEntity parseStore(RequestInsertDTO req) {
		/* PARSE STORE */
		LojaEntity entity = new LojaEntity();
		entity.setNomeLoja(req.getStoreName());
		entity.setEnderecoLoja(req.getStoreAddress());
		return entity;
	}
	
	public static LojaEntity parseStoreUpdate(StoreUpdateDTO req) {
		/* PARSE STORE */
		LojaEntity entity = new LojaEntity();
		entity.setIdLoja(req.getId());
		entity.setNomeLoja(req.getStoreName());
		entity.setEnderecoLoja(req.getStoreAddress());
		return entity;
	}
}
