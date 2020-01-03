package com.example.pem_test.app;

import android.app.Application;

import com.example.pem_test.contactCreationScreen.ContactCreationState;
import com.example.pem_test.contactDetailScreen.ContactDetailState;
import com.example.pem_test.contactListScreen.ContactListState;

import io.realm.Realm;

public class AppMediator extends Application {

  private ContactListState contactListState;
  private ContactCreationState contactCreationState;
  private ContactDetailState contactDetailState;

  public AppMediator() {
    Realm.init(this);
    this.contactListState = new ContactListState();
    this.contactCreationState = new ContactCreationState();
    this.contactDetailState = new ContactDetailState();
  }

  public ContactListState getContactListState() {
    return contactListState;
  }

  public void setContactListState(ContactListState contactListState) {
    this.contactListState = contactListState;
  }

  public ContactCreationState getContactCreationState() {
    return contactCreationState;
  }

  public void setContactCreationState(ContactCreationState contactCreationState) {
    this.contactCreationState = contactCreationState;
  }

  public ContactDetailState getContactDetailState() {
    return contactDetailState;
  }

  public void setContactDetailState(ContactDetailState contactDetailState) {
    this.contactDetailState = contactDetailState;
  }
}
