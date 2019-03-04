package com.example.demo.domain;



import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

/**
 * Created by RANGAREJ on 8/10/2017.
 */
public class OrderSpecifications {
    public static Specification<EOrder> byFolderName(final String folderName) {
        return (root, query, cb) -> cb.equal(root.get("folderName"), folderName);
    }
    public static Specification<EOrder> byFileName(final String fileName) {
        return (root, query, cb) -> cb.equal(root.get("fileName"), fileName);
    }
    public static Specification<EOrder> byPointOfSale(final String pointOfSale) {
        return (root, query, cb) -> cb.equal(root.get("pointOfSale"), pointOfSale);
    }
    public static Specification<EOrder> byCreatedOn(final ZonedDateTime createdOn){
        return  ((root, query, cb) -> cb.equal(root.get("createdOn"),createdOn));
    }
    public static Specification<EOrder> byCreatedDateBetween(final ZonedDateTime date, final ZonedDateTime date2) {
        return (root, query, cb) -> cb.between(root.get("createInfo").get("createdOn"), date, date2);
    }
}
