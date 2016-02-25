package com.wora.tutorial.service.person;

import java.util.ArrayList;

import com.wora.tutorial.bean.Person;

public class PersonService implements IPersonService {

	@Override
	public ArrayList<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Person> search(String keyword) {
		ArrayList<Person> persons = new ArrayList<>();

		for (int i = 0; i <= keyword.length(); i++) {
			Person person = new Person();

			person.setAge(keyword.length() * (i + 1));
			person.setName(keyword.toUpperCase() + (i + 1));
			person.setSurname(keyword.toUpperCase());

			if (i % 2 == 0) {
				person.setGender("MALE");
				person.setImageSource("/img/male.png");
			} else {
				person.setGender("FEMALE");
				person.setImageSource("/img/female.png");
			}

			persons.add(person);

		}

		return persons;
	}
}
