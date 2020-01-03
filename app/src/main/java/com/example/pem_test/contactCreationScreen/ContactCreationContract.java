package com.example.pem_test.contactCreationScreen;

import java.lang.ref.WeakReference;
import java.util.Map;

interface ContactCreationContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ContactCreationViewModel viewModel);

    void goBack();

    Map<String, String> getDataFromInput();
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

    void createContact(Map<String, String> data);
  }

  interface Router {

  }
}
