package com.example.contactsusingrecyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //defining array to hold contacts
    ArrayList<Contact>contacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        FloatingActionButton fab_add = findViewById(R.id.fab_add);

        //setting the custom adapter that we made

        //an adapter acts as a bridge between a data source and a UI component, such as a RecyclerView, ListView, GridView, etc.
        // Its primary role is to adapt the data (from an array, database, list, etc.) into a format that the UI component
        // can use to display the data on the screen.
        RecyclerAdapter adapter = new RecyclerAdapter(this, contacts);
        recyclerView.setAdapter(adapter);


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //displaying the dialog layout as a dialog onm top of main activity
                Dialog add_update_dialog =new Dialog(MainActivity.this);
                add_update_dialog.setContentView(R.layout.dialog_layout);

                EditText dialog_name = add_update_dialog.findViewById(R.id.add_name);
                EditText dialog_number = add_update_dialog.findViewById(R.id.add_number);
                Button add_contact = add_update_dialog.findViewById(R.id.dialog_addbtn);

                add_update_dialog.show();
                add_contact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = dialog_name.getText().toString();
                        String number = dialog_number.getText().toString();
                        if(!name.isEmpty() && !number.isEmpty()){

                            //adding contact in the last
                            contacts.add(new Contact(R.drawable.contact_image, name, number));

                            //The Adapter is informed that a new item has been added to the dataset at the specified position.
                            //The RecyclerView updates its view by inserting a new item at the position.
                            adapter.notifyItemInserted(contacts.size()-1);
                            recyclerView.scrollToPosition(contacts.size()-1);
                            add_update_dialog.dismiss();

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please Enter The desired Fields. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        //telling the recycler view how to arrange views(vertically in this case)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adding contacts to array
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}