package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService{
	
	
	private OnlinePaymentService paymentService;
	private Integer month;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ContractService() {
		
	}

	public ContractService(OnlinePaymentService paymentService, Integer month) {
		this.month = month;
		this.paymentService = paymentService;
	}

	
	
	public void processInstallment(Contract contract) {
		
		double amount = contract.getTotalValue()/month;
		
		Calendar cl = Calendar.getInstance();
		
		
		for(int i=1;i<=month;i++) {
			double value = paymentService.tax(amount, i);
			cl.setTime(contract.getDate());
			cl.add(Calendar.MONTH, i);
			Date date = cl.getTime();
			
			
			contract.getList().add(new Installment(date, value));
			
		}
		
	}
	
	
}
