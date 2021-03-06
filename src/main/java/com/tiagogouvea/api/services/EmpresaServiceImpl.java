package com.tiagogouvea.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tiagogouvea.api.entities.Empresa;
import com.tiagogouvea.api.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	@Cacheable("dadosEmpresa")
	public Empresa findByCnpj(String cnpj) {
		return empresaRepository.findByCnpj(cnpj);
	}

}
