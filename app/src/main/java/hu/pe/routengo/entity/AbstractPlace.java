package hu.pe.routengo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.requery.Entity;

@Entity
public abstract class AbstractPlace {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("name_en")
    @Expose
    String nameEn;
    @SerializedName("name_pl")
    @Expose
    String namePl;
    @SerializedName("name_de")
    @Expose
    String nameDe;
    @SerializedName("name_lt")
    @Expose
    String nameLt;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("description_en")
    @Expose
    String descriptionEn;
    @SerializedName("description_pl")
    @Expose
    String descriptionPl;
    @SerializedName("description_de")
    @Expose
    String descriptionDe;
    @SerializedName("description_lt")
    @Expose
    String descriptionLt;
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("country_en")
    @Expose
    String countryEn;
    @SerializedName("country_pl")
    @Expose
    String countryPl;
    @SerializedName("country_de")
    @Expose
    String countryDe;
    @SerializedName("country_lt")
    @Expose
    String countryLt;
    @SerializedName("city")
    @Expose
    String city;
    @SerializedName("city_en")
    @Expose
    String cityEn;
    @SerializedName("city_pl")
    @Expose
    String cityPl;
    @SerializedName("city_de")
    @Expose
    String cityDe;
    @SerializedName("city_lt")
    @Expose
    String cityLt;
    @SerializedName("region")
    @Expose
    String region;
    @SerializedName("image_url")
    @Expose
    String imageUrl;
    @SerializedName("website_url")
    @Expose
    String websiteUrl;
    @SerializedName("x_latLng")
    @Expose
    String xLatLng;
    @SerializedName("y_latLng")
    @Expose
    String yLatLng;
    @SerializedName("time")
    @Expose
    String time;
}