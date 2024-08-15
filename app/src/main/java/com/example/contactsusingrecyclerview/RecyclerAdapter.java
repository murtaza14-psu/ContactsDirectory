package com.example.contactsusingrecyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//So, RecyclerView.Adapter<RecyclerAdapter.ViewHolder> essentially means that your custom adapter (RecyclerAdapter) will work with
// a specific ViewHolder class (RecyclerAdapter.ViewHolder) to manage and display the views for each item in your RecyclerView.
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Contact>contactArr;
    //constructor to set the context, array and use it throughout the class(eg this)
    public RecyclerAdapter(Context context, ArrayList<Contact>contactArr){
        this.context=context;
        this.contactArr=contactArr;
    }
    @NonNull
    @Override

    //onCreateViewHolder is a method in the RecyclerView.Adapter class that is responsible for creating new ViewHolder objects.
    // These ViewHolder objects hold the views that represent each item in your RecyclerView.

    //when the recycler view calls this method a single row or item is made and if the recycler needs more it will call it multiple times.
    //this returns a view holder which is makes it ready to populate data from bind method
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflater is used to convert a layout into view type and allows us to use it as a view(here contact_rows is converted into view)
        View view = LayoutInflater.from(context).inflate(R.layout.contacts_rows, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Set the views for the current item
        holder.imgContact.setImageResource(contactArr.get(position).img);
        holder.txtName.setText(contactArr.get(position).name);
        holder.txtNumber.setText(contactArr.get(position).number);

        setAnimation(holder.itemView, position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();  // Get the current adapter position

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_layout);

                    EditText dialog_name = dialog.findViewById(R.id.add_name);
                    EditText dialog_number = dialog.findViewById(R.id.add_number);
                    Button update_contact = dialog.findViewById(R.id.dialog_addbtn);
                    TextView dialog_text = dialog.findViewById(R.id.dialog_text);

                    dialog_text.setText("Update Contact");
                    dialog_name.setText(contactArr.get(adapterPosition).name);
                    dialog_number.setText(contactArr.get(adapterPosition).number);
                    update_contact.setText("Update");

                    dialog.show();

                    update_contact.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String name = dialog_name.getText().toString();
                            String number = dialog_number.getText().toString();
                            if (!name.isEmpty() && !number.isEmpty()) {
                                contactArr.set(adapterPosition, new Contact(R.drawable.contact_image, name, number));
                                notifyItemChanged(adapterPosition);

                                dialog.dismiss();
                            } else {
                                Toast.makeText(context, "Please Enter The desired Fields.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int adapterPosition = holder.getAdapterPosition();  // Get the current adapter position

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context)
                            .setTitle("Delete Contact")
                            .setMessage("Are you sure?")
                            .setIcon(R.drawable.baseline_delete_forever_24)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    contactArr.remove(adapterPosition);
                                    notifyItemRemoved(adapterPosition);  // notify the adapter that an item was removed
                                }
                            })
                            .setNegativeButton("No", null);

                    alert.show();
                }
                return true;
            }
        });
    }


    //When the RecyclerView needs to know how many items it has to display,
    // it calls this method. The RecyclerView will then create and bind that many view holders.

    @Override
    public int getItemCount() {
        return contactArr.size();
    }

    //method to set animation
    private void setAnimation(View viewToAnimate,int position){
        Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(slideIn);
    }

    //View holder holds the views that you want to populate with items from your lists
    public class ViewHolder extends RecyclerView.ViewHolder {

        //finding views by id
        TextView txtName, txtNumber;
        ImageView imgContact;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {

            //the RecyclerView.ViewHolder has a constructor that binds the view(usually a complete layout inflated into a view) passed into a ViewHolder object
            // which later helps in accessing the individual views(buttons, images etc)
            super(itemView);
            txtName=itemView.findViewById(R.id.txtname);
            txtNumber=itemView.findViewById(R.id.txtnum);
            imgContact=itemView.findViewById(R.id.imgcontact);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }
}
