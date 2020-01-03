package com.example.pem_test.contactListScreen;


import com.example.pem_test.data.Repository;
import com.example.pem_test.data.RepositoryContract;

public class ContactListModel implements ContactListContract.Model {

  public static String TAG = ContactListModel.class.getSimpleName();
  private Repository repository;

  public ContactListModel(Repository repository) {
    this.repository = repository;
  }

  @Override
  public void loadContactList(RepositoryContract.LoadContactListCallback callback) {
    repository.loadContactList(callback);
  }
}
