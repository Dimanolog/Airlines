package by.trainings.java8.year2016.dzshnipko.airlines.services.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.Employee;

public class Crew {
	private Employee firstPilot;
	private Employee secondPilot;
	private Employee flightEngineer;
	private Employee navigator;
	private Employee radioman;
	private List<Employee> stewardsList = new ArrayList<>();

	public Crew(Set<Employee> empSet) {
		for (Employee employee : empSet) {
			switch (employee.getSpecialty()) {
			case firstPilot:
				firstPilot = employee;
				break;
			case secondPilot:
				secondPilot = employee;
				break;
			case flightEngineer:
				flightEngineer = employee;
				break;
			case navigator:
				navigator = employee;
				break;
			case radioman:
				radioman = employee;
				break;
			case steward:
				stewardsList.add(employee);
				break;

			default:
				throw new IllegalArgumentException("wrong crew");

			}
		}
	}
	
	public Set<Employee> getCrewAsSet(){
		
		Set<Employee> empSet=new HashSet<>();
		if(flightEngineer!=null){
			empSet.add(flightEngineer);
		}
		if(firstPilot!=null){
			empSet.add(firstPilot);
		}
		if(secondPilot!=null){
			empSet.add(secondPilot);
		}
		
		if(navigator!=null)
		{
			empSet.add(navigator);
		}
		
		if(radioman!=null)
		{
		empSet.add(radioman);}
		if(stewardsList.isEmpty()==false){
			empSet.addAll(stewardsList);
		}
		return empSet;
	}

	public Employee getFirstPilot() {
		return firstPilot;
	}

	public Employee getSecondPilot() {
		return secondPilot;
	}

	public Employee getFlightEngineer() {
		return flightEngineer;
	}

	public Employee getNavigator() {
		return navigator;
	}

	public Employee getRadioman() {
		return radioman;
	}

	public List<Employee> getStewardsList() {
		return stewardsList;
	}

	public void setFirstPilot(Employee firstPilot) {
		this.firstPilot = firstPilot;
	}

	public void setSecondPilot(Employee secondPilot) {
		this.secondPilot = secondPilot;
	}

	public void setFlightEngineer(Employee flightEngineer) {
		this.flightEngineer = flightEngineer;
	}

	public void setNavigator(Employee navigator) {
		this.navigator = navigator;
	}

	public void setRadioman(Employee radioman) {
		this.radioman = radioman;
	}

	public void setStewardsList(List<Employee> stewardsList) {
		this.stewardsList = stewardsList;
	}

}
