package ${PACKAGE_NAME};

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.sdos.sdosproject.R;
import es.sdos.sdosproject.ui.base.InditexActivity;
import es.sdos.sdosproject.ui.product.fragment.NotifyProductStockFragment;
/* TODO

<activity
      android:name="${PACKAGE_NAME}.${NAME}Activity"
      android:screenOrientation="portrait"/>

*/
public class ${NAME}Activity extends InditexActivity {
  
  @BindView(R.id.toolbar_title)
  TextView title;
  
  public static void startActivity(Activity activity, Long categoryId, Long productId, Long sku) {
    Intent intent = new Intent(activity, NotifyProductStockActivity.class);
    //intent.putExtra(PRODUCT_CATEGORY_ID_EXTRA_NAME, categoryId);
    activity.startActivity(intent);
    activity.overridePendingTransition(R.anim.slide_from_bottom_enter, R.anim.no_animation_slow);
  }

  @Override
  protected Builder configureActivityBuilder(Builder builder) {
    return super.configureActivityBuilder(builder)
        .setToolbarBack(true);
  }

  @Override
  public void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    ButterKnife.bind(this);

    //Long categoryId = getIntent().getExtras().getLong(PRODUCT_CATEGORY_ID_EXTRA_NAME);
    
    title.setText(R.string.notify_product_stock_title);
    //setFragment(NotifyProductStockFragment.newInstance(categoryId, productId, sku));
  }

  @Override
  public void onBackPressed() {
    finish();
    overridePendingTransition(R.anim.no_animation_slow, R.anim.slide_from_bottom_exit);
  }
  
}
