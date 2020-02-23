
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
    "query_match",
    "dataset"
})
public class GovernmentEmploymentDTO {

    @JsonProperty("query_match")
    private QueryMatch queryMatch;
    @JsonProperty("dataset")
    private Dataset dataset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("query_match")
    public QueryMatch getQueryMatch() {
        return queryMatch;
    }

    @JsonProperty("query_match")
    public void setQueryMatch(QueryMatch queryMatch) {
        this.queryMatch = queryMatch;
    }

    @JsonProperty("dataset")
    public Dataset getDataset() {
        return dataset;
    }

    @JsonProperty("dataset")
    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
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
