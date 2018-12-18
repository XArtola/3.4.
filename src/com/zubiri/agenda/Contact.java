package com.zubiri.agenda;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	
	private Calendar birthday;

	private ArrayList<Note> notes = new ArrayList<Note>();
	
	private boolean favorite = false;

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
	
	public void setFavourite(boolean favorite) {
		
		this.favorite = favorite;
		
	}
	
	public boolean getFavorite() {
		
		return favorite;
		
	}
	
	public Calendar getBirthday() {
		
		return birthday;
		
		
	}
	
	public void setBirthday(Calendar birthday) {
		
		this.birthday = birthday;
		
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
	
	/**@author ik013043z1
	 * 
	 * 
	 * @return true if the computers date is the same as the birthday false if not
	 */
	

	public boolean isBirthday() {
		
		boolean isBirthday = false;
		
		String today = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		
		String todaySplit[] = today.split("-");
		
		if(birthday.get(Calendar.DAY_OF_MONTH)==Integer.parseInt(todaySplit[2]))
			
			if(birthday.get(Calendar.MONTH) == Integer.parseInt(todaySplit[1]))
				
				isBirthday = true;
		
		return isBirthday;
	
			
			
	} 

}
