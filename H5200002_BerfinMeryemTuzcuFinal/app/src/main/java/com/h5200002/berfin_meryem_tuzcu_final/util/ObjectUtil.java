package com.h5200002.berfin_meryem_tuzcu_final.util;

import com.google.gson.Gson;
import com.h5200002.berfin_meryem_tuzcu_final.model.SongModel;

public class ObjectUtil {

    public static String songJsonString(SongModel songModel){

        Gson gson=new Gson();
        return gson.toJson(songModel);
    }

    public static SongModel jsonStringSong(String jsonString){

        Gson gson=new Gson();
        return gson.fromJson(jsonString, SongModel.class);
    }

}
