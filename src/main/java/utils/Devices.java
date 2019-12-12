package utils;

public class Devices {
    private String driverName;
    private String nodeURL;
    private String platformName;
    private String deviceId;
    private String deviceName;
    private String sdkVersion;
    private String browser;
    private String bootstrapPort;
    private String bundleId;
    public String getDriverName(){
        return driverName;
    }
    public void setDriverName(String driverName){
        this.driverName=driverName;
    }
    public String getNodeURL(){
        return nodeURL;
    }
    public void setNodeURL(String nodeURL){
        this.nodeURL=nodeURL;
    }
    public String getPlatformName(){
        return platformName;
    }
    public void setPlatformName(String platformName){
        this.platformName=platformName;
    }
    public String getDeviceId(){
        return deviceId;
    }
    public void setDeviceId(String deviceId){
        this.deviceId=deviceId;
    }
    public String getDeviceName(){
        return deviceName;
    }
    public void setDeviceName(String deviceName){
        this.deviceName=deviceName;
    }
    public String getSdkVersion(){
        return sdkVersion;
    }
    public void setSdkVersion(String sdkVersion){
        this.sdkVersion=sdkVersion;
    }
    public String getBrowser(){
        return browser;
    }
    public void setBrowser(String browser){
        this.browser=browser;
    }
    public String getBootstrapPort(){
        return bootstrapPort;
    }
    public void setBootstrapPort(String bootstrapPort){
        this.bootstrapPort=bootstrapPort;

    }
    public String  getBundleId(){
     return bundleId;
    }
    public void setBundleId(String bundleId){
        this.bundleId=bundleId;
    }
    @Override
    public String toString() {
        return
                "driverName=" + driverName +
                ", nodeURL=" + nodeURL +
                ", platformName=" + platformName +
                ", deviceId=" + deviceId +
                ", deviceName=" + deviceName +
                ", sdkVersion=" + sdkVersion+
                ", browser=" +browser+
                ", bootstrapPort=" + bootstrapPort+
                ", bundleId=" +bundleId;
    }
}
