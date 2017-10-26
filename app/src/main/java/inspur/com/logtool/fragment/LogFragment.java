package inspur.com.logtool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import inspur.com.logtool.MyApplication;
import inspur.com.logtool.R;
import inspur.com.logtool.dao.DeviceDao;
import inspur.com.logtool.model.Device;

/**
 * *Author 王建林
 * *E-mail wangjianlin1989@163.com
 * *TIME 2017/10/26  17:31
 * *
 * *Description:
 */
public class LogFragment extends Fragment{
    //声明listview
    private ListView logListView;
    //获取到的log数据
    private List<HashMap<String,Object>> listItem ;

    //获取开始时间和结束时间
    private EditText startTime,endTime;
    //获取查询按钮
    private Button search;
    //获取数据库操作类
    public static DeviceDao deviceDao = MyApplication.getInstances().getDaoSession().getDeviceDao();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logfragment,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logListView = (ListView) this.getActivity().findViewById(R.id.logList);
        startTime = (EditText) this.getActivity().findViewById(R.id.startTimeEdit);
        endTime = (EditText) this.getActivity().findViewById(R.id.endTimeEdit);
        search = (Button) this.getActivity().findViewById(R.id.search);


        //查询出所有的log数据
        List<Device> deviceListBase = deviceDao.loadAll();
        //遍历数据，将数据存入定义好的模板格式
        listItem = new ArrayList<HashMap<String, Object>>();
        for(Device item:deviceListBase){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("deviceName", item.getDEVICE_NAME());
            map.put("deviceAction", item.getACTION());
            map.put("deviceCode", item.getCODE());
            map.put("deviceDescription", item.getDESCRIPTION());
            map.put("deviceTime", item.getTIME());
            listItem.add(map);
        }
        //新建listview对应的适配器
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this.getContext(),listItem,R.layout.logitem,new String[]{"deviceName"
                ,"deviceAction","deviceCode","deviceDescription","deviceTime"},new int[]{R.id.deviceName,R.id.deviceAction,R.id.deviceCode,R.id.deviceDescription,R.id.deviceTime});
        logListView.setAdapter(mSimpleAdapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deviceDao.queryRaw()
            }
        });
    }
}
