package com.mobicare.wifi.cm.reports.entity;

import java.util.Date;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "LOGIN_REPORT")
public class LoginReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "mac_ap")
    private String macAP;

    @Column(name = "signal_strength")
    private String signalStrength;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "app_version")
    private String appVersion;

    @Column(name = "channel")
    private String channel;

    @Column(name = "ssid")
    private String ssid;

    @Column(name = "operator")
    private String operator;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "log_date")
    private Date logDate;

    @ElementCollection
    @MapKeyColumn(name = "report_key")
    @Column(name = "report_value")
    @CollectionTable(name = "LOGIN_REPORT_ADDITIONAL", joinColumns = @JoinColumn(name = "login_report_id"))
    private Map<String, String> loginReportAddicional;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "download_time")
    private long downloadTime;

    @Column(name = "captive_wispr", columnDefinition = "TEXT")
    private String captiveWispr;

    @Column(name = "result_wispr", columnDefinition = "TEXT")
    private String resultWispr;

    @Column(name = "local_ip")
    private String localIP;

    @Column(name = "access_point_ip")
    private String accessPointIP;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "latitude")
    private double latitude;


    @Column(name = "longitude")
    private double longitude;

    @PrePersist
    private void createDate() {
        setCreateDate(new Date());

        if (getLogDate() == null) {
            setLogDate(new Date());
        }

        setAccessPointIP(StringUtils.upperCase(getAccessPointIP()));
        setAppVersion(StringUtils.upperCase(getAppVersion()));
        setChannel(StringUtils.upperCase(getChannel()));
        setDeviceModel(StringUtils.upperCase(getDeviceModel()));
        setLocalIP(StringUtils.upperCase(getLocalIP()));
        setLogin(StringUtils.upperCase(getLogin()));
        setMacAddress(StringUtils.upperCase(getMacAddress()));
        setMacAP(StringUtils.upperCase(getMacAP()));
        setOperator(StringUtils.upperCase(getOperator()));
        setSignalStrength(StringUtils.upperCase(getSignalStrength()));
        setSsid(StringUtils.upperCase(getSsid()));
        setUserAgent(StringUtils.upperCase(getUserAgent()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAP() {
        return macAP;
    }

    public void setMacAP(String macAP) {
        this.macAP = macAP;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Map<String, String> getLoginReportAddicional() {
        return loginReportAddicional;
    }

    public void setLoginReportAddicional(Map<String, String> loginReportAddicional) {
        this.loginReportAddicional = loginReportAddicional;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(long downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getCaptiveWispr() {
        return captiveWispr;
    }

    public void setCaptiveWispr(String captiveWispr) {
        this.captiveWispr = captiveWispr;
    }

    public String getResultWispr() {
        return resultWispr;
    }

    public void setResultWispr(String resultWispr) {
        this.resultWispr = resultWispr;
    }

    public String getLocalIP() {
        return localIP;
    }

    public void setLocalIP(String localIP) {
        this.localIP = localIP;
    }

    public String getAccessPointIP() {
        return accessPointIP;
    }

    public void setAccessPointIP(String accessPointIP) {
        this.accessPointIP = accessPointIP;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
