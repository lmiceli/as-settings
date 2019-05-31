package ${PACKAGE_NAME};

import android.support.v4.app.Fragment;
import es.sdos.sdosproject.R;
import es.sdos.sdosproject.di.components.AppComponent;
import es.sdos.sdosproject.ui.base.BaseContract;
import es.sdos.sdosproject.ui.base.InditexFragment;
import es.sdos.sdosproject.ui.book.contract.${NAME}Contract;
import javax.inject.Inject;

public class ${NAME}Fragment extends InditexFragment
    implements ${NAME}Contract.View {

  @Inject
  ${NAME}Contract.Presenter presenter;
  // <include layout="@layout/layout_loading" tools:visibility="gone"/>
  @BindView(R.id.loading)
  View loadingView;

  public static Fragment newInstance() {
    ${NAME}Fragment fragment = new ${NAME}Fragment();
    return fragment;
  }

  @Override
  protected void injection(AppComponent appComponent) {
    appComponent.inject(this);
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.${fragment_layout};
  }

  @Override
  protected BaseContract.Presenter getPresenter() {
    return presenter;
  }

  @Override
  protected void initializeView() {

  }

  @Override
  public void setLoading(boolean loading) {

  }

  @Override
  public void showErrorMessage(String errorMessage) {
    if (getActivity() != null) {
      DialogUtils.createOkDialog(getActivity(), errorMessage, false, null)
          .show();
    }
  }

  @Override
  public void setData(SomeBO data) {
    //TODO  SET THE DATA ON THE FIELDS

  }
}


package es.sdos.sdosproject.ui.book.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import butterknife.BindView;
import es.sdos.sdosproject.R;
import es.sdos.sdosproject.data.bo.BookingBO;
import es.sdos.sdosproject.di.components.AppComponent;
import es.sdos.sdosproject.ui.base.BaseContract;
import es.sdos.sdosproject.ui.base.InditexFragment;
import es.sdos.sdosproject.ui.book.adapter.BookingListAdapter;
import es.sdos.sdosproject.ui.book.contract.BookingListContract;
import es.sdos.sdosproject.ui.order.adapter.PhysicalStoreDetailAdapter;
import es.sdos.sdosproject.ui.order.controller.LinearLayoutManagerWithSmoothScroller;
import java.util.List;
import javax.inject.Inject;

public class BookingListFragment extends InditexFragment
    implements BookingListContract.View {

  @Inject
  BookingListContract.Presenter presenter;

  @BindView(R.id.fragment_booking_list_recycler)
  RecyclerView recycler;

  private BookingListAdapter adapter;

  public static Fragment newInstance() {
    BookingListFragment fragment = new BookingListFragment();
    return fragment;
  }

  @Override
  protected void injection(AppComponent appComponent) {
    appComponent.inject(this);
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.fragment_booking_list;
  }

  @Override
  protected BaseContract.Presenter getPresenter() {
    return presenter;
  }

  @Override
  protected void initializeView() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManagerWithSmoothScroller(getActivity());
    recycler.setLayoutManager(linearLayoutManager);
  }
  
  @Override
  public void setLoading(boolean loading) {
    if (getActivity() != null) {
      if (loading) {
        loadingView.setVisibility(View.VISIBLE);
      } else {
        loadingView.setVisibility(View.GONE);
      }
    }
  }

  @Override
  public void showErrorMessage(String errorMessage) {

  }

  @Override
  public void setData(List<BookingBO> data) {
    //TODO  SET THE DATA ON THE FIELDS
    adapter = new BookingListAdapter(getContext(), data, null);
    recycler.setAdapter(adapter);
  }
}
