package br.com.send.consumer.mq.service;

import org.springframework.stereotype.Service;

@Service
public class VersaoService {

	private String versao = "1.0.0";
	
	public String getVersao() {
		return versao;
	}
}
