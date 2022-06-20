/**
 * Sprint 0 
 * Jaime Esquenazi, 456009274
 * Rehan Mullan, 723009386
 * 
 * Sources: Zybooks, geeksforgeeks.org
 */

 // equals question need to ask 

public class BackgroundImage {
    private String imageFileName;
    private String title;
    private String description;

    
    
    /**
    * Simple consturctor for background image
    */ 
    public BackgroundImage(String Filename, String title, String Description) {
        this.imageFileName = Filename;
        this.title = title;
        this.description = Description;
    }     
    
    /**
    * Sets the image file name
    * @param imageFileName
    */ 
    public void setImageFileName(String imageFileName){
        //updates the value of imageFilename
        this.imageFileName = imageFileName;
    }

    /**
    * returns the imageFileName
    */
    public String getImageFileName(){
        return this.imageFileName;
    }

    /**
    * Sets the images title
    * @param title is the updated title for the image
    */
    public void setTitle(String title){
        //updates the title of the image
        this.title = title;
    }

    /**
    * returns the image title
    */
    public String getTitle(){
        return this.title;
    }

    /**
    * Sets the description for the image
    * @param description is the updated name for the file
    */
    public void setDescription(String description){
        //updates the description of the image
        this.description = description;
    }

    /**
    * returns the image description
    */
    public String getDescription(){
        return this.description;
    }

    /**
    * returns a string containing background image information
    */
    @Override
    public String toString(){
        return this.title + " <" + this.description + ">";
    }
    /**
    * to compare equality of two background images
    */
    @Override
    public boolean equals(Object o){
        if (o instanceof BackgroundImage)  { 
        
            BackgroundImage s = (BackgroundImage) o;   //type cast generic object
            
            if((this.title == s.getTitle() && this.description == s.getDescription() && this.imageFileName == s.getImageFileName())) {
                return true;
            }

        }
        
        return false;
    
    }
}
