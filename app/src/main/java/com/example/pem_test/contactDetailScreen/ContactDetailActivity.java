package com.example.pem_test.contactDetailScreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pem_test.R;

public class ContactDetailActivity
    extends AppCompatActivity implements ContactDetailContract.View {

  public static String TAG = ContactDetailActivity.class.getSimpleName();

  private ContactDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_detail);

    // do the setup
    ContactDetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ContactDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(ContactDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
//    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
