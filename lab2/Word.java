package lab2;

public class Word {
	protected String theWord;
    protected int counts;
    protected static int outputFormat;

    //Constructor
    Word(String w) {theWord = w; counts = 0; outputFormat = 0;}

    //Member functions
    public String getWord(){ return theWord; }
    public int getCounts() { return counts; }
    public void increaseCounts() { counts++; }
    public void changeOutputFormat(int i) { outputFormat = i; }
    
    public String toString() {
    	if(outputFormat == 0) {
    		return "The word is :" + theWord; 
    	}else if(outputFormat == 1) {
    		return "The word " + theWord + " has occured " + counts + " times";
    	}else {
    		return "";
    	}
    }


}
