package com.mobicare.wifi.cm.reports.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "ERROR_REPORT")
public class ErrorReport implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    private String channel;

    private String ssid;

    @Column(name = "error_type")
    private String errorType;

    @Column(name = "error_message")
    private String errorMessage;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "operator")
    private String operator;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @PrePersist
    private void createDate() {
        setCreateDate(new Date());

        if (getEventDate() == null) {
            setEventDate(new Date());
        }

        setAccessPointIP(StringUtils.upperCase(getAccessPointIP()));
        setAppVersion(StringUtils.upperCase(getAppVersion()));
        setChannel(StringUtils.upperCase(getChannel()));
        setDeviceModel(StringUtils.upperCase(getDeviceModel()));
        setErrorMessage(StringUtils.upperCase(getErrorMessage()));
        setErrorType(StringUtils.upperCase(getErrorType()));
        setLocalIP(StringUtils.upperCase(getLocalIP()));
        setLogin(StringUtils.upperCase(getLogin()));
        setMacAddress(StringUtils.upperCase(getMacAddress()));
        setMacAP(StringUtils.upperCase(getMacAP()));
        setOperator(StringUtils.upperCase(getOperator()));
        setSignalStrength(StringUtils.upperCase(getSignalStrength()));
        setSsid(StringUtils.upperCase(getSsid()));
        setUserAgent(StringUtils.upperCase(getUserAgent()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
