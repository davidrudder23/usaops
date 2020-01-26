
package org.noses.usaops.sources.opendatasuicide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "custom_fields",
    "availableDisplayTypes"
})
public class Metadata {

    @JsonProperty("custom_fields")
    private CustomFields customFields;
    @JsonProperty("availableDisplayTypes")
    private List<String> availableDisplayTypes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("custom_fields")
    public CustomFields getCustomFields() {
        return customFields;
    }

    @JsonProperty("custom_fields")
    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("availableDisplayTypes")
    public List<String> getAvailableDisplayTypes() {
        return availableDisplayTypes;
    }

    @JsonProperty("availableDisplayTypes")
    public void setAvailableDisplayTypes(List<String> availableDisplayTypes) {
        this.availableDisplayTypes = availableDisplayTypes;
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
