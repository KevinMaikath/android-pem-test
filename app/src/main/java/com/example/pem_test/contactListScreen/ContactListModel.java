package com.example.pem_test.contactListScreen;


public class ContactListModel implements ContactListContract.Model {

  public static String TAG = ContactListModel.class.getSimpleName();

  public ContactListModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
