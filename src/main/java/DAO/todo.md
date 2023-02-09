You will need to design and create your own DAO classes from scratch. 
You should refer to prior mini-project lab examples and course material for guidance.

package Application.DAO;

import Application.Util.ConnectionUtil;
import Application.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//message_id integer primary key auto_increment,
posted_by integer,
message_text varchar(255),
time_posted_epoch long,
foreign key (posted_by) references Account(account_id)
//
public class SocialMediaDAO {
    /**
     * TODO: retrieve all messages from the message table.
     * You only need to change the sql String.
     * @return all messages.
     */
    public List<Message> getAllmessages(){
        Connection connection = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM message";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message messages = new Message(rs.getInt("message_id"),
                        rs.getInt("account_id"),
                        rs.getString("message_text"),
                        rs.getInt("posted_by");
                        rs.getlong("time_posted_epoch");
                messages.add(message);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return messages;
    }
//
 public SocialMedia getMessageBymessage_id(int message_id){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM Message WHERE message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            preparedStatement.setInt(1, message_id);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                SocialMedia Messages = new Message(rs.getInt("message_id"),
                        rs.getInt("account_id"),
                        rs.getString("message_text"),
                        rs.getInt("posted_by");
                        rs.getlong("time_posted_epoch");
                        System.out.println(Message);
                return Message;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }