package com.example.pem_test.contactCreationScreen;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.pem_test.app.AppMediator;
import com.example.pem_test.data.Repository;

public class ContactCreationScreen {

  public static void configure(ContactCreationContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ContactCreationState state = mediator.getContactCreationState();

    Repository repository = Repository.getInstance(context.get());

    ContactCreationContract.Router router = new ContactCreationRouter(mediator);
    ContactCreationContract.Presenter presenter = new ContactCreationPresenter(state);
    ContactCreationContract.Model model = new ContactCreationModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
