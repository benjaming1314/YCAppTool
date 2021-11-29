package com.yc.location.dev;

import android.content.Context;
import android.location.Location;

import com.yc.location.bean.DefaultLocation;
import com.yc.location.config.LocateMode;
import com.yc.location.config.LocationUpdateOption;
import com.yc.location.listener.AbsBaseLocationListener;
import com.yc.location.listener.LocationListener;

import java.io.File;

public final class LocationService implements ILocationProvider {

    private final ILocationProvider mDelegate;

    private LocationService() {
        this.mDelegate = new LocationImpl();
    }

    public static LocationService getInstance() {
        return LocationService.Singleton.INSTANCE;
    }

    public final void initLocationManager(Context arg0) {
        if (null != this.mDelegate) {
            this.mDelegate.initLocationManager(arg0);
        }

    }

    public final void requestOnceLocation(LocationListener arg0) {
        if (null != this.mDelegate) {
            this.mDelegate.requestOnceLocation(arg0);
        }

    }

    public final ILocationProvider registerLocationListener(AbsBaseLocationListener arg0) {
        return null != this.mDelegate ? this.mDelegate.registerLocationListener(arg0) : null;
    }

    public final ILocationProvider unRegisterLocationListener(AbsBaseLocationListener arg0) {
        return null != this.mDelegate ? this.mDelegate.unRegisterLocationListener(arg0) : null;
    }

    public final ILocationProvider startLocation(Context arg0) {
        return null != this.mDelegate ? this.mDelegate.startLocation(arg0) : null;
    }

    public final DefaultLocation getLastKnownLocation() {
        return null != this.mDelegate ? this.mDelegate.getLastKnownLocation() : null;
    }

    public final double getLatitude() {
        return null != this.mDelegate ? this.mDelegate.getLatitude() : 0.0D;
    }

    public final double getLongitude() {
        return null != this.mDelegate ? this.mDelegate.getLongitude() : 0.0D;
    }

    public final ILocationProvider setLocateMode(LocateMode arg0) {
        return null != this.mDelegate ? this.mDelegate.setLocateMode(arg0) : null;
    }

    public final ILocationProvider setInterval(LocationUpdateOption.IntervalMode arg0) {
        return null != this.mDelegate ? this.mDelegate.setInterval(arg0) : null;
    }

    public final ILocationProvider setCoordinateType(int arg0) {
        return null != this.mDelegate ? this.mDelegate.setCoordinateType(arg0) : null;
    }

    public final ILocationProvider stopLocation() {
        return null != this.mDelegate ? this.mDelegate.stopLocation() : null;
    }

    public final ILocationProvider enableMock(boolean arg0) {
        return null != this.mDelegate ? this.mDelegate.enableMock(arg0) : null;
    }

    public final void setMockLatLng(Location arg0) {
        if (null != this.mDelegate) {
            this.mDelegate.setMockLatLng(arg0);
        }

    }

    public final void setMockLatLng(double arg0, double arg1) {
        if (null != this.mDelegate) {
            this.mDelegate.setMockLatLng(arg0, arg1);
        }

    }

    public final boolean isMockEnabled() {
        return null != this.mDelegate && this.mDelegate.isMockEnabled();
    }

    public final ILocationProvider setLogPath(File arg0) {
        return null != this.mDelegate ? this.mDelegate.setLogPath(arg0) : null;
    }

    private static final class Singleton {
        static final LocationService INSTANCE = new LocationService();

        private Singleton() {
        }
    }
}