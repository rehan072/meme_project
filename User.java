import java.util.*;
/* Sprint 0
 * Jaime Esquenazi, 456009274
 * Rehan Mullan, 723009386
 * 
 * Sources: Zybooks, geeksforgeeks.org
 */

public class User {
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed; 
    

    // simple constructor with no parameters'
    public User(String userName) {
        this.userName = userName; 
        memesViewed = new ArrayList<Meme>();
        memesCreated = new ArrayList<Meme>();
        
    }
    
    /**
     * Sets the user's username
     * @param userName is the updated name for the user
     **/
    public void setUserName(String userName){
        //updates the value of @param userName
        this.userName = userName;
    }

    /**
     * returns the username
     */
    public String getUsername(){
        //Returns the user's userName
        return this.userName;
    }

    /**
     * setter for memesCreated
     * 
     **/
    public void setMemesCreated(ArrayList<Meme> memesCreated){
        this.memesCreated = memesCreated; 
        
    }



    /**
     * returns the meme created
     */
    public ArrayList<Meme> getMemesCreated(){
        return memesCreated;
    }

    /**
     * sets memes as viewed or not
     * @param memes v
     **/
    public void setMemesViewed(ArrayList<Meme> memesViewed){
        this.memesViewed = memesViewed;
    }

    public ArrayList<Meme> getMemesViewed() {
        return memesViewed;
    }

    /**
     *  returns nothing but sets the rating for meme 
     */
    public void rateMeme(Meme m, int score){
        memesViewed.add(m);                     // adding to ratings 
        m.addRating(new Rating(this, score));

    }

    /**
     * creates and returns a meme
     */
    public Meme createMeme(BackgroundImage backgroundImage, String caption){
        Meme mem = new Meme(backgroundImage, this, caption);
        memesCreated.add(mem);
        return mem;
    }

    /**
     *  if meme is deleted reutrns true. 
     */
    public boolean deleteMeme(Meme meme){
        if (memesCreated.contains(meme) && meme.getShared() == false) {
            return true;
        }
        return false; 
    }

    /**
     * shifts feeds of the meme 
     */
    public void shareMeme(Meme meme, Feed feed){
        meme.setShared(true);
        feed.getMemes().add(meme);
    }

    /**
     * gives the next meme a rating 
     */
    public boolean rateNextMemeFromFeed(Feed feed, int ratingScore){
        Meme presentMeme = feed.getNewMeme(this);
        memesViewed.add(presentMeme); // record it as being viewed
        presentMeme.addRating(new Rating(this, ratingScore));
        if (feed.getNewMeme(this) == null) {
            return false;
        }
        return true;
    }

    /**
     * calculates reputation for a meme 
     */
    public double calculateReputation(){
        
        if (memesCreated.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (int i = 0; i < memesCreated.size(); i++){

            sum = memesCreated.get(i).calculatingOverallRating();
        }
        double avg = sum/memesCreated.size();

        return avg;

    }

    /**
     * returns the name of the user
     */
    @Override
    public String toString(){
        return userName + " has rated " + this.memesViewed.size() + " memes, " + calculateReputation();                //for now its return null else string
    }

    /**
     * checks if a user is equal to another
     */
    @Override   
    public boolean equals(Object o){
        return super.equals(o); 
    }


}
