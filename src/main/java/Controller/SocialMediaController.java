package Controller;

import java.util.List;

import javax.lang.model.util.ElementScanner6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.*;
import Service.AccountService;
import Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;



/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    { this.accountService =new AccountService();
        this.messageService = new MessageService();
    }
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/register", this::CreatNewUserHandler);
        app.post("/login", this::authenticateHandler);
        app.post("/messages", this::CreatNewMessageHandler);
        app.get("/messages", this::RetrieveAllMessagesHandler);
        app.get("/messages/(message_id)", this::RetrieveMessagebyIdHandler);
        app.delete("/messages/(message_id)", this::DeleteMessagebyIdHandler);
        app.patch("/messages/(message_id)", this::UpdatebyIdHandler);
        app.post("/register", this::GetMessagebyUser_IdHandler);
        return app;
    }
    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    //#1
    private void CreatNewUserHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper om= new ObjectMapper();
        Account account = om.readValue(ctx.body(),Account.class);
        Account addedAccount = accountService.addAccount(account);
        if(addedAccount != null)
        {
            ctx.json(om.writeValueAsString(addedAccount));
            ctx.status(200);
    }else{
        ctx.status(400);
    }
}
    //#2
    private void authenticateHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Account account = om.readValue(ctx.body(),Account.class);
    Account newlogin = accountService.authenticates(account.username, account.password);
    if(newlogin != null){
        ctx.json(om.writeValueAsString(newlogin));
        ctx.status(200);
    } else{
        ctx.status(401);
    }
}
    //#3
    private void CreatNewMessageHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper mapper = new ObjectMapper();
   Message message = mapper.readValue(ctx.body(), Message.class);
   if(message.getMessage_text().isBlank()){
    ctx.json(mapper.writeValueAsString(message));
    ctx.status(400);
   return;
   }
   Message newmessage =messageService.InsertNewMessage(message);
   if(newmessage != null){
    ctx.json(mapper.writeValueAsString(newmessage));
    ctx.status(200);
} else{
    ctx.status(401);
   }
}
    //#4
    private void RetrieveAllMessagesHandler(Context ctx) throws JsonProcessingException{
        List <Message> messages = messageService.RetrieveAllmessages();
        ctx.json(messages);
    } 
     //#5
     private void RetrieveMessagebyIdHandler(Context ctx) throws JsonProcessingException{
       
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        int account_id = Integer.parseInt(ctx.pathParam("account_id"));
        Message message =messageService.RetrieveMessagebyID(message_id, account_id);
        if(message != null){
            ctx.status(200);
        }
    }
    //#6
    private void DeleteMessagebyIdHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper om= new ObjectMapper();
        Message message = om.readValue(ctx.body(), Message.class);
        if(message == null){
            ctx.status(200);
        }
    }
    //#7
    private void UpdatebyIdHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Message message = om.readValue(ctx.body(), Message.class);
    int message_id = Integer.parseInt(ctx.pathParam("message_id"));
    Message UpdatedMessage = messageService.UpdatebyId(message_id, message);
    System.out.println(UpdatedMessage);
    if(UpdatedMessage != null){
        ctx.status(200);
        ctx.json(om.writeValueAsString(UpdatedMessage));
    }
    ctx.status(400);
    }
    //#8
    private void GetMessagebyUser_IdHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om = new ObjectMapper();
    Account user_id = om.readValue(ctx.body(), Account.class);
    if(user_id != null){
        ctx.status(200);
        ctx.json(om.writeValueAsString(user_id));
    }else{
        ctx.status(200);
    }
}
    }
