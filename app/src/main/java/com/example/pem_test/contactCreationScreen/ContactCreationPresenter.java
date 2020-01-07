package com.example.pem_test.contactCreationScreen;

import android.util.Log;

import com.example.pem_test.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.Map;

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
    Map<String, String> data = view.get().getDataFromInput();

    if (data.get("name") != null && !data.get("name").equals("")
        && data.get("surname") != null && !data.get("surname").equals("")
        && data.get("age") != null && !data.get("age").equals("")
        && data.get("occupation") != null && !data.get("occupation").equals("")
        && data.get("dni") != null && !data.get("dni").equals("")
        && data.get("cv") != null && !data.get("cv").equals("")
        && data.get("rating") != null && !data.get("rating").equals("")) {

      model.createContact(data, new RepositoryContract.AddContactDoneCallback() {
        @Override
        public void done() {
          view.get().goBack();
        }
      });
    } else {
      String message = "Invalid input";
      view.get().presentToast(message);
    }

  }
}
