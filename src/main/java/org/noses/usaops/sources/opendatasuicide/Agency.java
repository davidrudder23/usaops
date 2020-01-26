
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
    "State Agency Performing Data Updates"
})
public class Agency {

    @JsonProperty("State Agency Performing Data Updates")
    private String stateAgencyPerformingDataUpdates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("State Agency Performing Data Updates")
    public String getStateAgencyPerformingDataUpdates() {
        return stateAgencyPerformingDataUpdates;
    }

    @JsonProperty("State Agency Performing Data Updates")
    public void setStateAgencyPerformingDataUpdates(String stateAgencyPerformingDataUpdates) {
        this.stateAgencyPerformingDataUpdates = stateAgencyPerformingDataUpdates;
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
