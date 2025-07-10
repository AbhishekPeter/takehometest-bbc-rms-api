package model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    private String type;
    private String title;
    private boolean live;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isLive() { return live; }
    public void setLive(boolean live) { this.live = live; }
}
