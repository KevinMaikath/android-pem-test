package com.example.pem_test.contactCreationScreen;

import android.util.Log;

import com.example.pem_test.data.Repository;
import com.example.pem_test.data.RepositoryContract;

import java.util.Map;


public class ContactCreationModel implements ContactCreationContract.Model {

  public static String TAG = ContactCreationModel.class.getSimpleName();

  private Repository repository;

  public ContactCreationModel(Repository repository) {
    this.repository = repository;
  }

  @Override
  public void createContact(Map<String, String> data,
                            RepositoryContract.AddContactDoneCallback callback) {
    repository.addContact(data, callback);
  }
}
