package com.dsr.diagnostics.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsr.diagnostics.ms.model.Disease;
import com.dsr.diagnostics.ms.service.DiseasesList;

@RestController
@RequestMapping("/diagnostics")
public class DiagnosticsResource {
	
	//Hard coded list of diseases
	private List<Disease> diseases = Arrays.asList(
		new Disease("D1", "Cancer", "Chemotherapy"),
		new Disease("D2", "Gastro", "Surgery"),
		new Disease("D3", "Headache", "Paracitamol")
	);
	
	//getDiseases returns a list of diseases
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}
	
	//getDiseaseById returns the disease with the given Id
	@RequestMapping("/diseases/{Id}")
	public Disease getDiseaseById(@PathVariable("Id") String Id) {
		
		Disease d = diseases.stream()
			.filter(disease -> Id.equals(disease.getId()))
			.findAny()
			.orElse(null);	
		
		return d;
	}	
}
