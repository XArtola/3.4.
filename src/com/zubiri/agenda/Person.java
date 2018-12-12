package com.zubiri.agenda;
import java.util.Random;

/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
public class Person{

	private String name = "";
	private int age = 0;
	private int weight = 0;
	private String dni = "";
	private int height = 0;

	public Person(String name, int age, int weight, int height, String dni) {

		this.name = name;
		this.age = age;
		this.weight = weight;
		this.dni = dni;

	}

	public Person(String name, int age, int weight, int height) {

		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public Person(String name) {

		this.name = name;
		

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getName() {

		return name;

	}

	public void setAge(int age) {

		if (age > 0 && age < 130) {

			this.age = age;

		}

	}

	public int getAge() {

		return age;

	}

	public void setWeight(int weight) {

		if (weight > 5 && weight < 400) {

			this.weight = weight;
		}

	}

	public int getWeight() {

		return weight;

	}

	public void setDni(String dni) {

		if (dni.length() == 9) {

			this.dni = dni;

		}

	}

	public String getDni() {

		return dni;

	}
	public void setHeight(int height) {

		if (height > 30 && height < 220) {

			this.height = height;
		}

	}

	public int getHeight() {

		return weight;

	}

	/**
	 * @author ik013043z1
	 * This method will return true if the weight is ideal and false if it is not.
	 * To calculate this i use the formula weight(Kg)/height^2(m) were each value
	 * between 18 and 24 will be considered a good one
	 * 
	 * @param weight The weight of the person in Kg
	 * @param height The height of the person in Cm
	 * 
	 * @return true if the weight is ideal false if not
	 **/
	public boolean idealWeight(int weight, int height) {

		if (18 < weight / (height / 100) ^ 2 < 24)
			return true;
		else
			return false;

	}

	/**@author ik013043z1 
	 * This method will print all the info about the person object 
	 * @return String with info of the contact
	 * **/
	public String toString() {

		return "Name: " + name + " Age: " + Integer.toString(age) + " Weight: " + Integer.toString(weight) + " DNI: "
				+ dni + " Height: " + Integer.toString(height);

	}

	/** @author ik013043z1
	 * This method will create a String with a random number and a random letter
	 * 
	 **/

	public void dniByDefault() {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		if (dni.matches("")) {

			Random r = new Random();

			this.dni = Integer.toString((int)Math.round(Math.random() * (99999999 - 00000000) + 00000000))
					+ alphabet.charAt(r.nextInt(alphabet.length()-1));

		}

	}

	/**@author ik013043z1 
	 * This method sees if the age is under 18 or not 
	 * @return true if it is adult false if not
	 * **/
	public boolean isAdult() {

		if (age < 18)

			return false;
		else
			return true;

	}

}
