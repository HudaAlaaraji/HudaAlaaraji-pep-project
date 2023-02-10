
package DAO;

import Util.ConnectionUtil;
import Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    /**
     * TODO: retrieve all messages from the message table.
     * You only need to change the sql String.
     * @return all messages.
     */
    //##4
    public List<Message> getAllmessages(){
        Connection connection = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM message";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(rs.getInt("message_id"),
                        rs.getInt("posted_by"),
                        rs.getString("message_text"),
                        rs.getLong("time_posted_epoch"));
                messages.add(message);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return messages;
    }
    //##5
    public Message getMessageBymessage_id(int message_id){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM Message WHERE message_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            preparedStatement.setInt(1, message_id);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message Messages = new Message(rs.getInt("message_id"),
                        rs.getInt("account_id"),
                        rs.getString("message_text"),
                        rs.getInt("posted_by");
                        rs.getLong("time_posted_epoch");
                        System.out.println(message_id);
                return Messages;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Message getMessageByAccount_id(int account_id){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM message WHERE account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            preparedStatement.setInt(1, account_id);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Message message = new Message(rs.getInt("account_id"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                        System.out.println(message);
                return message;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Message insertMessage(Message message){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "INSERT INTO message (message_id, posted_by, message_text, time_posted_epoch) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setInt(1, message.getMessage_id());
            preparedStatement.setInt(2, message.getPosted_by());
            preparedStatement.setString(3, message.getMessage_text());
            preparedStatement.setLong(4, message.getTime_posted_epoch());

            //foreign key (posted_by) references Account(account_id)
            //message_id integer primary key auto_increment,

            preparedStatement.executeUpdate();
            return message;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void deleteByMessage_id(Message message_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "DELETE FROM message WHERE message_id= ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            //preparedStatement.setInt(1, message());

            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
    