package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import za.co.mecer.modelImpl.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface PaymentDAO {

    public String PAYMENT_ERROR_MSG = "Either Your Connection Or The Payment Is Null!!!";

    public void addPayment(int loanId, Payment payment);

    public void removePayment(int loanId);

    public void getAllPayments();

    public Payment getPayment(int loanId);

    void displayPayments();

}
