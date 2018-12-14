package com.zubiri.agenda;

import java.util.ArrayList;

import javax.management.ConstructorParameters;

/**
 * 
 */

/**
 * @author ik013043z1
 *
 * 
 * 
 * 
 */
public class Contact {

	private Person person1 = new Person("");
	private String number = "";
	private String address = "";

	private ArrayList<Note> notes = new ArrayList<Note>();
	
	private boolean favourite = false;

	public Contact(Person person1, String number, String address) {

		this.person1 = person1;
		this.number = number;
		this.address = address;

	}

	public void setPerson(Person person1) {

		this.person1 = person1;
	}

	public Person getPerson() {

		return person1;

	}

	public void setNumber(String number) {

		this.number = number;

	}

	public String getNumber() {

		return number;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public String getAddress() {

		return address;

	}

	public ArrayList<Note> getNotes() {

		return notes;

	}

	public void setNotes(ArrayList<Note> notes) {

		this.notes = notes;

	}
	
	public void setFavourite(boolean favourite) {
		
		this.favourite = favourite;
		
	}
	
	public boolean getFavourite() {
		
		return favourite;
		
	}
	
	/**@author ik013043z1
	 * 
	 * 
	 * @param note the note want to add
	 */

	public void addNote(Note note) {

		notes.add(note);

	}
	
	/**@author ik013043z1
	 * 
	 * 
	 * 
	 * @param index the position of the note we want to delete
	 */

	public void deleteNote(int index) {

		notes.remove(index);

	}
	
	/**@author ik013043z1
	 * @param index The place of the note to modify
	 * @param note The note to modify
	 */
	
	public void modifyNote(int index, Note note) {
		
		notes.set(index, note);
		
		
	}

	/**
	 * @author ik013043z1
	 * 
	 *         This method converts all the info of a contact to a string
	 * 
	 * @return String
	 */

	public String contactToString() {

		return person1.toString() + " Number: " + number + " Address: " + address;

	}

}
