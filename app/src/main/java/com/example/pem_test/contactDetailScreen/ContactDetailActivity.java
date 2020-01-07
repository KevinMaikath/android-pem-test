package com.example.pem_test.contactDetailScreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pem_test.R;

public class ContactDetailActivity
    extends AppCompatActivity implements ContactDetailContract.View {

  public static String TAG = ContactDetailActivity.class.getSimpleName();

  private ContactDetailContract.Presenter presenter;

  private Toolbar toolbar;
  private TextView toolbar_title, name_label, surname_label, age_label, occupation_label, dni_label,
      cv_label, rating_label;
  private Button back_button, delete_button, save_rating_btn;
  private ImageButton star_1, star_2, star_3, star_4, star_5;
  private String newRatingValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_detail);

    this.toolbar = findViewById(R.id.toolbar);
    this.toolbar_title = findViewById(R.id.toolbar_title);
    toolbar_title.setText(R.string.detail_title);

    this.back_button = findViewById(R.id.toolbar_leftButton);
    back_button.setText(R.string.back_button);
    back_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onBackButtonClicked();
      }
    });

    this.delete_button = findViewById(R.id.toolbar_rightButton);
    delete_button.setText(R.string.delete_button);
    delete_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onDeleteButtonClicked();
      }
    });


    this.name_label = findViewById(R.id.detail_name_label);
    this.surname_label = findViewById(R.id.detail_surname_label);
    this.age_label = findViewById(R.id.detail_age_label);
    this.occupation_label = findViewById(R.id.detail_occupation_label);
    this.dni_label = findViewById(R.id.detail_dni_label);
    this.cv_label = findViewById(R.id.detail_cv_label);
    this.rating_label = findViewById(R.id.detail_rating_label);

    this.star_1 = findViewById(R.id.detail_star_1);
    this.star_1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        starClicked(1);
      }
    });

    this.star_2 = findViewById(R.id.detail_star_2);
    this.star_2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        starClicked(2);
      }
    });

    this.star_3 = findViewById(R.id.detail_star_3);
    this.star_3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        starClicked(3);
      }
    });

    this.star_4 = findViewById(R.id.detail_star_4);
    this.star_4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        starClicked(4);
      }
    });

    this.star_5 = findViewById(R.id.detail_star_5);
    this.star_5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        starClicked(5);
      }
    });

    this.newRatingValue = "0";

    this.save_rating_btn = findViewById(R.id.detail_save_rating);
    this.save_rating_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.saveRating(newRatingValue);
      }
    });

    setSupportActionBar(toolbar);
    // do the setup
    ContactDetailScreen.configure(this);
  }

  private void starClicked(int selected) {
    this.newRatingValue = String.valueOf(selected);
    this.rating_label.setText(newRatingValue);
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
    this.name_label.setText(viewModel.currentContact.getName());
    this.surname_label.setText(viewModel.currentContact.getSurname());
    this.age_label.setText(String.valueOf(viewModel.currentContact.getAge()));
    this.occupation_label.setText(viewModel.currentContact.getOccupation());
    this.dni_label.setText(viewModel.currentContact.getDni());
    this.cv_label.setText(viewModel.currentContact.getCv());
    this.rating_label.setText(String.valueOf(viewModel.currentContact.getRating()));
  }

  @Override
  public void goBack() {
    finish();
  }
}
