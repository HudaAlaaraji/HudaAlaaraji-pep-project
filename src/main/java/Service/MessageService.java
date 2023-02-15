package Service;
import DAO.MessageDAO;
import Model.Message;
import java.util.List;

public class MessageService {
     MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }
    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }
    //3
    public Message CreateNewMessage(Message message){
        return messageDAO.CreateNewMessage(message);
    }
    //4
    public List<Message> RetrieveAllMessages(){
        return messageDAO.RetrieveAllMessages();
    }
    //5
    public Message RetrieveMessagebyId(int message_id){
    return messageDAO.RetrieveMessagebyId(message_id);
    }
    //6
    public void DeleteMessagebyId(String message_text, int message_id){
         messageDAO.DeleteMessagebyId(message_text, message_id);
    }
    //7
    public void UpdatebyId(int message_id, Message message){
        if(messageDAO.UpdatebyId(message_id)==null){
        }
        else{
            messageDAO.UpdatebyId(message_id, message);
        }
    }
     //8
      public List<Message> GetMessagebyUser_Id(int message_id, int account_id){
    return messageDAO.GetMessagebyUser_Id(message_id, account_id);
      }
    }
       