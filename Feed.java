import java.util.ArrayList;

/**
 * Sprint 0
 * Jaime Esquenazi, 456009274
 * Rehan Mullan, 723009386
 * 
 * Sources: Zybooks, geeksforgeeks.org
 */

public class Feed {
    private ArrayList<Meme> memes; //current feed

    /**
     * Simple consturctor for feed
     */
    public Feed() {
        memes = new ArrayList<Meme>();
    }

    /**
     * to set the value for memes
     */
    public void setMemes(ArrayList <Meme> memes){
        this.memes = memes;
    }

    /**
     * to return the array list of memes
     */
    public ArrayList<Meme> getMemes(){
        return this.memes;
    }

    /**
     * to return new meme made by specific user
     */
    public Meme getNewMeme(User u){ 
        for (int i = 0; i < memes.size(); i++) {
            System.out.println("entered");
            if (!u.getMemesViewed().contains(this.memes.get(i)) && !u.getMemesCreated().contains(this.memes.get(i))) {
                return this.memes.get(i);
            }
                
        }
        
       return null;
         
    }

    /**
     * return stirng containing meme
     */
    @Override
    public String toString(){
    
        String memesString = "";
        for (int i = 0; i < memes.size(); i++) {
            memesString = memesString + memes.get(i) + "\n";

        }
        return memesString; 
    }


}
