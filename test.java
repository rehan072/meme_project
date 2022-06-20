import java.util.ArrayList;

public class test {
    

    public static void main(String[] args) {
        //--------------------Constructors---------------------------
        BackgroundImage b1 = new BackgroundImage("joker", "batman", "dies");
        BackgroundImage b2 = new BackgroundImage("superman", "batman", "dies");
        BackgroundImage b3 = new BackgroundImage("joker", "batman", "dies");

        User u1 = new User("user1");
        User u2 = new User("user2");
        User u3 = new User("user1");

        Rating upvote = new Rating(u1, 1);
        Rating pass = new Rating(u1, 0);
        Rating downvote = new Rating(u1,-1);
        Rating up1 = new Rating(u1, 1);

        Meme m1 = new Meme(b1, u1, "good meme");
        Meme m2 = new Meme(b2, u2, " bad meme");
        Meme m3 = new Meme(b3, u1, "good meme");

        Feed f1 = new Feed();
        Feed f2 = new Feed();

        //----------------------toString()-------------------------- 
        System.out.println(b1);
        System.out.println(u1);
        System.out.println(upvote);
        System.out.println(m1);

        System.out.println(b2);
        System.out.println(u2);
        System.out.println(pass);
        System.out.println(m2);

        //----------------------addRating()------------------------
        m1.addRating(upvote); 
        m1.addRating(upvote);
        m1.addRating(upvote);
        m1.addRating(pass);
        m1.addRating(upvote);
        m1.addRating(pass);

        m2.addRating(upvote);
        m2.addRating(upvote);
        m2.addRating(upvote);
        m2.addRating(pass);
        m2.addRating(upvote);
        m2.addRating(pass);

        System.out.println(m1.getRatings());

        //----------------------equals()-----------------------------
        b1.equals(b3);
        b2.equals(b1);

        m1.equals(m3);
        m2.equals(m1);

        u1.equals(u3);
        u2.equals(u1);

        upvote.equals(up1);
        downvote.equals(upvote);

        //-----------------calculatorOverallRating()----------------
        System.out.println(m1.calculatingOverallRating());// works
        System.out.println(m2.calculatingOverallRating());

        //-----------------setCaptionverticalAlign()----------------
        m1.setCaptionVerticalAlign("top");  //works
        m2.setCaptionVerticalAlign("top");
        //System.out.println(m1.setCaptionVerticalAlign("top"));

        //----------------------setScore()--------------------------
        upvote.setScore(9); 
        upvote.setScore(1);

        //---------------------getNewMeme()------------------------
        System.out.println(f1.getNewMeme(u1));//works
        System.out.println(f2.getNewMeme(u2));

        //----------------------rateMeme()--------------------------
        u1.rateMeme(m1, 1);
        u2.rateMeme(m2, -1);
        
        //---------------rateNextMemeFromFeed()---------------------
        u1.rateNextMemeFromFeed(f1, 1);
        u2.rateNextMemeFromFeed(f2, -1);

        //---------------------shareMeme()--------------------------
        u1.shareMeme(m1, f1);
        u2.shareMeme(m2, f2);

        //-----------------calculatorReputation()-------------------
        u1.calculateReputation();
        u2.calculateReputation();

        System.out.println(f1.getMemes());
        

        
        


        
        

        


    }
}
