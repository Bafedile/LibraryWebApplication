package za.co.mecer.modelImpl;

import za.co.mecer.model.Clients;
import za.co.mecer.exceptions.ClientException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Client implements Clients {

    private String identityNum, firstName, lastName, address, homeTel, workTel, mobileTel;
    private int clientId;

    public Client() {
    }

    /**
     *
     * @param clientId
     * @param firstName
     * @param lastName
     * @param identityNum
     * @param address
     * @param homeTel
     * @param workTel
     * @param mobileTel
     * @throws ClientException
     */
    public Client(int clientId, String firstName, String lastName, String identityNum,
            String address, String homeTel, String workTel, String mobileTel) throws ClientException {
        setIdentityNum(identityNum);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setHomeTel(homeTel);
        setMobileTel(mobileTel);
        setWorkTel(workTel);
        setClientId(clientId);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param identityNum
     * @param address
     * @param homeTel
     * @param workTel
     * @param mobileTel
     * @throws ClientException
     */
    public Client(String firstName, String lastName, String identityNum,
            String address, String homeTel, String workTel, String mobileTel) throws ClientException {
        setIdentityNum(identityNum);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setHomeTel(homeTel);
        setMobileTel(mobileTel);
        setWorkTel(workTel);
    }

    /**
     *
     * @param firstName
     * @throws ClientException
     */
    @Override
    public void setFirstName(String firstName) throws ClientException {
        if (!checkNameLength(firstName)) {
            throw new ClientException(NAME_ERROR_MSG);
        }
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     * @throws ClientException
     */
    @Override
    public void setLastName(String lastName) throws ClientException {
        if (!checkNameLength(lastName)) {
            throw new ClientException(NAME_ERROR_MSG);
        }
        this.lastName = lastName;
    }

    /**
     *
     * @param identityNum
     * @throws ClientException
     */
    @Override
    public void setIdentityNum(String identityNum) throws ClientException {
        if (!checkIdentityNumLength(identityNum)) {
            throw new ClientException(ID_ERROR_MSG);
        }
        this.identityNum = identityNum;
    }

    /**
     *
     * @param address
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param homeTel
     * @throws ClientException
     */
    @Override
    public void setHomeTel(String homeTel) throws ClientException {
        if (!checkTelLength(homeTel)) {
            throw new ClientException(TEL_ERROR_MSG);
        }
        this.homeTel = homeTel;
    }

    /**
     *
     * @param workTel
     * @throws ClientException
     */
    @Override
    public void setWorkTel(String workTel) throws ClientException {
        if (!checkTelLength(workTel)) {
            if (workTel.length() == 0) {
                this.workTel = workTel;
            } else {
                throw new ClientException(TEL_ERROR_MSG);
            }
        }
        this.workTel = workTel;
    }

    /**
     *
     * @param mobileTel
     * @throws ClientException
     */
    @Override
    public void setMobileTel(String mobileTel) throws ClientException {
        if (!checkTelLength(mobileTel)) {
            if (mobileTel.length() == 0) {
                this.mobileTel = mobileTel;
            } else {
                throw new ClientException(TEL_ERROR_MSG);
            }

        }
        this.mobileTel = mobileTel;
    }

    /**
     *
     * @return
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    @Override
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     *
     * @return
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    @Override
    public String getHomeTel() {
        return homeTel;
    }

    /**
     *
     * @return
     */
    @Override
    public String getWorkTel() {
        return workTel;
    }

    /**
     *
     * @return
     */
    @Override
    public String getMobileTel() {
        return mobileTel;
    }

    /**
     *
     * @param name
     * @return
     * @throws ClientException
     */
    @Override
    public boolean checkNameLength(String name) throws ClientException {
        return (name.length() > 0);
    }

    /**
     *
     * @param identityNum
     * @return
     * @throws ClientException
     */
    @Override
    public boolean checkIdentityNumLength(String identityNum) throws ClientException {
        return (identityNum.length() == 13);
    }

    /**
     *
     * @param homeTel
     * @return
     * @throws ClientException
     */
    @Override
    public boolean checkTelLength(String homeTel) throws ClientException {
        return (homeTel.length() == 10);
    }

//    /**
//     *
//     * @return
//     */
//    @Override
//    public String toString() {
//        return String.format("Client Id: %d%n"
//                + "FirstName: %S%n"
//                + "LastName: %S%n"
//                + "Identity Number: %S%n"
//                + "Home Address: %S%n"
//                + "Home Telephone Number: %s%n"
//                + "Work Telephone Number: %s%n"
//                + "Mobile Telephone Number: %s%n%n", clientId, firstName, lastName, identityNum, address, homeTel, workTel, mobileTel);
//    }
    @Override
    public String toString() {
        return String.format("%d;%S;%S;%S;%S;%S;%S;%S", clientId, firstName, lastName, identityNum, address, homeTel, workTel, mobileTel);
    }

    /**
     *
     * @param clientId
     * @throws ClientException
     */
    @Override
    public void setClientId(int clientId) throws ClientException {
        if (clientId <= 0) {
            throw new ClientException(CLIENT_ID_ERROR_MSG);
        }
        this.clientId = clientId;
    }

    /**
     *
     * @return
     */
    @Override
    public int getClientId() {
        return clientId;
    }
}
