
package org.noses.usaops.sources.opendatasuicide;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reviewedAt",
    "reviewedAutomatically",
    "state",
    "submissionId",
    "submissionObject",
    "submissionOutcome",
    "submittedAt",
    "workflowId",
    "reviewer",
    "submissionDetails",
    "submissionOutcomeApplication",
    "submitter"
})
public class Approval {

    @JsonProperty("reviewedAt")
    private Integer reviewedAt;
    @JsonProperty("reviewedAutomatically")
    private Boolean reviewedAutomatically;
    @JsonProperty("state")
    private String state;
    @JsonProperty("submissionId")
    private Integer submissionId;
    @JsonProperty("submissionObject")
    private String submissionObject;
    @JsonProperty("submissionOutcome")
    private String submissionOutcome;
    @JsonProperty("submittedAt")
    private Integer submittedAt;
    @JsonProperty("workflowId")
    private Integer workflowId;
    @JsonProperty("reviewer")
    private Reviewer reviewer;
    @JsonProperty("submissionDetails")
    private SubmissionDetails submissionDetails;
    @JsonProperty("submissionOutcomeApplication")
    private SubmissionOutcomeApplication submissionOutcomeApplication;
    @JsonProperty("submitter")
    private Submitter submitter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reviewedAt")
    public Integer getReviewedAt() {
        return reviewedAt;
    }

    @JsonProperty("reviewedAt")
    public void setReviewedAt(Integer reviewedAt) {
        this.reviewedAt = reviewedAt;
    }

    @JsonProperty("reviewedAutomatically")
    public Boolean getReviewedAutomatically() {
        return reviewedAutomatically;
    }

    @JsonProperty("reviewedAutomatically")
    public void setReviewedAutomatically(Boolean reviewedAutomatically) {
        this.reviewedAutomatically = reviewedAutomatically;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("submissionId")
    public Integer getSubmissionId() {
        return submissionId;
    }

    @JsonProperty("submissionId")
    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    @JsonProperty("submissionObject")
    public String getSubmissionObject() {
        return submissionObject;
    }

    @JsonProperty("submissionObject")
    public void setSubmissionObject(String submissionObject) {
        this.submissionObject = submissionObject;
    }

    @JsonProperty("submissionOutcome")
    public String getSubmissionOutcome() {
        return submissionOutcome;
    }

    @JsonProperty("submissionOutcome")
    public void setSubmissionOutcome(String submissionOutcome) {
        this.submissionOutcome = submissionOutcome;
    }

    @JsonProperty("submittedAt")
    public Integer getSubmittedAt() {
        return submittedAt;
    }

    @JsonProperty("submittedAt")
    public void setSubmittedAt(Integer submittedAt) {
        this.submittedAt = submittedAt;
    }

    @JsonProperty("workflowId")
    public Integer getWorkflowId() {
        return workflowId;
    }

    @JsonProperty("workflowId")
    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    @JsonProperty("reviewer")
    public Reviewer getReviewer() {
        return reviewer;
    }

    @JsonProperty("reviewer")
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    @JsonProperty("submissionDetails")
    public SubmissionDetails getSubmissionDetails() {
        return submissionDetails;
    }

    @JsonProperty("submissionDetails")
    public void setSubmissionDetails(SubmissionDetails submissionDetails) {
        this.submissionDetails = submissionDetails;
    }

    @JsonProperty("submissionOutcomeApplication")
    public SubmissionOutcomeApplication getSubmissionOutcomeApplication() {
        return submissionOutcomeApplication;
    }

    @JsonProperty("submissionOutcomeApplication")
    public void setSubmissionOutcomeApplication(SubmissionOutcomeApplication submissionOutcomeApplication) {
        this.submissionOutcomeApplication = submissionOutcomeApplication;
    }

    @JsonProperty("submitter")
    public Submitter getSubmitter() {
        return submitter;
    }

    @JsonProperty("submitter")
    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
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
