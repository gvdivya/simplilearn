package divya;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Locked_me {

	public static void main(String[] args) throws InputMismatchException {

		System.out.println("Welcome to Locked_me.com");
		System.out.println("Developed by Divya");

		System.out.println("Please enter the path where Folder need to be created \n");
		Scanner sc = new Scanner(System.in);

		String path = sc.nextLine();// Takes the directory path as the user input
		System.out.println("Please enter Folder name\n");
		String fname = sc.nextLine();// Takes the folder name as the user input
		File folder = new File((path) + "/" + fname);// folder is assigned with path with newly created folder
		if (folder.exists()) {// checking folder already exists are not
			System.out.println("Folder already exist");

		} else {

			folder.mkdir();// creates main folder on which operations to be performed

			System.out.println("Folder created\n\n");
		}

		String fpath = folder.getAbsolutePath();

		Main: // starting point of main menu .
		do {
			try {
				System.out.println("Main Menu\n");
				System.out.println("1.Display Files name in ascending order\n");
				System.out.println("2.Business-level operations\n");
				System.out.println("3.Close the application\n");
				// System.out.println("Please enter the path to perform the operations:");
				// String fpath = sc.nextLine();// perform operations on other path than user
				// created above
				File op = new File(fpath);
				File array[] = op.listFiles();
				System.out.println();
				System.out.println("Please enter your choice :\n");

				int choice = sc.nextInt();

				switch (choice) {
				case 1:

					List<String> lfile = Arrays.asList(op.list());
					if (array.length == 0) {
						System.out.println("Folder is Empty");
					} else {
						Collections.sort(lfile);// sorting file name in ascending order using collections as
												// array[i] is not in sorted order

						System.out.println("Sorting by filename in ascending order");
						System.out.println("---------------------------------------");
						for (String s : lfile) {
							System.out.println(s);
							System.out.println();
						}
						System.out
								.println("-----------------" + "Total No of files:" + array.length + "--------------");

						/*
						 * for (int i = 0; i < array.length; i++) { System.out.println(array[i]); }
						 */
					}
					break;

				case 2:

					while (true) {

						System.out.println("Enter your choice for Business-level operations:\n");
						System.out.println("1.Add File\n");
						System.out.println("2.Delete File\n");
						System.out.println("3.Search File\n");
						System.out.println("4.Back to main menu\n");
						System.out.println("5.close Application\n");
						int choice_2 = sc.nextInt();

						switch (choice_2) {
						case 1:

							System.out.println("Enter the file name to be created:\n");
							Scanner sc1 = new Scanner(System.in);
							String cfile = sc1.nextLine();// input file name from user
							File file1 = new File((fpath) + "/" + cfile);// path to create file in the above created
																			// folder
							if (file1.exists()) {
								System.out.println("file Exists\n");
							} else {
								try {
									file1.createNewFile();// creates new file
									System.out.println("file created\n");
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							break;

						case 2:
							System.out.println("Enter the file name to be deleted:\n");
							Scanner sc2 = new Scanner(System.in);
							String dname = sc2.nextLine();
							File file2 = new File((fpath) + "/" + dname);
							if (file2.exists()) {// checks if the exact file exists
								file2.delete();// Deletes file
								System.out.println("File deleted\n");
							} else {
								System.out.println("File dosen't exist\n");

							}
							break;

						case 3:
							System.out.println("Enter the file name to be Searched:\n");
							Scanner sc3 = new Scanner(System.in);
							String sname = sc3.nextLine();// search
							int count = 0;// to check file found or not if yes increment count

							for (int i = 0; i < array.length; i++) {
								if (array[i].getName().startsWith(sname)) // checks the files starting with the
																			// given
																			// name
								{
									System.out.println(array[i]);
									count++;// if file present increment count
								}
							}
							if (count > 0) {
								System.out.println(count + "  Files found\n");
							} else {
								System.out.println("File not found\n");
							}
							break;

						case 4:
							System.out.println("Back to Main Menu\n");
							continue Main;// will go back and continue to specific point where Main is mentioned

						case 5:
							System.out.println("Application closed\n");
							System.exit(0);// will exit the application
							break;

						default:
							System.out.println("Invalid choice back to previous menu \n");

							break;
						}

					}
				case 3:
					System.out.println("Application closed\n");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice back to main menu\n");
					break;

				}

			} catch (InputMismatchException ex) {
				System.out.println("Try again. (" + "Incorrect input: an integer is required)");
				sc.nextLine();
			}

		} while (true);
	}
}
