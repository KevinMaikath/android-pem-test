package com.example.pem_test.contactCreationScreen;

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

    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void onCancelButtonClicked() {
    view.get().goBack();
  }

  @Override
  public void onDoneButtonClicked() {
    // TODO onDoneButtonClicked
  }
}
