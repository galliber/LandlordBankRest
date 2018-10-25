package daredevil.landlordbankrest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_id")
    private int id;

    @Column(name = "iban")
    private String iban;

    @Column(name = "balance")
    private float balance;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "security_nuber")
    private int securityNumber;

    @OneToMany(mappedBy = "sender")
    private List<Transactions> sender;

    @OneToMany(mappedBy = "recipient")
    private List<Transactions> recipient;

    public BankAccount() {
    }

    public BankAccount(String iban, float balance, List<Transactions> sender, List<Transactions> recipient) {
        this.iban = iban;
        this.balance = balance;
        this.sender = sender;
        this.recipient = recipient;
    }

    public BankAccount(String iban, float balance) {
        this.iban = iban;
        this.balance = balance;
        this.sender = new ArrayList<>();
        this.recipient = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<Transactions> getSender() {
        return sender;
    }

    public void setSender(List<Transactions> sender) {
        this.sender = sender;
    }

    public List<Transactions> getRecipient() {
        return recipient;
    }

    public void setRecipient(List<Transactions> recipient) {
        this.recipient = recipient;
    }
}
