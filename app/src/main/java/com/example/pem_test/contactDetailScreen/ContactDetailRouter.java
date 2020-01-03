package com.example.pem_test.contactDetailScreen;

import android.util.Log;

import com.example.pem_test.app.AppMediator;

public class ContactDetailRouter implements ContactDetailContract.Router {

  public static String TAG = ContactDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public ContactDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ContactDetailState getDataFromContactListScreen() {
    ContactDetailState state = mediator.getContactDetailState();
    return state;
  }
}
