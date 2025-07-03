package Day2;

class MovieManagementSystem {
	static class Node{
		String Movie_title,Director;
		int year;
		double rating;
		Node next,prev;
		Node(String Movie_title,String Director,int year,double rating){
			this.Movie_title=Movie_title;
			this.Director=Director;
			this.year=year;
			this.rating=rating;
			this.next=null;
			this.prev=prev;
		}
	}
	public static Node head;
	public static Node tail;
	
	//function for add in start
	public static void add_First(String Movie_title,String Director,int year,double rating) {
		Node newNode=new Node(Movie_title,Director,year,rating);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
	}
	
	//function for add in end
	public static void add_Last(String Movie_title,String Director,int year,double rating) {
		Node newNode=new Node(Movie_title,Director,year,rating);
        if(head==null){
            tail=head=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        }
	
	//function for add in mid
	public void add_Mid(int idx,String Movie_title,String Director,int year,double rating){
        if(idx==0){
            add_First(Movie_title,Director,year,rating);
            return;
        }
        Node newNode=new Node(Movie_title,Director,year,rating);
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;    
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
	
	//Delete a Movie record by movie title
	public void movie_title_remove(String title) {
		Node temp=head;
		if(temp.Movie_title.equals(title)) {
			head=temp.next;
			temp.next=null;
			return;
		}
		while(temp.next!=null) {
			if(temp.next.Movie_title.equals(title)){
				temp.next=temp.next.next;
				return;
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid details");
	}
	
	
	//Search for a movie record by Director or rating
	public void Search_record(String Director, double rating) {
		Node temp=head;
		while(temp!=null) {
			if(temp.Director.equals(Director) || temp.rating==rating) {
				System.out.println("Movie title : "+temp.Movie_title);
				System.out.println("Director : "+temp.Director);
				System.out.println("Year of Release : "+temp.year);
				System.out.println("Rating : "+temp.rating);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid details");
	}
	
	//Display all Movie recorde
	public void DisplayDetails(Node head){
		if(head==null) {
			System.out.println("No data available");
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.println("Movie title : "+temp.Movie_title);
			System.out.println("Director : "+temp.Director);
			System.out.println("Year of Release : "+temp.year);
			System.out.println("Rating : "+temp.rating);
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			temp=temp.next;
		}
	}
	
	//update student's grade based on their Roll Number
	public void Update(String Movie_title,double rating) {
		Node temp=head;
		while(temp!=null) {
			if(temp.Movie_title.equals(Movie_title)) {
				temp.rating=rating;
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid deatils");
	}
	
	//Main method for testing
	public static void main(String[] args) {
		MovieManagementSystem mms=new MovieManagementSystem();
		mms.add_First("Jadu", "Deepu", 2004, 0.0);
		mms.add_First("Bewada","Deepanshu",2021,1.0);
		mms.add_Mid(1,"Besharam", "Bhavya", 2003, 5.0);
		mms.add_Last("Baniya","tarun",2025,3.5);
		
		mms.DisplayDetails(head);
	}
}