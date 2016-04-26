package be.vergauwen.simon.androidqualitycontrol.core.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("name")
    String name;

    @SerializedName("html_url")
    String url;

    @SerializedName("description")
    String description;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}