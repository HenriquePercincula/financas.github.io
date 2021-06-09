package br.financas.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.financas.fatec.model.PessoaFisica;
import br.financas.fatec.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService implements
 ServiceInterface<PessoaFisica> {
 @Autowired
 private PessoaFisicaRepository repository;
 public PessoaFisicaService() {}
 @Override
 public PessoaFisica create(PessoaFisica obj) {
 repository.save(obj);
 return obj;
 }
 @Override
 public PessoaFisica findById(Long id) {
 java.util.Optional<PessoaFisica> _PessoaFisica = repository.findById(id);
 return _PessoaFisica.orElse(null);
 }

@Override
public List<PessoaFisica> findAll() {
return repository.findAll();
}
@Override	
public boolean update(PessoaFisica obj) {
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