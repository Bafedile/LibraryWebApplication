package za.co.mecer.model;

import za.co.mecer.exceptions.BookException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Books {

    public String BOOK_NOT_FOUND_MSG = "Book Not Found!!!";
    public String BOOK_ISBN_ERROR_MSG = "Book ISBN Number Should Be 13 Digits Long!!";
    public String BOOK_ID_ERROR_MSG = "Book Id Can Not Be 0 or Less!!";

    public void setISBN(String ISBN) throws BookException;

    public void setAvailability(boolean availability);

    public void setAccess(boolean access);

    public void setTitle(String title);

    public String getISBN();

    public String getTitle();

    public boolean getAccess();

    public boolean getAvailability();
}
