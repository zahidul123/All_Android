package com.example.onekkosteachi.All_ModelClass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Booklist {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("last_modified")
    @Expose
    private String lastModified;
    @SerializedName("results")
    @Expose

    private Results results;

    /**
     * No args constructor for use in serialization
     *
     */
    public Booklist() {
    }

    /**
     *
     * @param results
     * @param lastModified
     * @param status
     * @param numResults
     * @param copyright
     */
    public Booklist(String status, String copyright, Integer numResults, String lastModified, Results results) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.lastModified = lastModified;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Booklist{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", numResults=" + numResults +
                ", lastModified='" + lastModified + '\'' +
                ", results=" + results +
                '}';
    }
}