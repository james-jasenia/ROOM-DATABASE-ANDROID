package com.example.roomprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomprototype.model.Contact;
import com.example.roomprototype.model.ContactViewModel;

public class NewContactActivity extends AppCompatActivity {

    private EditText enterName;
    private EditText enterOccupation;
    private Button saveInfoButton;
    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        enterName = findViewById(R.id.enterNameEditText);
        enterOccupation = findViewById(R.id.enterOccupationEditText);
        saveInfoButton = findViewById(R.id.saveInfoButton);

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(NewContactActivity.this.getApplication()).create(ContactViewModel.class);

        saveInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Manage Empty Text Fields
                Contact contact = new Contact(enterName.getText().toString(), enterOccupation.getText().toString());
                contactViewModel.insert(contact);
            }
        });
    }
}