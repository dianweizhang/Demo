package demo.zdw.com.demo.butterknife;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import demo.zdw.com.demo.R;

/**
 * Created by yidatec on 2018/9/19.
 * <p>
 * https://github.com/JakeWharton/butterknife
 *
 *
 * @BindView—->绑定一个view；id为一个view 变量
 @BindViews —-> 绑定多个view；id为一个view的list变量
 @BindArray—-> 绑定string里面array数组；@BindArray(R.array.city ) String[] citys ;
 @BindBitmap—->绑定图片资源为Bitmap；@BindBitmap( R.mipmap.wifi ) Bitmap bitmap;
 @BindBool —->绑定boolean值
 @BindColor —->绑定color；@BindColor(R.color.colorAccent) int black;
 @BindDimen —->绑定Dimen；@BindDimen(R.dimen.borth_width) int mBorderWidth;
 @BindDrawable —-> 绑定Drawable；@BindDrawable(R.drawable.test_pic) Drawable mTestPic;
 @BindFloat —->绑定float
 @BindInt —->绑定int
 @BindString —->绑定一个String id为一个String变量；@BindString( R.string.app_name ) String meg;



 @OnClick—->点击事件
 @OnCheckedChanged —->选中，取消选中
 @OnEditorAction —->软键盘的功能键
 @OnFocusChange —->焦点改变
 @OnItemClick item—->被点击(注意这里有坑，如果item里面有Button等这些有点击的控件事件的，需要设置这些控件属性focusable为false)
 @OnItemLongClick item—->长按(返回真可以拦截onItemClick)
 @OnItemSelected —->item被选择事件
 @OnLongClick —->长按事件
 @OnPageChange —->页面改变事件
 @OnTextChanged —->EditText里面的文本变化事件
 @OnTouch —->触摸事件
 @Optional —->选择性注入，如果当前对象不存在，就会抛出一个异常，为了压制这个异常，可以在变量或者方法上加入一下注解,让注入变成选择性的,如果目标View存在,则注入, 不存在,则什么事情都不做



 代码混淆
 -keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }

 -keepclasseswithmembernames class * {
 @butterknife.* <fields>;
 }

 -keepclasseswithmembernames class * {
 @butterknife.* <methods>;
 }


 Butterknife插件：zelezny
 */

public class ButterknifeActivity extends Activity {

    @BindView(R.id.butter_tv)
    TextView butterTv;
    @BindView(R.id.butter_btn)
    Button butterBtn;
    @BindView(R.id.butter_et)
    EditText butterEt;
    @BindView(R.id.butter_lv)
    ListView butterLv;

    @BindArray(R.array.city)  //绑定string里面array数
    String[] citys ;

    @BindString(R.string.app_name)  //绑定资源文件中string字符串
            String str;

    @BindColor( R.color.colorAccent ) //具体色值在color文件中,绑定一个颜色值
    int black ;

    @BindBitmap( R.mipmap.ic_launcher)//绑定Bitmap 资源
    public Bitmap bitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        butterTv.setText("aaaaaaa");
        butterEt.setText(str);
    }

    @OnClick({R.id.butter_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butter_btn:
                Toast.makeText(ButterknifeActivity.this,"Hello", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.butter_btn )   //给 button1 设置一个点击事件
    public void showToast(){
        Toast.makeText(this, "is a click", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick( R.id.butter_btn )    //给 button1 设置一个长按事件
    public boolean showToast2(){
        Toast.makeText(this, "is a long click", Toast.LENGTH_SHORT).show();
        return true ;
    }
}
