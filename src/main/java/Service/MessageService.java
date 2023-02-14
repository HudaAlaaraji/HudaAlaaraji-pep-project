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
        return messageDAO.insertMessage(message);
    }
    public List<Message> GetAllMessage(){
        return messageDAO.GetAllMessages();
    }
    public Message GetMessagebyId(int message_id){
    return messageDAO.getMessageBymessage_id(message_id);
    }
    public void DeleteMessagebyId( Message  message_id){
         messageDAO.deleteByMessage_id(message_id);
    }
    public Message UpdatebyId(int message_id, Message message){
        return messageDAO.updateMessage(message_id, message);
    }
    public Message RetrieveMessagebyID(int message_id, int account_id) {
        return null;
    }
    public List<Message> RetrieveAllmessages() {
        return null;
    }
}