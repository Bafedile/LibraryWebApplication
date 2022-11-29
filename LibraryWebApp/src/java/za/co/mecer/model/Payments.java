package za.co.mecer.model;

import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Payments {

    public String AMOUNT_ERROR_MSG = "A Payable Amount Should Be 0 or More!!";
    public String PAYMENT_ID_ERROR_MSG = "Payment Id Can Not Be 0 Or Less";

    public void setAmount(double amount) throws PaymentException;

    public double getAmount();

}
