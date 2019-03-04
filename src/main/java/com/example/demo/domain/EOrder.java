package com.example.demo.domain;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by RANGAREJ on 6/20/2017.
 */
@Entity
@Table(name = "IMPORT_ORDER")
public class EOrder {
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;


    @Column(name = "PROCESSING_DATA_TYPE", length = 40)
    private String processingDataType;


    @Column(name = "FOLDER_NAME")
    private String folderName;

    @Column(name = "POINT_OF_SALE")
    private String pointOfSale;

    @Column(name = "FILE_NAME")
    private String fileName;


    @Column(name = "CREATED_ON", nullable = true)
    private ZonedDateTime createdOn;

    @Column(name = "CREATED_BY", nullable = true)
    private String createdBy;


    @Column(name = "UPDATED_ON", nullable = true)
    private ZonedDateTime lastUpdatedOn;


    @Column(name = "UPDATED_BY", nullable = true)
    private String lastUpdatedBy;


    public EOrder() {
    }

    public EOrder(Status status, String folderName, String pointOfSale, String fileName) {
        this.status = status;
        this.folderName = folderName;
        this.pointOfSale = pointOfSale;
        this.fileName = fileName;
    }

    public EOrder(String id, Status status, String folderName, String pointOfSale, String fileName) {
        this.status = status;
        this.folderName = folderName;
        this.pointOfSale = pointOfSale;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(ZonedDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    public String getProcessingDataType() {
        return processingDataType;
    }

    public void setProcessingDataType(String processingDataType) {
        this.processingDataType = processingDataType;
    }

    /**
     * Created by RANGAREJ on 6/20/2017.
     */
    public static enum Status {
        InProgress,
        Success,
        Failed,
        Draft
    }
}
