package com.example.pem_test.contactCreationScreen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pem_test.R;

import java.util.HashMap;
import java.util.Map;

public class ContactCreationActivity
    extends AppCompatActivity implements ContactCreationContract.View {

  public static String TAG = ContactCreationActivity.class.getSimpleName();

  private ContactCreationContract.Presenter presenter;

  private Toolbar toolbar;
  private TextView toolbar_title;
  private Button cancel_button, done_button;
  private EditText name_input, surname_input, age_input, occupation_input, dni_input, cv_input;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_creation);

    this.toolbar = findViewById(R.id.toolbar);
    this.toolbar_title = findViewById(R.id.toolbar_title);
    toolbar_title.setText(R.string.creation_title);

    this.cancel_button = findViewById(R.id.toolbar_leftButton);
    cancel_button.setText(R.string.cancel_button);
    cancel_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onCancelButtonClicked();
      }
    });

    this.done_button = findViewById(R.id.toolbar_rightButton);
    done_button.setText(R.string.done_button);
    done_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onDoneButtonClicked();
      }
    });

    this.name_input = findViewById(R.id.creation_name_input);
    this.surname_input = findViewById(R.id.creation_surname_input);
    this.age_input = findViewById(R.id.creation_age_input);
    this.occupation_input = findViewById(R.id.creation_occupation_input);
    this.dni_input = findViewById(R.id.creation_dni_input);
    this.cv_input = findViewById(R.id.creation_cv_input);

    setSupportActionBar(toolbar);
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

  @Override
  public void goBack() {
    finish();
  }


  @Override
  public Map<String, String> getDataFromInput() {
    HashMap<String, String> data = new HashMap<>();

    data.put("name", name_input.getText().toString());
    data.put("surname", surname_input.getText().toString());
    data.put("age", age_input.getText().toString());
    data.put("occupation", occupation_input.getText().toString());
    data.put("dni", dni_input.getText().toString());
    data.put("cv", cv_input.getText().toString());

    return data;
  }

  @Override
  public void presentToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
