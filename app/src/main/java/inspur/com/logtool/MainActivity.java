package inspur.com.logtool;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import inspur.com.logtool.dao.DeviceDao;
import inspur.com.logtool.fragment.LogFragment;
import inspur.com.logtool.fragment.StatusFragment;
import inspur.com.logtool.model.Device;

public class MainActivity extends FragmentActivity {

    //声明一个viewpage，实现滑动效果
    private ViewPager viewPager;
    //声明两个textviw，分别用来表示获取状态和获取日志的按钮
    private TextView getStatus,getLogs;

    //声明一个list用来存放fragment
    private List<Fragment> list;
    private int currentPage = 0;// 初始化当前页为0（第一页）
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取数据库操作类,插入几条模拟数据
        DeviceDao deviceDao = MyApplication.getInstances().getDaoSession().getDeviceDao();
        Device device = new Device("5","2013-01-21 21:58:10","printer","init_dev","err","错误");
        deviceDao.insert(device);

        initView();

    }

    public void initView(){
        //实例化控件
        viewPager = (ViewPager) findViewById(R.id.logViewPage);
        getStatus = (TextView) findViewById(R.id.getStatus);
        getLogs = (TextView) findViewById(R.id.getLogs);
        list = new ArrayList<Fragment>();

        //设置Fragment数据源
        Fragment statusFragment = new StatusFragment();
        Fragment logFragment = new LogFragment();
        list.add(statusFragment);
        list.add(logFragment);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };

        viewPager.setAdapter(adapter);

        //设置滑动监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getStatus.setTextColor(Color.BLACK);
                getLogs.setTextColor(Color.BLACK);
                switch (position){
                    case 0:
                        getStatus.setTextColor(Color.rgb(51, 153, 0));
                        break;
                    case 1:
                        getLogs.setTextColor(Color.rgb(51, 153, 0));
                        break;
                }
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
