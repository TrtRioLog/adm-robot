package com.br.ml.adm.service;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RobotServiceImpl implements RobotService {

	private boolean wakeUpAtivado;

	@Override
	@Async
	public void  wakeUp(Long intervaloMinutos) throws InterruptedException {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://adm-ml-controle.herokuapp.com/variavel/chromedrive";
		
		String resposta;
		
		ativarWakeUp();

		while (wakeUpAtivado) {

			try {
				//chamar endpoint da outra aplicacao	
				resposta = restTemplate
						.getForObject(url, String.class);

				System.out.println(resposta);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Xiiii... " + e.getMessage());
			}

			TimeUnit.MINUTES.sleep(intervaloMinutos);
		}
		
	}	
	
	private void ativarWakeUp() {
		wakeUpAtivado = true;		
	}

	@Override
	public void desativarWakeUp() {
		wakeUpAtivado = false;		
	}

	@Override
	public String tocToc() {
		return "I am here!";		
	}	
}