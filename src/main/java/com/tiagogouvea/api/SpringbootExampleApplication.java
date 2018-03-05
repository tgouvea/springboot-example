package com.tiagogouvea.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tiagogouvea.api.utils.SenhaUtils;

@SpringBootApplication
public class SpringbootExampleApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtPaginas;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExampleApplication.class, args);
		System.out.println("Teste Travis");
	}
	
	@Bean
	public CommandLineRunner teste() {
		
		return args -> {
			
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded = " + senhaEncoded); 

			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded 2 = " + senhaEncoded); 

			System.out.println("Senha valida = " + SenhaUtils.validaSenha("123456", senhaEncoded)); 

			
			System.out.println("Quantidade = " + this.qtPaginas); 
		};
	}
}
