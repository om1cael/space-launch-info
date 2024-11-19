package com.om1cael.sli.models;

import com.google.gson.annotations.SerializedName;

public record Launch(@SerializedName("name") String name,
                     @SerializedName("status") LaunchStatus launchStatus,
                     @SerializedName("window_start") String windowStart,
                     @SerializedName("window_end") String windowEnd) {}
