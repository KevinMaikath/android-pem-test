package com.example.pem_test.contactCreationScreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pem_test.R;

public class ContactCreationActivity
    extends AppCompatActivity implements ContactCreationContract.View {

  public static String TAG = ContactCreationActivity.class.getSimpleName();

  private ContactCreationContract.Presenter presenter;

  private Toolbar toolbar;
  private TextView toolbar_title;
  private Button back_button, delete_button;
  private EditText name_input, surname_input, age_input, occupation_input, dni_input, cv_input;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_creation);

    this.toolbar = findViewById(R.id.toolbar);
    this.toolbar_title = findViewById(R.id.toolbar_title);
    toolbar_title.setText(R.string.creation_title);

    this.back_button = findViewById(R.id.toolbar_leftButton);
    back_button.setText(R.string.cancel_button);

    this.delete_button = findViewById(R.id.toolbar_rightButton);
    delete_button.setText(R.string.done_button);

    this.name_input = findViewById(R.id.creation_name_input);
    this.surname_input = findViewById(R.id.creation_surname_input);
    this.age_input = findViewById(R.id.creation_age_input);
    this.occupation_input = findViewById(R.id.creation_occupation_input);
    this.dni_input = findViewById(R.id.creation_dni_input);
    this.cv_input = findViewById(R.id.creation_cv_input);

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
  }
}
