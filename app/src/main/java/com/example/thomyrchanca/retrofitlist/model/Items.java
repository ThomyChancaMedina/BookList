package com.example.thomyrchanca.retrofitlist.model;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("etag")
    @Expose
    public String etag;
    @SerializedName("selfLink")
    @Expose
    public String selfLink;

    @SerializedName("volumeInfo")
    @Expose
    public VolumeInfo volumeInfo;

    /*@SerializedName("saleInfo")
    @Expose
    public SaleInfo saleInfo;
    @SerializedName("accessInfo")
    @Expose
    public AccessInfo accessInfo;
    @SerializedName("searchInfo")
    @Expose
    public SearchInfo searchInfo;*/

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

   public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    /* public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }*/

    @Override
    public String toString() {
        return "Item{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selfLink='" + selfLink + '\'' +
                ", volumeInfo=" + volumeInfo +
               /* ", saleInfo=" + saleInfo +
                ", accessInfo=" + accessInfo +
                ", searchInfo=" + searchInfo +*/
                '}';
    }
}