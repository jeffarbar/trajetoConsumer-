package br.com.send.consumer.mq.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "posicao_atual_ponto_monitorado")
public class PosicaoAtualPontoMonitoradoModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_posicao_atual_ponto_monitorado", nullable = false )
	private Long idPosicaoAtualPontoMonitorado;
	
	@Column(name = "identificador_dispositivo", nullable = false , unique = true )
	private String identificadorDispositivo;
	
	@Column(name = "descricao" )
	private String descricao;
	
	@Column(name = "latitude", nullable = false )
	private Double latitude;
	
	@Column(name = "longitude", nullable = false )
	private Double longitude;
	
	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCadastro;


	public Long getIdPosicaoAtualPontoMonitorado() {
		return idPosicaoAtualPontoMonitorado;
	}

	public void setIdPosicaoAtualPontoMonitorado(Long idPosicaoAtualPontoMonitorado) {
		this.idPosicaoAtualPontoMonitorado = idPosicaoAtualPontoMonitorado;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
