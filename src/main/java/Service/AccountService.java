
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
    public Account CreateNewUser(Account account){
        return accountDAO.CreateNewUser(account);
}
public boolean authenticate(String username, String password) throws Exception{
    return accountDAO.authenticate(username, password);
}
}

