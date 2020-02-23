
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Jurisdiction"
})
public class Jurisdiction {

    @JsonProperty("Jurisdiction")
    private String jurisdiction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Jurisdiction")
    public String getJurisdiction() {
        return jurisdiction;
    }

    @JsonProperty("Jurisdiction")
    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
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
