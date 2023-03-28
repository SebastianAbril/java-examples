package springbootmigrations.cat_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteRequest {
    @JsonProperty("image_id")
    private String imageId;

    @JsonProperty("sub_id")
    private String subId;
    private Integer value;

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
}
