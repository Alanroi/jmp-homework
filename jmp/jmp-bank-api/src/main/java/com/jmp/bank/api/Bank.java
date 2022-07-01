package com.jmp.bank.api;

import com.jmp.dto.BankCard;
import com.jmp.dto.BankCardType;
import com.jmp.dto.User;
//this interface must be implemented for a class that creates bankCards
public interface Bank {
    BankCard createBankCard(User user, BankCardType bct);
}
