package com.zcr.test;

import java.sql.Timestamp;

/**
 * Created by dongheng on 2015/8/31.
 */
public class ServerPO {
    private Long id = 0L;
    private String instanceId = "";
    private String instanceUuid;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    private Timestamp deletedTime;

    private String userId = "";
    private String tenantId = "";
    private String name = "";


    private Timestamp expireTime; // 过期时间
    private String productType = ""; // 支付方式
    private String imageUserId = ""; // 镜像所属用户ID
    private String imageId = ""; // 镜像
    private String imageUuid = ""; // 镜像
    private String imageType = "";
    private String status = "";
    private boolean hasScheduleTask = false; // 是否设置定时快照
    private String orderUuid = ""; // 订单id
    private String resourceUuid = ""; // 资源id
    private String extra = "";
    private String source = "";
    private String dccId = "";  // 专属服务器短id
    private String dccUuid = ""; // 专属服务器长id
    private String tag = "";
    private String flavorId = "";

    private Timestamp releaseTime;

    private String osName = "";
    private String osVersion = "";
    private String osArch = "";
    private String osLang = "";
    private String osBuild = "";
    private String osType = "";
    private String taskStatus = "";

    public Integer getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(Integer instanceType) {
        this.instanceType = instanceType;
    }

    private Integer instanceType;  // 0:普通 1：专属 2:物理机,具体类型见InstanceType类
    private String dccName;
    private String dccFlavor;
    private String dccFlavorType;
    private String password;

    private String vpcName = "";
    private String vpcCidr = "";
    private String subnetName = "";
    private String subnetCidr = "";

    private String vpcId = "";
    // add by hsq
    private String vpcUuid;
    private String subnetId = ""; // 短id
    private String subnetUuid = "";  // 长id
    // 子网类型
    private String subnetType = "";
    private String zoneId = "";
    private String logicalZone = "";
    private String region;
    // 订单状态，用预付费<==>后付费转换状态
    private String orderStatus = "";

    // 实例置放策略，取值default、dedicatedHost, 根据instanceType 0 : 普通 1 ：专属 2 : 物理机设置
    private String placementPolicy;



    private String fpgaCard = "";

    private Integer fpgaCount = 0;

    private String gpuCard = "";

    private Integer gpuCount = 0;

    private String kunlunCard = "";

    private Integer kunlunCount = 0;

    // 虚机类型api专用
    private String instanceFamily = "";

    private int deleted = 0;


    // 虚机用途，默认是bcc 可选值 bcc;cce;rds(专属实例用于部署rds);scs(专属实例用于部署scs)
    private String application = "bcc";

    // 创建来源,用户普通创建情况下为空,其余情况填写请求来源(一般结构为internal_xxx)
    private String createdFrom = "";

    // 虚机绑定的密钥对Id
    private String keypairId = "";

    // 虚机绑定的密钥对名称
    private String keypairName = "";

    // 元数据，Map<String, Object> Json序列化数据，
    // 创建BCC指定脚本地址，
    // 创建DCC专属RDS时, 调用发发来的请求参数. 待创建完成回调时需要携带
    private String metadata = "";

    private String rdsUuid; // bcc上部署的rds的Uuid(一般供FE使用)

    private String scsUuid; // bcc上部署的scs的Uuid(一般供FE使用)

    private String rdsId; // bcc上部署的rds的Id(一般供FE使用)

    private String scsId; // bcc上部署的scs的Id(一般供FE使用)

    // 使用的镜像的最大内存GB
    private int maxRamGb;

    private String hostEyeStatus = "alive";

    private String userShutdownTime;
    private String sysShutdownTime;

    private String chargeStatus;


    private int eniNum;

    private String specId;

    private String specialVersion = "";


    private String deploysetUuid = "";

    private String sysVolumeId;

    private String chainId;

    private String chainUuid;

    private String chainStatus;

    private int resizeCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceUuid() {
        return instanceUuid;
    }

    public void setInstanceUuid(String instanceUuid) {
        this.instanceUuid = instanceUuid;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Timestamp getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Timestamp deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }


}
