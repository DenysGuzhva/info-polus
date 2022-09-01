package com.infopolus.repository;

import com.infopolus.entiry.Contact;
import com.infopolus.entiry.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

  private final List<Contact> allOwners = new ArrayList<>();

  public void createProducts() {
    allOwners.add(new Contact(1, "andrii S"));
    allOwners.add(new Contact(2, "Denis P"));
    allOwners.add(new Contact(3, "Andrii K"));
    allOwners.add(new Contact(4, "Taras B"));
    allOwners.add(new Contact(5, "Maksym H"));
  }

  public List<Contact> getAllContacts() {
    return allOwners;
  }

  public void save(Contact contact) {
    contact.setId(allOwners.size());
    allOwners.add(contact);
  }

  public void saveAll(List<Contact> vehicles) {
    vehicles.forEach(this::save);
  }

  public Vehicle deleteById(int id) {
    allOwners.removeIf(x -> x.getId() == (id));
    return null;
  }

}
