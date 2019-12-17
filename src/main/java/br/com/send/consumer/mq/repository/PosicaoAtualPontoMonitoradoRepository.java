package br.com.send.consumer.mq.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.send.consumer.mq.model.PosicaoAtualPontoMonitoradoModel;

@Repository
public interface PosicaoAtualPontoMonitoradoRepository extends JpaRepository<PosicaoAtualPontoMonitoradoModel, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM posicao_atual_ponto_monitorado WHERE identificador_dispositivo = ?1 " , nativeQuery = true)
	void deleteByIdentificadorDispositivo(String identificadorDispositivo);
}

