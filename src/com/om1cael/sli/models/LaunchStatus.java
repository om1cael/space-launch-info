package com.om1cael.sli.models;

import com.google.gson.annotations.SerializedName;

public record LaunchStatus(@SerializedName("name") String launchStatus,
                           @SerializedName("description") String description) {}
