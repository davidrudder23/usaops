
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Update Frequency",
    "Time Period of Content",
    "Date Metadata Written"
})
public class TimePeriod {

    @JsonProperty("Update Frequency")
    private String updateFrequency;
    @JsonProperty("Time Period of Content")
    private String timePeriodOfContent;
    @JsonProperty("Date Metadata Written")
    private String dateMetadataWritten;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Update Frequency")
    public String getUpdateFrequency() {
        return updateFrequency;
    }

    @JsonProperty("Update Frequency")
    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    @JsonProperty("Time Period of Content")
    public String getTimePeriodOfContent() {
        return timePeriodOfContent;
    }

    @JsonProperty("Time Period of Content")
    public void setTimePeriodOfContent(String timePeriodOfContent) {
        this.timePeriodOfContent = timePeriodOfContent;
    }

    @JsonProperty("Date Metadata Written")
    public String getDateMetadataWritten() {
        return dateMetadataWritten;
    }

    @JsonProperty("Date Metadata Written")
    public void setDateMetadataWritten(String dateMetadataWritten) {
        this.dateMetadataWritten = dateMetadataWritten;
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
