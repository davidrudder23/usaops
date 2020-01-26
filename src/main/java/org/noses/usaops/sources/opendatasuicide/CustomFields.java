
package org.noses.usaops.sources.opendatasuicide;

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
    "Jurisdiction",
    "Agency",
    "Time Period",
    "GIS Download"
})
public class CustomFields {

    @JsonProperty("Jurisdiction")
    private Jurisdiction jurisdiction;
    @JsonProperty("Agency")
    private Agency agency;
    @JsonProperty("Time Period")
    private TimePeriod timePeriod;
    @JsonProperty("GIS Download")
    private GISDownload gISDownload;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Jurisdiction")
    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    @JsonProperty("Jurisdiction")
    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @JsonProperty("Agency")
    public Agency getAgency() {
        return agency;
    }

    @JsonProperty("Agency")
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @JsonProperty("Time Period")
    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    @JsonProperty("Time Period")
    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    @JsonProperty("GIS Download")
    public GISDownload getGISDownload() {
        return gISDownload;
    }

    @JsonProperty("GIS Download")
    public void setGISDownload(GISDownload gISDownload) {
        this.gISDownload = gISDownload;
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
