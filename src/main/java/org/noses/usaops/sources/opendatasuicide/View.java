
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "attribution",
    "averageRating",
    "category",
    "createdAt",
    "description",
    "displayType",
    "downloadCount",
    "hideFromCatalog",
    "hideFromDataJson",
    "indexUpdatedAt",
    "newBackend",
    "numberOfComments",
    "oid",
    "provenance",
    "publicationAppendEnabled",
    "publicationDate",
    "publicationGroup",
    "publicationStage",
    "rowsUpdatedAt",
    "rowsUpdatedBy",
    "tableId",
    "totalTimesRated",
    "viewCount",
    "viewLastModified",
    "viewType",
    "approvals",
    "columns",
    "grants",
    "metadata",
    "owner",
    "query",
    "rights",
    "tableAuthor",
    "tags",
    "flags"
})
public class View {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("attribution")
    private String attribution;
    @JsonProperty("averageRating")
    private Integer averageRating;
    @JsonProperty("category")
    private String category;
    @JsonProperty("createdAt")
    private Integer createdAt;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayType")
    private String displayType;
    @JsonProperty("downloadCount")
    private Integer downloadCount;
    @JsonProperty("hideFromCatalog")
    private Boolean hideFromCatalog;
    @JsonProperty("hideFromDataJson")
    private Boolean hideFromDataJson;
    @JsonProperty("indexUpdatedAt")
    private Integer indexUpdatedAt;
    @JsonProperty("newBackend")
    private Boolean newBackend;
    @JsonProperty("numberOfComments")
    private Integer numberOfComments;
    @JsonProperty("oid")
    private Integer oid;
    @JsonProperty("provenance")
    private String provenance;
    @JsonProperty("publicationAppendEnabled")
    private Boolean publicationAppendEnabled;
    @JsonProperty("publicationDate")
    private Integer publicationDate;
    @JsonProperty("publicationGroup")
    private Integer publicationGroup;
    @JsonProperty("publicationStage")
    private String publicationStage;
    @JsonProperty("rowsUpdatedAt")
    private Integer rowsUpdatedAt;
    @JsonProperty("rowsUpdatedBy")
    private String rowsUpdatedBy;
    @JsonProperty("tableId")
    private Integer tableId;
    @JsonProperty("totalTimesRated")
    private Integer totalTimesRated;
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonProperty("viewLastModified")
    private Integer viewLastModified;
    @JsonProperty("viewType")
    private String viewType;
    @JsonProperty("approvals")
    private List<Approval> approvals = null;
    @JsonProperty("columns")
    private List<Column> columns = null;
    @JsonProperty("grants")
    private List<Grant> grants = null;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("query")
    private Query query;
    @JsonProperty("rights")
    private List<String> rights = null;
    @JsonProperty("tableAuthor")
    private TableAuthor tableAuthor;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("flags")
    private List<String> flags = null;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("attribution")
    public String getAttribution() {
        return attribution;
    }

    @JsonProperty("attribution")
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    @JsonProperty("averageRating")
    public Integer getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayType")
    public String getDisplayType() {
        return displayType;
    }

    @JsonProperty("displayType")
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    @JsonProperty("downloadCount")
    public Integer getDownloadCount() {
        return downloadCount;
    }

    @JsonProperty("downloadCount")
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @JsonProperty("hideFromCatalog")
    public Boolean getHideFromCatalog() {
        return hideFromCatalog;
    }

    @JsonProperty("hideFromCatalog")
    public void setHideFromCatalog(Boolean hideFromCatalog) {
        this.hideFromCatalog = hideFromCatalog;
    }

    @JsonProperty("hideFromDataJson")
    public Boolean getHideFromDataJson() {
        return hideFromDataJson;
    }

    @JsonProperty("hideFromDataJson")
    public void setHideFromDataJson(Boolean hideFromDataJson) {
        this.hideFromDataJson = hideFromDataJson;
    }

    @JsonProperty("indexUpdatedAt")
    public Integer getIndexUpdatedAt() {
        return indexUpdatedAt;
    }

    @JsonProperty("indexUpdatedAt")
    public void setIndexUpdatedAt(Integer indexUpdatedAt) {
        this.indexUpdatedAt = indexUpdatedAt;
    }

    @JsonProperty("newBackend")
    public Boolean getNewBackend() {
        return newBackend;
    }

    @JsonProperty("newBackend")
    public void setNewBackend(Boolean newBackend) {
        this.newBackend = newBackend;
    }

    @JsonProperty("numberOfComments")
    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    @JsonProperty("numberOfComments")
    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    @JsonProperty("oid")
    public Integer getOid() {
        return oid;
    }

    @JsonProperty("oid")
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @JsonProperty("provenance")
    public String getProvenance() {
        return provenance;
    }

    @JsonProperty("provenance")
    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    @JsonProperty("publicationAppendEnabled")
    public Boolean getPublicationAppendEnabled() {
        return publicationAppendEnabled;
    }

    @JsonProperty("publicationAppendEnabled")
    public void setPublicationAppendEnabled(Boolean publicationAppendEnabled) {
        this.publicationAppendEnabled = publicationAppendEnabled;
    }

    @JsonProperty("publicationDate")
    public Integer getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JsonProperty("publicationGroup")
    public Integer getPublicationGroup() {
        return publicationGroup;
    }

    @JsonProperty("publicationGroup")
    public void setPublicationGroup(Integer publicationGroup) {
        this.publicationGroup = publicationGroup;
    }

    @JsonProperty("publicationStage")
    public String getPublicationStage() {
        return publicationStage;
    }

    @JsonProperty("publicationStage")
    public void setPublicationStage(String publicationStage) {
        this.publicationStage = publicationStage;
    }

    @JsonProperty("rowsUpdatedAt")
    public Integer getRowsUpdatedAt() {
        return rowsUpdatedAt;
    }

    @JsonProperty("rowsUpdatedAt")
    public void setRowsUpdatedAt(Integer rowsUpdatedAt) {
        this.rowsUpdatedAt = rowsUpdatedAt;
    }

    @JsonProperty("rowsUpdatedBy")
    public String getRowsUpdatedBy() {
        return rowsUpdatedBy;
    }

    @JsonProperty("rowsUpdatedBy")
    public void setRowsUpdatedBy(String rowsUpdatedBy) {
        this.rowsUpdatedBy = rowsUpdatedBy;
    }

    @JsonProperty("tableId")
    public Integer getTableId() {
        return tableId;
    }

    @JsonProperty("tableId")
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @JsonProperty("totalTimesRated")
    public Integer getTotalTimesRated() {
        return totalTimesRated;
    }

    @JsonProperty("totalTimesRated")
    public void setTotalTimesRated(Integer totalTimesRated) {
        this.totalTimesRated = totalTimesRated;
    }

    @JsonProperty("viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("viewLastModified")
    public Integer getViewLastModified() {
        return viewLastModified;
    }

    @JsonProperty("viewLastModified")
    public void setViewLastModified(Integer viewLastModified) {
        this.viewLastModified = viewLastModified;
    }

    @JsonProperty("viewType")
    public String getViewType() {
        return viewType;
    }

    @JsonProperty("viewType")
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    @JsonProperty("approvals")
    public List<Approval> getApprovals() {
        return approvals;
    }

    @JsonProperty("approvals")
    public void setApprovals(List<Approval> approvals) {
        this.approvals = approvals;
    }

    @JsonProperty("columns")
    public List<Column> getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @JsonProperty("grants")
    public List<Grant> getGrants() {
        return grants;
    }

    @JsonProperty("grants")
    public void setGrants(List<Grant> grants) {
        this.grants = grants;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    @JsonProperty("rights")
    public List<String> getRights() {
        return rights;
    }

    @JsonProperty("rights")
    public void setRights(List<String> rights) {
        this.rights = rights;
    }

    @JsonProperty("tableAuthor")
    public TableAuthor getTableAuthor() {
        return tableAuthor;
    }

    @JsonProperty("tableAuthor")
    public void setTableAuthor(TableAuthor tableAuthor) {
        this.tableAuthor = tableAuthor;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("flags")
    public List<String> getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(List<String> flags) {
        this.flags = flags;
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
