package com.jmp.dto;
//this class create a Debit Bank Card objet inheriting the attributes and methods of BankCard class
public class DebitBankCard extends BankCard{
    public DebitBankCard(String number, User user) {
        super(number, user);
    }

    @Override
    public String toString() {
        return "DebitBankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
