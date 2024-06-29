import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class AccountsInformation {

    // Manager's account information
    private final String managerName = "ali dayi";
    private final String managerPhoneNumber = "09123456789";
    private final String managerPassword = "pass1234";

    // Lists to store user information
    private ArrayList<String> userName = new ArrayList<>();
    private ArrayList<String> userPhoneNumber = new ArrayList<>();
    private ArrayList<String> userPassword = new ArrayList<>();
    private ArrayList<String> cart = new ArrayList<>();
    private ArrayList<Double> wallet = new ArrayList<>();

    // Method to check account type
    public String checkAccount(String phoneNumber, String password) {
        if (phoneNumber.equals(managerPhoneNumber) && password.equals(managerPassword))
            return "manager";
        else if (userPhoneNumber.contains(phoneNumber) && password.equals(userPassword.get(userPhoneNumber.indexOf(phoneNumber))))
            return "user";
        else
            return "invalid information";
    }

    // Method to get index of a user by phone number
    public int getIndex(String phoneNumber) {
        return userPhoneNumber.indexOf(phoneNumber);
    }

    // Method to add a name to the user list
    public void addName(String name) {
        userName.add(name);
    }

    // Method to add a password to the user list
    public void addPassword(String password) {
        userPassword.add(password);
    }

    // Method to add a phone number to the user list
    public void addPhoneNumber(String phoneNumber) {
        userPhoneNumber.add(phoneNumber);
    }

    // Method to check if the name is valid
    public boolean checkName(String name) {
        return name != null;
    }

    // Method to check if the password is valid
    public boolean checkPassword(String password) {
        return password.length() >= 8;
    }

    // Method to check if the phone number is valid
    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("09") && phoneNumber.length() == 11 && !userPhoneNumber.contains(phoneNumber);
    }

    // Method to initialize the wallet with a default amount
    public void setWallet() {
        wallet.add((double) 1000000);
    }

    public ArrayList<String> getUserName() {
        return userName;
    }

    public ArrayList<String> getUserPhoneNumber() {
        return userPhoneNumber;
    }


    public void changeName(String name, int index) {
        if (checkName(name)) {
            userName.set(index, name);
        }
    }

    public void changePhonenumber(String phonenumber, int index) {
        if (checkPhoneNumber(phonenumber)) {
            userPhoneNumber.set(index, phonenumber);
        }
    }
}