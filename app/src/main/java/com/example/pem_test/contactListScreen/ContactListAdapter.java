package com.example.pem_test.contactListScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pem_test.R;
import com.example.pem_test.data.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

  private List<Contact> contactList;
  private final View.OnClickListener clickListener;

  public ContactListAdapter(View.OnClickListener clickListener) {
    this.contactList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void setItems(List<Contact> items) {
    contactList = items;
    notifyDataSetChanged();
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.contact_list_recycler_cell, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    holder.itemView.setTag(contactList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    String name = contactList.get(position).getName();
    holder.contactName.setText(name);

    String surname = contactList.get(position).getSurname();
    holder.contactName.setText(surname);

    String dni = contactList.get(position).getDni();
    holder.contactDNI.setText(dni);
  }

  @Override
  public int getItemCount() {
    return contactList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView contactName;
    final TextView contactSurname;
    final TextView contactDNI;

    ViewHolder(View view) {
      super(view);
      contactName = view.findViewById(R.id.contact_name_label);
      contactSurname = view.findViewById(R.id.contact_surname_label);
      contactDNI = view.findViewById(R.id.contact_dni_label);
    }
  }

}
