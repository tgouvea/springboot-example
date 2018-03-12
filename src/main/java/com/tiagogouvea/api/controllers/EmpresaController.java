package com.tiagogouvea.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagogouvea.api.dtos.EmpresaDto;
import com.tiagogouvea.api.entities.Empresa;
import com.tiagogouvea.api.responses.Response;
import com.tiagogouvea.api.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;
	
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<Response<Empresa>> buscarEmpresa (@PathVariable("cnpj") String cnpj) {
		
		Response<Empresa> response = new Response<>();
		
		System.out.println("CNPJ: " + cnpj);
		response.setData(empresaService.findByCnpj(cnpj));
		
		System.out.println(response.toString());
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result){
		
		Response<EmpresaDto> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		
		response.setData(empresaDto);
		
		
		return ResponseEntity.ok(response);
	}
	
}
