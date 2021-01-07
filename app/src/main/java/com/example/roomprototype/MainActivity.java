package com.example.roomprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomprototype.model.Contact;
import com.example.roomprototype.model.ContactViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Read up on this.
        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(ContactViewModel.class);

        //You can replace the new Observer<List<Contact>>() with a lambda function.
        contactViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                Log.d("onCreate:", contacts.get(0).getName());
            }
        });
    }
}