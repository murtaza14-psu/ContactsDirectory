package com.example.contactsusingrecyclerview;

import android.app.Dialog;
import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {

    ArrayList<Contact> contacts = new ArrayList<>();




//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public ContactsFragment() {
        // Required empty public constructor
    }

//    public static ContactsFragment newInstance(String param1, String param2) {
////        ContactsFragment fragment = new ContactsFragment();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
////        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

        //setting the custom adapter that we made

        //an adapter acts as a bridge between a data source and a UI component, such as a RecyclerView, ListView, GridView, etc.
        // Its primary role is to adapt the data (from an array, database, list, etc.) into a format that the UI component
        // can use to display the data on the screen.
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contacts, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recycler);
        FloatingActionButton fab_add = view.findViewById(R.id.fab_add);


        RecyclerAdapter adapter = new RecyclerAdapter(getContext(), contacts);
        recyclerView.setAdapter(adapter);

        //telling the recycler view how to arrange views(vertically in this case)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        //adding new Contact
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //displaying the dialog layout as a dialog onm top of main activity
                Dialog add_update_dialog = new Dialog(getActivity());
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
                        if (!name.isEmpty() && !number.isEmpty()) {

                            //adding contact in the last
                            contacts.add(new Contact(R.drawable.contact_image, name, number));

                            //The Adapter is informed that a new item has been added to the dataset at the specified position.
                            //The RecyclerView updates its view by inserting a new item at the position.
                            adapter.notifyItemInserted(contacts.size() - 1);
                            recyclerView.scrollToPosition(contacts.size() - 1);
                            add_update_dialog.dismiss();

                        } else {
                            Toast.makeText(getContext(), "Please Enter The desired Fields. ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



        //Adding contacts to array
        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));
//        contacts.add(new Contact(R.drawable.contact_image, "Murtaza", "03303659991"));


        return view;
    }
}