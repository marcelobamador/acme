package br.com.acme;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.acme.api.ApiController;
import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.dto.ResponsetDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.service.GeneralService;
import br.com.acme.service.StoreService;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {
	
	@InjectMocks
	ApiController apiController;
	
	@Mock
	GeneralService generalService;
	
	@Mock
	StoreService storeService;
	
	@Mock
	HttpServletRequest request;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void insertStoreTest() {
		init();
		when(apiController.insertStore(returnInserStore(), request)).thenReturn(returnResponse());
		ResponsetDTO response = apiController.insertStore(returnInserStore(), request);
		assertNull(response);
	}
	
	@Test
	void updateStoreTest() {
		init();
		when(apiController.updateStore(returnUpdateStore(), request)).thenReturn(returnResponse());
		ResponsetDTO response = apiController.updateStore(returnUpdateStore(), request);
		assertNull(response);
	}
	
	@Test
	void searchStoreNameTest() {
		init();
		when(apiController.searchStoreName("teste")).thenReturn(returnListResponse());
		List<ResponseSearchStoreDTO> response = apiController.searchStoreName("teste");
		assertNotNull(response);
	}
	
	@Test
	void searchStoreAddressTest() {
		init();
		when(apiController.searchStoreAddress("teste")).thenReturn(returnListResponse());
		List<ResponseSearchStoreDTO> response = apiController.searchStoreAddress("teste");
		assertNotNull(response);
	}
	
	private List<ResponseSearchStoreDTO> returnListResponse() {
		List<ResponseSearchStoreDTO> list = new ArrayList<ResponseSearchStoreDTO>();
		ResponseSearchStoreDTO responseDTO = new ResponseSearchStoreDTO();
		responseDTO.setCdReturn(200);
		responseDTO.setIdStore(1L);
		responseDTO.setMessageReturn("Sucesso");
		responseDTO.setStoreAddress("teste");
		responseDTO.setStoreName("teste");
		list.add(responseDTO);
		return list;
	}
	
	private StoreUpdateDTO returnUpdateStore() {
		StoreUpdateDTO request = new StoreUpdateDTO();
		request.setId(1L);
		request.setStoreAddress("teste");
		request.setStoreName("teste");
		return request;
	}
	
	private ResponsetDTO returnResponse() {
		ResponsetDTO response = new ResponsetDTO();
		response.setCdReturn(200);
		response.setMessageReturn("Sucesso");
		return response;
	}
	
	private RequestInsertDTO returnInserStore() {
		RequestInsertDTO request = new RequestInsertDTO();
		request.setStoreAddress("teste");
		request.setStoreName("teste");
		return request;
	}
}
