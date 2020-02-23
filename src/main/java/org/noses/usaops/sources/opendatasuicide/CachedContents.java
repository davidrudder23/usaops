
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "largest",
    "non_null",
    "null",
    "top",
    "smallest",
    "cardinality"
})
public class CachedContents {

    @JsonProperty("largest")
    private String largest;
    @JsonProperty("non_null")
    private String nonNull;
    @JsonProperty("null")
    private String _null;
    @JsonProperty("top")
    private List<Top> top = null;
    @JsonProperty("smallest")
    private String smallest;
    @JsonProperty("cardinality")
    private String cardinality;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("largest")
    public String getLargest() {
        return largest;
    }

    @JsonProperty("largest")
    public void setLargest(String largest) {
        this.largest = largest;
    }

    @JsonProperty("non_null")
    public String getNonNull() {
        return nonNull;
    }

    @JsonProperty("non_null")
    public void setNonNull(String nonNull) {
        this.nonNull = nonNull;
    }

    @JsonProperty("null")
    public String getNull() {
        return _null;
    }

    @JsonProperty("null")
    public void setNull(String _null) {
        this._null = _null;
    }

    @JsonProperty("top")
    public List<Top> getTop() {
        return top;
    }

    @JsonProperty("top")
    public void setTop(List<Top> top) {
        this.top = top;
    }

    @JsonProperty("smallest")
    public String getSmallest() {
        return smallest;
    }

    @JsonProperty("smallest")
    public void setSmallest(String smallest) {
        this.smallest = smallest;
    }

    @JsonProperty("cardinality")
    public String getCardinality() {
        return cardinality;
    }

    @JsonProperty("cardinality")
    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
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
