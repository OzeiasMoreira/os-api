package com.ozeias.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ozeias.os.domain.OS;
import com.ozeias.os.dtos.OsDTO;
import com.ozeias.os.services.OsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/os")
public class OsResource {
	
	@Autowired
	private OsService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OsDTO> findById(@PathVariable Integer id){
		OsDTO obj = new OsDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<OsDTO>> findAll(){
		List<OsDTO> list = service.findAll().stream()
				.map(obj -> new OsDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<OsDTO> create(@Valid @RequestBody OsDTO obj){
		obj = new OsDTO(service.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	 
	@PutMapping
	public ResponseEntity<OsDTO> update(@Valid @RequestBody OsDTO obj){
		obj = new OsDTO(service.update(obj));
		return ResponseEntity.ok().body(obj);
		
	}
}
