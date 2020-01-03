package com.example.pem_test.contactDetailScreen;

import java.lang.ref.WeakReference;

interface ContactDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
  }

  interface Model {
  }

  interface Router {
    ContactDetailState getDataFromContactListScreen();
  }
}
