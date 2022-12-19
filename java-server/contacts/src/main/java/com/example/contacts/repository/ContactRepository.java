package com.example.contacts.repository;


import com.example.contacts.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository <Contact, Long>{
    List<Contact> findByPhoneOrEmail(String phone, String email);
    //makes a list with the contacts that have this phone or email

    Page<Contact> findAll(Pageable pageable);
}