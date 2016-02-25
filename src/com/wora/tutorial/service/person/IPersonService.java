package com.wora.tutorial.service.person;

import java.util.ArrayList;

import com.wora.tutorial.bean.Person;

public interface IPersonService {

	public ArrayList<Person> findAll();

	public ArrayList<Person> search(String keyword);

}
