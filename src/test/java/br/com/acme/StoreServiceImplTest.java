package br.com.acme;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.acme.dto.RequestInsertDTO;
import br.com.acme.dto.ResponseSearchStoreDTO;
import br.com.acme.dto.ResponsetDTO;
import br.com.acme.dto.StoreUpdateDTO;
import br.com.acme.repository.StoreRepository;
import br.com.acme.service.GeneralService;
import br.com.acme.service.impl.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {

	@InjectMocks
	StoreServiceImpl storeService;
	
	@Mock
	StoreRepository rpStore;
	
	@Mock
	GeneralService generalService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void inserStoreTest() {
		init();
		ResponsetDTO dto = storeService.insertStore(returnInserStore());
		assertNotNull(dto);
	}
	
	@Test
	public void updateStoreTest() {
		init();
		ResponsetDTO dto = storeService.updateStore(returnUpdateStore());
		assertNotNull(dto);
	}
	
	@Test
	public void searchStoreNameTest() throws Exception {
		init();
		List<ResponseSearchStoreDTO> response = storeService.searchStoreName("teste");
		assertNotNull(response);
	}
	
	@Test
	public void searchStoreAddressTest() throws Exception {
		init();
		List<ResponseSearchStoreDTO> response = storeService.searchStoreAddress("teste");
		assertNotNull(response);
	}
	
	private StoreUpdateDTO returnUpdateStore() {
		StoreUpdateDTO request = new StoreUpdateDTO();
		request.setId(1L);
		request.setStoreAddress("teste");
		request.setStoreName("teste");
		return request;
	}
	
	private RequestInsertDTO returnInserStore() {
		RequestInsertDTO request = new RequestInsertDTO();
		request.setStoreAddress("teste");
		request.setStoreName("teste");
		return request;
	}
}
