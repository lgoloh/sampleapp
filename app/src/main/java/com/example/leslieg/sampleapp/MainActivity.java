package com.example.leslieg.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contact> contacts = new ArrayList<>();
        String[] list = {"David Island", "Jane Massachusetts", "Mike DC", "James Virginia", "Samantha Philly"};
        for (String name : list) {
            contacts.add(new Contact(name, "12345"));
        }
        final ContactListAdapter adapter = new ContactListAdapter(this, contacts);
        RecyclerView contactsView = (RecyclerView) findViewById(R.id.contactlist);
        contactsView.setAdapter(adapter);

        ClickListener listener = new ClickListener() {
            @Override
            public void onClick(View view, final int pos) {
                TextView contactname = (TextView) view.findViewById(R.id.contactname);
                ImageView call = (ImageView) view.findViewById(R.id.call);
                contactname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message = adapter.getContact(pos).getContact();
                        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
                    }
                });
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(), "You called me!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        };

        ContactListClickListener contactlistener = new ContactListClickListener(this, contactsView, listener);
        contactsView.addOnItemTouchListener(contactlistener);
        contactsView.setLayoutManager(new LinearLayoutManager(this));
    }
}
