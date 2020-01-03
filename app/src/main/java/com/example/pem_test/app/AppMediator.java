package com.example.pem_test.app;

import android.app.Application;

import com.example.pem_test.contactListScreen.ContactListState;

import io.realm.Realm;

public class AppMediator extends Application {

  private ContactListState contactListState;

  public AppMediator() {
    Realm.init(this);
    this.contactListState = new ContactListState();
  }

  public ContactListState getContactListState() {
    return contactListState;
  }

  public void setContactListState(ContactListState contactListState) {
    this.contactListState = contactListState;
  }
}
