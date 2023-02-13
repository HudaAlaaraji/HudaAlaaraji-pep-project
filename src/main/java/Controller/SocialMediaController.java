package Controller;

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
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/register", this::CreatNewUserHandler);
        app.post("/login", this::processUserproccingHandler);
        app.post("/messages", this::exampleHandler);
        app.post("/messages", this::exampleHandler);
        app.post("/messages/(message_id)", this::exampleHandler);
        app.post("/register", this::exampleHandler);
        app.post("/register", this::exampleHandler);
        app.post("/register", this::exampleHandler);
        return app;
    }


    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void CreatNewUserHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper om= new ObjectMapper();
        Account account = om.readValue(ctx.body(),Account.class);
        Account postlogins= AccountService(account);
        if(account != null){
            ctx.json(om.writeValueAsString(account));
        return null;
    }
        {
        ctx.status(400);
    }
private void processUserproccingHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Account account = om.readValue(ctx.body(),Account.class);
    if(account != null){
        ctx.status(401);
    } else
    ctx.json(om.writeValuestring(postlogins));
}
public void postNewMessageHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
   Message message = om.readValue(ctx.body(),Message.class);
   if(message != null){
    ctx.status(400);
   }else{
    ctx.json(om.writeValueAsString(message));
   }

}
public void UpdatebyIDHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Message message = om.readValue(ctx.body(), Message.class);
    int message_id = Integer.parseInt(ctx.pathParam("message_id"));
    Message UpdatedMessage = messageService.UpdatebyId(message_id, message);
    System.out.println(UpdatedMessage);
    if(UpdatedMessage == null){
        ctx.status(400);
    }else{
        ctx.json(om.writeValueAsString(UpdatedMessage));
    }
}
public void GetAllMessages(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Message message = om.readValue(ctx.body(), Message.class);
    Message message_text = messageService.GetAllMessages(message);
    System.out.println(GetAllMessages);
    if(GetAllMessages == null){
        ctx.status(200);
    }else{
        ctx.json(om.writeValueAsString(message));
    }
}
public void DeleteMessagebyIDHandler(Context ctx) throws JsonProcessingException{
    ObjectMapper om= new ObjectMapper();
    Message message = messageService.GetMessagebyId(Integer.parseIn(ctx.Pathparam("message")));
    if(message != null){
     message = om.readValue(ctx.body(), Message.class);
}
    Message delete = messageService.DeleteMessagebyId(message.getMessage_id());
    if(delete != null){
        else 
    }
        ctx.status(200);
        ctx.json(delete);
    }