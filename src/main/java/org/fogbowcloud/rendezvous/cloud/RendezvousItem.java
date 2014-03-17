package org.fogbowcloud.rendezvous.cloud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class RendezvousItem {
    public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private long lastTime;
    private ResourcesInfo resourcesInfo;

    public RendezvousItem(ResourcesInfo resourcesInfo) {
        if (resourcesInfo == null) {
            throw new IllegalArgumentException();
        }
        lastTime = System.currentTimeMillis();
        this.resourcesInfo = resourcesInfo;
    }

    public ResourcesInfo getResourcesInfo() {
        return resourcesInfo;
    }

    public long getLastTime() {
        return lastTime;
    }

    public String getFormattedTime() {
        SimpleDateFormat dateFormatISO8601 = new SimpleDateFormat(
                ISO_8601_DATE_FORMAT, Locale.ROOT);
        dateFormatISO8601.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        Date date = new Date(lastTime);

        return dateFormatISO8601.format(date);
    }
}