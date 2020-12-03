package view.checkcustomerpanel;

import java.util.Vector;

import constants.ControllerConstants.EController;
import constants.ViewConstants.ETableStatus;
import controller.customer.CustomerControllerImpl;
import main.FrontController;
import model.service.customer.Customer;
import view.defaultClass.Default_CustomerTable;

public class CustomerTable extends Default_CustomerTable{
	private static final long serialVersionUID = 1L;
	private CustomerControllerImpl customerController;
	
	public CustomerTable(FrontController frontController, ETableStatus insuranceregistration) {
		super();
		this.status = insuranceregistration;
		this.customerController = (CustomerControllerImpl) frontController.mappingController(EController.CustomerController.getControllerName());
		this.refresh();
	}
	
	public void refresh() {
		this.rowData.clear();
		for (Customer customer : this.customerController.getCustomerList()) {
			Vector<Object> customers = new Vector<Object>();
			customers.add(customer.getName());
			customers.add(customer.getCustomerSID());
			customers.add(customer.isGender());
			customers.add(customer.getAge()+"세");
			customers.add(customer.getPhoneNum());
			if (this.status == ETableStatus.insuranceRegistration) {
				if (customer.isRegistrationStatus()) {this.rowData.add(customers);}
			}else if(this.status == ETableStatus.checkCustomer){
				this.rowData.add(customers);
			}
		}
		this.updateUI();
	}
}
