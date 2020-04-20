package Package;

public class UrlPageRank {
	//UrlPageRank object class
    private String URL;
    String url;
    int num;
    int NumofKeyWords = (int)(Math.random()*100)+1;;
    int TimeOfPage = (int)(Math.random()*100)+1;;
    int NumOfLinks =(int)(Math.random()*100)+1;;
    int AmountPaid= (int)(Math.random()*100)+1;;
    int sum;

    //To create an object 
    public UrlPageRank(String url){
        this.URL=url;
        this.sum= NumofKeyWords + TimeOfPage + NumOfLinks + AmountPaid;
    }
    
    public void putSum(int input) {
    	this.sum = input;
    }
    //sets the sum of the object, This is used to increase the key value
    public void setSum(int increase) {
    	this.sum = sum + increase;
    }
//Used throughout to generate the PageRankFactor number
    	public int getSum() {
    		return sum;
    	}
    	// return sum. This method is used after increasing the key
 
    
    public String getURL() {
        return URL;
    }
// return a toString of the object
    public String toString(UrlPageRank o) {
    	return " URL: " + getURL() +", PageRank: "+ getSum();
    }
    //returns all the PageRankFactors
    public String returnPageFactor() {
		return  "KW: " + NumofKeyWords + ", " + 
				"Time: " + TimeOfPage + ", " +
				"Links: " + NumOfLinks + " Days" + ", " +
				"Paid: " + AmountPaid;
	}
}

