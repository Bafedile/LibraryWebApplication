package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.modelImpl.Payment;
import za.co.mecer.dao.impl.PaymentDAOImpl;
import za.co.mecer.services.PaymentService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentServiceImpl implements PaymentService {

    PaymentDAOImpl paymentImpl;
    LoanServiceImpl loanService;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param conn
     */
    public PaymentServiceImpl() {
        this.paymentImpl = new PaymentDAOImpl();
        this.loanService = new LoanServiceImpl();
    }

}
