
/**
 * 
 */

import java.lang.module.FindException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.zubiri.agenda.Agenda;
import com.zubiri.agenda.Contact;
import com.zubiri.agenda.Person;

/**
 * @author ik013043z1
 *
 */
public class mainInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finish = false;

		Agenda myAgenda = new Agenda();

		int option = 0;
		
		System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
		
		for(int i =0; i< myAgenda.size(); i++) {
			
			String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
			
			
			String todaySplit[] = today.split("-");
			
			if(myAgenda.getContact(i).getBirthday().get(Calendar.DAY_OF_MONTH)==Integer.parseInt(todaySplit[2]))
				
				if(myAgenda.getContact(i).getBirthday().get(Calendar.MONTH) == Integer.parseInt(todaySplit[1]))
					
					System.out.println("Today is " +myAgenda.getContact(i).getPerson().getName() + "´s birthday." + "He/she becomes "+ (Integer.parseInt(todaySplit[0])- myAgenda.getContact(i).getBirthday().get(Calendar.YEAR)));
				
				
		} 

		while (!finish) {

			System.out.println("Hello, welcome to the digital agenda. This is what you are able to do:"
					+ "\n\t 1- See an specific contact" + "\n\t 2- How many contacts do i have?"
					+ "\n\t 3- Delete a contact" + "\n\t 4- Modify a contact" + "\n\t 5- Add a new contact"
					+ "\n\t 6- Delete all the information" + "\n\t 7- Set a birthday" + "\n\t 8- Close the agenda"
					+ "\n Choose an option by its number [1-8]");

			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:

				System.out.println("Enter the name of the contact you want to see:");
				System.out.println(myAgenda.getContact(myAgenda.findContact(sc.next())).contactToString());
				break;

			case 2:

				System.out.println("You have " + myAgenda.size() + " contacts.\n");
				break;

			case 3:

				System.out.println("Enter the name of the contact you want to delete");
				String toDelete = sc.next();
				sc.nextLine();
				System.out.println("Are you sure you want to delete it? [y/n]");
				switch (sc.next().charAt(0)) {

				case 'y':

					myAgenda.deleteContact(toDelete);

					break;

				default:

					System.out.println("The contact has not been deleted");
					break;

				}

				break;

			case 4:

				System.out.println("Enter the name of the contact you want to modify");
				String toModifyName = sc.next();
				Contact toModify = myAgenda.getContact(myAgenda.findContact(toModifyName));
				System.out.println("What do you want to change?\n" + "1- Name\n" + "2- Age\n" + "3- Weight\n"
						+ "4- DNI\n" + "5- Height\n" + "6- Number\n" + "7- Address\n");

				switch (sc.nextInt()) {

				case 1:

					System.out.println("The Name of the contact is: " + toModify.getPerson().getName()
							+ ". Please enter the new name:");
					toModify.getPerson().setName(sc.next());
					System.out.println("The new Name of the contact is: " + toModify.getPerson().getName() + ".");
					break;

				case 2:

					System.out.println("The Age of the contact is: " + toModify.getPerson().getAge()
							+ ". Please enter the new age:");
					toModify.getPerson().setAge(sc.nextInt());
					System.out.println("The new Name of the contact is: " + toModify.getPerson().getAge() + ".");
					break;

				case 3:

					System.out.println("The Weight of the contact is: " + toModify.getPerson().getWeight()
							+ ". Please enter the new weight:");
					toModify.getPerson().setWeight(sc.nextInt());
					System.out.println("The new Name of the contact is: " + toModify.getPerson().getWeight() + ".");
					break;

				case 4:

					System.out.println("The DNI of the contact is: " + toModify.getPerson().getDni()
							+ ". Please enter the new dni:");
					toModify.getPerson().setDni(sc.next());
					System.out.println("The new Name of the contact is: " + toModify.getPerson().getDni() + ".");
					break;

				case 5:

					System.out.println("The DNI of the contact is: " + toModify.getPerson().getHeight()
							+ ". Please enter the new height:");
					toModify.getPerson().setHeight(sc.nextInt());
					System.out.println("The new Name of the contact is: " + toModify.getPerson().getHeight() + ".");
					break;

				case 6:

					System.out.println(
							"The Number of the contact is: " + toModify.getNumber() + ". Please enter the new number:");
					toModify.setNumber(sc.next());
					System.out.println("The new Name of the contact is: " + toModify.getNumber() + ".");
					break;

				case 7:

					System.out.println("The Address of the contact is: " + toModify.getAddress()
							+ ". Please enter the new address:");
					toModify.setAddress(sc.next());
					System.out.println("The new Name of the contact is: " + toModify.getAddress() + ".");
					break;

				}

				myAgenda.modifyContact(toModify, myAgenda.findContact(toModifyName));

				break;

			case 5:

				System.out.println("Enter the new contact info in the next way: Name Number Address"
						+ "\n Ex. Xabier 99999999 Lasarte");

				String[] collectedData = sc.nextLine().split(" ");
				Person person1 = new Person(collectedData[0]);
				Contact contact1 = new Contact(person1, collectedData[1], collectedData[2]);

				myAgenda.addContact(contact1);
				break;

			case 6:

				myAgenda.deleteAll();
				break;

			case 7:
				
				System.out.println("What contacts birthday do you want to set?");
				
				Contact contact = myAgenda.getContact(myAgenda.findContact(sc.next()));
				sc.nextLine();
				System.out.println("Enter the birthday in th enext way year month day. Ex. 2018 12 17");
				Calendar birthday = null;
				birthday.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
				contact.setBirthday(birthday);
				myAgenda.modifyContact(contact, myAgenda.findContact(contact.getPerson().getName()));

			case 8:

				finish = true;
				break;

			default:

				System.out.println("This is not a correct option please enter another one. [1-8]");

				option = sc.nextInt();

			}

		}

	}

}