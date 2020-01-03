package com.example.pem_test.contactListScreen;

import android.util.Log;

import com.example.pem_test.data.Contact;
import com.example.pem_test.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import io.realm.RealmResults;

public class ContactListPresenter implements ContactListContract.Presenter {

  public static String TAG = ContactListPresenter.class.getSimpleName();

  private WeakReference<ContactListContract.View> view;
  private ContactListState state;
  private ContactListViewModel viewModel;
  private ContactListContract.Model model;
  private ContactListContract.Router router;

  public ContactListPresenter(ContactListState state) {
    viewModel = this.state = state;
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

    if (state.contactListHasChanged) {
      model.loadContactList(new RepositoryContract.LoadContactListCallback() {
        @Override
        public void setContactList(Contact[] contactList) {
          viewModel.contactList = contactList;
          state.contactListHasChanged = false;
          view.get().displayData(viewModel);
      Log.e(TAG, "____________ CONTACT LIST CHANGED TRUE ______");
        }
      });
    }

    if (viewModel.contactList == null) {
      viewModel.contactList = new Contact[]{};
    }

    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void onContactClicked(Contact contact) {
    // TODO onContactClicked
  }

  @Override
  public void onAddButtonClicked() {
    router.navigateToContactCreationScreen();
  }
}
