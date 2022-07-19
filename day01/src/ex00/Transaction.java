package ex00;

import java.util.UUID;

import static ex00.Program.printError;
    enum Category {
        SENDING,
        RECEIVING
    }

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private long transferAmount;
    private Category transferCategory;


    public Transaction(User userOne, User userTwo, long transferAmount, Category tCategory) {
        this.identifier = UUID.randomUUID();
        this.recipient = userOne;
        this.sender = userTwo;
        this.transferCategory = tCategory;
        this.transferAmount = transferAmount;
        if (transferAmount < 0) {
            printError("Wrong data ");
        }
        if (tCategory == Category.SENDING) {
            userTwo.setBalanc(userTwo.getBalanc() - transferAmount);
            userOne.setBalanc(userOne.getBalanc() + transferAmount);
            return;
        }
        if (tCategory == Category.RECEIVING) {
            userTwo.setBalanc(userTwo.getBalanc() - transferAmount);
            userOne.setBalanc(userOne.getBalanc() + transferAmount);
            return;
        }
        else {
            printError("Command invalide");
        }
    }



    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public Category getTransferCategory() {
        return transferCategory;
    }
    public void printTransfer() {
        System.out.println("-----------------------------------------\n" +
                "Transfer\n" +
                "Transfer ID: " + getIdentifier() + "\n" +
                "Resipient: " + recipient.getName() + "\n" +
                "Sender: " + sender.getName() + "\n" +
                "Transfer Category: " + getTransferCategory() + "\n" +
                "Transfer Amount: " + getTransferAmount());

    }
}
