package com.example.pem_test.contactListScreen;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.pem_test.app.AppMediator;

public class ContactListRouter implements ContactListContract.Router {

  public static String TAG = ContactListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ContactListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ContactListActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ContactListState state) {
    mediator.setContactListState(state);
  }

  @Override
  public ContactListState getDataFromPreviousScreen() {
    ContactListState state = mediator.getContactListState();
    return state;
  }
}
