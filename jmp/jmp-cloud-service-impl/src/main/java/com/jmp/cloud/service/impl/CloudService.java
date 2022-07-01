package com.jmp.cloud.service.impl;

import com.jmp.dto.BankCard;
import com.jmp.dto.Subscription;
import com.jmp.dto.User;
import com.jmp.service.api.Service;
import com.jmp.service.api.SubscriptionNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//this class create a subscription and can interact with subscriptions
public class CloudService implements Service {
    //A hashmap that contains subscriptions as values and bank numbers as keys
    private static final HashMap<String,Subscription> submap = new HashMap<>();
    //A list that contains all the users with a subscription
    private static final List<User> userList = new ArrayList<>();
    static Lambda ageCalc = year -> LocalDate.now().getYear() - year;

    // this will create a subscription using just a bankcard
    @Override
    public void subscribe(BankCard bc) {
        Subscription newSubscription = new Subscription(bc.toString(), LocalDate.now());
        System.out.println("the "+newSubscription.getBankcard()+" have subscribed for a start date of:"+newSubscription.getStartDate());
        submap.put(bc.getNumber(),newSubscription);
        userList.add(bc.getUser());
    }
    //return the subscription that is associated with a card number
    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String subs) throws SubscriptionNotFoundException {
        Optional<Subscription> optional = Optional.ofNullable(submap.get(subs));
        optional.orElseThrow(()->new SubscriptionNotFoundException("the subscription for the number "+subs+" was not found"));

        return optional;
    }
    //return the list with all the users with a subscription
    @Override
    public List<User> getAllUsers() {

        return Collections.unmodifiableList(userList);
    }
    //return the average age of users
    @Override
    public double getAverageUsersAge(){
        double count = 0;
        for(User user: userList){
            double age = ageCalc.calc(user.getBirthday().getYear());
            count+= age;
        }
        return count/userList.size();
    }
    //this method return a list of the subscriptions that is filter by a specific condition that is passed through a predicate
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate){
        return submap.values().stream().filter(predicate).collect(Collectors.toUnmodifiableList());
    }
}
