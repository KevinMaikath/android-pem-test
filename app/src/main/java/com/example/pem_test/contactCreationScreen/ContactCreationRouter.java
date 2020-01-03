package com.example.pem_test.contactCreationScreen;

import android.util.Log;


import com.example.pem_test.app.AppMediator;

public class ContactCreationRouter implements ContactCreationContract.Router {

  public static String TAG = ContactCreationRouter.class.getSimpleName();

  private AppMediator mediator;

  public ContactCreationRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

}
