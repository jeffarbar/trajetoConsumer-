package br.com.send.consumer.mq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.send.consumer.mq.model.PosicaoAtualPontoMonitoradoModel;
import br.com.send.consumer.mq.model.TrajetoModel;
import br.com.send.consumer.mq.repository.PosicaoAtualPontoMonitoradoRepository;
import br.com.send.consumer.mq.util.DataUtil;

@Service
public class PosicaoAtualPontoMonitoradoService {

	private static final Logger logger = LogManager.getLogger(PosicaoAtualPontoMonitoradoService.class);
	
	@Autowired
	private PosicaoAtualPontoMonitoradoRepository posicaoAtualPontoMonitoradoRepository;
	
	public void salva(TrajetoModel trajetoModel) throws Exception {
		
		try {
			posicaoAtualPontoMonitoradoRepository.deleteByIdentificadorDispositivo(trajetoModel.getIdentificadorDispositivo() );
			
			PosicaoAtualPontoMonitoradoModel posicaoAtualPontoMonitoradoModel = new PosicaoAtualPontoMonitoradoModel();
			
			posicaoAtualPontoMonitoradoModel.setDtCadastro(trajetoModel.getDtCriacao());
			posicaoAtualPontoMonitoradoModel.setIdentificadorDispositivo(trajetoModel.getIdentificadorDispositivo());
			posicaoAtualPontoMonitoradoModel.setLatitude(trajetoModel.getLatitude());
			posicaoAtualPontoMonitoradoModel.setLongitude(trajetoModel.getLongitude());
			
			posicaoAtualPontoMonitoradoRepository.save(posicaoAtualPontoMonitoradoModel);

		
		}catch (Exception e) {
			logger.error("{ Erro ao salvar posição monitorado atual }", e);
			throw e;
		}
	} 
}
