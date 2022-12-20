package com.example.contacts.services;

import com.example.contacts.models.Contact;
import com.example.contacts.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repository;
    ContactService(ContactRepository repository) {
        this.repository = repository;
    }


    public Page<Contact> getAllContacts(int page, int size){
        Pageable paging = PageRequest.of(page, size);
        return repository.findAll(paging);
    }


    public Contact createContact(Contact contact) throws Exception {
        if(!repository.findByPhoneOrEmail(contact.getPhone(), contact.getEmail()).isEmpty()){
            throw new Exception ("Contact already exists");
        }
        return repository.save(contact);
    }

    public Optional<Contact> getContact(Long id){
        return repository.findById(id);
    }

    public Contact updateContact(Long id, Contact contact){
        return repository.findById(id)
                .map(person -> {
                    person.setName(contact.getName());
                    person.setPhone(contact.getPhone());
                    person.setEmail(contact.getEmail());
                    return repository.save(contact);
                })
                .orElseGet(() -> {
                    contact.setId(id);
                    return repository.save(contact);
                });
    }

    public void deleteContact(Long id){
        repository.deleteById(id);
    }


}
