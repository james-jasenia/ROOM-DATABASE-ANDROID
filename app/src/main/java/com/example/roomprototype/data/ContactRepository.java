package com.example.roomprototype.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomprototype.model.Contact;
import com.example.roomprototype.util.ContactRoomDatabase;

import java.util.List;

public class ContactRepository {

    //Properties
    private ContactDao contactDao;
    private LiveData<List<Contact>> allContacts;

    //Life Cycle
    public ContactRepository(Application application) {
        ContactRoomDatabase db = ContactRoomDatabase.getDatabase(application);
        contactDao = db.contactDao();

        allContacts = contactDao.getAllContacts();
    }

    //Accessors
    public LiveData<List<Contact>> getAllContacts() { return allContacts; }

    public void insert(Contact contact) {
        ContactRoomDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.insert(contact);
        });
    }
}
