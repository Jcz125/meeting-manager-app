package eu.telecomnancy.profrdv.server.model.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooleanResult {
    public boolean success;

    public BooleanResult() {}

    public BooleanResult(boolean success) {this.success = success;}
}
