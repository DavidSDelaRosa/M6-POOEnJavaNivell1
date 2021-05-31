package com.jobs.application;
import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Boss boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
		
		System.out.println("Añadido: " + boss + " a la lista");
		System.out.println("Tamaño de la lista:  " + repository.getAllMembers().size());
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
		
		System.out.println("Añadido: " + employee + " a la lista");
		System.out.println("Tamaño de la lista:  " + repository.getAllMembers().size());
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Manager manager = new Manager(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
		System.out.println("Añadido: " + manager + " a la lista");
		System.out.println("Tamaño de la lista:  " + repository.getAllMembers().size());
	}


	public void payAllEmployeers() {
		
		for(AbsStaffMember abs: repository.getAllMembers()) {
			abs.pay();
		}
	
	}

	public String getAllEmployees() {
		
		return repository.getAllMembers().toString();
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
		
		System.out.println("Añadido: " + volunteer + " a la lista");
		System.out.println("Tamaño de la lista:  " + repository.getAllMembers().size());
	}
	
}
