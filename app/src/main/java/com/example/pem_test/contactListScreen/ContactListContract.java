package com.example.pem_test.contactListScreen;

import com.example.pem_test.contactDetailScreen.ContactDetailState;
import com.example.pem_test.data.Contact;
import com.example.pem_test.data.RepositoryContract;

import java.lang.ref.WeakReference;

interface ContactListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onContactClicked(Contact contact);

    void onAddButtonClicked();
  }

  interface Model {
    void loadContactList(RepositoryContract.LoadContactListCallback callback);
  }

  interface Router {
    void navigateToContactCreationScreen();

    void navigateToContactDetailScreen();

    void passDataToContactDetailScreen(ContactDetailState state);
  }
}
