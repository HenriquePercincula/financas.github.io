package br.financas.fatec.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.financas.fatec.model.Conta;
import br.financas.fatec.repositories.ContaRepository;

@Service
public class ContaService implements
 ServiceInterface<Conta> {
 @Autowired
 private ContaRepository repository;
 public ContaService() {}
 @Override
 public Conta create(Conta obj) {
 repository.save(obj);
 return obj;
 }
 @Override
 public Conta findById(Long id) {
 java.util.Optional<Conta> _conta = repository.findById(id);
 return _conta.orElse(null);
 }

@Override
public List<Conta> findAll() {
return repository.findAll();
}
@Override	
public boolean update(Conta obj) {
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