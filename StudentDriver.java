import java.util.Scanner;
import java.util.*; // just try catch

public class StudentDriver{
	public static void main (String [] args){
		Scanner reader = new Scanner(System.in);
	    StudentLinkedList studentLink = new StudentLinkedList();
	    StudentLinkNode readNode;
		StudentClass students;
		boolean diploma,short_semester =true; //need to check;
		int notional_credit,temp,id,currentStudentId=1;
		double marks;
		int choice;
		String name; //semester = " ";

		do {
			choice = getUserChoice();
			switch (choice){
				case 1 : {
					System.out.println("\nProgramme :  \n1.Diploma \n2.Degree");
					System.out.print("Your Choice : ");
					if(getInt()==1)
						{diploma = true;}
					else
						{diploma = false;}

					System.out.print("\nStudent name : ");
					name = reader.nextLine();
					id = currentStudentId;
					System.out.println("Student ID : " + id);
					currentStudentId++;

					System.out.println("\nSemester : \n1.Short semester. \n2.Long semester. ");
					System.out.print("Your Choice : ");
					temp = getInt();

					while(temp != 1 && temp != 2){
						System.out.println("You can only insert either 1 or 2");
						temp = getInt();
					}

					if(temp == 1)
						{short_semester = true;}

					else if(temp == 2)
						{short_semester = false;}

					// how about ELSE?

					System.out.print("\nStudent notional credits : ");
					notional_credit = getInt();

					// to prevent user to enroll short semester student with more than 11 notional credit
					if(short_semester){
						while(notional_credit>11){
							System.out.println("Sorry, the maximum national credits for short semester is 11.");
							System.out.print("Please reinput the student national credits : ");
							notional_credit=getInt();
						}
					}

					// to prevent user to enroll long semester student with more than 20 notional credit
					else{
						while(notional_credit>20){
							System.out.println("Sorry, the maximum national credits for long semester is 20.");
							System.out.print("Please reinput the student national credits : ");
							notional_credit=getInt();
						}
					}

					System.out.println("Record Created.\n");

					students = new StudentClass(name,id,notional_credit,diploma, short_semester);
					studentLink.insert(students);
					break;
				}

				case 2 :{
					System.out.print("The student ID : ");
					studentLink.addRecord(getInt());
				    break;
				}

				case 3:{
					System.out.print("The student ID : ");
					studentLink.modifyRecord(getInt());
					break;
				}

				case 4:{
					System.out.print("The student ID : ");
					studentLink.deleteRecord(getInt());
					break;
				}
				case 5 :
				{
					System.out.println("\nPlease choose what you want to view : \n1. Dean's List \n2. Under Probation \n3. Diploma List \n4. Degree List \n5. All List");
					System.out.print("Your Choice : ");
					switch(getInt()){
						case 1:{
							System.out.println("\nPlease choose the list that you want to display:\n1. Diploma student under Dean's List \n2. Degree student under Dean's List \n3. All student under Dean's List");
							System.out.print("Your choice : ");
							switch(getInt())
							{
								case 1:{
									studentLink.diplomaDeanList();
									break;}

								case 2:{
									studentLink.degreeDeanList();
									break;}

								case 3:{
									studentLink.diplomaDeanList();
									studentLink.degreeDeanList();
									break;}

								default:{break;}
							}
	                         break;}

						case 2:{
								System.out.println("Student under probation");
								studentLink.displayProbation();
								break;}
						case 3:{
								System.out.println("Please choose what Class Of Award you want to display : ");
								System.out.println("1. Distinction\n2. Upper Credit\n3. Lower Credit\n4. Pass\n5. Fail");
								System.out.print("Your choice : ");
								studentLink.displayDiplomaList(getInt());
								break;}

						case 4:{
								System.out.println("Please choose what Degree classyou want to display : ");
								System.out.println("1. First Class Honours\n2. Second Class Honours, Upper Division \n3. Second Class Honours, Lower Division \n4. Third Class Honours \n5. Fail");
								studentLink.displayDegreeList(getInt());
								break;}

						case 5:{
								studentLink.printAll(studentLink.getFirst());
								break;}
					}
					break;}

				case 6:{
					System.out.println("Thank you for using the system!");
					break;}

				default :{
					System.out.println("Sorry, you must input a number between 1-6!\n");
					break;}

			}
			} while (choice!= 6);
		}

	public static int getUserChoice(){
		System.out.println("Please choose your choice below : " );
		System.out.println("1. Create Record for new student");
		System.out.println("2. Input Mark ");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Display Records");
		System.out.println("6. Exit");
		System.out.print("Your choice : ");
		return getInt();
	}

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

} // END OF CLASS
