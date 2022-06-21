import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String studentNames = bufferedReader.readLine();
				String names[] = studentNames.split(", ");
				for(String name : names) {
					System.out.println(name);
				}
            } catch (Exception e){

            }
            System.out.println("Data Loaded.");
        }
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			   String studentNames = bufferedReader.readLine();
			   String names[] = studentNames.split(",");
			   Random random = new Random();
               int randomIndex = random.nextInt(names.length);
               System.out.println(names[randomIndex]);
			} catch (Exception e){

            }
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String studentNames = bufferedReader.readLine();
				String student = args[0].substring(1);
				studentNames = studentNames + ", " + student;
				bufferedReader.close();

			    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", false));
			    bufferedWriter.flush();
	            Date date = new Date();
                String dateForm = "dd/mm/yyyy-hh:mm:ss a";
	            DateFormat dateFormat = new SimpleDateFormat(dateForm);
	            String formsteOfDate= dateFormat.format(date);

                bufferedWriter.write(studentNames +"\nList last updated on "+formsteOfDate);
                bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			    String studentNames = bufferedReader.readLine();
			    String names[] = studentNames.split(", ");
			    boolean done = false;
			    String student = args[0].substring(1);
			    for(int idx = 0; idx<names.length && (!done); idx++) {
				    if(names[idx].equals(student)) {
					    System.out.println("We found it!");
                        done=true;
				    }
			    }
                if (!done) {
                    System.out.println("Not found!");
                }
			} catch (Exception e){

            }
			System.out.println("Data Loaded.");
        }
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String read = bufferedReader.readLine();
                char array[] = read.toCharArray();
                boolean in_word = false;
                int count=0;
			    for(char character : array) {
				    if(character == ' ' && in_word) {
                       count++;
                       in_word = false;
				    }
                    else {
                        in_word = true;
                    }
			    }
                if (in_word) {
                    count++;
                }
			    System.out.println(count +" word(s) found ");
			} catch (Exception e){

            }
			System.out.println("Data Loaded.");				
		}
	}
}