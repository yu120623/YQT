package com.yqt360.www.home.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yqt360.www.R;
import com.yqt360.www.base.activity.BaseActivity;
import com.yqt360.www.entity.CompanyList;
import com.yqt360.www.entity.HttpData;
import com.yqt360.www.http.API;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by FreeMason on 2016/4/7.
 */
public class MainActivity extends BaseActivity {

    String tjs = "{\"status\":0," +
            "\"message\":\"数据返回成功\"," +
            "\"data\":[" +
            "{" +
            "\"companyAID\":\"827ccb0eea8a706c4c34a16891f84e7b\"," +
            "\"companyName\":\"苏州中新精密工业有限公司\"," +
            "\"regStatus\":\"在业\"," +
            "\"legalPersonName\":\"颜寿水\"," +
            "\"regCapital\":\"1020万美元\"," +
            "\"establishTime\":\"2000-11-29\"" +
            "}]}";

//    @Bind(R.id.news_list)
//    RecyclerView newsList;

//    private NewsAdapter newsAdapter;
    private List<CompanyList.Company> companyList = new ArrayList<>();



    @Override
    protected void initViews() {
     //   initData();
//        loadNews();
    }


    private void initData() {
//        newsAdapter = new NewsAdapter();
//        newsList.setHasFixedSize(true);
//        newsList.setLayoutManager(new LinearLayoutManager(context));
//        newsList.setItemAnimator(new DefaultItemAnimator());
//        newsList.setAdapter(newsAdapter);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
        HttpData d =  gson.fromJson(tjs,HttpData.class);
        companyList = d.getData();
        Log.w("afb", "==============================initData: "+companyList.get(0));
    }

//    private void loadNews() {
//        API.getMainAPI().getNews(2)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SSubscriber() {
//                               @Override
//                               public void onSuccess(HttpData httpData) {
//                                   CompanyList cl = (CompanyList) httpData;
//
//                               }
//
//                               @Override
//                               public void onFailed() {
//
//                               }
//                           }
//                );

//                .subscribe(new Subscriber<List<BcConsulationModel>>() {     //订阅的事情在主线程运行
//                    @Override
//                    public void onCompleted() {
//                        swipeRefreshLayout.setRefreshing(false);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        swipeRefreshLayout.setRefreshing(false);
//                        Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNext(List<BcConsulationModel> bcConsultations) {
//                        MainActivity.this.newsDataList = bcConsultations;
//                        newsAdapter.notifyDataSetChanged();
//                    }
//                }
//                );
//    }

//    class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
//
//        @Override
//        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = inflater.inflate(R.layout.item_news, parent, false);
//            return new NewsViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(NewsViewHolder holder, int position) {
////            com= newsDataList.get(position);
////            holder.content.setText(news());
////            holder.title.setText(news.getConTitle());
////            ImageLoader.getInstance().displayImage(news.getImagePath(), holder.newsImg);
//        }
//
//        @Override
//        public int getItemCount() {
//            return newsDataList.size();
//        }
//    }
//
//    class NewsViewHolder extends RecyclerView.ViewHolder {
//        @Bind(R.id.news_img)
//        ImageView newsImg;
//        @Bind(R.id.news_title)
//        TextView title;
//        @Bind(R.id.news_content)
//        TextView content;
//
//        public NewsViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }

    @Override
    public int getContent() {
        return R.layout.activity_main;
    }

    @Override
    public String getActionBarTitle() {
        return "首页";
    }
}
