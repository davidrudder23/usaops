package org.noses.usaops.sources.cpj;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Year",
        "Motive Confirmed",
        "Motive Unconfirmed",
        "Media Worker"
})
public class JournalistsKilledDTO {

    @JsonProperty("Year")
    private String year;
    @JsonProperty("Motive Confirmed")
    private Integer motiveConfirmed;
    @JsonProperty("Motive Unconfirmed")
    private Integer motiveUnconfirmed;
    @JsonProperty("Media Worker")
    private Integer mediaWorker;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Year")
    public String getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("Motive Confirmed")
    public Integer getMotiveConfirmed() {
        return motiveConfirmed;
    }

    @JsonProperty("Motive Confirmed")
    public void setMotiveConfirmed(Integer motiveConfirmed) {
        this.motiveConfirmed = motiveConfirmed;
    }

    @JsonProperty("Motive Unconfirmed")
    public Integer getMotiveUnconfirmed() {
        return motiveUnconfirmed;
    }

    @JsonProperty("Motive Unconfirmed")
    public void setMotiveUnconfirmed(Integer motiveUnconfirmed) {
        this.motiveUnconfirmed = motiveUnconfirmed;
    }

    @JsonProperty("Media Worker")
    public Integer getMediaWorker() {
        return mediaWorker;
    }

    @JsonProperty("Media Worker")
    public void setMediaWorker(Integer mediaWorker) {
        this.mediaWorker = mediaWorker;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
