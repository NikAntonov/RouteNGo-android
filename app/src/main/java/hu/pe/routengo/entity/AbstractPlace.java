package hu.pe.routengo.entity;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.requery.Entity;

@Entity
public abstract class AbstractPlace implements Parcelable {
    @SerializedName("id")
    @Expose
    protected String id;
    @SerializedName("name")
    @Expose
    protected String name;
    @SerializedName("name_en")
    @Expose
    protected String nameEn;
    @SerializedName("name_pl")
    @Expose
    protected String namePl;
    @SerializedName("name_de")
    @Expose
    protected String nameDe;
    @SerializedName("name_lt")
    @Expose
    protected String nameLt;
    @SerializedName("type")
    @Expose
    protected String type;
    @SerializedName("description")
    @Expose
    protected String description;
    @SerializedName("description_en")
    @Expose
    protected String descriptionEn;
    @SerializedName("description_pl")
    @Expose
    protected String descriptionPl;
    @SerializedName("description_de")
    @Expose
    protected String descriptionDe;
    @SerializedName("description_lt")
    @Expose
    protected String descriptionLt;
    @SerializedName("country")
    @Expose
    protected String country;
    @SerializedName("country_en")
    @Expose
    protected String countryEn;
    @SerializedName("country_pl")
    @Expose
    protected String countryPl;
    @SerializedName("country_de")
    @Expose
    protected String countryDe;
    @SerializedName("country_lt")
    @Expose
    protected String countryLt;
    @SerializedName("city")
    @Expose
    protected String city;
    @SerializedName("city_en")
    @Expose
    protected String cityEn;
    @SerializedName("city_pl")
    @Expose
    protected String cityPl;
    @SerializedName("city_de")
    @Expose
    protected String cityDe;
    @SerializedName("city_lt")
    @Expose
    protected String cityLt;
    @SerializedName("region")
    @Expose
    protected String region;
    @SerializedName("image_url")
    @Expose
    protected String imageUrl;
    @SerializedName("website_url")
    @Expose
    protected String websiteUrl;
    @SerializedName("x_latLng")
    @Expose
    protected String xLatLng;
    @SerializedName("y_latLng")
    @Expose
    protected String yLatLng;
    @SerializedName("time")
    @Expose
    protected String time;
}