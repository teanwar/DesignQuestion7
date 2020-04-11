import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = "";
		String ptype = "";
		int option = 1;
		SecurityCheckLine line = new SecurityCheckLine();

		while (option < 7 && option > 0) {
			System.out.print("************************************************************\n");
			System.out.print("Please choose one of the following options:\n");
			System.out.print("1. Add new person\n");
			System.out.print("2. Get the first person from line without removing it\n");
			System.out.print("3. Return the first person from line and remove it\n");
			System.out.print("4. Get number of people in line\n");
			System.out.print("5. Get number of people in line with high priority\n");
			System.out.print("6. Exit\n");
			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.print("   Enter name of the person: ");
				name = sc.next();
				System.out
						.print("   Choose one of following types for this person\n 1. Staff \t 2. VIP \t 3. Regular\n");
				int pt = sc.nextInt();
				if (pt == 1)
					ptype = "staff";
				else if (pt == 2)
					ptype = "VIP";
				else
					ptype = "regular";
				line.AddPerson(name, ptype);
				System.out.print(name + " is added to line.\n");
				break;
			case 2:
				if (line.Size() == 0)
					System.out.print("The line is empty.\n");
				else
					System.out.print(line.GetFirst() + "\n");
				break;
			case 3:
				if (line.Size() == 0)
					System.out.print("The line is empty.\n");
				else
					System.out.print(line.Pop() + "\n");
				break;
			case 4:
				System.out.print("There are " + line.Size() + " people in the line.\n");
				break;
			case 5:
				System.out.print("There are " + line.PriorityLineSize() + " people with high priority in the line.\n");
				break;

			default:

				break;

			}
		}

		System.out.print("Thank you for using this program.\n exiting ....");
	}
}
