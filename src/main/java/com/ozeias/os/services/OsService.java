package com.ozeias.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozeias.os.domain.Cliente;
import com.ozeias.os.domain.OS;
import com.ozeias.os.domain.Tecnico;
import com.ozeias.os.domain.enuns.Prioridade;
import com.ozeias.os.domain.enuns.Status;
import com.ozeias.os.dtos.OsDTO;
import com.ozeias.os.repositories.OsRepository;
import com.ozeias.os.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class OsService {

	@Autowired
	private OsRepository repository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private TecnicoService tecnicoService;

	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + "Tipo: " + OS.class.getName()));
	}

	public List<OS> findAll() {
		return repository.findAll();
	}

	public OS create(@Valid OsDTO obj) {
		return fromDTO(obj);
	}

	public OS update(@Valid OsDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}

	private OS fromDTO(OsDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));

		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());

		newObj.setTecnico(tec);
		newObj.setCliente(cliente);
		
		if(newObj.getStatus().getCod().equals(2)){
			newObj.setDataFechamento(LocalDateTime.now());
		}
		return repository.save(newObj);
	}

}
