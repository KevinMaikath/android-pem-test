package com.example.pem_test.contactCreationScreen;

import android.util.Log;

import com.example.pem_test.data.Repository;


public class ContactCreationModel implements ContactCreationContract.Model {

  public static String TAG = ContactCreationModel.class.getSimpleName();

  private Repository repository;

  public ContactCreationModel(Repository repository) {
    this.repository = repository;
  }

}