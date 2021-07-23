package com.accela.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.accela.entities.Address;
import com.accela.repositories.AddressRepository;
import com.accela.repositories.PersonRepository;

@Controller
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/address/new")
	public String showNewAddressForm(Model model) {

		model.addAttribute("address", new Address());
		model.addAttribute("listPerson", personRepository.findAll());
		return "add-address";
	}

	@PostMapping("/addaddress")
	public String addAddress(@Valid Address address, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-address";
		}

		addressRepository.save(address);
		return "redirect:/addresses";
	}

	@GetMapping("/addresses")
	public String showAddressList(Model model) {

		model.addAttribute("listAddress", addressRepository.findAll());
		return "show-address";
	}

	@GetMapping("/edit/address/{id}")
	public String showAddressUpdateForm(@PathVariable("id") Integer id, Model model) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid address Id:" + id));
		model.addAttribute("address", address);

		model.addAttribute("listPerson", personRepository.findAll());

		return "add-address";
	}

	@GetMapping("/delete/address/{id}")
	public String deletePerson(@PathVariable("id") Integer id, Model model) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid address Id:" + id));
		addressRepository.delete(address);

		return "redirect:/addresses";
	}

}
