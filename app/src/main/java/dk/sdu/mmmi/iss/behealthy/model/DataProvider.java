package dk.sdu.mmmi.iss.behealthy.model;

import java.io.Serializable;

public class DataProvider implements Serializable {

    private String name;

    public DataProvider(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
