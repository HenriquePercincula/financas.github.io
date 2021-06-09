package br.financas.fatec.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.financas.fatec.model.PessoaJuridica;
import br.financas.fatec.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoas_juridicas")
public class PessoaJuridicaController implements
 ControllerInterface<PessoaJuridica> {
 @Autowired
 private PessoaJuridicaService service;
 
 @GetMapping
 public ResponseEntity<List<PessoaJuridica>> getAll() {
	 return ResponseEntity.ok(service.findAll());
	 }

 @GetMapping(value = "/{id}")
 public ResponseEntity<?> get(@PathVariable("id") Long id){
 PessoaJuridica _obj = service.findById(id);
 if (_obj != null) {
 return ResponseEntity.ok(_obj);
 }
 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 }

 @PostMapping
 public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica obj)
 {
 service.create(obj);
 return ResponseEntity.ok(obj);
 }
 
 @PutMapping
 public ResponseEntity<?> put(@RequestBody PessoaJuridica _obj)
 {
 if (service.update(_obj)) {
 return ResponseEntity.ok(_obj);
 }
 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 }

 @DeleteMapping(value = "/{id}")
 public ResponseEntity<?> delete(@PathVariable("id") Long id) {
 if (service.delete(id)) {
 return ResponseEntity.ok().build();
 }
 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
 }
}