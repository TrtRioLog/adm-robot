package com.br.ml.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.ml.adm.service.RobotService;

@RestController
public class RobotController {
	@Autowired
	RobotService robotService;
	
	@GetMapping(value = "/WakeUp")
	public ResponseEntity<String> wakeUp(@RequestParam Long intervaloMinutos, @RequestParam String App) {
		String msgReturn = "WakeUp!";
		
		try {
			robotService.wakeUp(intervaloMinutos, App);
			
		} catch (Exception e) {			
			msgReturn = e.getMessage();
			
		}
		
		return ResponseEntity.ok(msgReturn); 
	}

	@GetMapping(value = "/TocToc")
	public ResponseEntity<String> tocToc() {
		String msgReturn;
		
		try {
			msgReturn = robotService.tocToc();
			
		} catch (Exception e) {			
			msgReturn = e.getMessage();
			
		}
		
		return ResponseEntity.ok(msgReturn); 
	}	
	
	@GetMapping(value = "/StopWakeUp")
	public ResponseEntity<String> stopWakeUp()
			throws Throwable {
		
		robotService.desativarWakeUp();
		
		return ResponseEntity.ok("WakeUp desativado");		
	}
	
} 
