package daredevil.landlordbankrest.models.Models;

public class TransactionsModel {
    private float transferredAmount;
    private BankAccountModel sender;
    private BankAccountModel recipient;

    public TransactionsModel() {
    }

    public TransactionsModel(float transferredAmount, BankAccountModel sender, BankAccountModel recipient) {
        this.transferredAmount = transferredAmount;
        this.sender = sender;
        this.recipient = recipient;
    }

    public float getTransferredAmount() {
        return transferredAmount;
    }

    public void setTransferredAmount(float transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public BankAccountModel getSender() {
        return sender;
    }

    public void setSender(BankAccountModel sender) {
        this.sender = sender;
    }

    public BankAccountModel getRecipient() {
        return recipient;
    }

    public void setRecipient(BankAccountModel recipient) {
        this.recipient = recipient;
    }
}
