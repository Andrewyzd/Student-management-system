public class StudentClass{

		public String name;
		public int id;
		public String StringID;
		public boolean diploma;
		public int notional_credits;
		public boolean short_semester;
		public String StringSemester;
		public double mark;
		public double average_mark=0.0;
		public String class_of_award;
		public int credit_counter=0;
		public int probation_counter;
		public int total_notional_credit = 0;

	/**
	 *default constructor to initialize value
	 */
		public StudentClass(){
			name = "null";
			id = 0;
			diploma = true;
			notional_credits = 0;
			short_semester = true;
			mark = 0.0;
		    class_of_award = "null";
		}

	/**
	 *overloaded constructor to initialize the data
	 *@param name the name of student
	 *@param id the identity number of student
	 *@param notional_credit the notional credit of the semester
	 *@param diploma the diploma to determine the programme if the student
	 *@param short_semester the semester to determine is long or short semester
	 */
		public StudentClass(String name, int id, int notional_credits, boolean diploma, boolean short_semester){
			this.name = name;
			this.id = id;
			setStringID(id);
			this.diploma = diploma;
			this.notional_credits = notional_credits;
			this.short_semester = short_semester;
			setStringSemester(short_semester);
		}

   /**
	 *setName() - mutator method to change the name of student
	 *@param name name of student
	 */
		public void setName(String name)
			{this.name = name;}

   /**
	 *setID() - mutator method to change the id of student
	 *@param  id id of student
	 */
		public void setID(int id){
			this.id = id;
			setStringID(id);
			}

   /**
	 *setStringID() - mutator method to generate the id of student
	 *@param  id id of student
	 */
		public void setStringID(int id)
			{this.StringID = String.format("%07d", id);}

   /**
	 *setStringDiploma() - mutator method to change the programme of student
	 *@param  diploma diploma of student
	 */
		public void setDiploma(boolean diploma)
			{this.diploma = diploma;}

   /**
	 *setNotionalCredit() - mutator method to change the notional credit of student
	 *@param  credits notional_credit of student
	 */
		public void setNotionalCredit(int credits)
			{this.notional_credits = credits;
			 setTotalNotionalCredit(credits);}

   /**
	 *setTotalNotionalCredit() - mutator method to change the total notional credit of student
	 *@param  credits total_notional_credit of student
	 */
		public void setTotalNotionalCredit(int credits){
			this.total_notional_credit += credits;
		}

   /**
	 *setShortSemester() - mutator method to change the type of semester of student
	 *@param  short_semester short_semester of student
	 */
		public void setShortSemester(boolean semester){
			this.short_semester = short_semester;
			setStringSemester(short_semester);
		}

   /**
	 *setStringSemester() - mutator method to determine the type of semester of student
	 *@param  short_semester short_semester of student
	 */
		public void setStringSemester(boolean short_semester){
			if (short_semester)
				StringSemester = "Short Semester";
			else
				StringSemester = "Long Semester";
		}
   /**
	 *setMark() - mutator method to change the GPA and mark of student
	 *@param  mark mark of student
	 */

		public void setMark(double mark){
			this.mark = mark;
			setAverageMark(mark);
		}
   /**
	 *setAverageMark() - mutator method to change the total mark of student
	 *@param  mark average_mark of student
	 */
		public void setAverageMark(double mark){
			this.average_mark += (mark*getNotionalCredit());
			setClassOfAward(average_mark/total_notional_credit);
		}

   /**
	 *setClassOfAward() - mutator method to change the class of award of student
	 *@param class of award of student
	 */
		public void setClassOfAward(double mark){
			if(getDiploma()){
				if(mark <=4.00 && mark >= 3.50)
					this.class_of_award = "Distinction";
				else if(mark <=3.49 && mark >= 3.00)
					this.class_of_award = "Upper Credit";
				else if(mark <=2.99 && mark >= 2.50)
					this.class_of_award = "Lower Credit";
				else if(mark <=2.49 && mark >= 2.00)
					this.class_of_award = "Pass";
				else if(mark < 2.00 && probation_counter ==1)
					this.class_of_award = "Fail,P1";
				else if(mark <2.00 && probation_counter == 2)
					this.class_of_award = "Fail, P2";
				else if(mark <2.00 && probation_counter == 3)
					this.class_of_award = "Fail, P3";
			}

			else if(!getDiploma()){
				if(mark >= 80.0 && mark <=100.0)
					 this.class_of_award = "First Class Honours";
				else if(mark <=79.0 && mark >= 70.0)
					this.class_of_award = "Second Class Honours, Upper Division";
				else if(mark <=69.0 && mark >= 60.0)
					this.class_of_award = "Second Class Honours, Lower Division";
				else if(mark <=59.0 && mark >= 50.0)
					this.class_of_award = "Third Class Honours";
				else if(mark <=49.0 && mark > 0.00)
				    this.class_of_award = "Fail";
			}
		}
   /**
	 *setCreditCounter() - mutator method to change the credit counter of student
	 *@param  credit_counter credit_counter of student
	 */
		public void setCreditCounter(int credit_counter)
			{this.credit_counter = credit_counter;}

   /**
	 *setProbationCounter() - mutator method to change the probation counter of student
	 *@param  probation_counter probation_counter of student
	 */
		public void setProbationCounter(int probation_counter )
			{this.probation_counter = probation_counter;}

	/**
	 *getName() - accessor method to get the name of student
	 *@return name of student
	 */
		public String getName()
			{return name;}

	/**
	 *getID() - accessor method to get the identity number of student
	 *@return id of student
	 */
		public int getID()
			{return id;}

	/**
	 *getStringID() - accessor method to get the identity number of student
	 *@return StringID of student
	 */
		public String getStringID(){
			return StringID;
		}

	/**
	 *getDiploma() - accessor method to determine the programme of student
	 *@return diploma of student
	 */
		public boolean getDiploma()
			{return diploma;}

	/**
	 *getNotionalCredit() - accessor method to get the notional credit of student
	 *@return notional_credits of student
	 */
		public int getNotionalCredit()
			{return notional_credits;}

	/**
	 *getShortSemester() - accessor method to determine the type of semester of student
	 *@return short_semester of student
	 */
		public boolean getShortSemester()
			{return short_semester;}

	/**
	 *getShortSemester() - accessor method to determine the type of semester of student
	 *@return StringSemester of student
	 */
		public String getStringSemester()
			{return StringSemester;}

	/**
	 *getMark() - accessor method to get the GPA and mark of student
	 *@return mark of student
	 */
		public double getMark()
			{return mark;}

	/**
	 *getAverageMark() - accessor method to get the CGPA and average mark of student
	 *@ return average_mark/total_notional_credit of student
	 */
		public double getAverageMark(){
			if(total_notional_credit==0)
				return 0.0;
			else
				return (average_mark/total_notional_credit);
		}

	/**
	 *getClassOfAward() - accessor method to get the class of award of student
	 *@return class_of_award of student
	 */
		public String getClassOfAward()
			{return class_of_award;}

	/**
	 *getCreditCounter() - accessor method to get the credit counter of student
	 *@return credit_counter of student
	 */
		public int getCreditCounter()
			{return credit_counter;}

	/**
	 *getProbationCounter() - accessor method to get the probation counter of student
	 *@return probation_counter of student
	 */
		public int getProbationCounter()
			{return probation_counter;}


    /**
      * The string representation is "Name = getName(), Student ID = getStringID(), Notional Credit = getNotionalCredit(), Type of Semester = getStringSemester(),
      * CGPA = getAverageMark(), Class of Award = getClassOfAward()";
      * Where getName() is the name of student, getStringID() is the identity number of student, getNotionalCredit() is the notional credits of semester
      * getStringSemester() is the type of semester of student, getAverageMark() is the CGPA and Mean Mark of student and getClassOfAward() is the class of award of student
      */
      @Override
		public String toString(){
			if(getDiploma()){
				return "\n[Name:" + this.getName()+"]"+"\t[Student ID: " + this.getStringID()+"]"+ "\t[Notional Credit: " + this.getNotionalCredit()+"]"+"\t[Type of Semester: "
			       + this.getStringSemester()+"]"+ "\t[CGPA: " + this.getAverageMark()+"]"+ "\t[Class of Award: " +this.getClassOfAward()+"]" +"\n";

			}
			else{
				return "\n[Name:" + this.getName()+"]"+"\t[Student ID: " + this.getStringID()+"]"+ "\t[Notional Credit: " + this.getNotionalCredit()+"]"+"\t[Type of Semester: "
			       + this.getStringSemester()+"]"+ "\t[Mean Mark: " + this.getAverageMark()+"%]"+ "\t[Class of Award: " +this.getClassOfAward()+"]" + "\n";
			}
		}
}