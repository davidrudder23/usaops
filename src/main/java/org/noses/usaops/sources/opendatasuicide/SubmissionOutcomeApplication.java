
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failureCount",
    "status"
})
public class SubmissionOutcomeApplication {

    @JsonProperty("failureCount")
    private Integer failureCount;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("failureCount")
    public Integer getFailureCount() {
        return failureCount;
    }

    @JsonProperty("failureCount")
    public void setFailureCount(Integer failureCount) {
        this.failureCount = failureCount;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
