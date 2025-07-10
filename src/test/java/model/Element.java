package model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Element {
    private String id;
    private Episode episode;
    private String transmission_start;
    private String transmission_end;
    private String scheduled_start;
    private String scheduled_end;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Episode getEpisode() { return episode; }
    public void setEpisode(Episode episode) { this.episode = episode; }

    public String getTransmission_start() { return transmission_start; }
    public void setTransmission_start(String transmission_start) { this.transmission_start = transmission_start; }

    public String getTransmission_end() { return transmission_end; }
    public void setTransmission_end(String transmission_end) { this.transmission_end = transmission_end; }

    public String getScheduled_start() { return scheduled_start; }
    public void setScheduled_start(String scheduled_start) { this.scheduled_start = scheduled_start; }

    public String getScheduled_end() { return scheduled_end; }
    public void setScheduled_end(String scheduled_end) { this.scheduled_end = scheduled_end; }

}

