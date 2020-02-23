
package org.noses.usaops.sources.usafacts;

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
    "id",
    "geo_id",
    "geo_id_type",
    "geo_name",
    "name",
    "government_type",
    "x_type",
    "y_type",
    "rounding_unit",
    "sig_figs",
    "data",
    "meta",
    "default_adjustment",
    "adjustment_id",
    "available_adjustments"
})
public class Dataset {

    @JsonProperty("id")
    private String id;
    @JsonProperty("geo_id")
    private String geoId;
    @JsonProperty("geo_id_type")
    private String geoIdType;
    @JsonProperty("geo_name")
    private String geoName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("government_type")
    private String governmentType;
    @JsonProperty("x_type")
    private String xType;
    @JsonProperty("y_type")
    private String yType;
    @JsonProperty("rounding_unit")
    private Integer roundingUnit;
    @JsonProperty("sig_figs")
    private Integer sigFigs;
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonProperty("meta")
    private List<Object> meta = null;
    @JsonProperty("default_adjustment")
    private Object defaultAdjustment;
    @JsonProperty("adjustment_id")
    private Object adjustmentId;
    @JsonProperty("available_adjustments")
    private List<Object> availableAdjustments = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("geo_id")
    public String getGeoId() {
        return geoId;
    }

    @JsonProperty("geo_id")
    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    @JsonProperty("geo_id_type")
    public String getGeoIdType() {
        return geoIdType;
    }

    @JsonProperty("geo_id_type")
    public void setGeoIdType(String geoIdType) {
        this.geoIdType = geoIdType;
    }

    @JsonProperty("geo_name")
    public String getGeoName() {
        return geoName;
    }

    @JsonProperty("geo_name")
    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("government_type")
    public String getGovernmentType() {
        return governmentType;
    }

    @JsonProperty("government_type")
    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    @JsonProperty("x_type")
    public String getXType() {
        return xType;
    }

    @JsonProperty("x_type")
    public void setXType(String xType) {
        this.xType = xType;
    }

    @JsonProperty("y_type")
    public String getYType() {
        return yType;
    }

    @JsonProperty("y_type")
    public void setYType(String yType) {
        this.yType = yType;
    }

    @JsonProperty("rounding_unit")
    public Integer getRoundingUnit() {
        return roundingUnit;
    }

    @JsonProperty("rounding_unit")
    public void setRoundingUnit(Integer roundingUnit) {
        this.roundingUnit = roundingUnit;
    }

    @JsonProperty("sig_figs")
    public Integer getSigFigs() {
        return sigFigs;
    }

    @JsonProperty("sig_figs")
    public void setSigFigs(Integer sigFigs) {
        this.sigFigs = sigFigs;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonProperty("meta")
    public List<Object> getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    @JsonProperty("default_adjustment")
    public Object getDefaultAdjustment() {
        return defaultAdjustment;
    }

    @JsonProperty("default_adjustment")
    public void setDefaultAdjustment(Object defaultAdjustment) {
        this.defaultAdjustment = defaultAdjustment;
    }

    @JsonProperty("adjustment_id")
    public Object getAdjustmentId() {
        return adjustmentId;
    }

    @JsonProperty("adjustment_id")
    public void setAdjustmentId(Object adjustmentId) {
        this.adjustmentId = adjustmentId;
    }

    @JsonProperty("available_adjustments")
    public List<Object> getAvailableAdjustments() {
        return availableAdjustments;
    }

    @JsonProperty("available_adjustments")
    public void setAvailableAdjustments(List<Object> availableAdjustments) {
        this.availableAdjustments = availableAdjustments;
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
