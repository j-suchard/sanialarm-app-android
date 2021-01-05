package de.cvd.gs.sanialarm;

import java.util.Collection;
import java.util.Locale;

public class User {
    private final String accountID;
    private final String givenName;
    private final String surname;
    private final AccountType[] accountType;
    protected int internalID;
    private String emailAddress;

    /**
     * Initializer for the User to store the logged in user.<br>
     *     The following
     *     {@link User#internalID} <br>
     *     {@link User#accountID} <br>
     *     {@link User#givenName} accessible via {@link User#getGivenName()}<br>
     *     {@link User#surname} accessible via {@link User#getSurname()}<br>
     *     {@link User#emailAddress} accessible via {@link User#getEmailAddress()}<br>
     *     {@link User#accountType} accessible via {@link User#accountType}<br>
     *
     * @param internalID Internal ID in the database to manage the foreign keys accessible via {@link User#getInternalID()}
     * @param accountID Official Account ID, this should be visible to the user accessible via {@link User#getAccountID()}
     * @param givenName The given/first name of the user accessible via {@link User#getGivenName()}
     * @param surname The surname/family name/last name of the user accessible via {@link User#getSurname()}
     * @param emailAddress The users email address, used for login accessible via {@link User#getEmailAddress()}
     * @param accountType The account type accessible via {@link User#accountType}.
     */
    public User(int internalID, String accountID, String givenName, String surname,
                String emailAddress, Collection<AccountType> accountType) {
        this.internalID = internalID;
        this.accountID = accountID;
        this.givenName = givenName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.accountType = (AccountType[]) accountType.toArray();
    }

    /**
     * Get the users Account Type
     * @return {@link AccountType Type of Account}
     */
    public AccountType[] getAccountType() {
        return accountType;
    }

    /**
     * Get the user's email address used for login
     * @return Email Address as {@link String}
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the users Email Address
     * @param emailAddress New email Address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get the user's surname/last/family name
     * @return Surname as {@link String}
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Get the user's given/first name
     * @return First/given name as {@link String}
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Get the user's internal ID
     * @return {@link Integer} representing the mysql-based user id. Do not use as identifier for frontend
     */
    public int getInternalID() {
        return internalID;
    }

    /**
     * Get the user's public Account ID
     * @return {@link String} representing the account ID. This value can be used as frontend identification for the user
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Get the user's full name
     * @return {@link String} representing the users full name
     */
    public String getFullName() {
        return String.format(Locale.getDefault(), "%s %s", givenName, surname);
    }

    public boolean changeEmailAddress(String newEmailAddress) {
        //TODO: Code change of email address and verification
        throw new NoSuchMethodError();
    }
}
