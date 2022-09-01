package com.infopolus.service.serviceImpl;

import com.infopolus.dto.ContactDto;
import com.infopolus.mapper.Mapper;
import com.infopolus.repository.ContactRepository;
import com.infopolus.service.ContactService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactService {

  private final ContactRepository contactRepository;
  private final Mapper mapper;

  public ContactsServiceImpl(ContactRepository contactRepository, Mapper mapper) {
    this.contactRepository = contactRepository;
    this.mapper = mapper;
  }

  @Override
  public List<ContactDto> getAllContacts() {
    return mapper.allToDto(contactRepository.getAllContacts());
  }

}
