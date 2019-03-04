package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.time.ZonedDateTime;

/**
 * Created by RANGAREJ on 8/10/2017.
 */
public class OrderCriteria {

    @JsonProperty
    @Valid
    private SearchParameter.StringParameter<String> fileName;
    @JsonProperty
    @Valid
    private SearchParameter.StringParameter<String> folderName;
    @JsonProperty
    @Valid
    private SearchParameter.StringParameter<String> pointOfSale;
    //Dates
    @JsonProperty
    @Valid
    private SearchParameter.RangeParameter<ZonedDateTime> createdOn;
    @JsonProperty
    @Valid
    private SearchParameter.RangeParameter<ZonedDateTime> updatedOn;


    @JsonCreator
    public OrderCriteria(@JsonProperty("folderName") SearchParameter.StringParameter<String> folderName,
                         @JsonProperty("pointOfSale") SearchParameter.StringParameter<String> pointOfSale,
                         @JsonProperty("fileName") SearchParameter.StringParameter<String> fileName,
                         @JsonProperty("createdOn") SearchParameter.RangeParameter<ZonedDateTime> createdOn,
                         @JsonProperty("updatedOn") SearchParameter.RangeParameter<ZonedDateTime> updatedOn) {
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.fileName = fileName;
        this.folderName = folderName;
        this.pointOfSale = pointOfSale;
    }

    public OrderCriteria(Builder builder) {
        this.createdOn = builder.createdOn;
        this.updatedOn = builder.updatedOn;
        this.fileName = builder.fileName;
        this.folderName = builder.folderName;
        this.pointOfSale = builder.pointOfSale;

    }

    public SearchParameter.RangeParameter<ZonedDateTime> getCreatedOn() {
        return createdOn;
    }

    public SearchParameter.RangeParameter<ZonedDateTime> getUpdatedOn() {
        return updatedOn;
    }

    public SearchParameter.StringParameter<String> getFileName() {
        return fileName;
    }

    public SearchParameter.StringParameter<String> getFolderName() {
        return folderName;
    }

    public SearchParameter.StringParameter<String> getPointOfSale() {
        return pointOfSale;
    }


    public static class Builder {
        //Dates
        private SearchParameter.RangeParameter<ZonedDateTime> createdOn;
        private SearchParameter.RangeParameter<ZonedDateTime> updatedOn;
        private SearchParameter.StringParameter<String> fileName;
        private SearchParameter.StringParameter<String> folderName;
        private SearchParameter.StringParameter<String> pointOfSale;

        public Builder fileName(SearchParameter.StringParameter<String> fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder folderName(SearchParameter.StringParameter<String> folderName) {
            this.folderName = folderName;
            return this;
        }

        public Builder pointOfSale(SearchParameter.StringParameter<String> pointOfSale) {
            this.pointOfSale = pointOfSale;
            return this;
        }

        public Builder createdOn(SearchParameter.RangeParameter<ZonedDateTime> createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder updatedOn(SearchParameter.RangeParameter<ZonedDateTime> updatedOn) {
            this.updatedOn = updatedOn;
            return this;
        }

        public OrderCriteria build() {
            return new OrderCriteria(this);
        }
    }

}
