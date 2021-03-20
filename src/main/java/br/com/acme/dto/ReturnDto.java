package br.com.acme.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnDto implements Serializable {

	private static final long serialVersionUID = 7499975590541177438L;
	private String messageReturn;
	private Integer cdReturn;

	public String getMessageReturn() {
		return messageReturn;
	}

	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}

	public Integer getCdReturn() {
		return cdReturn;
	}

	public void setCdReturn(Integer cdReturn) {
		this.cdReturn = cdReturn;
	}

}
