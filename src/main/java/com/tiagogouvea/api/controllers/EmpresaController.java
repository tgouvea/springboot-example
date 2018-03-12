package com.tiagogouvea.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagogouvea.api.dtos.EmpresaDto;
import com.tiagogouvea.api.entities.Empresa;
import com.tiagogouvea.api.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;
	
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<Empresa> buscarEmpresa (@PathVariable("cnpj") String cnpj) {
		
		System.out.println("CNPJ: " + cnpj);
		Empresa emp = empresaService.findByCnpj(cnpj);
		
		System.out.println(emp.toString());
		
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping
	public ResponseEntity<EmpresaDto> cadastrar(@RequestBody EmpresaDto empresaDto){
		
		
		return ResponseEntity.ok(empresaDto);
	}
	
}
