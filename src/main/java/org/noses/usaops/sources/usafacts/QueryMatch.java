
package org.noses.usaops.sources.usafacts;

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
    "line_item_id",
    "gov_type",
    "fips"
})
public class QueryMatch {

    @JsonProperty("line_item_id")
    private String lineItemId;
    @JsonProperty("gov_type")
    private String govType;
    @JsonProperty("fips")
    private String fips;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("line_item_id")
    public String getLineItemId() {
        return lineItemId;
    }

    @JsonProperty("line_item_id")
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @JsonProperty("gov_type")
    public String getGovType() {
        return govType;
    }

    @JsonProperty("gov_type")
    public void setGovType(String govType) {
        this.govType = govType;
    }

    @JsonProperty("fips")
    public String getFips() {
        return fips;
    }

    @JsonProperty("fips")
    public void setFips(String fips) {
        this.fips = fips;
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
