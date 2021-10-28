import java.util.HashMap;
import java.util.ArrayList;


public class Message {
    
    // Message Attributes / Qualities
    public static final String[] Qualities = {"Positivity"};
    private HashMap<String, Integer> quality_scores = new HashMap<>();

    // Message History and Statistics
    public final boolean is_root_message;
    private Message root_message;


    private int likes_counter = 0;
    private ArrayList<Message> comments = new ArrayList<>();


    // Initialisers

    public Message(int[] quality_scores) throws Message_Qualities_Exception{
        
        this.is_root_message = true;
        this.root_message = this;

        messageInit(quality_scores);
        
    }

    public Message(int[] quality_scores, Message root_message) throws Message_Qualities_Exception{

        this.is_root_message = false;
        this.root_message = root_message;
        
        messageInit(quality_scores);
     
    }

    private void messageInit(int[] quality_scores) throws Message_Qualities_Exception{
        // Validate the scores given for qualities
        validateInputScores(quality_scores);
 
        // Place scores in the quality scores hashmap for easy retrieval
        for(int i = 0; i < Qualities.length; i++){
            this.quality_scores.put(Qualities[i], quality_scores[i]);
        }
    }


    // Ensure that when a Message object is instantiaed All qualities are provided a valid score
    private void validateInputScores(int[] quality_scores) throws Message_Qualities_Exception{

        // Make sure that a score has been provided for every quality
        if(quality_scores.length != Qualities.length){
            throw new Message_Qualities_Exception("Every message must provide a value of every quality");
        }

        // Make sure that each score is a number between 1 and 10 (inclusive)
        for(int i = 0; i < Qualities.length; i++){
            if(quality_scores[i] > 10 || quality_scores[i] < 1){
                throw new Message_Qualities_Exception(
                    "The score for " + Qualities[i] + 
                    "(The "+Integer.toString(i)+"th element in the list provided) " +
                    "should be a number between 1 and 10 inclusive"
                );
            }
        }


    }


    // Message Interaction functions

    public void like(){
        this.likes_counter++;
    }

    public void commentOnMessage(Message m){
        this.comments.add(m);
    }


    // Message Analytics Functions

    public int getNoLikes(){
        return this.likes_counter;
    }

    public int getNoComments(){
        return this.comments.size();
    }
    
    // Getters

    public int getQualityScore(String quality){
        return this.quality_scores.get(quality);
    }

    public Message getRootMessage(){
        return this.root_message;
    }

}


class Message_Qualities_Exception extends Exception{

    public Message_Qualities_Exception(String err_msg){
        super(err_msg);
    }

}