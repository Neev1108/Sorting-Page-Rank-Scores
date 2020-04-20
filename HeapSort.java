package Package;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HeapSort {

    
    private UrlPageRank eachUrl []; 
    private int Heapsize;    
    
//Basic constructor, creates an array with the PageRankScores so we can sort it
    HeapSort(UrlPageRank [] A){
        this.eachUrl = new UrlPageRank[A.length];
        this.Heapsize= A.length - 1;

        for(int i=1; i < eachUrl.length; i++){
            this.eachUrl[i] = A[i];
        }
      }
    public UrlPageRank[] returnEach() {
    	return this.eachUrl;
    
    }
    //Just a method to getUrl
    public UrlPageRank[] getUrl() {
        return eachUrl;
    }
    //Parent node
    public int parent(int i){
        return (int) Math.floor(i/2);
    }
//left child node
    public int left(int i){
        return 2 * i;
    }
//right child node
    public int right(int i){
        return 2*i+1;
    }
    //Standard Build Max Heap function 
    public void build_max_heap(UrlPageRank [] A){
        int n = Heapsize;
        for(int i = (int) Math.floor(n/2); i >= 1; i--){
            max_heapify(A,i);
        }

    }

    //method to maintain heap property, If left child node is greater than i's node then keeps largest as l. Basically meaning 
    //that there is swap, because the parent node is still larger. Repeat with right child node.
    //If the right or left child node is larger than i, it does the switch and then repeats with nodes higher up on the tree
    public void max_heapify(UrlPageRank [] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if(l<=Heapsize && A[l].getSum() > A[i].getSum()){
            largest=l;
        }
        else {largest = i; }
        if(r<=Heapsize && A[r].getSum()>A[largest].getSum()){
            largest=r;
        }
        if(largest!=i){
            UrlPageRank temp = A[i];
            A[i]=A[largest];
            A[largest]=temp;
            max_heapify(A,largest);
        }

    }
    
   

    

    //order array in accending order
    //To do the actual sort. Decrements down the heap and inserts the root into the last index of the array. Shifts indexes up and then
    //does maxheapify to make sure property is satisfied again and the ROOT IS THE LARGEST value in the array
    public void heap_sort(UrlPageRank [] A){
        int s= Heapsize;
        for(int i=s; i > 1; i--){
            UrlPageRank temp = A[1];
            A[1]=A[i];
            A[i]=temp;
            Heapsize-=1;
            max_heapify(A,1);
        }
    }

    //just returns the maximum of the heap in string form
    public String heap_maximum(UrlPageRank [] A){
        return A[1].getURL() + "     "  +A[1].getSum();
    }
    
    // removes and returns the max of array. It does by replacing the first element
    //with the last element and then making the last element null. The it calls max heapify to satisfy the max heap property
    public void heap_extract_max(UrlPageRank [] A) {
    	
    	if (Heapsize < 1) {
    		System.out.println("Heap underflow error");
    	}
        UrlPageRank max = A[1];
        A[1] = A[Heapsize];
        A[Heapsize] = null;
        Heapsize = Heapsize - 1;
        max_heapify(A,1);
        
    }

    
   //These next 2 methods are to just print the array, 1 for backwards and 1 for forwards
    public void print(UrlPageRank [] A){
    	int count=0;
        for(int i =A.length-1; i > 0; i--){
        	count++;
            System.out.println(count + " URL: " +A[i].getURL() +", PageRank: "+A[i].getSum());
        }
    }
    public void println(UrlPageRank [] A) {
    	int count = 0;
    	for (int i=1; i < A.length; i++) {
    		count++;
    		System.out.println(count + " URL: " +A[i].getURL() +", PageRank: "+A[i].getSum());
    	}
    }
  
    /* This insert method is complicated. I first created an object for the url inputted. Then I created an copied the elements of the array 
     * into an arraylist. I did this because I was having trouble creating memory for an array to insert another url so arraylist was much better
     * Then I added the object to this new arraylist. This object becomes a new element added to the heap, so I can now compare the parent node 
     * of the new object and swap if it's PageRank factor is less than the objects PageRank factor. I keep swapping until the object is 
     * in its rightful place where it still satisfies the heap property.
     * 
     */
    public void heap_insert (UrlPageRank A[ ], int value)
    {
        this.Heapsize = Heapsize + 1;
        heap_increase_key(A, Heapsize, value);
    }
    
      
    //To increase the key of an Url. Makes the PageRank sum of that Url into the parameter key. Then swaps with parent node if parent nodes PageRank
    //is less than it's page rank. This is done in a while loop until it is in its rightful place in the heap. 
    //Put an if statement in the beginning so the set sum method is not affected during the insert method.
    //
    public void heap_increase_key(UrlPageRank [] A, int i, int key){
    	if (i < 21)
       A[i].setSum(key);
        while(i > 1 && A[parent(i)].getSum() < A[i].getSum()){
            UrlPageRank temp = A[i];
            A[i] = A[parent(i)];
            A[parent(i)]= temp;
            i = parent(i);
        }

    }
    
    }



