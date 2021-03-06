package com.zcr.test;

public class Dimension {
        public String name;
        public String value;

        public Dimension() {
        }

        public Dimension(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String toString() {
            return this.getName() + "='" + this.getValue() + "'";
        }
}

