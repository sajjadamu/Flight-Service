package com.jck.travel.flight.util.enumeration;


public enum ApiTag {

    TBO("tbo"),
    GAL("gal");

    private String tag;

    ApiTag(final String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public String toString() {
        return this.getTag();
    }
}
