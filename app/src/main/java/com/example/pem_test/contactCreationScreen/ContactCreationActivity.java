package com.example.pem_test.contactCreationScreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pem_test.R;

public class ContactCreationActivity
    extends AppCompatActivity implements ContactCreationContract.View {

  public static String TAG = ContactCreationActivity.class.getSimpleName();

  private ContactCreationContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_creation);

    // do the setup
    ContactCreationScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ContactCreationContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(ContactCreationViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
//    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
