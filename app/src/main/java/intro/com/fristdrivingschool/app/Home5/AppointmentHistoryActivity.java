package intro.com.fristdrivingschool.app.Home5;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.AutoListView.AutoListView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.HaveAppointmentAdapter;
import intro.com.fristdrivingschool.base.BaseActivity;

/**
 * 预约历史
 */
public class AppointmentHistoryActivity extends BaseActivity {

    @BindView(R.id.appointment_history_top_back_layout)
    TextView appointmentHistoryTopBackLayout;
    @BindView(R.id.appointment_history_top_layout)
    LinearLayout appointmentHistoryTopLayout;
    @BindView(R.id.appointment_history_listView)
    AutoListView appointmentHistoryListView;
    private List<String> listHistory=new ArrayList<>();
    private HaveAppointmentAdapter haveAppointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_history);
        ButterKnife.bind(this);
    }

    @Override
    protected void initTab() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        listHistory.add("");
        listHistory.add("");
        listHistory.add("");
        haveAppointmentAdapter=new HaveAppointmentAdapter(activity,listHistory);
        appointmentHistoryListView.setAdapter(haveAppointmentAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData(int... mark) {

    }

    @Override
    public void success(String str, int mark, int... position) {

    }

    @Override
    public void error(String str, int mark, int... position) {

    }
}
