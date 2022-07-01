package com.jmp.service.api;

import com.jmp.dto.BankCard;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//This interface must be implemented for a class that creates a subscription, return subscriptions and all the users
public interface Service {

    void subscribe(BankCard bc);
    Optional<Subscription> getSubscriptionByBankCardNumber(String subs) throws SubscriptionNotFoundException;
    List<User> getAllUsers();
    double getAverageUsersAge();
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);
    static Boolean isPayableUser(User user){
        int age = LocalDate.now().getYear()-user.getBirthday().getYear();
        return age > 18;
    }
}
