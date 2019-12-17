package br.com.send.consumer.mq.model;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.send.consumer.mq.to.TrajetoTo;
import br.com.send.consumer.mq.util.DataUtil;

@Document(collection = "trajeto")
public class TrajetoModel {

	public TrajetoModel() {}
	
	public TrajetoModel(TrajetoTo trajetoTo) throws Exception {
		if(trajetoTo != null) {
			BeanUtils.copyProperties(trajetoTo,this);
			if( trajetoTo.getDtCriacao() != null ) {
				this.setDtCriacao( DataUtil.convert_yyyyMMddHHmmss(trajetoTo.getDtCriacao()) );
			}
		}
	}

	@Id
	private String id;
	 
	@Indexed
	private Date dtCriacao;
	 
	@Indexed
	private String identificadorDispositivo;
	 
	private Double latitude;
	 
	private Double longitude;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getIdentificadorDispositivo() {
		return identificadorDispositivo;
	}

	public void setIdentificadorDispositivo(String identificadorDispositivo) {
		this.identificadorDispositivo = identificadorDispositivo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	 
	
}