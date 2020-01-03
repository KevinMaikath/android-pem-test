package com.example.pem_test.data;

import java.util.List;

import io.realm.RealmResults;

public interface RepositoryContract {

  interface LoadContactListCallback {
    void setContactList(final RealmResults<Contact> contactList);
  }

  void loadContactList(LoadContactListCallback callback);

  void addContact(Contact contact);

  void removeContact(Contact contact);

}
