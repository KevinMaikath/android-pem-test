package com.example.pem_test.contactListScreen;

import java.lang.ref.WeakReference;

public class ContactListPresenter implements ContactListContract.Presenter {

  public static String TAG = ContactListPresenter.class.getSimpleName();

  private WeakReference<ContactListContract.View> view;
  private ContactListViewModel viewModel;
  private ContactListContract.Model model;
  private ContactListContract.Router router;

  public ContactListPresenter(ContactListState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ContactListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ContactListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ContactListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    ContactListState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }


}
