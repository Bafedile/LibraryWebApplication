package za.co.mecer.services;

import java.io.IOException;
import java.sql.SQLException;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Services {

    public int getMenuChoice();

    public void setOptionChoice(int choice) throws SQLException, ClientException, LoanException,
            IOException, AuthorException, PaymentException, BookException;

    public int getBookMenuChoice();

    public int getAuthorMenuChoice();

    public int getClientMenuChoice();

    public int getLoanMenuChoice();

    public int getPaymentMenuChoice();

}
