package com.champlain.oop2a1;

import java.time.LocalDate;

/**
 * Represents a person with a name, date of birth, and email address.
 * and also if the person has a parking pass.
 */
public class Person {
    private final String aName;
    private final LocalDate aDOB;
    private final String aEmailAddress;
    private boolean ahasParkingPass;

    /**
     * Constructs a Person object with a name, date of birth, and email address.
     *
     * @param pName The person's name. Cannot be null or empty.
     * @param pDOB The person's date of birth. Cannot be null and must be in the past.
     * @param pEmailAddress The person's email address. Cannot be null and must be a valid format.
     * @throws IllegalArgumentException if any of the provided arguments are invalid.
     */
    public Person(String pName, LocalDate pDOB, String pEmailAddress) {
        if (pName == null || pName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (pDOB == null || pDOB.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth must be in the past.");
        }
        if (pEmailAddress == null || !pEmailAddress.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        this.aName = pName.trim();
        this.aDOB = pDOB;
        this.aEmailAddress = pEmailAddress.trim();
        this.ahasParkingPass = false;
    }

    /**
     * Checks if the person has a parking pass.
     *
     * @return true if a parking pass has been purchased, false otherwise.
     */
    public boolean isPurchasedParkingPass() {
        return ahasParkingPass;
    }

    /**
     * Attempts to purchase a parking pass for the person.
     *
     * @return true if the purchase was successful (i.e., they didn't already have one), false otherwise.
     */
    public boolean purchaseParkingPass() {
        if (this.ahasParkingPass) {
            return false;
        }
        this.ahasParkingPass = true;
        return true;
    }

    /**
     * Returns the person's name.
     *
     * @return The name.
     */
    public String getName() {
        return aName;
    }

    /**
     * Returns the person's email address.
     *
     *
     * @return The email address.
     */
    public String getEmailAddress() {
        return aEmailAddress;
    }

    /**
     * Returns the person's date of birth.
     *
     * @return The date of birth.
     */
    public LocalDate getDOB() {
        return aDOB;
    }

    /**
     * Returns a string representation of the Person object.
     *
     * @return A formatted string with the person's details and parking pass status.
     */
    @Override
    public String toString() {
        return  aName + " " + aDOB + " " + aEmailAddress ;

    }


}