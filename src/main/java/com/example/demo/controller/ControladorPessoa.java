package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.services.ServicePessoa;

@RestController
public class ControladorPessoa {
	// ArrayList<String> palavras = new ArrayList<>();
	ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	private final ServicePessoa servicePessoa;
	
	@Autowired
	public ControladorPessoa(ServicePessoa servicePessoa) {
		this.servicePessoa = servicePessoa;
	}
	
    /* @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }
    
    @GetMapping("/teste2")
    public String teste2(){
        return "Olá,isto é o meu segundo Get";
    } */
    
    /* @PostMapping("/postest")
    public String teste3(@RequestBody String teste){
    	return teste;
    } */
    
    /* @GetMapping("/testePessoa")
    public Pessoa testePessoa(){
    	return new Pessoa("David",7);
    } */
	
    @PostMapping("/addPessoa")
    public List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
    	if(pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getIdade()<=0) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	List<Pessoa> aux = servicePessoa.addPessoa(pessoa);
    	return aux;
    }
    
    @GetMapping("/getPessoas")
    public List<Pessoa> getPalavras(){
    	return servicePessoa.getPessoas();
    }
    
    @DeleteMapping("/deletePessoa/{id}")
    public String deletePessoa(@PathVariable String id) {
		return servicePessoa.deletePessoa(id);
    }
    
    @PutMapping("/updatePessoa")
    public String updatePessoa(Pessoa pessoa){
    	return servicePessoa.updatePessoa(pessoa);
    }
    
    /* @PostMapping("/postest")
    public String teste4(@RequestBody String teste){
    	palavras.add(teste);
    	return "Sucesso ao inserir a string";
    } */
    
    /* @GetMapping("/getList")
    public ArrayList<String> getPalavras(){
    	return palavras;
    } */
    
}
