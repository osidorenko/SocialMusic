package by.bsuir.spp_project.service.fileupload;

import org.springframework.stereotype.Component;

@Component("storageProperties")
public class StorageProperties {
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
