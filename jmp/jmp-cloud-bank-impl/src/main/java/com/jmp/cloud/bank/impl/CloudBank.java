package com.jmp.cloud.bank.impl;

import com.jmp.bank.api.Bank;
import com.jmp.dto.*;
//this class create BankCard objects
public class CloudBank implements Bank {
    //this variable number assign represent the number that will be assigned to te cards
    private static int number = 1000;
    //this method increment the number that will be assigned to the credit cards
    private static void incrementNumber(){
        number+=1;
    }
    //this method create a unique bankcard that depends on the Bank card type
    @Override
    public BankCard createBankCard(User user, BankCardType bct) {
        BankCard card;
        var numberCard = "";
        if(bct == BankCardType.CREDIT){
            numberCard+= number;
            incrementNumber();
            card = new CreditBankCard(numberCard,user);
            return card;
        }
        else if(bct == BankCardType.DEBIT){
            numberCard+= number;
            incrementNumber();
            card = new DebitBankCard(numberCard,user);
            return card;
        }

        return null;
    }
}
