package com.example.pem_test.contactListScreen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pem_test.R;

public class ContactListActivity
    extends AppCompatActivity implements ContactListContract.View {

  public static String TAG = ContactListActivity.class.getSimpleName();

  private ContactListContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_list);

    // do the setup
    ContactListScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ContactListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(ContactListViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
