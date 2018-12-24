import java.util.HashMap;

public class Bank {

    static class Account{
        private String id;
        private String name;
        private int money;
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

    public void openAccount(String id, String name){
        Account account = new Account();
        account.id = id;
        account.name = name;
        accounts.put(id, account);
    }

    public void putMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }

        account.money += amount;
    }

    public void getMoney(String id, int amount){
        Account account = accounts.get(id);
        if(account == null){
            return;
        }

        account.money -= amount;
    }
}
