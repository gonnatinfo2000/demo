package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;

@Service
public class ServicePessoa {
	List<Pessoa> pessoas = new ArrayList<>();
	
	public List<Pessoa> addPessoa(Pessoa pessoa){
		System.out.println(pessoa);
		pessoas.add(pessoa);
		return pessoas;
	}
	
	public String deletePessoa(String id) {
		try {
			Long id_pessoa = Long.parseLong(id);
			
			for(Pessoa pessoaAux: pessoas) {
				if(pessoaAux.getId() == id_pessoa) {
					pessoas.remove(pessoaAux);
					return "Sucesso";
				}
			}
			return "Id não existe";
		}catch(Exception e){
			return "Id privado";
		}
	}
	
	public String updatePessoa(Pessoa pessoa) {
		for(Pessoa pessoaAux: pessoas) {
			if(pessoa.getIdade() > 0) {
				pessoa.setIdade(pessoa.getIdade());
			}
			
			if(!(pessoa.getNome() == null)) {
				pessoa.setNome(pessoa.getNome());
			}
		}
		return "Erro.";
	}
	
	public List<Pessoa> getPessoas(){
		return pessoas;
	}
	
}

