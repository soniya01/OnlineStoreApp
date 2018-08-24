package com.soniyaprojects.onlinestoreapp.webservice.DTOs;

import com.google.gson.annotations.SerializedName;
import com.soniyaprojects.onlinestoreapp.models.Category;
import com.soniyaprojects.onlinestoreapp.models.Ranking;

import java.util.List;

public class OnlineStoreResponse extends BaseResponse {

    @SerializedName("categories")
    private List<Category> categoryList;

    @SerializedName("rankings")
    private List<Ranking> rankingList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Ranking> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }
}
