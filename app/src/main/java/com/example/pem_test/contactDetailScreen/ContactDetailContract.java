package com.example.pem_test.contactDetailScreen;

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
  }

  interface Model {
  }

  interface Router {
    ContactDetailState getDataFromContactListScreen();
  }
}
