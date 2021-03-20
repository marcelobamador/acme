package br.com.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.model.LojaEntity;

@Service
public class GeneralService {
	public void fieldVerification(RequestInsertDTO req) throws Exception {
		if (req.getStoreName() == null || req.getStoreAddress().isEmpty()) {
			throw new Exception("O nome da loja deve ser preenchido");
		}

		if (req.getStoreAddress() == null || req.getStoreAddress().isEmpty()) {
			throw new Exception("O endereço da loja deve ser preenchido");
		}
	}
	
	public void fieldVerificationUpdate(StoreUpdateDTO req) throws Exception {
		if (req.getId() == null) {
			throw new Exception("O id da loja deve ser informado");
		}
		
		if (req.getStoreName() == null || req.getStoreAddress().isEmpty()) {
			throw new Exception("O nome da loja deve ser informado");
		}

		if (req.getStoreAddress() == null || req.getStoreAddress().isEmpty()) {
			throw new Exception("O endereço da loja deve ser informado");
		}
	}
	
	public List<ResponseSearchStoreDTO> parseFindAllStore(List<LojaEntity> listEntity){
		List<ResponseSearchStoreDTO> listResponse = new ArrayList<ResponseSearchStoreDTO>();
		ResponseSearchStoreDTO returnResponseDto;
		for (LojaEntity lojaEntity : listEntity) {
			returnResponseDto = new ResponseSearchStoreDTO();
			returnResponseDto.setIdStore(lojaEntity.getIdLoja());
			returnResponseDto.setStoreName(lojaEntity.getNomeLoja());
			returnResponseDto.setStoreAddress(lojaEntity.getEnderecoLoja());
			listResponse.add(returnResponseDto);
		}
		return listResponse;
	}
}
