package intro.com.fristdrivingschool.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import intro.com.fristdrivingschool.Custom.AutoListView.AutoListView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.MessageBoardItemAdapter;
import intro.com.fristdrivingschool.tool.BaseFragment;

/**
 * Created by HFZS on 2018/7/5.
 * 学习页面
 */
public class Home3Fragment extends BaseFragment {
    View view;
    @BindView(R.id.home3_layout_titleTV)
    TextView home3LayoutTitleTV;
    @BindView(R.id.home3_layout_messageBoard_listView)
    AutoListView home3LayoutMessageBoardListView;
    Unbinder unbinder;
    private List<String> list = new ArrayList<>();
    private MessageBoardItemAdapter messageBoardItemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home3_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        fristMethod();
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        messageBoardItemAdapter = new MessageBoardItemAdapter(list, activity);
        home3LayoutMessageBoardListView.setAdapter(messageBoardItemAdapter);
    }

    @Override
    protected void getData(int... mark) {
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        messageBoardItemAdapter.notifyDataSetChanged();
        home3LayoutMessageBoardListView.setResultSize(list.size());
    }

    @Override
    protected void initEvent() {
        //下拉
        home3LayoutMessageBoardListView.setOnRefreshListener(new AutoListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                getData();
            }
        });

        //上拉
        home3LayoutMessageBoardListView.setOnLoadListener(new AutoListView.OnLoadListener() {
            @Override
            public void onLoadMore() {
                getData();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
