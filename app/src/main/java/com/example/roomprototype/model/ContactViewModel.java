package com.example.roomprototype.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomprototype.data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private final ContactRepository contactRepository;

    private final LiveData<List<Contact>> allContacts;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository = new ContactRepository(application);
        allContacts = contactRepository.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts() { return allContacts; }

    public void insert(Contact contact) { contactRepository.insert(contact); }
}
