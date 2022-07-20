package ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Node head;
    private Node end;
    private int size;

    public TransactionsLinkedList() {
        this.size = 0;
    }


    @Override
    public void addTransaction(Transaction transaction) {
        Node node = new Node(transaction);
        if (end == null) {
            head = node;
        } else {
            end.next = node;
            node.back = end;
        }
        end = node;
        size++;
    }

    @Override
    public void deleteTransaction(UUID idTransaction) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.getIdentifier().equals(idTransaction)) {
                if (temp.back != head) {
                    temp.back.next = temp.next;
                }else {
                    head = temp.next;
                }
                if (temp.next != end) {
                    temp.next.back = temp.back;
                } else {
                    end = temp.back;
                }
                size--;
                return;
            }
            temp = temp.next;
        }
        throw new TransactionNotFoundException("Exception: id:" + idTransaction + " not found");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] massTransaction = new Transaction[size];
        Node temp = head;
        for (int i = 0;i < size; i++) {
            massTransaction[i] = temp.data;
            temp = temp.next;
        }
        return massTransaction;
    }

    @Override
    public Transaction findTracsactionById(UUID id) {
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data.getIdentifier().equals(id)) {
                return temp.data;
            }
        }
        return null;
    }

    private static class Node {
        Node next;
        Node back;
        Transaction data;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getBack() {
            return back;
        }

        public void setBack(Node back) {
            this.back = back;
        }

        public Transaction getData() {
            return data;
        }

        public Node(Transaction data) {
            this.data = data;
        }

        public void setData(Transaction data) {
            this.data = data;
        }

    }


    @Override
    public String toString() {
        String str = "";
        for (Node temp = head; temp != null; temp = temp.next) {
            str += temp.data.getRecipient().getName() +
                    " -> " + temp.data.getSender().getName() + ", " +
                    temp.data.getTransferAmount() + ", ID: " + temp.data.getTransferCategory() +
                    ", " + temp.data.getIdentifier() + "\n";

        }
        return str;
    }
}
