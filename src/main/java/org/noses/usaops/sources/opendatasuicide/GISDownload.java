
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Place Keywords"
})
public class GISDownload {

    @JsonProperty("Place Keywords")
    private String placeKeywords;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Place Keywords")
    public String getPlaceKeywords() {
        return placeKeywords;
    }

    @JsonProperty("Place Keywords")
    public void setPlaceKeywords(String placeKeywords) {
        this.placeKeywords = placeKeywords;
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
