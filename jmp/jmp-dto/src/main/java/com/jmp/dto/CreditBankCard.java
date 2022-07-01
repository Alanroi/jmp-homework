package com.jmp.dto;
//this class create a Credit Bank Card objet inheriting the attributes and methods of BankCard class
public class CreditBankCard extends BankCard{
    public CreditBankCard(String number, User user) {
        super(number, user);
    }

    @Override
    public String toString() {
        return "CreditBankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
