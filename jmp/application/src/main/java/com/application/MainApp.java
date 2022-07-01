package com.application;

import com.jmp.cloud.bank.impl.CloudBank;
import com.jmp.cloud.service.impl.CloudService;
import com.jmp.dto.BankCard;
import com.jmp.dto.BankCardType;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;
import com.jmp.service.api.Service;
import com.jmp.service.api.SubscriptionNotFoundException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Predicate;

public class MainApp {
    public static void main(String[] args) throws SubscriptionNotFoundException {
        LocalDate meBirthday = LocalDate.of(1998, 2, 4);
        LocalDate broBirthday = LocalDate.of(2001, 3, 23);
        User me  =new User("Alan","Roi",meBirthday);
        User bro  =new User("Kevin","Ali",broBirthday);
        CloudBank cardsGen = new CloudBank();
        BankCard meCard = cardsGen.createBankCard(me, BankCardType.CREDIT);
        BankCard broCard = cardsGen.createBankCard(bro, BankCardType.DEBIT);
        CloudService subsGen = new CloudService();
        subsGen.subscribe(meCard);
        subsGen.subscribe(broCard);
        System.out.println(subsGen.getAllUsers());
        System.out.println(subsGen.getSubscriptionByBankCardNumber("1000"));
        System.out.println("The average  age of all the users is "+subsGen.getAverageUsersAge());
        System.out.println("The answer for checking if the user 'me' is over 18 years old is: " + Service.isPayableUser(me));
        //Condition to be used in getAllSubscriptionByCondition method
        Predicate<Subscription> predicate = (s)-> Objects.equals(s.getStartDate(), LocalDate.now());
        System.out.println(subsGen.getAllSubscriptionsByCondition(predicate));

    }
}
