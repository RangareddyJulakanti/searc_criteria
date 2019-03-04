package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by RANGAREJ on 8/10/2017.
 */

public class SearchParameter {

    public static class RangeParameter<T> extends Parameter<T> {
        @JsonProperty("value2")
        @NotNull(message = "{RangeParameter.Value2.Can.Not.Be.Null}")
        private T value2;

        @JsonCreator
        public RangeParameter(
                @JsonProperty("value") T value,
                @JsonProperty("value2") T value2
        ) {
            super(Operator.Range, value);
            this.value2 = value2;
        }

        public T getValue2() {
            return value2;
        }
    }
    public static class StringParameter<T> extends Parameter<T> {
        @JsonCreator
        public StringParameter(
                @JsonProperty("operator") Operator operator,
                @JsonProperty("value") T value) {
            super(operator, value);
            if (operator == Operator.Range) {
                throw new RuntimeException("Operator Range not supported for String Parameter");
            }
        }
    }



    public abstract static class Parameter<T> {

        public enum Operator {Equals, Contains, StartsWith, Range};

        @NotNull(message = "{Parameter.Operator.Can.Not.Be.Null}")
        private Operator operator;

        @NotNull(message = "{Parameter.Value.Can.Not.Be.Null}")
        private T value;

        public Parameter(
                Operator operator,
                T value) {
            this.operator = operator;
            this.value = value;
        }

        public Operator getOperator() {
            return operator;
        }

        public T getValue() {
            return value;
        }

    }

}

