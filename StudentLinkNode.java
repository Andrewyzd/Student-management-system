public class StudentLinkNode
{
    public StudentClass Student; // data item
    public StudentLinkNode next; // next link in list

    public StudentLinkNode(StudentClass Student) // constructor
    {
         // initialize data
        this.Student = Student;
        // (next is automatically set to null)
    }

    public void displayLink()
    	{System.out.println(Student.toString());}

}