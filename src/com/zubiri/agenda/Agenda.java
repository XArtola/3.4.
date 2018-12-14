package com.zubiri.agenda;

/**
 * 
 */
import java.util.ArrayList;

/**
 * @author ik013043z1
 *
 */
public class Agenda {

	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	public void setContacts(ArrayList<Contact> contacts) {

		this.contacts = contacts;

	}

	public ArrayList<Contact> getContacts() {

		return contacts;

	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method returns a specific contact of the agenda
	 * 
	 * @param index the index of the agenda
	 * @return A Contact type object that matches with the entered name
	 */

	public Contact getContact(int index) {

		return contacts.get(index);

	}

	/**
	 * @author ik013043z1
	 * 
	 * @param name
	 * @return An int with the value of the index
	 */

	public int findContact(String name) {

		return findIndex(name);

	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method will add a new contact to the agenda
	 * 
	 * @param A Contact type object that will be added to the ArrayList
	 */

	public void addContact(Contact contact1) {

		this.contacts.add(contact1);

	}

	/**
	 * @author ik013043z1 This method will delete a contact entering a the name of
	 *         it
	 * @param name The name of the contact we want to delete
	 */

	public void deleteContact(String name) {

		contacts.remove(findIndex(name));

	}

	/**
	 * @author ik013043z1 This method will delete a contact entering a the index of
	 *         it in the ArrayList
	 * 
	 * @param name The name of the contact we want to delete
	 */

	public void deleteContact(int index) {

		contacts.remove(index);
	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method updates a contact object in a specific place in the
	 *         ArrayList
	 * 
	 * @param contactName The name of the contact we want to modify
	 */

	public void modifyContact(Contact contact, int index) {

		contacts.set(index, contact);

	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method returns the number of contacts
	 * 
	 * @return An int type variable, the number of contacts
	 */

	public int size() {

		return contacts.size();

	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method will delete all the information stored in the ArrayList
	 *         contacts
	 */

	public void deleteAll() {

		contacts.clear();

	}

	/**
	 * @author ik013043z1
	 * 
	 * 
	 * @return a string with the numbered list of the contacts
	 */

	public String contactList() {

		String list = "";

		if (contacts.size() < 0) {

			for (int i = 0; i < contacts.size(); i++) {

				list = list + "\n" + i + "- " + contacts.get(i).getPerson().getName();

			}

		}

		else {

			list = "The agenda is empty";

		}

		return list;

	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method will reorder the contacts alphabetically
	 * 
	 */

	public void orderContacts() {

		ArrayList<Contact> orderedList = new ArrayList<Contact>();

		while (contacts.size() > 1) {

			int smallestIndex = 0;

			for (int a = 0; a < contacts.size(); a++) {

				if (contacts.get(smallestIndex).getPerson().getName()
						.compareTo(contacts.get(a).getPerson().getName()) < 0)

					smallestIndex = a;

			}

			orderedList.add(contacts.get(smallestIndex));
			contacts.remove(smallestIndex);

		}
		
		orderedList.add(contacts.get(0));		
		contacts = orderedList;

	}
	
	private int findIndex(String toFind) {

		boolean notFound = true;

		int cnt = 0;
		int index = 0;

		while ((notFound) && (cnt < contacts.size())) {

			if (contacts.get(cnt).getPerson().getName().matches(toFind)) {

				index = cnt;

				notFound = false;
			}

			cnt++;
		}

		if (notFound)

			index = -1;

		return index;
	}

}
