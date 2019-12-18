package br.com.send.consumer.mq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.send.consumer.mq.model.TrajetoModel;
import br.com.send.consumer.mq.repository.TrajetoRepository;
import br.com.send.consumer.mq.to.TrajetoTo;

@Service
public class ProcessarService {

	private static final Logger logger = LogManager.getLogger(ProcessarService.class);
	
	@Autowired
	private TrajetoRepository trajetoRepository;
	
	@Autowired
	private PosicaoAtualPontoMonitoradoService posicaoAtualPontoMonitoradoService;
	
	@Autowired
	private ObjectMapper mapper;
	
	public void processa( String msg ) throws Exception{
		
		try {
			
			TrajetoModel trajetoModel = convert(msg);
			
			posicaoAtualPontoMonitoradoService.salva(trajetoModel);
			trajetoRepository.save(trajetoModel);
		
		}catch (Exception e) {
			throw e;
		}
	}
	
	private TrajetoModel convert( String msg ) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TrajetoTo trajetoTo = mapper.readValue(msg, TrajetoTo.class);
	
		if( trajetoTo.getDtCriacao() != null && trajetoTo.getDtCriacao().contains("T") ) {
			trajetoTo.setDtCriacao( trajetoTo.getDtCriacao().replace("T", " ") );
		}
		
		return new TrajetoModel(trajetoTo);
	}
	
}
