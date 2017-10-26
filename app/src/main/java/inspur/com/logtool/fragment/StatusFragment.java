package inspur.com.logtool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inspur.com.logtool.R;

/**
 * *Author 王建林
 * *E-mail wangjianlin1989@163.com
 * *TIME 2017/10/26  17:29
 * *
 * *Description:
 */
public class StatusFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.statusfragment,container,false);
    }
}
