package hu.pe.routengo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.requery.Entity;

@Entity
public abstract class AbstractPlace {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_pl")
    @Expose
    private String namePl;
    @SerializedName("name_de")
    @Expose
    private String nameDe;
    @SerializedName("name_lt")
    @Expose
    private String nameLt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_en")
    @Expose
    private String descriptionEn;
    @SerializedName("description_pl")
    @Expose
    private String descriptionPl;
    @SerializedName("description_de")
    @Expose
    private String descriptionDe;
    @SerializedName("description_lt")
    @Expose
    private String descriptionLt;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_en")
    @Expose
    private String countryEn;
    @SerializedName("country_pl")
    @Expose
    private String countryPl;
    @SerializedName("country_de")
    @Expose
    private String countryDe;
    @SerializedName("country_lt")
    @Expose
    private String countryLt;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("city_en")
    @Expose
    private String cityEn;
    @SerializedName("city_pl")
    @Expose
    private String cityPl;
    @SerializedName("city_de")
    @Expose
    private String cityDe;
    @SerializedName("city_lt")
    @Expose
    private String cityLt;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("x_latLng")
    @Expose
    private String xLatLng;
    @SerializedName("y_latLng")
    @Expose
    private String yLatLng;
    @SerializedName("time")
    @Expose
    private String time;
}
