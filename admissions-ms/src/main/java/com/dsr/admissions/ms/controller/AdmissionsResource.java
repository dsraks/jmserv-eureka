package com.dsr.admissions.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dsr.admissions.ms.model.Patient;
import com.dsr.admissions.ms.service.DiseasesList;
import com.dsr.admissions.ms.service.EmployeesList;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//A hard coded list of patients
	List<Patient> patients = Arrays.asList(				
		new Patient("P1", "Raghava Chari", "Indian"),
		new Patient("P2", "Venkata Kishore", "American"),
		new Patient("P3", "Suman Ranganathan", "British")
		);
	
	//getPatients() returns a list of patients
	@RequestMapping("/patients")
	public List<Patient> getPatients() {
		return patients;
	}
	
	//getPatientById() returns a patient with a given Id
	@RequestMapping("/patients/{Id}")
	public Patient getPatientById(@PathVariable("Id") String Id) {
		Patient p = patients.stream()
				.filter(patient -> Id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		return p;
	}
	
	//getPhysicians calls the HUMANRES-MS microservice to get list of physicians
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians() {
		EmployeesList physicians = 
				restTemplate.getForObject("http://humanres-ms/humanres/employees", EmployeesList.class);
		return physicians;
	}
	
	//getPhysicians calls the HUMANRES-MS microservice to get list of physicians
	@RequestMapping("/physician/{Id}")
	public EmployeesList getPhysiciansById(@PathVariable("Id") String Id) {
		String pathURL = "http://humanres-ms/humanres/employee/"+Id;
		EmployeesList physicians = 
				restTemplate.getForObject(pathURL, EmployeesList.class);
		return physicians;
	}
	
	//getDiseases calls the DIAGNOSTICS-MS microservice to get list of diseases
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseases = 
				restTemplate.getForObject("http://diagnostics-ms/diagnostics/diseases", DiseasesList.class);
		return diseases;
	}	
}
