package com.example.pem_test.contactListScreen;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.pem_test.app.AppMediator;
import com.example.pem_test.data.Repository;

public class ContactListScreen {

  public static void configure(ContactListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ContactListState state = mediator.getContactListState();

    Repository repository = Repository.getInstance(context.get());

    ContactListContract.Router router = new ContactListRouter(mediator);
    ContactListContract.Presenter presenter = new ContactListPresenter(state);
    ContactListContract.Model model = new ContactListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
