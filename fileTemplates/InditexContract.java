package ${PACKAGE_NAME};

import es.sdos.sdosproject.ui.base.BaseContract;

public interface ${NAME}Contract {

  interface View extends BaseContract.LoadingView {

    void setData(SomeBO data);

  }
  interface ActivityView {
  }

  interface Presenter extends BaseContract.Presenter<${NAME}Contract.View> {
  }
}
