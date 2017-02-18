package hu.pe.routengo.entity;

/**
 * Created by Galya Sheremetova on 18.02.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

    public String getNameDe() {
        return nameDe;
    }

    public void setNameDe(String nameDe) {
        this.nameDe = nameDe;
    }

    public String getNameLt() {
        return nameLt;
    }

    public void setNameLt(String nameLt) {
        this.nameLt = nameLt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionPl() {
        return descriptionPl;
    }

    public void setDescriptionPl(String descriptionPl) {
        this.descriptionPl = descriptionPl;
    }

    public String getDescriptionDe() {
        return descriptionDe;
    }

    public void setDescriptionDe(String descriptionDe) {
        this.descriptionDe = descriptionDe;
    }

    public String getDescriptionLt() {
        return descriptionLt;
    }

    public void setDescriptionLt(String descriptionLt) {
        this.descriptionLt = descriptionLt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getCountryPl() {
        return countryPl;
    }

    public void setCountryPl(String countryPl) {
        this.countryPl = countryPl;
    }

    public String getCountryDe() {
        return countryDe;
    }

    public void setCountryDe(String countryDe) {
        this.countryDe = countryDe;
    }

    public String getCountryLt() {
        return countryLt;
    }

    public void setCountryLt(String countryLt) {
        this.countryLt = countryLt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEn() {
        return cityEn;
    }

    Иван Благовестный, [18.02.17 15:11]
    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCityPl() {
        return cityPl;
    }

    public void setCityPl(String cityPl) {
        this.cityPl = cityPl;
    }

    public String getCityDe() {
        return cityDe;
    }

    public void setCityDe(String cityDe) {
        this.cityDe = cityDe;
    }

    public String getCityLt() {
        return cityLt;
    }

    public void setCityLt(String cityLt) {
        this.cityLt = cityLt;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getXLatLng() {
        return xLatLng;
    }

    public void setXLatLng(String xLatLng) {
        this.xLatLng = xLatLng;
    }

    public String getYLatLng() {
        return yLatLng;
    }

    public void setYLatLng(String yLatLng) {
        this.yLatLng = yLatLng;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
