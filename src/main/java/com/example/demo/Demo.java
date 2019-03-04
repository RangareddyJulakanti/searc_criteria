package com.example.demo;

import com.example.demo.domain.OrderCriteria;
import com.example.demo.domain.OrderSpecifications;
import com.example.demo.domain.SearchParameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZonedDateTime;

public class Demo {

    public static void main(String[] args) throws JsonProcessingException {
     OrderCriteria orderCriteria=   new OrderCriteria.Builder()
                .createdOn(new SearchParameter.RangeParameter<>(ZonedDateTime.now(),ZonedDateTime.now()))
                .fileName(new SearchParameter.StringParameter<>(SearchParameter.Parameter.Operator.Equals,"mtest.txt"))
                .folderName(new SearchParameter.StringParameter<>(SearchParameter.Parameter.Operator.Equals,"foldername"))
                .build();
       String data= new ObjectMapper().writeValueAsString(orderCriteria

        );
         if(orderCriteria.getFileName().getOperator()== SearchParameter.Parameter.Operator.Equals) {
             OrderSpecifications.byFileName("file.txt");
         }
        System.out.println(data);
        System.out.println(orderCriteria.getFileName().getOperator());
    }
}
