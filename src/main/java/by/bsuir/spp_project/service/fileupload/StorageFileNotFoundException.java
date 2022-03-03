package by.bsuir.spp_project.service.fileupload;

import by.bsuir.spp_project.service.fileupload.StorageException;

public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
