package com.jobs.domain;

public class Manager extends Employee{

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
		
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", salaryPerMonth=" + salaryPerMonth + ", totalPaid=" + totalPaid + "]";
	}
	
}
