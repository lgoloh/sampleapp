package com.example.leslieg.sampleapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactHolder> {

    private ArrayList<Contact> contactList;
    private Context mContext;

    public ContactListAdapter(Context context, ArrayList<Contact> list) {
        mContext = context;
        contactList = list;
    }
    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder viewHolder, int pos) {
        viewHolder.contactName.setText(contactList.get(pos).getName());
    }

    @Override
    public int getItemCount() {return contactList.size();}

    public Contact getContact(int position) {
        return contactList.get(position);
    }



    class ContactHolder extends RecyclerView.ViewHolder {

        private TextView contactName;
        private ImageView callButton;

        public ContactHolder(View itemview) {
            super(itemview);
            contactName = itemview.findViewById(R.id.contactname);
            callButton = itemview.findViewById(R.id.call);

        }

    }
}
