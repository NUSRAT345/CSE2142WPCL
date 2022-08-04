import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String names[];
	public static String studentNames;
	public static Constant constant = new Constant();

	public static void ReadNames(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(constant.FileNmae)));
			studentNames = bufferedReader.readLine();
			names = studentNames.split(constant.split);
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
			for(String name : names) {
				System.out.println(name);
			}
            System.out.println(constant.dataLoaded);
        }
		else if(args[0].equals(constant.randomName)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			Random random = new Random();
			System.out.println(names[random.nextInt(names.length)]);
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.addName)){

			System.out.println(constant.dataLoad);
			ReadNames();
			studentNames = studentNames + constant.split + args[0].substring(1);
			DateFormat dateFormat = new SimpleDateFormat(constant.dateFormat);
			Write(studentNames + constant.lastUpdate + dateFormat.format(new Date()));
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.query)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			for(int idx = 0; idx<names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(constant.Found);
					break;
				}
			}

			System.out.println(constant.dataLoaded);
        }
		else if(args[0].contains(constant.countWords)) {

			System.out.println(constant.dataLoad);
			ReadNames();
			System.out.println(names.length + constant.wordsFound);
			System.out.println(constant.dataLoaded);
		}
		else {
			System.out.println(constant.Error);
		}
	}
}
