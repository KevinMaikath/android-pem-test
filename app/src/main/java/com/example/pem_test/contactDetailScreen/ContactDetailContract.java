package com.example.pem_test.contactDetailScreen;

import com.example.pem_test.data.Contact;
import com.example.pem_test.data.RepositoryContract;

import java.lang.ref.WeakReference;

interface ContactDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactDetailViewModel viewModel);

    void goBack();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onBackButtonClicked();

    void onDeleteButtonClicked();

    void saveRating(String newRatingValue);
  }

  interface Model {
    void deleteContact(Contact contact, RepositoryContract.RemoveContactDoneCallback callback);

    void saveRating(Contact currentContact, String newRatingValue);
  }

  interface Router {
    ContactDetailState getDataFromContactListScreen();
  }
}
