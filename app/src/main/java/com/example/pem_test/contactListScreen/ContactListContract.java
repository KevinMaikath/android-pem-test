package com.example.pem_test.contactListScreen;

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
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ContactListState state);

    ContactListState getDataFromPreviousScreen();
  }
}
