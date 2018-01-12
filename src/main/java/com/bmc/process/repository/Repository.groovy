package com.bmc.process.repository;

import java.io.IOException;
import java.util.List;

import com.bmc.process.model.Dto;
import com.bmc.process.model.MethodRepository;

public interface Repository {

	public List<MethodRepository> read(String source) throws IOException;
	
	public void write(Dto dto, String source) throws IOException;
	
}
