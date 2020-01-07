package com.example.pem_test.data;

import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

public interface RepositoryContract {

  void editRating(Contact currentContact, String newRatingValue);

  interface LoadContactListCallback {
    void setContactList(final List<Contact> contactList);
  }

  interface AddContactDoneCallback {
    void done();
  }

  interface RemoveContactDoneCallback {
    void done();
  }

  void loadContactList(LoadContactListCallback callback);

  void addContact(Map<String, String> data, AddContactDoneCallback callback);

  void removeContact(Contact contact, RemoveContactDoneCallback callback);

}
