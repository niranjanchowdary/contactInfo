package com.contact;

import java.util.Arrays;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class ContactsStore {
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();;
	static Key key;

	static Entity contact;

	// adding contact to contacts
	public static boolean addContact(String name, String phno, String phno1, String email, String email1,
			String address) {
		Entity user = getId(name);
		if (user == null) {

			System.out.println(name + phno + phno1 + email + email1 + address);
			try {
				Entity contact = new Entity("name", name);
				contact.setProperty("mobile", phno);
				contact.setProperty("home", phno1);
				contact.setProperty("email", email);
				contact.setProperty("email-1", email1);
				contact.setProperty("address", address);
				// persisting data
				datastore.put(contact);
			} catch (NullPointerException e) {
				System.out.println("happend");
			}

			// return true if data persisted
			return true;
		} else {
			// return false if the data is not persisted
			System.out.println("sorry");
			return false;
		}

	}

	// editing contact info logic
	public static boolean editContact(String name, String option, String value) {
		Entity user = getId(name);
		if (user != null) {
			// edit properties
			user.setProperty(option, value);

			datastore.put(user);
			// return true if edited
			return true;
		} else
			// return false if not edited
			return false;
	}

	// fetching entity from data store logic
	private static Entity getId(String name) {
		// TODO Auto-generated method stub
		key = KeyFactory.createKey("name", name);
		System.out.println(key + " key");
		Entity e = datastore.get(Arrays.asList(key)).get(key);
		System.out.println(e);

		// check entity whether it is null or not if null return null
		if (e == null)

		{
			System.out.println("return true");
			return null;
		}
		// else return entity
		else {
			System.out.println("false");
			return e;
		}
	}

	// deleting contact logic
	public static boolean deleteContact(String name, String option) {
		Entity user = getId(name);
		// TODO Auto-generated method stub
		Key op = KeyFactory.createKey("" + option + "", name);
		if (user != null) {
			System.out.println(op);
			user.removeProperty(option);
			datastore.put(user);
			if (option.equals("name")) {
				datastore.delete(op);
				System.out.println("del");
			}

			// return true if data deleted
			return true;
		}
		// else return false
		else
			return false;
	}

	public static Entity searchCon(String name) {
		// TODO Auto-generated method stub
		key = KeyFactory.createKey("name", name);
		System.out.println(key + " key");
		Entity e = datastore.get(Arrays.asList(key)).get(key);
		System.out.println(e);
		if (e != null)
			return e;
		else
			return null;
	}
}
