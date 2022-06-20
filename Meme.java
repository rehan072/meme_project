import java.util.*; //got to test 

//import java.util.

/**
 * Sprint 0
 * Jaime Esquenazi, 456009274
 * Rehan Mullan, 723009386
 * 
 * Sources: Zybooks, geeksforgeeks.org
 */

public class Meme {
    private User creator;
    private BackgroundImage backgroundImage;
    private ArrayList<Rating> ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;

    /**
     * Simple constructor for meme
     **/
    public Meme(BackgroundImage image, User creator, String Caption) {
        this.ratings = new ArrayList<Rating>(10);
        this.captionVerticalAlign = "bottom";
        this.creator = creator;
        this.backgroundImage = image;
        this.caption = Caption;
    }

    /**
     * Sets the creator of the meme
     * @param creator is the updated name for the creator
     **/
    public void setCreator(User creator) {
        //updates the creaotr of the meme
        this.creator = creator;
    }

    /**
     * returns the creator
     */
    public User getCreator() { 
        return this.creator;
    }

    /**
     * Sets the backGroundImage
     * @param backgroungImage is the updated name for the background
     **/
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    
    /**
     * returns the background image
     */
    public BackgroundImage getBackgroundImage() {
        return this.backgroundImage;
    }

    /**
     * Sets the rating of the meme
     * @param ratings is the updated value for the rating
     **/
    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings; 
    }

    /**
     * to return the rating
     */
    public ArrayList<Rating> getRatings() {
        return this.ratings; 
    }

    /**
     * Sets the caption of the meme
     * @param caption is the updated caption for the meme
     **/
    public void setCaption(String caption) {
        this.caption = caption;
    } 

    /**
     * returns the caption
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     *sets captional vertically aligned in a string
     * @param captionaVerticalAlign is the updated string
     **/
    public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
        if ( captionVerticalAlign != "top" && captionVerticalAlign != "bottom" && captionVerticalAlign != "middle") {
            return false;
        }
        else if(captionVerticalAlign == "top" && (this.captionVerticalAlign == "bottom" || this.captionVerticalAlign == "middle")) {
            this.captionVerticalAlign = captionVerticalAlign;
            return true; 
        }
        else if (captionVerticalAlign == "middle" && (this.captionVerticalAlign == "bottom" || this.captionVerticalAlign == "top")) {
            this.captionVerticalAlign = captionVerticalAlign;
            return true; 
        }
        else if (captionVerticalAlign == "bottom" && (this.captionVerticalAlign == "middle" || this.captionVerticalAlign == "top")) {
            this.captionVerticalAlign = captionVerticalAlign;
            return true; 
        }

        else {
        return false;
        }
        
    }

    /**
     * returns the caption vertically alined as a string
     */
    public String getCaptionVerticalAlign() {
        return captionVerticalAlign;
    }

    /**
     * sets value of shared as a boolean
     * @param shared is the updated value
     **/
    public void setShared(boolean shared) {
        this.shared = shared;
    }

    /**
     * adds boolean value for shared
     **/
    public boolean getShared() {
        return this.shared;        // replace later 
    }

    /**
     * adds boolean value of rating
     * @param rating is the updated value for rating
     **/
    public boolean addRating(Rating r) {
      /*  if (ratings.size() == 10) {
            for (int i = 0; i < ratings.size(); i++) {
                ratings.get(0) = null; */

            if (this.ratings.size() == 10) {
                for (int i = 0; i < this.ratings.size(); i++) {
                    this.ratings.set(0,null);
                    this.ratings.set(i,this.ratings.get(i + 1));
                    if (i + 1 == 9) {
                        this.ratings.set(i + 1, r);
                        return true;
                    }
                }
            }

            else if (this.ratings.size() < 10 ) {
                this.ratings.add(r);
                return true;

            }
            return false; 
            

    }

    /**
     * calculates overall rating for meme
     **/
    public double calculatingOverallRating() {
        double overallRating = 0.0;
        for ( int i= 0; i < ratings.size(); i++) {
            overallRating = ratings.get(i).getScore() + overallRating;
            if (this.ratings.isEmpty()) {
                return 0.0;
            }

        }
 
        return overallRating; //replace later 
    }

    /**
    * returns a string containing meme information
    */
    /*private ArrayList<Integer> helper1(ArrayList <Rating> rating) {
        int numberOfratings = rating.size();

        ArrayList <Integer> sortedRate = ["+1":,]
        
        for (int i = 0; i < rating.size(); i++) {
            int sum = rating.get(i).getScore();
            return sum;
        } */

    


     @Override
    public String toString() {
        
        int num_ones = 0;
        int num_minus = 0;

        for (int i = 0; i < this.ratings.size(); i++) {
            if (this.ratings.get(i).getScore() == 1) {
                num_ones +=1;
            }
            else if (this.ratings.get(i).getScore() == -1) {
                num_minus += 1;
            }
        }
        return this.backgroundImage + " " + this.caption + " " + calculatingOverallRating() + " " + "[+1:" + num_ones + "," + "-1:" + num_minus + "]"; 
    }
    
    /**
    * Compares equality of two background memes
    */
     @Override
    public boolean equals(Object o) {
        if (o instanceof Meme) {
            Meme s = (Meme) o;

            if ( this.creator == s.getCreator() && this.caption == s.getCaption() && this.backgroundImage == s.getBackgroundImage()) {
                return true; 
            }
        }

        
        return false;
        
    }


}

