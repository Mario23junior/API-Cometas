package com.project.cometa.Controller.ServiceController;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cometa.Exception.ResourceNotFoundExceptionIntercept;
import com.project.cometa.Model.InformacaosOrbitais;
import com.project.cometa.Repositorys.RepositoryInformacaosOrbitas;

@Service
public class ServiceInformacaosOrbitais {
    
	private RepositoryInformacaosOrbitas repositoryInformacaosOrbitas;
	
	public ServiceInformacaosOrbitais(RepositoryInformacaosOrbitas repositoryInformacaosOrbitas) {
		this.repositoryInformacaosOrbitas = repositoryInformacaosOrbitas;
	}
	
	public InformacaosOrbitais salvarInformacoes(InformacaosOrbitais informacaosOrbitais) {
		InformacaosOrbitais saveInfoOrb = repositoryInformacaosOrbitas.save(informacaosOrbitais);
		return saveInfoOrb;
	}
	
	public Optional<InformacaosOrbitais> listByComet(Long id) {
		Optional<InformacaosOrbitais> list = repositoryInformacaosOrbitas.findById(id);
		list.orElseThrow(() -> new ResourceNotFoundExceptionIntercept("informação não encontrada"));
		return list;
	}
}
