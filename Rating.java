

/**
 * Sprint 0
 * Jaime Esquenazi, 456009274
 * Rehan Mullan, 723009386
 * 
 * Sources: Zybooks, geeksforgeeks.org
 */

public class Rating {
    private int score;
    private User user;
    private String typeRating;     /**
     * Sets the score of the meme
     * @param score is the updated score for the meme
     **/
    public Rating(User user, int score) {
        this.score = score;
        this.user = user; 
        if (score == 0) {
            this.typeRating = "pass";
        } 
        else if (score == -1) {
            this.typeRating = "Downvote";
        }

        else if (score == 1) {
            this.typeRating = "upvote";
        }
    }
    
    
    public boolean setScore(int score){
        //updates the score of the meme
        
        if (score != 0 && score != 1 && score != -1) {
            return false;
        }

        else if (score == 0) {
            typeRating = "pass";
            this.score = score; 
            return true;
        }

        else if (score == 1) {
            typeRating = "upvote";
            this.score = score;
            return true;
        }

        else if (score == -1) {
            typeRating = "downvote";
            this.score = score;
            return true; 
        }
        else {
            this.score = score;
            return false;
        }
    }

    /**
     * returns the score
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Sets the user of the meme
     * @param score is the updated user
     **/
    public void setUser(User user){
        this.user = user;
    }

    /**
     * returns the user
     */
    public User getUser(){
        return this.user;
    }

    /**
     * displays the rating
     */
    @Override
    public String toString(){
        return "Rating was " + typeRating;
    }

    // checks is a rating is equal to another. 
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rating) {
            Rating r = (Rating) o;

            if (this.user == r.getUser() && this.score == r.getScore()) {
                return true; 
            }
        }
        return false;                /// replace later
    }
}
