package com.ozeias.os.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozeias.os.domain.Cliente;
import com.ozeias.os.domain.OS;
import com.ozeias.os.domain.Tecnico;
import com.ozeias.os.domain.enuns.Prioridade;
import com.ozeias.os.domain.enuns.Status;
import com.ozeias.os.repositories.ClienteRepository;
import com.ozeias.os.repositories.OsRepository;
import com.ozeias.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OsRepository ordemServicoRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Ozeias Moreira", "105.108.809-75", "(43)99950-2930");
		Tecnico t2 = new Tecnico(null, "Leonardo Fatias", "336.398.139-28", "(43)99950-6759");
		Cliente c1 = new Cliente(null, "Patricia Rocha", "827.550.519-49", "(43)99850-6522");
		OS os1 = new OS(null, Prioridade.ALTA, "Code fail", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		t2.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.save(t1);
		tecnicoRepository.save(t2);
		clienteRepository.save(c1);
		ordemServicoRepository.save(os1);
	}
}
