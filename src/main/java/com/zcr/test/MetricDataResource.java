/*
package com.zcr.test;

package com.baidu.iop.bcm.mvc.resources;
import com.baidu.iop.bcm.client.ClientFactory;
import com.baidu.iop.bcm.client.CloudServiceClient;
import com.baidu.iop.bcm.configuration.M4Config;
import com.baidu.iop.bcm.constant.CommonConstant;
import com.baidu.iop.bcm.custom.request.MetricDataRequestParam;
import com.baidu.iop.bcm.model.metricdata.MergedMetricData;
import com.baidu.iop.bcm.model.metricdata.MergedNamespaceMetricData;
import com.baidu.iop.bcm.model.metricdata.MetricDataVo;
import com.baidu.iop.bcm.model.metricdata.MetricSeriesVo;
import com.baidu.iop.bcm.model.transform.CloudResource;
import com.baidu.oped.cloudwatch.business.model.metric.Dimension;
import com.baidu.iop.bcm.service.MetricDataService;
import com.baidu.iop.bcm.util.DateTool;
import com.baidu.oped.cloudwatch.business.api.MappingUtils;
import com.baidu.oped.cloudwatch.business.model.metric.M4InstanceAndTags;
import com.baidu.oped.cloudwatch.business.utils.M4Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static com.baidu.iop.bcm.constant.CommonConstant.*;
import static com.baidu.oped.cloudwatch.business.utils.M4Constants.M4_BCM_DEFAULT_INSTANCE_SPLITER;

@RestController
@RequestMapping("admin-api/v1/metricdata")
public class MetricDataResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricDataResource.class);

    @Autowired
    MetricDataService metricDataService;

    @Autowired
    ClientFactory clientFactory;

    M4Config m4Config;

    */
/**
     * 获取百度云平台租户的某一云产品的某一监控项的监控数据
     * @param metricDataRequestParam
     * @return
     *//*

    @PostMapping
    public MetricDataVo search(@RequestBody MetricDataRequestParam metricDataRequestParam) throws Exception {
        LOGGER.debug("get the metric data with the params: {}.", metricDataRequestParam);
        String product = CommonConstant.VENDOR + metricDataRequestParam.getProduct();
        metricDataRequestParam.setProduct(product);
        List<String> dimensions = metricDataRequestParam.getDimension();
        String metricName = metricDataRequestParam.getMetricName();
        String statistics = metricDataRequestParam.getStatistics();
        String customId = metricDataRequestParam.getCustomId();
        String region = metricDataRequestParam.getRegion();
        if (CommonConstant.REGION_HK02.equalsIgnoreCase(region)) {
            region = "gz";
        } else if (CommonConstant.REGION_GLOBAL.equalsIgnoreCase(region)) {
            region = "bj";
        }
        String moTypeName = metricDataRequestParam.getMoTypeName();
        if (MO_TYPE_GROUP.equalsIgnoreCase(moTypeName)) {
            if (IN_BANDWIDTH.equalsIgnoreCase(metricName)) {
                metricDataRequestParam.setMetricName(IN_TRAFFIC);
            }
            if (OUT_BANDWIDTH.equalsIgnoreCase(metricName)) {
                metricDataRequestParam.setMetricName(OUT_TRAFFIC);
            }
        }
        metricName = metricDataRequestParam.getMetricName();
        metricDataRequestParam.setRegion(region);
        MetricDataVo metricDataVo = new MetricDataVo();
        // 保存长短id映射关系
        HashMap<String, String> idMap = new HashMap<>();
        // 最后发出查询请求的批量namespace
        StringBuilder requestNamespace = new StringBuilder();
        if (product.equalsIgnoreCase(BCE_BCC) || product.equalsIgnoreCase(BCE_BBC)
                || product.equalsIgnoreCase(BCE_EIP) || product.equalsIgnoreCase(BCE_CDS)
                || product.equalsIgnoreCase(BCE_RDS)) {
            // 需要将长id转换为短id的批量namespace
            StringBuilder transformNamespace = new StringBuilder();
            // 经过转换的namespace
            StringBuilder transformedNamespace = new StringBuilder();
            for (String dimensionStr : dimensions) {
                String nameSpace = getNameSpace(customId, product, region, dimensionStr);
                if (isShortId(dimensionStr)) {
                    requestNamespace.append(nameSpace + ",");
                } else {
                    // 添加到批量转换的namespace串中
                    transformNamespace.append(nameSpace + ",");
                }
            }
            if (transformNamespace.length() > 0) {
                // 发出批量转换请求
                transformedNamespace = getTransformedNamespace(transformNamespace, region, product, idMap);
                if (transformedNamespace.length() > 0) {
                    requestNamespace.append(transformedNamespace);
                }
            }
        } else {
            // 对于其他云产品，暂不支持批量查询
            Assert.notEmpty(dimensions, "dimension must be not null");
            String dimensionStr = dimensions.get(0);
            String nameSpace = getNameSpace(customId, product, region, dimensionStr);
            requestNamespace.append(nameSpace + ",");
        }
        if (requestNamespace.length() == 0
                || "null".equals(requestNamespace.toString())
                || "".equals(requestNamespace.toString())) {
            metricDataVo.setTitle(metricName);
            metricDataVo.setData(new ArrayList<>());
            return metricDataVo;
        }
        requestNamespace.deleteCharAt(requestNamespace.length() - 1);
        // 获取监控数据
        List<MergedNamespaceMetricData> mergedNamespaceMetricData = getMetricData(metricDataRequestParam,
                requestNamespace.toString());
        // 将监控数据转换为指定格式
        metricDataVo = convertToMetricDataVo(metricName, dimensions, statistics,
                mergedNamespaceMetricData, idMap, product);
        return metricDataVo;
    }

    */
/**
     * 根据请求信息中的维度信息，判断实例id是否为短id
     * @param dimensionStr
     * @return
     *//*

    private boolean isShortId(String dimensionStr) {
        String[] dimensionArr = dimensionStr.split(";");
        for (String key : dimensionArr) {
            int colonIndex = key.indexOf(":");
            String dimensionValue = key.substring(colonIndex + 1);
            if (dimensionValue.startsWith("i-")
                    || dimensionValue.startsWith("v-")
                    || dimensionValue.startsWith("ip-")
                    || dimensionValue.startsWith("rds-")) {
                return true;
            }
        }
        return false;
    }

    */
/**
     * 将用户输入的长id转换为短id，并存储映射关系
     * @param transformNamespace
     * @param region
     * @param product
     * @param idMap
     * @return
     *//*

    public StringBuilder getTransformedNamespace(StringBuilder transformNamespace,
                                                 String region, String product, HashMap<String, String> idMap) {
        StringBuilder transformedNamespace = new StringBuilder();
        transformNamespace.deleteCharAt(transformNamespace.length() - 1);
        List<CloudResource> cloudResourceList;
        CloudServiceClient cloudServiceClient = clientFactory.createCloudServiceClient(region);
        cloudResourceList = cloudServiceClient.getShortIdBatch(product, CLOUD_SERVICE_TYPE,
                transformNamespace.toString());
        if (cloudResourceList.isEmpty()) {
            LOGGER.debug("Without long id mapping relationship : {}.", transformNamespace);
            transformedNamespace = transformNamespace;
        }
        String[] transformNamespaces = transformNamespace.toString().split(",");
        StringBuilder cloudResourceNotTransformedList = new StringBuilder();
        // 对于没有得到短id映射信息的长id，按照长id拼接
        if (cloudResourceList.size() != transformNamespaces.length) {
            for (String trans : transformNamespaces) {
                boolean flag = false;
                for (CloudResource cloud : cloudResourceList) {
                    if (cloud.getName().equalsIgnoreCase(trans)) {
                        flag = true;
                    }
                }
                if (!flag) {
                    cloudResourceNotTransformedList.append(trans + ",");
                }
            }
            transformedNamespace.append(cloudResourceNotTransformedList);
        }
        // 对于得到短id映射信息的长id，按照短id拼接，并存储长短id映射关系
        for (CloudResource cloudResource : cloudResourceList) {
            List<Dimension> dimensionList = cloudResource.getProperties();
            String longId = "";
            String shortId = "";
            for (Dimension dimension : dimensionList) {
                if (dimension.getName().equalsIgnoreCase("TRANSFORM_NAME")) {
                    transformedNamespace.append(dimension.getValue() + ",");
                    shortId = getIdfromNamespace(dimension.getValue());
                }
                if (dimension.getName().equalsIgnoreCase("ORIGINAL_NAME")) {
                    longId = getIdfromNamespace(dimension.getValue());
                }
                // 将转换过的长短id映射关系保存起来
                if (org.apache.commons.lang.StringUtils.isNotEmpty(shortId) && org.apache.commons.lang.StringUtils.isNotEmpty(longId)) {
                    idMap.put(shortId, longId);
                }
            }
        }
        return transformedNamespace;
    }

    */
/**
     * 从namespqce中提取id信息
     * @param namespace
     * @return
     *//*

    private static String getIdfromNamespace(String namespace) {
        int index = namespace.indexOf("___");
        String id = "";
        if (index > 0) {
            id = namespace.substring(0, index);
        }
        return id;
    }

    private MetricDataVo convertToMetricDataVo(String metricName, List<String> dimensions, String statistics,
                                               List<MergedNamespaceMetricData> mergedNamespaceMetricData,
                                               HashMap<String, String> idMap, String product) {
        MetricDataVo metricDataVo = new MetricDataVo();
        metricDataVo.setTitle(metricName);
        List<MetricSeriesVo> dataPoints = getDataPoints(dimensions, statistics, mergedNamespaceMetricData,
                idMap, product);
        metricDataVo.setData(dataPoints);
        return metricDataVo;
    }

    private List<MetricSeriesVo> getDataPoints(List<String> dimensions, String statistics,
                                               List<MergedNamespaceMetricData> mergedNamespaceMetricData,
                                               HashMap<String, String> idMap, String product) {
        List<MetricSeriesVo> metricSeriesVos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(mergedNamespaceMetricData)) {
            for (MergedNamespaceMetricData mergedNamespaceMetricDatum : mergedNamespaceMetricData) {
                MetricSeriesVo metricSeriesVo = new MetricSeriesVo();
                List<List<Object>>  dataPoints = getDataSeries(statistics, mergedNamespaceMetricDatum);
                String namespace = mergedNamespaceMetricDatum.getNamespace();
                String name = "";
                if (product.equalsIgnoreCase(BCE_BCC) || product.equalsIgnoreCase(BCE_BBC)
                        || product.equalsIgnoreCase(BCE_EIP) || product.equalsIgnoreCase(BCE_CDS)
                        || product.equalsIgnoreCase(BCE_RDS)) {
                    name = getMetriSeriesVoName(dimensions, namespace, idMap);
                } else {
                    name = dimensions.get(0);
                }
                metricSeriesVo.setName(name);
                metricSeriesVo.setData(dataPoints);
                metricSeriesVos.add(metricSeriesVo);
            }
        }
        return metricSeriesVos;
    }

    private String getMetriSeriesVoName(List<String> dimensions, String namespace,
                                        HashMap<String, String> idMap) {
        String metricSeriesVoName = "";
        // 响应数据中的namespace与请求数据中的namespace不一致，要按照请求数据中的id信息进行回显
        String responseId = getIdfromNamespace(namespace);
        // 遍历请求信息，找出这个响应信息对应请求信息
        for (String dimensionStr : dimensions) {
            if (dimensionStr.contains(responseId)) {
                metricSeriesVoName = dimensionStr;
                return metricSeriesVoName;
            }
        }
        // 遍历完没有找到对应的请求信息，说明响应信息为经过转换的短id
        // 则得到此短id对应的长id，再次遍历请求信息，找出这个响应信息对应请求信息
        String longId = idMap.get(responseId);
        for (String dimensionStr : dimensions) {
            if (dimensionStr.contains(longId)) {
                metricSeriesVoName = dimensionStr;
                return metricSeriesVoName;
            }
        }
        return metricSeriesVoName;
    }

    private List<List<Object>> getDataSeries(String statistics, MergedNamespaceMetricData mergedNamespaceMetricDatum) {
        List<List<Object>> dataPoints = new ArrayList<>();
        for (MergedMetricData item : mergedNamespaceMetricDatum.getItems()) {
            List<Object> dataSeries = new ArrayList<>();
            dataSeries.add((item.getTimestampInLong())*1000);
            // average,maximum,minimum,sampleCount,sum
            if (statistics.trim().equals("average")) {
                if (item.isMetricDataStatisticsValue()) {
                    dataSeries.add(item.getStatisticsValue().getAvg());
                } else {
                    dataSeries.add(item.getValue());
                }
            } else if (statistics.trim().equals("maximum")) {
                if (item.isMetricDataStatisticsValue()) {
                    dataSeries.add(item.getStatisticsValue().getMax());
                } else {
                    dataSeries.add(item.getValue());
                }
            } else if (statistics.trim().equals("minimum")) {
                if (item.isMetricDataStatisticsValue()) {
                    dataSeries.add(item.getStatisticsValue().getMin());
                } else {
                    dataSeries.add(item.getValue());
                }
            } else if (statistics.trim().equals("sampleCount")) {
                if (item.isMetricDataStatisticsValue()) {
                    dataSeries.add(item.getStatisticsValue().getCnt());
                } else if (item.getValue() != null) {
                    dataSeries.add(item.getValue());
                }
            } else if (statistics.trim().equals("sum")) {
                if (item.isMetricDataStatisticsValue()) {
                    dataSeries.add(item.getStatisticsValue().getSum());
                } else {
                    dataSeries.add(item.getValue());
                }
            }
            dataPoints.add(dataSeries);
        }
        return dataPoints;
    }

    private List<MergedNamespaceMetricData> getMetricData(MetricDataRequestParam metricDataRequestParam,
                                                          String namespace) throws ParseException {
        MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        String metricName = metricDataRequestParam.getMetricName();
        if (!"BCE_CDN".equalsIgnoreCase(metricDataRequestParam.getProduct())) {
            metricName = MappingUtils.getM4MetricNameFromBCMMetricName(metricDataRequestParam.getProduct(), metricName);
        }
        String productName = metricDataRequestParam.getCustomId();
        int startTime = DateTool.string2timestamp(metricDataRequestParam.getStartTime());
        int endTime = DateTool.string2timestamp(metricDataRequestParam.getEndTime());
        int periodInSecond = metricDataRequestParam.getPeriodInSecond();
        queryMap.add(START_TIME_KEY, String.valueOf(startTime));
        queryMap.add(END_TIME_KEY, String.valueOf(endTime));
        queryMap.add(CYCLE, Integer.toString(periodInSecond));
        queryMap.add(CommonConstant.STATISTICS,metricDataRequestParam.getStatistics());
        queryMap.add(CommonConstant.ABSENCE_KEY, CommonConstant.ABSENCE_VALUE);
        List<MergedNamespaceMetricData> mergedNamespaceMetricData = metricDataService.getMetricData(productName,
                namespace, metricName, queryMap);
        return mergedNamespaceMetricData;
    }

    public String getNameSpace(String customId, String product, String region, String dimensionStr) {
        String namespace;
        // 当product= BCE_SMS 或 BCE_SES 的时候，dimensions是有可能为空的，此时取默认instance
        if (product.equals("BCE_SMS") || product.equals("BCE_SES")) {
            String defaultInstance;
            if (product.equals("BCE_SMS")) {
                namespace = M4Constants.M4_BCE_SMS_DEFAULT_KEY + M4_BCM_DEFAULT_INSTANCE_SPLITER
                        + m4Config.get(M4Config.SAVER_REGION) + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER
                        + product + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER + product;
            } else {
                namespace = M4Constants.M4_BCE_SES_DEFAULT_KEY + M4_BCM_DEFAULT_INSTANCE_SPLITER
                        + m4Config.get(M4Config.SAVER_REGION) + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER
                        + product + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER + product;
            }
        } else {
            String[] dimensionArr = dimensionStr.split(";");
            List<Dimension> dimensionList = new ArrayList<>();
            for (String key : dimensionArr) {
                String dimensionName = key.split(":")[0];
                String dimensionValue = key.split(":")[1];
                Dimension dimension = new Dimension();
                dimension.setName(dimensionName);
                dimension.setValue(dimensionValue);
                dimensionList.add(dimension);
            }
            // 转换namespace
            M4InstanceAndTags m4InstanceAndTags = MappingUtils.buildM4InstanceAndTags(region, dimensionList, product, customId, false);
            namespace = m4InstanceAndTags.getInstance();
            // 根据其维度进行拼接
            if (StringUtils.isEmpty(namespace)) {
                namespace = getNameSpaceFromDimensions(customId, product, dimensionList, region);
            }
            // 监控对象类型为service时其namespace
            if (StringUtils.isEmpty(namespace)) {
                namespace = getServiceFromDimensions(customId, product, dimensionList, region);
            }
        }
        return namespace;
    }

    private String getNameSpaceFromDimensions(String customId, String product,
                                              List<Dimension> dimensionList, String region) {
        String instance = "";
        switch (product) {
            case "BCE_DEDICATEDCONN":
                instance = "DedicatedConnectionId";
                break;
            case "BCE_IOT_TSDB":
                instance = "DatabaseId";
                break;
            case "BCE_BAE":
                instance = "InstanceId";
                break;
            case "BCE_BBC":
                instance = "InstanceId";
                break;
            case "BCE_BCC":
                instance = "InstanceId";
                break;
            case "BCE_RDS":
                instance = "InstanceId";
                break;
            case "BCE_EIP":
                instance = "InstanceId";
                break;
            case "BCE_DCC":
                instance = "InstanceId";
                break;
            case "BCE_BSS":
                instance = "eip";
                break;
            case "BCE_CDS":
                instance = "VolumeId";
                break;
            case "BCE_BMR":
                instance = "ClusterId";
                break;
            case "BCE_CDN":
                instance = "DomainId";
                break;
            case "BCE_PEERCONN":
                instance = "InstanceId";
                break;
            case "BCE_BCH":
                instance = "AppId";
                break;
            case "BCE_FAAS":
                instance = "FunctionArn";
                break;
            case "BCE_DEDICATEDCONN_GATEWAY":
                instance = "InstanceId";
                break;
            default:
                break;
        }
        String instanceValue = "";
        for (Dimension dimension : dimensionList) {
            if (dimension.getName().trim().equals(instance)) {
                instanceValue = dimension.getValue();
            }
        }
        String namespace = "";
        if (!StringUtils.isEmpty(instanceValue)) {
            namespace = instanceValue + M4_BCM_DEFAULT_INSTANCE_SPLITER
                    + region + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER
                    + product + M4Constants.M4_BCM_DEFAULT_FULL_INSTANCE_SPLITER + customId;
        }
        return namespace;
    }

    public static String getServiceFromDimensions(String customId, String product,
                                                  List<Dimension> bcmDimensions, String region) {
        StringBuilder tempStringBuilders = new StringBuilder();
        for (Dimension dimension : bcmDimensions) {
            String dimensionName = dimension.getName();
            String dimensionValue = dimension.getValue();
            if (!tempStringBuilders.toString().isEmpty()) {
                // 3个下划线
                tempStringBuilders.append("___");
            }
            // 2个下划线
            tempStringBuilders.append("bce_");
            tempStringBuilders.append(dimensionName);
            tempStringBuilders.append("__");
            tempStringBuilders.append(dimensionValue);
        }
        tempStringBuilders.append("." + product + "." + customId);
        return tempStringBuilders.toString();
    }

    // 获取维度的类型 如:BlbId InstanceId GroupId
    private List<String> getDimensionsType(String dimensions) {
        List<String> types = new ArrayList<>();
        if (org.apache.commons.lang.StringUtils.isBlank(dimensions)) {
            return types;
        }
        String[] dimItemStrs = dimensions.split(";");
        for (String dimItemStr : dimItemStrs) {
            String[] dimKV = dimItemStr.split(":");
            types.add(dimKV[0]);
        }
        return types;
    }
}
*/
