package com.example.pem_test.contactListScreen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pem_test.R;
import com.example.pem_test.data.Contact;

public class ContactListActivity
    extends AppCompatActivity implements ContactListContract.View {

  public static String TAG = ContactListActivity.class.getSimpleName();

  private ContactListContract.Presenter presenter;

  private RecyclerView recyclerView;
  private ContactListAdapter listAdapter;

  private Toolbar toolbar;
  private TextView toolbar_title;
  private Button add_button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    Log.e(TAG, "____________ ON CREATE __________");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_list);

    this.toolbar = findViewById(R.id.toolbar);
    this.toolbar_title = findViewById(R.id.toolbar_title);
    toolbar_title.setText(R.string.contact_list_title);

    this.add_button = findViewById(R.id.toolbar_rightButton);
    add_button.setText(R.string.add_button);
    add_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onAddButtonClicked();
      }
    });

    listAdapter = new ContactListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Contact contact = (Contact) view.getTag();
        presenter.onContactClicked(contact);
      }
    });

    recyclerView = findViewById(R.id.contact_list_recycler);
    recyclerView.setAdapter(listAdapter);

    setSupportActionBar(toolbar);
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
