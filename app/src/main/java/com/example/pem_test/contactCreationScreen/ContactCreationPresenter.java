package com.example.pem_test.contactCreationScreen;

import android.util.Log;

import java.lang.ref.WeakReference;

public class ContactCreationPresenter implements ContactCreationContract.Presenter {

  public static String TAG = ContactCreationPresenter.class.getSimpleName();

  private WeakReference<ContactCreationContract.View> view;
  private ContactCreationViewModel viewModel;
  private ContactCreationContract.Model model;
  private ContactCreationContract.Router router;

  public ContactCreationPresenter(ContactCreationState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ContactCreationContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ContactCreationContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ContactCreationContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

//    if (viewModel.data == null) {
      // call the model
//      String data = model.fetchData();

      // set initial state
//      viewModel.data = data;
//    }

    // update the view
    view.get().displayData(viewModel);

  }


}