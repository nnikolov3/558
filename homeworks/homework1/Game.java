/**
 * Provided for HW1.
 */

public class Game {

    /**
     * Attribute
     */ 
    private String mDescription;
    
    /**
     * Constructor
     */ 
    public Game(String description) {
        setDescription(description);
    }

    /**
     * Getter for Description
     */ 
    public String getDescription() {
        return mDescription;
    }

    /**
     * Setter for Description
     */ 
    public void setDescription(String description) {
        mDescription = description;
    }

    public String toString() {
        return(“description: “ + mDescription);
    }
}
