package com.example.pem_test.contactDetailScreen;

import android.util.Log;

import com.example.pem_test.data.Contact;
import com.example.pem_test.data.RepositoryContract;

import java.lang.ref.WeakReference;

public class ContactDetailPresenter implements ContactDetailContract.Presenter {

  public static String TAG = ContactDetailPresenter.class.getSimpleName();

  private WeakReference<ContactDetailContract.View> view;
  private ContactDetailViewModel viewModel;
  private ContactDetailContract.Model model;
  private ContactDetailContract.Router router;

  public ContactDetailPresenter(ContactDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ContactDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ContactDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ContactDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    ContactDetailState state = router.getDataFromContactListScreen();
    if (state != null) {
      viewModel.currentContact = state.currentContact;
    }

    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void onBackButtonClicked() {
    view.get().goBack();
  }

  @Override
  public void onDeleteButtonClicked() {
    // TODO onDeleteButtonClicked
    model.deleteContact(viewModel.currentContact, new RepositoryContract.RemoveContactDoneCallback() {
      @Override
      public void done() {
        view.get().goBack();
      }
    });
  }
}
