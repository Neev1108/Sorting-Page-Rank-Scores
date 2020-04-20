package Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class inputMain{

public static void main(String[] args){
	//Enter a Keyword
	  System.out.println("Please enter a keyword");
	  Scanner input = new Scanner(System.in);
	   String aKeyWord = input.nextLine();

	   //Create an array for the string and an array for the objects
	   String[] Urls = new String[31];    
	   UrlPageRank[] each = new UrlPageRank[31]; 

	   //Web Crawler Search
	   WebCrawler gSearch = new WebCrawler(aKeyWord);
       gSearch.search();

       //Put Urls into an array and print
       System.out.println("\n");
       Urls = gSearch.getUrls();
       int count = 0;
       for(int i = 0; i < 30; i++ ) {
    	   count++;
    	   System.out.println(count+ "." + Urls[i]);
       }
       
  //Fill the array with the objects relating to each url and PageRankSum
       for (int i = 1; i < 31; i++) {
           UrlPageRank ObjectForUrl = new UrlPageRank(Urls[i]);
           each[i] = ObjectForUrl;
       }
       
       //Asks user to input a url number to print PageRank scores and factors
   	System.out.println("Please enter a number between 1-30, "
   			+ "associated with each url to view it's PageRank scores: ");
   	int num = input.nextInt();
   	System.out.println(("Here are the PageRank scores for the website link:"
	 		+ " \nKW = The frequency and location of keywords within the web page \n"
	 		+ "Time = How long the web page has existed \n"
	 		+ "Links = The number of other web pages that link to the page in question\n"
	 		+ "Paid = The amount paid towards Search Engine Company"));
  
   	System.out.println( each[num-1].getURL() + "\n"+ each[num-1].returnPageFactor() + "\n This is your PageRank Sum: " + each[num-1].getSum());
	System.out.println("\n" + "\n");
       
       
   	
   	
       System.out.println("Type anything to display list sorted by Page Rank: ");
	String l = input.nextLine();
	//Perform heapsort methods to sort list
	   HeapSort heapsort = new HeapSort(each); //Creates an array of the integers
	   heapsort.build_max_heap(each); //sorts the Object arrays integer values
	   heapsort.heap_sort(each);
	   heapsort.print(each); //Prints object array with its Url and integer value
	       
	   //Builds new heap by reversing the array and counting up to 20, 
	   // the array has 21 spaces with the first being null for priority queue methods
	   System.out.println("Type anything to create new heap of 20 links: ");
		String h = input.nextLine();
	        UrlPageRank[] NewPage = new UrlPageRank[21];
	        for(int i= 1; i < NewPage.length; i++ ) {
	        	NewPage[i] = each[each.length - i];
	        }
	        
	        //Prints new heap and Creates new heap objects to make sure each priority queue method is different
	        HeapSort newHeap = new HeapSort(NewPage);
	        newHeap.println(NewPage);
	        UrlPageRank [] temp1 = NewPage.clone();
	        UrlPageRank[] temp2 = NewPage.clone();
	        UrlPageRank[] dummyArray = NewPage.clone();
	        HeapSort ExtractHeap = new HeapSort(temp1);
	        HeapSort increaseHeap = new HeapSort(temp2);
	        HeapSort InsertHeap = new HeapSort(dummyArray);
	        
	   
	        
	        //Extracting the max number. First ask to see max number and then extract it.
	        // Note. The print statement is different because the last element becomes null. 
	        System.out.println("Would you like to return the maximum number? ");
	         String s2 = input.nextLine();
	         System.out.println(ExtractHeap.heap_maximum(temp1));      
	         System.out.println("Would you like to extract top of heap?");
	  		 String s1 = input.nextLine();
	  		 ExtractHeap.heap_extract_max(temp1);
	  		 ExtractHeap.heap_sort(temp1);
	  		 int count3 = 0;
	  		 for (int i = temp1.length-2; i > 0; i--) { //Need to print differently because the last element becomes null after extraction
	  			 count3++;
	  			 System.out.println(count3 + " URL: " + temp1[i].getURL() +", PageRank: "+ temp1[i].getSum());
	  		 } 
	  		 
	  		 
				//Makes the array into an arraylist and then adds the new key into the end and
			     //converts it back into an array, then does the heap insert method. Insertion has parameters of value and the array itself.
		     	System.out.println("\nPlease enter a URL (will be inserted in orginal 20 link heap):");
			      String m = input.nextLine();
		  		 ArrayList<UrlPageRank> array = new ArrayList<>(Arrays.asList(dummyArray));
			      UrlPageRank newUrl = new UrlPageRank(m);
			      array.add(newUrl);
			      UrlPageRank [] NewObjectArray = new UrlPageRank[array.size()];
			      NewObjectArray = array.toArray(NewObjectArray);
			      InsertHeap.print(NewObjectArray); //good through here
			      InsertHeap.heap_insert(NewObjectArray, newUrl.getSum()); 
			      InsertHeap.heap_sort(NewObjectArray);
			      System.out.println("This is your inserted Url on the heap up above: "  ); 
			      System.out.println("Type anything to see new heap sorted: ");
				  String o = input.nextLine();
			      InsertHeap.print(NewObjectArray);
			      
			      
			      
			      
	  		 //Increase a key block, asks user to enter a url number and a value to increase that url's PageRank by. 
	        System.out.println("Please type anything to move onto increasing a key of the heap");
			String z = input.nextLine();
	        System.out.println("\n \n \n \n \n");
			increaseHeap.println(temp2);
			System.out.println("Please type a number corresponding to the Url to set its value (from the heap above): ");
	         int u = input.nextInt();
	         System.out.println("Please enter a value to change this Url's PageRank by (pick a large value):  ");
	         int u2 = input.nextInt();
	        increaseHeap.heap_increase_key(temp2, u, u2);
	        increaseHeap.heap_sort(temp2);
	     	increaseHeap.print(temp2);
	     
		
		      
			

			}
	        	

	}


			

