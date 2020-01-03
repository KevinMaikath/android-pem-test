package com.example.pem_test.data;

import android.content.Context;
import android.util.Log;

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
    RealmConfiguration config = new RealmConfiguration.Builder()
        .name("contact.db")
        .schemaVersion(1)
        .deleteRealmIfMigrationNeeded()
        .build();
    this.realm = Realm.getInstance(config);
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
  public void addContact(final Contact contact) {
    // TODO addContact
    realm.executeTransactionAsync(
        new Realm.Transaction() {
          @Override
          public void execute(Realm bgRealm) {
            bgRealm.insert(contact);
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
