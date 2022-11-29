package za.co.mecer.model;

import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface Authors {

    public String NAME_ERROR_MSG = "Name Can Not Be Null OR Empty!!!";
    public String AUTHOR_ID_ERROR_MSG = "Author Id Can Not Be Less Than 1";

    public void setName(String name) throws AuthorException;

    public String getName();

    public int getAuthorId();

    public void setAuthorId(int authorId) throws AuthorException;

}
