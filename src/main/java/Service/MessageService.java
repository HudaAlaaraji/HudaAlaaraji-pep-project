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
    public Message CreateNewMessage(Message message){
        return messageDAO.CreateNewMessage(message);
    }
    public List<Message> GetAllMessage(){
        return messageDAO.RetrieveAllMessages();
    }
    public Message RetrieveMessagebyId(int message_id){
    return messageDAO.RetrieveMessagebyId(message_id);
    }
    public void DeleteMessagebyId( Message  message_id){
         messageDAO.deleteByMessage_id(message_id);
    }
    public Message UpdatebyId(int message_id, Message message){
        return messageDAO.UpdatebyId(message_id, message);
    }
    public Message GetMessagebyUser_Id(int message_id, int account_id) {
        return null;
    }
    public List<Message> RetrieveAllmessages() {
        return null;
    }
}