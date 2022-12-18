package com.example.contacts;

class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}
