package com.br.ml.adm.service;

public interface RobotService {

	void wakeUp(Long intervaloMinutos, String App) throws InterruptedException;

	void desativarWakeUp();

	String tocToc();
	
}
