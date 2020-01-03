package com.example.pem_test.contactCreationScreen;

import java.lang.ref.WeakReference;

interface ContactCreationContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactCreationViewModel viewModel);

    void goBack();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onCancelButtonClicked();

    void onDoneButtonClicked();
  }

  interface Model {

  }

  interface Router {

  }
}
