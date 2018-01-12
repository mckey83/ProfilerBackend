package com.bmc.process;

import com.bmc.process.service.Service;
import com.bmc.process.service.ServiceSimple;

public class Start {	

	public static void main(String[] args) {
		ServiceSimple service = new ServiceSimple();
		service.proceed();
	}
}
