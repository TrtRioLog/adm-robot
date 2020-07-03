package com.br.ml.adm.service;

public interface RobotService {

	void wakeUp(Long intervaloMinutos) throws InterruptedException;

	void desativarWakeUp();	
}
