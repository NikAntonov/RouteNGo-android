package hu.pe.routengo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.requery.Entity;

@Entity
public abstract class AbstractPlace {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("name_en")
    @Expose
    public String nameEn;
    @SerializedName("name_pl")
    @Expose
    public String namePl;
    @SerializedName("name_de")
    @Expose
    public String nameDe;
    @SerializedName("name_lt")
    @Expose
    public String nameLt;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("description_en")
    @Expose
    public String descriptionEn;
    @SerializedName("description_pl")
    @Expose
    public String descriptionPl;
    @SerializedName("description_de")
    @Expose
    public String descriptionDe;
    @SerializedName("description_lt")
    @Expose
    public String descriptionLt;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("country_en")
    @Expose
    public String countryEn;
    @SerializedName("country_pl")
    @Expose
    public String countryPl;
    @SerializedName("country_de")
    @Expose
    public String countryDe;
    @SerializedName("country_lt")
    @Expose
    public String countryLt;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("city_en")
    @Expose
    public String cityEn;
    @SerializedName("city_pl")
    @Expose
    public String cityPl;
    @SerializedName("city_de")
    @Expose
    public String cityDe;
    @SerializedName("city_lt")
    @Expose
    public String cityLt;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("image_url")
    @Expose
    public String imageUrl;
    @SerializedName("website_url")
    @Expose
    public String websiteUrl;
    @SerializedName("x_latLng")
    @Expose
    public String xLatLng;
    @SerializedName("y_latLng")
    @Expose
    public String yLatLng;
    @SerializedName("time")
    @Expose
    public String time;
}