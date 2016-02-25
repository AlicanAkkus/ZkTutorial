package com.wora.tutorial.person.controller;

import java.util.ArrayList;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.wora.tutorial.bean.Person;
import com.wora.tutorial.service.person.PersonService;

public class PersonSearchController extends SelectorComposer<Component> {

	PersonService personService = new PersonService();

	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox personListbox;
	@Wire
	private Label nameLabel;
	@Wire
	private Label surnameLabel;
	@Wire
	private Label ageLabel;
	@Wire
	private Label genderLabel;
	@Wire
	private Image genderImage;

	@Listen("onClick = #searchButton")
	public void search() {
		String keyword = keywordBox.getValue();
		ArrayList<Person> result = personService.search(keyword);
		personListbox.setModel(new ListModelList<Person>(result));
	}

	@Listen("onSelect = #personListbox")
	public void showDetail() {
		Person selected = personListbox.getSelectedItem().getValue();
		nameLabel.setValue(selected.getName());
		surnameLabel.setValue(selected.getSurname());
		ageLabel.setValue(selected.getAge() + "");
		genderLabel.setValue(selected.getGender());
		genderImage.setSrc(selected.getImageSource());
	}
}
