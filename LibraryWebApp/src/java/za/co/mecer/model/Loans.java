package za.co.mecer.model;

import java.time.LocalDate;
import za.co.mecer.exceptions.LoanException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Loans {

    public String FINE_ERROR_MSG = "Fine Amount Should Be 0.0 or More!!";
    public String LOAN_ID_ERROR_MSG = "Loan Id Can Not Be 0 Or Less!!";

    public LocalDate getReturnDate();

    public void setReturnDate(LocalDate localDate);

    public LocalDate getBorrowedDate();

    public void setBorrowedDate(LocalDate localDate);

    public void setFine(double fine) throws LoanException;

    public double getFine();
}
