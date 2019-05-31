package ${PACKAGE_NAME};

import es.sdos.sdosproject.data.bo.UseCaseErrorBO;
import es.sdos.sdosproject.task.usecases.CallWs${NAME}UC;
import es.sdos.sdosproject.task.usecases.base.UseCaseHandler;
import es.sdos.sdosproject.task.usecases.base.UseCaseUiCallback;
import es.sdos.sdosproject.ui.base.BasePresenter;
import es.sdos.sdosproject.ui.book.contract.${NAME}Contract;
import javax.inject.Inject;

/**
 * TODO: inject in AppComponent and create provider
 */
public class ${NAME}Presenter extends BasePresenter<${NAME}Contract.View>
    implements ${NAME}Contract.Presenter {

  @Inject
  UseCaseHandler useCaseHandler;
  @Inject
  CallWs${NAME}UC callWs${NAME}UC;
  @Override
  public void initializeView(${NAME}Contract.View view) {
    super.initializeView(view);
    getSomethingAtBeginningOrRemoveThisMethod();
  }

  private void getResult() {
    useCaseHandler.execute(callWs${NAME}UC,
        new CallWs${NAME}UC.RequestValues(),
        new UseCaseUiCallback<CallWs${NAME}UC.ResponseValue>() {
          @Override
          protected void onUiSuccess(CallWs${NAME}UC.ResponseValue response) {
            response.getBookingStoreItem();
            view.setData(response.getResult());
          }

          @Override
          protected void onUiError(UseCaseErrorBO error) {
            //TODO SHOW MESSAGE
          }
        });
  }
}
