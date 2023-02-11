package Service;
import DAO.MessageDAO;
import Model.Message;
import java.util.List;

public class MessageService {
    public MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }
    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }
    public Message InsertNewMessage(Message message){
        return messageDAO.InsertNewMessage(message);
    }
    public Message GetAllMessage(){
        return messageDAO.GetAllmessage();
    }
    public Message GetMessagebyId(int message_id){
    return messageDAO.GetMessagebyId(message_id);
    }
    public Message DeleteMessagebyId(int message_id){
        return messageDAO.DeleteMessagebyId(message_id);
    }
    public Message UpdatebyId(int message_id, Message message){
        return messageDAO.UpdatebyId(message_id, message);
    }
}