package com.h5200002.berfin_meryem_tuzcu_final.network;




import com.h5200002.berfin_meryem_tuzcu_final.model.SongModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("songs.json")
    Observable<List<SongModel>> getSongs();


}
