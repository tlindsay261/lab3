package lab3;

import java.util.Scanner;
import java.util.ArrayList;

public class Student{
    private String program;
    private String year;
    private int avgGrade;

    
    /** 
     * @param studentProgram
     */
    //set program value
    public void setProgram(String studentProgram){
        program = studentProgram;
    }
    
    /** 
     * @param studentYear
     */
    //set year value
    public void setYear(String studentYear){
        year = studentYear;
    }
    
    /** 
     * @param studentGrade
     */
    //set avggrade value
    public void setGrade(int studentGrade){
        avgGrade = studentGrade;
    }
    //print program
    public void printProgram(){
        System.out.println("Program: " + program);
    }
    //print year
    public void printYear(){
        System.out.println("Year: " + year);
    }
    //print grade
    public void printGrade(){
        System.out.println("Average Grade: " + avgGrade + "%");
    }
    
    /** 
     * @param avg
     * @param count
     */
    //print avg grade of class
    public void printAvg(int avg, int count){
        //divide avg by count to get real avg
        avg = avg/count;

    }
    
    /** 
     * @param count
     */
    //print size of class
    public void printClassSize(int count){
        //print count
        System.out.println("The class size is: " + count);
    }

    public void printClassInfo(){
            System.out.println("Program: " + program);
            System.out.println("Year: " + year);
            System.out.println("Average Grade: " + avgGrade + "%");
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args){
        //Set number for menu, count for student number, and arraylist to hold students
        String grade;
        String number = new String();
        ArrayList<Student> students = new ArrayList<Student>();
        //start menu loop
        while (! number.equals("5")) {
            //print menu
            System.out.print("\n(1) Enter information for a new student.\n(2) Show all student information with program, year, and average grade.\n(3) Print the average grades for class and the total number of students.\n(4) Enter a specific program and show all student information for that program.\n(5) End program.\nEnter a number corresponding to a menu option: ");
            //get input from user for menu option
            Scanner user_Input = new Scanner(System.in);
            number = user_Input.nextLine();
            //if first menu option is chosen
            if (number.equals("1")) {
                //get input from user and split it into program and year separately
                System.out.print("\nEnter the student program and year: ");
                Scanner sentence_Input = new Scanner(System.in);
                String sentence = sentence_Input.nextLine();
                String separate[] = sentence.split("[ ]+");
                //Check for length to be correct, if it isnt ask to correct
                while (separate.length != 2){
                    System.out.print("Error. You have entered too little or too much information, please try again.\n");
                    System.out.print("\nEnter the student program and year: ");
                    sentence = sentence_Input.nextLine();
                    separate = sentence.split("[ ]+");
                }
                //create new student object in array and set program, year, and grade
                Student newStudent = new Student();
                newStudent.setProgram(separate[0]);
                newStudent.setYear(separate[1]);
                //ask for grade separately
                System.out.print("\nEnter the average grade(optional: default 0%): ");
                sentence_Input = new Scanner(System.in);
                //input grade into newStudent object
                grade = sentence_Input.nextLine();
                if(grade.equals("")){
                    newStudent.setGrade(0);
                }
                else{
                    int gradeInt = Integer.parseInt(grade);
                    newStudent.setGrade(gradeInt);
                }

                students.add(newStudent);
            }
            //if menu option 2
            else if (number.equals("2")) {
                for(int i=0; i < students.size(); i++){
                    Student curr = students.get(i);
                    curr.printProgram();
                    curr.printYear();
                    curr.printGrade();
                }
            }
            //if option 3
            else if (number.equals("3")) {
                //initialize count and avg variables for final answers
                int avg = 0;
                int count = 0;
                //get input from user to find program they are looking for
                System.out.print("\nEnter the program you are looking for: ");
                Scanner sentence_Input = new Scanner(System.in);
                String sentence = sentence_Input.nextLine();
                //step through students
                for(int i=0; i < students.size(); i++){
                    //get grade for each student in set program
                    Student curr = students.get(i);
                    if(curr.program.equals(sentence)){
                        //add grades up
                        avg += curr.avgGrade;
                        //increment count for each student
                        count +=1;
                    }
                }
                //find real avg
                avg = avg/count;
                //print the avg
                System.out.println("The class average is: " + avg);
                //print the avg
                System.out.println("The class size is: " + count);
            }
            //if option 4
            else if (number.equals("4")) {
                //get input from user to find program
                System.out.print("\nEnter the program you are looking for: ");
                Scanner sentence_Input = new Scanner(System.in);
                String sentence = sentence_Input.nextLine();
                //step through students
                for(int i=0; i < students.size(); i++){
                    Student curr = students.get(i);
                    if(curr.program.equals(sentence)){
                        curr.printClassInfo();
                    }
                }
            }
            else if (number.equals("5")){
                break;
            }
            else {
                System.out.print("\nPlease enter a valid option: \n\n");
            }
        }
    }
}
    