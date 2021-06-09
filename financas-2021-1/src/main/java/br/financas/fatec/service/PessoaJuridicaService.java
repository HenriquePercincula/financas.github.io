package br.financas.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.financas.fatec.model.PessoaJuridica;
import br.financas.fatec.repositories.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService implements
 ServiceInterface<PessoaJuridica> {
 @Autowired
 private PessoaJuridicaRepository repository;
 public PessoaJuridicaService() {}
 @Override
 public PessoaJuridica create(PessoaJuridica obj) {
 repository.save(obj);
 return obj;
 }
 @Override
 public PessoaJuridica findById(Long id) {
 java.util.Optional<PessoaJuridica> _PessoaJuridica = repository.findById(id);
 return _PessoaJuridica.orElse(null);
 }

@Override
public List<PessoaJuridica> findAll() {
return repository.findAll();
}
@Override	
public boolean update(PessoaJuridica obj) {
	if (repository.existsById(obj.getId())) {
		repository.save(obj);
		return true;
	}
	return false;
}

@Override
public boolean delete(Long id) {
	if (repository.existsById(id)) {
		repository.deleteById(id);
		return true;
	}
	return false;
}
}