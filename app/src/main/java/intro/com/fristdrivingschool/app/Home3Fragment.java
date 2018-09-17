package intro.com.fristdrivingschool.app;

import android.content.Context;
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
    private MyHolder myHolder;
    private Context context;
    List<String> list=new ArrayList<>();
    private MessageBoardItemAdapter messageBoardItemAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home3_layout, container, false);
        context=getContext();
        initView();
        getData();
        initEvent();
        return view;
    }

    @Override
    protected void initView() {
        myHolder=new MyHolder(view);
        messageBoardItemAdapter=new MessageBoardItemAdapter(list,context);
        myHolder.home3LayoutMessageBoardListView.setAdapter(messageBoardItemAdapter);
    }

    @Override
    protected void getData() {
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
        myHolder.home3LayoutMessageBoardListView.setResultSize(list.size());
    }

    @Override
    protected void initEvent() {
        //下拉
        myHolder.home3LayoutMessageBoardListView.setOnRefreshListener(new AutoListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                getData();
            }
        });

        //上拉
        myHolder.home3LayoutMessageBoardListView.setOnLoadListener(new AutoListView.OnLoadListener() {
            @Override
            public void onLoadMore() {
                getData();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }

    class MyHolder {
        @BindView(R.id.home3_layout_titleTV)
        TextView home3LayoutTitleTV;
        @BindView(R.id.home3_layout_messageBoard_listView)
        AutoListView home3LayoutMessageBoardListView;

        MyHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
