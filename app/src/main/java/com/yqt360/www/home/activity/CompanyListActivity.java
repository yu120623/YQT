package com.yqt360.www.home.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cundong.recyclerview.RecyclerViewUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yqt360.www.R;
import com.yqt360.www.base.activity.BaseActivity;
import com.yqt360.www.entity.CompanyList;
import com.yqt360.www.entity.HttpData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/4/21.
 */
public class CompanyListActivity extends BaseActivity {
    @Bind(R.id.company_list)
    RecyclerView companyList;

    private List<CompanyList.Company> companyDataList = new ArrayList<>();
    private CompanyListAdapter companyListAdapter;

    String strJson = "{\"status\":0," +
            "\"message\":\"\"," +
            "\"data\":[" +
            "{" +
            "\"companyAID\":\"827ccb0eea8a706c4c34a16891f84e7b\"," +
            "\"companyName\":\"苏州中新精密工业有限公司\"," +
            "\"regStatus\":\"在业\"," +
            "\"legalPersonName\":\"颜寿水\"," +
            "\"regCapital\":\"1020万美元\"," +
            "\"establishTime\":\"2000-11-29\"" +
            "}," +
            "{" +
            "\"companyAID\":\"23e81af89d45f9ad1961fae378a16814\"," +
            "\"companyName\":\"苏州中新金属制造有限公司\"," +
            "\"regStatus\":\"在业\"," +
            "\"legalPersonName\":\"常桂平\"," +
            "\"regCapital\":\"3000万元人民币\"," +
            "\"establishTime\":\"2004-07-30\"" +
            "}" +
            "]}";

    @Override
    protected void initViews() {
        init();
        companyListAdapter = new CompanyListAdapter();
        companyList.setLayoutManager(new LinearLayoutManager(context));
        companyList.setAdapter(companyListAdapter);

    }

    void init(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
        HttpData data = gson.fromJson(strJson, HttpData.class);
        companyDataList = data.getData();

    }



    class CompanyListAdapter extends RecyclerView.Adapter<CompanyListViewHolder> {

        @Override
        public CompanyListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_companies, parent, false);
            return new CompanyListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CompanyListViewHolder holder, int position) {
            holder.companyName.setText(companyDataList.get(position).getCompanyName());
            holder.companyRegStatus.setText(companyDataList.get(position).getRegStatus());

        }

        @Override
        public int getItemCount() {
            return companyDataList.size();
        }
    }

    class CompanyListViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.company_name)
        TextView companyName;
        @Bind(R.id.company_regstatus)
        TextView companyRegStatus;

        public CompanyListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    @Override
    public int getContent() {
        return R.layout.activity_company_list;
    }

    @Override
    public String getActionBarTitle() {
        return "查询结果";
    }

}

