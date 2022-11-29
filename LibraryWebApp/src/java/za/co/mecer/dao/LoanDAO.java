package za.co.mecer.dao;

import java.time.LocalDate;
import za.co.mecer.modelImpl.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface LoanDAO {

    public String LOAN_ERROR_MSG = "Either Your Connection Or The Loan Is Null!!!";

    public void getAllLoans();

    void addLoan(String clientIdentityNum, Loan loan, String bookISBN);

    void removeLoan(int loanId);

    void changeReturnDate(int loanId, LocalDate newReturnDate);

    void addFine(int loanId, double fine);

    Loan searchLoan(int loanId);

    public void displayLoans();

    public int getLoanId(String identityNum);
}
