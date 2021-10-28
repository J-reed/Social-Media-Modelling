import java.util.ArrayList;
import javafx.util.Pair;

public class User {

    // This Arraylist stores all messages a user has commented under or has made themselves
    public ArrayList<Pair<Message, Message>> Message_History = new ArrayList<>();

    public User(){

    }

    // User Action Functions

    /*
        This method will generate a new message / post that a user makes which is a root message
    */
    public Message generateFreshMessage() throws NotImplementedException{
        throw new NotImplementedException();
    }



    // User Reaction Functions


    /*
        This method calculates whether this user would reply with 
        a new message on a being shown an existing message by the
        algorithm.

        The Method also calculates the quality scores of the new generated message
    */ 
    public Message commentOnMessage(Message m) throws NotImplementedException{
        throw new NotImplementedException();
    }

    /*
        This method calculates whether this user would like an 
        existing message shown to them by the algorithm.


    */
    public Message likeMessage(Message m) throws NotImplementedException{
        throw new NotImplementedException();
    }

}
