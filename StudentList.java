import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static BufferedReader bufferedReader;
	public static String studentNames;
	public static Constant constant = new Constant();

	public static void ReadNames(){
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(constant.FileNmae)));
			studentNames = bufferedReader.readLine();
		} catch(Exception e){

		}
	}

	public static void Write(String updateText){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(constant.FileNmae, false));
			bufferedWriter.flush();
			bufferedWriter.write(updateText);
			bufferedWriter.close();
		} catch(Exception e) {

		}
	}
	public static void main(String[] args) {

//		Check arguments
		if (args.length != 1) {
			System.out.println(constant.Error);
			System.exit(1);
		}
		if(args[0].equals(constant.showNames)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			String names[] = studentNames.split(constant.split);
			for(String name : names) {
				System.out.println(name);
			}
            System.out.println(constant.dataLoaded);
        }
		else if(args[0].equals(constant.randomName)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			String names[] = studentNames.split(constant.split);
			Random random = new Random();
			int randomIndex = random.nextInt(names.length);
			System.out.println(names[randomIndex]);
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.addName)){

			System.out.println(constant.dataLoad);
			ReadNames();
			String student = args[0].substring(1);
			studentNames = studentNames + constant.split + student;
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat(constant.dateFormat);
			String fd= dateFormat.format(date);
			String updateText = studentNames + constant.lastUpdate + fd;
			Write(updateText);

			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.query)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			String names[] = studentNames.split(constant.split);
			boolean done = false;
			String student = args[0].substring(1);
			for(int idx = 0; idx<names.length && (!done); idx++) {
				if(names[idx].equals(student)) {
					System.out.println(constant.Found);
					done=true;
				}
			}
			if (!done) {
				System.out.println(constant.notFound);
			}

			System.out.println(constant.dataLoaded);
        }
		else if(args[0].contains(constant.countWords)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			char array[] = studentNames.toCharArray();
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
			System.out.println(count + constant.wordsFound);
			System.out.println(constant.dataLoaded);
		}
		else {
			System.out.println(constant.Error);
		}
	}
}