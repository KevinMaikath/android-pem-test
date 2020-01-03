package com.example.pem_test.contactListScreen;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.pem_test.app.AppMediator;
import com.example.pem_test.contactCreationScreen.ContactCreationActivity;
import com.example.pem_test.contactDetailScreen.ContactDetailActivity;
import com.example.pem_test.contactDetailScreen.ContactDetailState;

public class ContactListRouter implements ContactListContract.Router {

  public static String TAG = ContactListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ContactListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToContactCreationScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ContactCreationActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToContactDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ContactDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToContactDetailScreen(ContactDetailState state) {
    mediator.setContactDetailState(state);
  }

}
