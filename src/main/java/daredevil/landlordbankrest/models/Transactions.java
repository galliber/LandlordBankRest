package daredevil.landlordbankrest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @Column(name = "transferred_amount", nullable = false)
    private float transferredAmount;

    @Column(name = "timestamp")
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "sender", nullable = false)
    private BankAccount sender;

    @ManyToOne
    @JoinColumn(name = "recipient", nullable = false)
    private BankAccount recipient;

    public Transactions() {
    }

    public Transactions(float transferredAmount, Date timestamp, BankAccount sender, BankAccount recipient) {
        this.transferredAmount = transferredAmount;
        this.timestamp=timestamp;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Transactions(float transferredAmount, BankAccount sender, BankAccount recipient) {
        this.transferredAmount = transferredAmount;
        this.timestamp=new Date();
        this.sender = sender;
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(float transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public BankAccount getSender() {
        return sender;
    }

    public void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public BankAccount getRecipient() {
        return recipient;
    }

    public void setRecipient(BankAccount recipient) {
        this.recipient = recipient;
    }
}

