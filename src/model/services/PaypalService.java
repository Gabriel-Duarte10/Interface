package model.services;

public class PaypalService implements OnlinePaymentService{
	
	public Double tax (Double amount, Integer month) {
		 double value = amount + (amount*0.01)*month;
		 return value + (value*0.02);
	}
	
}
