package com.example.contacts;


import java.util.List;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
class ContactController {

    private final ContactRepository repository;
    ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contacts")
    List<Contact> all() {
        return repository.findAll();
    }


    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact newContact) {

        System.out.println("post");
        return repository.save(newContact);
    }


    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PutMapping("/contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {

        return repository.findById(id)
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setPhone(newContact.getPhone());
                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                })
                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
