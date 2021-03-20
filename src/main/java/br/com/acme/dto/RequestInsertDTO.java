package br.com.acme.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vo")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestInsertDTO implements Serializable {

	private static final long serialVersionUID = 3657824676964627135L;
	private String storeName;
	private String storeAddress;

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
