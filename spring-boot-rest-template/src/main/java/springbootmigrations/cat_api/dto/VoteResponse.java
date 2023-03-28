package springbootmigrations.cat_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteResponse {

    private String message;
    private Integer id;
    @JsonProperty("image_id")
    private String imageId;
    @JsonProperty("sub_id")
    private String subId;
    private Integer value;
    @JsonProperty("country_code")
    private String countryCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "VoteResponse{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", imageId='" + imageId + '\'' +
                ", subId='" + subId + '\'' +
                ", value=" + value +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
