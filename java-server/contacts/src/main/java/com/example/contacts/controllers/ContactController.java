package com.example.contacts.controllers;


import java.util.List;
import java.util.Optional;

import com.example.contacts.exceptions.ContactNotFoundException;
import com.example.contacts.models.Contact;
import com.example.contacts.services.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin(origins = "http://localhost:3000", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
class ContactController {

    private final ContactService service;
    ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/contacts")
    List<Contact> all(@RequestParam (defaultValue="0") String page, @RequestParam(defaultValue = "10") String pagesize) {

        Page<Contact> contacts= service.getAllContacts(Integer.parseInt(page),Integer.parseInt(pagesize));
        return contacts.getContent();
    }


    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact newContact){
        try{
            return service.createContact(newContact);
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {

        return service.getContact(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PutMapping("/contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
        return service.updateContact(id, newContact);
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
    }
}
