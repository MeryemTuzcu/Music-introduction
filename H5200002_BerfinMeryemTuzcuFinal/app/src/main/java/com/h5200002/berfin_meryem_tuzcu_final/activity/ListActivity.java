package com.h5200002.berfin_meryem_tuzcu_final.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h5200002.berfin_meryem_tuzcu_final.R;
import com.h5200002.berfin_meryem_tuzcu_final.adaptor.SongAdaptor;
import com.h5200002.berfin_meryem_tuzcu_final.model.SongModel;
import com.h5200002.berfin_meryem_tuzcu_final.network.Service;
import com.h5200002.berfin_meryem_tuzcu_final.util.AlertUtil;
import com.h5200002.berfin_meryem_tuzcu_final.util.Constans;
import com.h5200002.berfin_meryem_tuzcu_final.util.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    androidx.constraintlayout.widget.ConstraintLayout imgInfo;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();




    }
    private void init(){
        setImgInfo();
        getSongs();
    }

    private void setImgInfo(){
        imgInfo=findViewById(R.id.imgInfo);

    }
    private void getSongs(){
        new Service().getServiceApi().getSongs().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<SongModel>>() {
                    List<SongModel> songs=new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<SongModel> songModelListParam) {
                        songs=songModelListParam;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete()
                    {
                        if(songs.size()>0) {
                            initRecycleView(songs);

                        }
                    }
                });
    }


    private void initRecycleView(List<SongModel> songModelList)
    {
        recyclerView =findViewById(R.id.rcvSongs);

        SongAdaptor songAdaptor = new SongAdaptor(songModelList, getApplicationContext(), new SongAdaptor.OnItemClickListener(){


            @Override
            public void onItemClick(SongModel clickSong) {
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.listScreen_click_song)+clickSong.getName(),Toast.LENGTH_SHORT).show();
                switchScreen(clickSong);

            }

            @Override
            public void onClick(int position) {


            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(songAdaptor);
    }


    @Override
    public void onBackPressed() {
        context = this;
        boolean IsBack = AlertUtil.onBackPressed(context);
        if(IsBack) super.onBackPressed();
    }


    private void switchScreen(SongModel clickSong){


        Intent ListActivity = new Intent(getApplicationContext(), DetailActivity.class);
        String clickSongString= ObjectUtil.songJsonString(clickSong);
        ListActivity.putExtra(Constans.CLICK_SONG,clickSongString);
        startActivity(ListActivity);

    }

}
