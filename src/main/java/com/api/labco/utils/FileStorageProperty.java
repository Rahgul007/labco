package com.api.labco.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FileStorageProperty {
    private String applicationDir;
    private String catalogDir;

    public String getApplicationDir() {
        return applicationDir;
    }

    public void setApplicationDir(String applicationDir) {
        this.applicationDir = applicationDir;
    }

    public String getCatalogDir() {
        return catalogDir;
    }

    public void setCatalogDir(String catalogDir) {
        this.catalogDir = catalogDir;
    }
}
