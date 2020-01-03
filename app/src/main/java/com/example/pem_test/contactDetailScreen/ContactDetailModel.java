package com.example.pem_test.contactDetailScreen;

import android.util.Log;

import com.example.pem_test.data.Repository;

public class ContactDetailModel implements ContactDetailContract.Model {

  public static String TAG = ContactDetailModel.class.getSimpleName();

  private Repository repository;

  public ContactDetailModel(Repository repository) {
    this.repository = repository;
  }

}
