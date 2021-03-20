package br.com.acme.dto;

public class ResponseSearchStoreDTO extends ReturnDto {

	private static final long serialVersionUID = -7602468965037081110L;
	private Long idStore;
	private String storeName;
	private String storeAddress;

	public Long getIdStore() {
		return idStore;
	}

	public void setIdStore(Long idStore) {
		this.idStore = idStore;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

}
