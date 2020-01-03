package com.example.pem_test.contactListScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pem_test.R;
import com.example.pem_test.data.Contact;

public class ContactListActivity
    extends AppCompatActivity implements ContactListContract.View {

  public static String TAG = ContactListActivity.class.getSimpleName();

  private ContactListContract.Presenter presenter;

  private RecyclerView recyclerView;
  private ContactListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_list);

    listAdapter = new ContactListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Contact contact = (Contact) view.getTag();
        presenter.onContactClicked(contact);
      }
    });

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
  public void displayData(final ContactListViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.contactList);
      }
    });
  }
}
