
package Service;
import DAO.AccountDAO;
import Model.Account;

public class AccountService {
     AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    //1
    public Account CreateNewUser(Account account){
        return accountDAO.CreateNewUser(account);
    }
    //2
    public Boolean Login(String username, String password)throws Exception {
    return accountDAO.login(username, password);
    }
    public Account addAccount(Account account) {
        return null;
    }
    public Account login(String username, String password) {
        return null;
    }
}


    