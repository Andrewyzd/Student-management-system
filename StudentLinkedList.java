import java.util.*;

public class StudentLinkedList{
	private StudentLinkNode first;

	public StudentLinkedList()
		{first = null;}

	public boolean isEmpty()
		{return (first==null);}

	public void insertFirst(StudentClass Student){
		StudentLinkNode studentNode = new StudentLinkNode(Student);
        studentNode.next = first;
        first = studentNode;
        }

	public void insert(StudentClass Student){
	    if(isEmpty())
	    {insertFirst(Student);}
        else{

        	if (Student.diploma)
        		{insertFirst(Student);}
        	else{
    			StudentLinkNode current = first;
    			while (current.next != null)
    			{current = current.next;}
	    		StudentLinkNode newLink = new StudentLinkNode(Student);
	    		current.next = newLink;
		    	}

        	}
	}

    public void addRecord(int studentID){
    	StudentLinkNode LinkNode = first;
    	double student_mark ;

		// looping to get the student with the entered student id
    	while(LinkNode != null){

    		if(LinkNode.Student.getID() == studentID){
    			break;
    		}

    		else if (LinkNode.next == null){
    			System.out.println("Sorry, this Student ID is not in the database.\n");
    			break;
    		}
    		else
    			LinkNode = LinkNode.next;
    	}

			// If the student is diploma
    		if (LinkNode.Student.getDiploma()){
    			System.out.print("Please input the student mark (0.0 - 4.0) : ");
    			student_mark = getDouble();

    			while(student_mark<0.0 || student_mark>4.0){
    					System.out.println("Sorry, for Diploma student the Minimum mark is 0.0 and Maximum is 4.0");
    				     student_mark = getDouble();
    				}

    			if(student_mark<2.0 && LinkNode.Student.getDiploma()){
				LinkNode.Student.setProbationCounter(LinkNode.Student.getProbationCounter()+1);}
	    		}

	    	else{
	    		System.out.print("Please input the student mark (0.0 - 100.0) : ");
    			student_mark = getDouble();

    			while(student_mark<0.0 || student_mark>100.0){
    					System.out.println("Sorry, for Degree student the Minimum mark is 0.0 and Maximum is 100.0");
    				     student_mark = getDouble();
    				}
	    	}
	    	LinkNode.Student.setAverageMarkCounter(LinkNode.Student.getAverageMarkCounter()+1);
    		LinkNode.Student.setMark(student_mark);
    		System.out.println("Mark added.\n");

    }

    public void modifyRecord(int studentID){
    	int current_national_credits;
    	double current_mark=0.0;
    	StudentClass student ;
    	String status = "";
    	StudentLinkNode LinkNode = first;

    	while(LinkNode.Student.getID() != studentID)
    		{LinkNode = LinkNode.next;}

		System.out.println("Please select an option to modify:\n1. Notional Credit \n2. Mark");
		System.out.print("Your Choice : ");
		switch(getInt()){
			case 1:{
					System.out.print("Enter the current notional credit : ");
					current_national_credits = getInt();
					while(current_national_credits<0){
					System.out.println("Error, The minimum notional credit is 0");
					System.out.print("Enter the current notional credit : ");
					current_national_credits = getInt();
					}
					LinkNode.Student.setNotionalCredit(current_national_credits);
					break;
				}

			case 2:{
					if(LinkNode.Student.getDiploma()){
						System.out.print("Enter the current GPA : ");
						current_mark = getDouble();

						while(current_mark>4.0 ||current_mark<0.0){
						System.out.println("Sorry, the maximum GPA is 4.0!");
						System.out.print("Enter the current GPA : ");
						current_mark = getDouble();
						}

					if(current_mark<2.0)
							{LinkNode.Student.setProbationCounter(LinkNode.Student.getProbationCounter()+1);}
					}

					else if(!LinkNode.Student.getDiploma()){
					System.out.print("Enter the current Mark : ");
					current_mark = getDouble();

					while(current_mark<0.0 ||current_mark>100.0){
					System.out.println("Sorry, the maximum Mean Mark is 100%!");
					System.out.print("Enter the current Mark : ");
					current_mark = getDouble();
					}

					}
					else
					{

					}
					LinkNode.Student.setMark(-LinkNode.Student.getMark());
					LinkNode.Student.setMark(current_mark);

					break;
					}

			default : {
				System.out.print("Sorry, this option is not provided : ");
				break;
			}
		}
    }

    public StudentLinkNode deleteFirst()
    {
        StudentLinkNode temp = first;
        first = first.next;
        return temp;
    }

    public void deleteRecord(int studentID){
    	StudentLinkNode previous = first;
    	StudentLinkNode post = first;

    	if(post.next == null)
    		{deleteFirst();}

    	else if(post.Student.getID() ==studentID && post.next!=null)
    		{deleteFirst();}

    	else if(post.Student.getID()== studentID && post.next.next==null)
    		{post.next = null;}

     	else{
     		while(post.Student.getID() != studentID){
     			previous = post;
     			post = post.next;
     		}
    		previous.next = post.next;
    	}
    	System.out.println("The student's record have been deleted successfully.");


    	// NEED TO ADD CODE IF THE ID IS NOT INDATABSE

    }

       public void displayDiplomaList(int choice){
    	StudentLinkNode LinkNode = first;

    	     if(LinkNode == null)
            {System.out.println("....<<No student yet>>....");}

         		else
         			{
         				if (choice == 1){
         					while (LinkNode != null){
         						if (LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Distinction"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}
         						else
         							LinkNode=LinkNode.next;
         					}

         				}
         				else if (choice == 2){
         					while (LinkNode != null){
         						if (LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Upper Credit"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}
         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}
         						else
         							LinkNode=LinkNode.next;

         					}

         				}

         				else if (choice == 3){
         					while (LinkNode != null){
         						if (LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Lower Credit"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}

         				else if (choice == 4){
         					while (LinkNode != null){
         						if (LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Pass"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}

         				else if (choice == 5){
         					while (LinkNode != null){
         						if (LinkNode.Student.diploma && LinkNode.Student.getAverageMark()<2.00 && LinkNode.Student.getAverageMark()!=0.0){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}
         				else
         					System.out.print("error");
         			}
    }

    public void displayDegreeList(int choice){
    	StudentLinkNode LinkNode = first;

    	 if(LinkNode == null)
            {System.out.println("....<<No student yet>>....");}

         		else
         			{
         				if (choice == 1){
         					while (LinkNode != null){
         						if (!LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "First Class Honours"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}
         				else if (choice == 2){
         					while (LinkNode != null){
         						if (!LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Second Class Honours, Upper Division"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}
         				else if (choice == 3){
         					while (LinkNode != null){
         						if (!LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Second Class Honours, Lower Division"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}

         				else if (choice == 4){
         					while (LinkNode != null){
         						if (!LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Third Class Honours"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}

         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}

         				else if (choice == 5){
         					while (LinkNode != null){
         						if(!LinkNode.Student.diploma && LinkNode.Student.getClassOfAward() == "Fail"){
         							LinkNode.displayLink();
         							LinkNode=LinkNode.next;
         							continue;
         						}


         						else if (LinkNode.next == null){
         							System.out.println("....<<No student yet>>....\n");
         							break;
         						}

         						else
         							LinkNode=LinkNode.next;
         					}

         				}
         				else
         					System.out.print("error"); // change this one
         			}
    }

    public void diplomaDeanList(){
    	System.out.println("\nList of Diploma Student under Dean's List : \n");
    	StudentLinkNode LinkNode = first;

    	if(LinkNode == null)
            {System.out.println("....<<No student yet>>....\n");}

        else {
        	while(LinkNode != null){
	        	if(LinkNode.Student.getAverageMark()>3.80 && (LinkNode.Student.getNotionalCredit()>=12 && !LinkNode.Student.getShortSemester()) || (LinkNode.Student.getNotionalCredit()>=6 && LinkNode.Student.getShortSemester())){
		       		LinkNode.displayLink();
		       		LinkNode = LinkNode.next;
		       		continue;
        		}
        		else if (LinkNode.next == null){
        			System.out.println("....<<No student yet>>....\n");
        			break;
        		}
        		else
	        		LinkNode = LinkNode.next;
       		}
        }
	}

	public void degreeDeanList(){
		System.out.println("\nList of Degree Student under Dean's List : \n");
    	StudentLinkNode LinkNode = first;

		if(LinkNode == null)
            {System.out.println("....<<No student yet>>....");}
        else {
        	while(LinkNode != null){
	        	if(LinkNode.Student.getAverageMark()>80.0 && (LinkNode.Student.getNotionalCredit()>=12 && !LinkNode.Student.getShortSemester()) || (LinkNode.Student.getNotionalCredit()>=6 && LinkNode.Student.getShortSemester())){
	        	LinkNode.displayLink();
	        	LinkNode = LinkNode.next;
		       	continue;
	        	}
	        	else if (LinkNode.next == null){
	        		System.out.println("....<<No student yet>>....\n");
	        		break;
	        	}
	        	else
        			LinkNode = LinkNode.next;
        	}
        }
	}

    public void displayProbation(){
    	StudentLinkNode LinkNode = first;
    	if(LinkNode == null)
            {System.out.println("....<<No student yet>>....");}
        else {
            while(LinkNode!=null){
	    		if(LinkNode.Student.diploma && LinkNode.Student.getProbationCounter()>0 && LinkNode.Student.getAverageMark()<2.0){
	    			LinkNode.displayLink();
	        		LinkNode = LinkNode.next;
	    		}
	    		else if (LinkNode.next == null){
	        		System.out.println("....<<No student yet>>....\n");
	        		break;
	        	}
	        	else
        			LinkNode = LinkNode.next;
	    	}
        }
    }

    public void printAll(StudentLinkNode readNode){
     	if (readNode == null)
     	    {return;}
       	readNode.displayLink();
       	printAll(readNode.next);
    }

    public StudentLinkNode getFirst()
   		 {return first;}

   	public static int getInt(){
		Scanner reader = new Scanner(System.in);
		int input=0; // SHOULD 0?
		boolean repeat;
		do{
			repeat =false;
			try{
				input = reader.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Sorry, you have entered an invalid data type.");
				//MUST ADD SOMETHING
				repeat =true;
				reader.nextLine();
			}
		}while(repeat);
		return input;
	}

	public static double getDouble(){
			Scanner reader = new Scanner(System.in);
			double input=0; // SHOULD 0?
			boolean repeat;
			do{
				repeat =false;
				try{
					input = reader.nextDouble();
				}catch(InputMismatchException e){
					System.out.println("Sorry, you have entered an invalid data type.");
					//MUST ADD SOMETHING
					repeat =true;
					reader.nextLine();
				}
			}while(repeat);
			return input;
	} // end of getDouble


}