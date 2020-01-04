package com.example.pem_test.contactDetailScreen;

import android.util.Log;

import com.example.pem_test.data.Contact;
import com.example.pem_test.data.Repository;
import com.example.pem_test.data.RepositoryContract;

public class ContactDetailModel implements ContactDetailContract.Model {

  public static String TAG = ContactDetailModel.class.getSimpleName();

  private Repository repository;

  public ContactDetailModel(Repository repository) {
    this.repository = repository;
  }


  @Override
  public void deleteContact(Contact contact, RepositoryContract.RemoveContactDoneCallback callback) {
    repository.removeContact(contact, callback);
  }
}
