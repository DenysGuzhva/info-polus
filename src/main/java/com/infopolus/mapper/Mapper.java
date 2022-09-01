package com.infopolus.mapper;

import com.infopolus.dto.ContactDto;
import com.infopolus.entiry.Contact;
import com.infopolus.repository.VehicleRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

  private final VehicleRepository vehicleRepository;

  public Mapper(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  public ContactDto toDto(Contact contact) {
    return ContactDto.builder()
        .id(contact.getId())
        .fullName(contact.getFullName())
        .vehicles(vehicleRepository.findAllByOwnerId(contact.getId()))
        .build();
  }

  public List<ContactDto> allToDto(List<Contact> contacts) {
    return contacts.stream().map(this::toDto).collect(Collectors.toList());
  }

}
