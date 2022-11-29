package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.modelImpl.Loan;
import za.co.mecer.dao.impl.LoanDAOImpl;
import za.co.mecer.services.LoanService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanServiceImpl implements LoanService {

    LoanDAOImpl loanImpl;
    ClientServiceImpl clientService;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * @param conn
     */
    public LoanServiceImpl() {
        this.loanImpl = new LoanDAOImpl();
        this.clientService = new ClientServiceImpl();

    }

    @Override
    public void addLoan(String clientIdentityNum, Loan loan, String bookISBN) throws LoanException {
        loanImpl.addLoan(clientIdentityNum, loan, bookISBN);
    }

    @Override
    public Loan getLoan() throws LoanException {
        return loanImpl.searchLoan(9);
    }

}
