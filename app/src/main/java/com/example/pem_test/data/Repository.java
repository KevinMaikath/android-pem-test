package com.example.pem_test.data;

import android.content.Context;
import android.util.Log;

import java.util.Map;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class Repository implements RepositoryContract {

  private static Repository instance = null;
  private Realm realm;

  private Contact[] contactList;

  public static Repository getInstance(Context context) {
    if (instance == null) {
      instance = new Repository(context);
    }
    return instance;
  }

  private Repository(Context context) {
    Realm.init(context);
    this.realm = Realm.getDefaultInstance();
  }

  @Override
  public void loadContactList(final LoadContactListCallback callback) {
    final RealmResults<Contact> contacts = realm.where(Contact.class).findAllAsync();
    contacts.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<Contact>>() {
      @Override
      public void onChange(RealmResults<Contact> contacts, OrderedCollectionChangeSet changeSet) {
        changeSet.getInsertions();
        callback.setContactList(contacts);
      }
    });
  }

  @Override
  public void addContact(final Map<String, String> data, AddContactDoneCallback callback) {
    // TODO addContact
    Number currentIdNum = realm.where(Contact.class).max("id");
    int nextId;
    if (currentIdNum == null) {
      nextId = 1;
    } else {
      nextId = currentIdNum.intValue() + 1;
    }

    realm.beginTransaction();

    Contact newContact = realm.createObject(Contact.class);
    newContact.setId(nextId);
    newContact.setName(data.get("name"));
    newContact.setSurname(data.get("surname"));
    newContact.setAge(Integer.parseInt(data.get("age")));
    newContact.setOccupation(data.get("occupation"));
    newContact.setDni(data.get("dni"));
    newContact.setCv(data.get("cv"));

    realm.commitTransaction();

    callback.done();

  }

  @Override
  public void removeContact(final Contact contact, RemoveContactDoneCallback callback) {
    realm.beginTransaction();
    contact.deleteFromRealm();
    realm.commitTransaction();
    callback.done();
  }
}
