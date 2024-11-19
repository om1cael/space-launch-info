package com.om1cael.sli;

import com.om1cael.sli.models.Launch;

public class Main {
    public static void main(String[] args) {
        LaunchManager launchManager = new LaunchManager();
        LaunchInfoUtils launchInfoUtils = new LaunchInfoUtils();

        launchManager.mapJSONToLaunches().thenAccept(launches -> {
            if(launches.isEmpty()) {
                System.out.println("Could not fetch the launches.");
                return;
            }

            launches.forEach(launch -> {
                printLaunchDetails(launch, launchInfoUtils);
            });
        }).exceptionally(e -> {
            System.out.println("Could not get the list of launches.");
            return null;
        });
    }

    private static void printLaunchDetails(Launch launch, LaunchInfoUtils launchInfoUtils) {
        System.out.println(launch.name());
        System.out.println(" - Status: " + launch.launchStatus().launchStatus());
        System.out.println(" - Description: " + launch.launchStatus().description());
        System.out.println(" - Window Start (UTC): " + launchInfoUtils.getFormattedLaunchTime(launch.windowStart()));
        System.out.println(" - Window End (UTC): " + launchInfoUtils.getFormattedLaunchTime(launch.windowEnd()));
        System.out.println();
    }
}