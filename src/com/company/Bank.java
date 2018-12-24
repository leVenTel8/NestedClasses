package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Bank {

    public class Account{
        private String id;
        private String name;
        private int money;
        private ArrayList<AccountOperation> operations =
                new ArrayList<AccountOperation>();

        public Account(String id, String name, int amount){
            this.id = id; //this ссылка на самого себя
            this.name = name;
            this.money = amount;
        }

        public void open(){
            accounts.put(id, this);
        }

        public void close(){
            accounts.remove(id, this);
        }
    }

    public static class Banker{
        public Bank createBank(){
            return new Bank();
        }
    }

    private Bank(){  //данный конструктор означает,

    }               //нельзя будет создать через new
                    //в любом другом месте программы, кроме самого этого класса

    HashMap<String, Account> accounts = new HashMap<String, Account>();


    public void putMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }

        AccountOperation operation = new AccountOperation() {
            public Date getDate() {
                return new Date();
            }

            public int amount() {
                return amount;
            }
        };
        account.operations.add(operation);

    }

    public void getMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }

        AccountOperation operation = new AccountOperation() {
            public Date getDate() {
                return new Date();
            }

            public int amount() {
                return -amount;
            }
        };
        account.operations.add(operation);

    }
}
