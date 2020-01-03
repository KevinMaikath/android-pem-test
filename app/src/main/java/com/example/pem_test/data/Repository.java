package com.example.pem_test.data;

import android.content.Context;
import android.util.Log;

import java.util.Map;

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
    realm.executeTransactionAsync(
        new Realm.Transaction() {
          @Override
          public void execute(Realm bgRealm) {
            RealmResults<Contact> results = bgRealm.where(Contact.class).findAll();
            contactList = results.toArray(new Contact[results.size()]);
          }
        },
        new Realm.Transaction.OnSuccess() {
          @Override
          public void onSuccess() {
            callback.setContactList(contactList);
          }
        },
        new Realm.Transaction.OnError() {
          @Override
          public void onError(Throwable error) {
            Log.e("REPOSITORY", "______ Load contact list ERROR: " + error + "  _____ ");
          }
        }
    );
  }

  @Override
  public void addContact(final Map<String, String> data) {
    // TODO addContact
    realm.executeTransactionAsync(
        new Realm.Transaction() {
          @Override
          public void execute(Realm bgRealm) {


            Number currentIdNum = bgRealm.where(Contact.class).max("id");
            int nextId;
            if (currentIdNum == null) {
              nextId = 1;
            } else {
              nextId = currentIdNum.intValue() + 1;
            }

            Contact contact = new Contact();
            contact.setId(nextId);
            contact.setName(data.get("name"));
            contact.setSurname(data.get("surname"));
            contact.setAge(Integer.parseInt(data.get("age")));
            contact.setOccupation(data.get("occupation"));
            contact.setDni(data.get("dni"));
            contact.setCv(data.get("cv"));

            bgRealm.insertOrUpdate(contact);
          }
        }
    );
  }

  @Override
  public void removeContact(final Contact contact) {
    // TODO removeContact
    realm.executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(Realm bgRealm) {
        RealmResults<Contact> results = bgRealm.where(Contact.class)
            .equalTo("id", contact.getId())
            .findAll();
        results.deleteAllFromRealm();
      }
    });
  }
}
