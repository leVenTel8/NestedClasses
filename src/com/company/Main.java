package com.company;

public class Main {

    public static void main(String[] args) {
	    Bank.Banker banker = new Bank.Banker();
        Bank bank = banker.createBank();


        //создаем новый вложенный объект типа Account который ассоциируется с конкретным эксземляром
        //класса типа bank и передаем параметры в конструктор
        Bank.Account account = bank.new Account("qwe", "Boost", 100000);

        account.open();
        bank.putMoney("qwe",1000);
        bank.getMoney("qwe",1000);

        account.close();
    }
}
