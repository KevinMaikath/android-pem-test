package com.example.pem_test.contactDetailScreen;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.pem_test.app.AppMediator;
import com.example.pem_test.data.Repository;

public class ContactDetailScreen {

  public static void configure(ContactDetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ContactDetailState state = mediator.getContactDetailState();

    Repository repository = Repository.getInstance(context.get());

    ContactDetailContract.Router router = new ContactDetailRouter(mediator);
    ContactDetailContract.Presenter presenter = new ContactDetailPresenter(state);
    ContactDetailContract.Model model = new ContactDetailModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
