package com.h5190045.selim_gecu_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlanetModel { //Gezegenler için model dosyası
    @SerializedName("GezegenAdi")
    @Expose
    private String gezegenAdi;
    @SerializedName("GezegenYaricapi")
    @Expose
    private String gezegenYaricapi;
    @SerializedName("DunyayaUzakligi")
    @Expose
    private String dunyayaUzakligi;
    @SerializedName("GezegenYuzeySicakligi")
    @Expose
    private String gezegenYuzeySicakligi;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("KapakImgUrl")
    @Expose
    private String kapakImgUrl;

    public String getGezegenAdi() {
        return gezegenAdi;
    }

    public void setGezegenAdi(String gezegenAdi) {
        this.gezegenAdi = gezegenAdi;
    }

    public String getGezegenYaricapi() {
        return gezegenYaricapi;
    }

    public void setGezegenYaricapi(String gezegenYaricapi) {
        this.gezegenYaricapi = gezegenYaricapi;
    }

    public String getDunyayaUzakligi() {
        return dunyayaUzakligi;
    }

    public void setDunyayaUzakligi(String dunyayaUzakligi) {
        this.dunyayaUzakligi = dunyayaUzakligi;
    }

    public String getGezegenYuzeySicakligi() {
        return gezegenYuzeySicakligi;
    }

    public void setGezegenYuzeySicakligi(String gezegenYuzeySicakligi) {
        this.gezegenYuzeySicakligi = gezegenYuzeySicakligi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getKapakImgUrl() {
        return kapakImgUrl;
    }

    public void setKapakImgUrl(String kapakImgUrl) {
        this.kapakImgUrl = kapakImgUrl;
    }
}
