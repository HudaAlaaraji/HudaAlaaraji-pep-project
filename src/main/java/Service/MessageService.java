import DAOMessageService 
import Model.Message;
import java.util.List;

package Service;

public class MessageService {
    public MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new messageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }
}