package za.co.mecer.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.modelImpl.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoanService {

    public Loan getLoan() throws LoanException;

    public void addLoan(String clientIdentityNum, Loan loan, String bookISBN) throws LoanException;
}
