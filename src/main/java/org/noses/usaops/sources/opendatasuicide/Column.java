
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "dataTypeName",
    "fieldName",
    "position",
    "renderTypeName",
    "format",
    "flags",
    "description",
    "tableColumnId",
    "cachedContents"
})
public class Column {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dataTypeName")
    private String dataTypeName;
    @JsonProperty("fieldName")
    private String fieldName;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("renderTypeName")
    private String renderTypeName;
    @JsonProperty("format")
    private Format format;
    @JsonProperty("flags")
    private List<String> flags = null;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tableColumnId")
    private Integer tableColumnId;
    @JsonProperty("cachedContents")
    private CachedContents cachedContents;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("dataTypeName")
    public String getDataTypeName() {
        return dataTypeName;
    }

    @JsonProperty("dataTypeName")
    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    @JsonProperty("fieldName")
    public String getFieldName() {
        return fieldName;
    }

    @JsonProperty("fieldName")
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("renderTypeName")
    public String getRenderTypeName() {
        return renderTypeName;
    }

    @JsonProperty("renderTypeName")
    public void setRenderTypeName(String renderTypeName) {
        this.renderTypeName = renderTypeName;
    }

    @JsonProperty("format")
    public Format getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(Format format) {
        this.format = format;
    }

    @JsonProperty("flags")
    public List<String> getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("tableColumnId")
    public Integer getTableColumnId() {
        return tableColumnId;
    }

    @JsonProperty("tableColumnId")
    public void setTableColumnId(Integer tableColumnId) {
        this.tableColumnId = tableColumnId;
    }

    @JsonProperty("cachedContents")
    public CachedContents getCachedContents() {
        return cachedContents;
    }

    @JsonProperty("cachedContents")
    public void setCachedContents(CachedContents cachedContents) {
        this.cachedContents = cachedContents;
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
