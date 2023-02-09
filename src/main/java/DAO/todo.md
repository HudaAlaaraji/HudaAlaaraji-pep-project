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
     * TODO: retrieve all books from the Book table.
     * You only need to change the sql String.
     * @return all Authors.
     */
    public List<Book> getAllBooks(){
        Connection connection = ConnectionUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM book";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }

    /**
     * TODO: retrieve an book from the Book table, identified by its id.
     * You only need to change the sql String and leverage PreparedStatement's setString and setInt methods.
     * @return a book identified by id.
     */
    public Book getBookByIsbn(int isbn){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM book WHERE isbn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            preparedStatement.setInt(1, isbn);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                        System.out.println(book);
                return book;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * TODO: insert an book into the Book table.
     * Unlike some of the other insert problems, the primary key here will be provided by the client as part of the
     * Book object. Given the specific nature of an ISBN as both a numerical organization of books outside of this
     * database, and as a primary key, it would make sense for the client to submit an ISBN when submitting a book.
     * You only need to change the sql String and leverage PreparedStatement's setString and setInt methods.
     */
    public Book insertBook(Book book){
        Connection connection = ConnectionUtil.getConnection();
        try {
            //Write SQL logic here
            String sql = "INSERT INTO book (isbn, author_id, title, copies_available) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setString and setInt methods here.
            preparedStatement.setInt(1, book.getIsbn());
            preparedStatement.setInt(2, book.getAuthor_id());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setInt(4, book.getCopies_available());

            preparedStatement.executeUpdate();
            return book;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * TODO: retrieve all books from the Book table with a book_count over zero.
     * You only need to change the sql String and leverage PreparedStatement's setString and setInt methods.
     * @returnall books with book count > 0.
     */
    public List<Book> getBooksWithBookCountOverZero(){
        Connection connection = ConnectionUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM book WHERE copies_available > 0";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //write preparedStatement's setInt method here.
            //preparedStatement.setString(1, Book.getBooksWithBookCountOverZero());

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }