package com.example.pem_test.data;

import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

public interface RepositoryContract {

  interface LoadContactListCallback {
    void setContactList(final Contact[] contactList);
  }

  void loadContactList(LoadContactListCallback callback);

  void addContact(Map<String, String> data);

  void removeContact(Contact contact);

}
