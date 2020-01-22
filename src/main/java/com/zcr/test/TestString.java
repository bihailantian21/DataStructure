package com.zcr.test;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestString {

    public static void main(String[] args) {

         /* List<String> types = new ArrayList<>();
        String dimensions = "InstanceId:i-xxx";
        String[] dimItemStrs = dimensions.split(";");
        for (String dimItemStr : dimItemStrs) {
            String[] dimKV = dimItemStr.split(":");
            types.add(dimKV[0]);
        }
        System.out.println(types);*/

        /*List<String> types = new ArrayList<>();
        String[] dimensions = {"BlbId:er;BlbPort:80","BlbId:er;BlbPort:80"};
        String[] dimItemStrs = {};
        String[] dimKV = {};
        for (String dimensionArray : dimensions) {
            //获取每个实例的维度类型
            dimItemStrs = dimensionArray.split(";");
            for (String dimItemStr : dimItemStrs) {
                dimKV = dimItemStr.split(":");
                types.add(dimKV[0]);
            }
        }
        System.out.println(types);*/

        /*String[] dimensions = {"BlbId:er1;BlbPort:801", "BlbId:er;BlbPort:802"};
        List<Dimension> dimensionList = new ArrayList<>();
        for (String dimensionArray : dimensions) {
            String[] dimensionArr = dimensionArray.split(";");
            for (String key : dimensionArr) {
                String dimensionName = key.split(":")[0];
                String dimensionValue = key.split(":")[1];
                Dimension dimension = new Dimension();
                dimension.setName(dimensionName);
                dimension.setValue(dimensionValue);
                dimensionList.add(dimension);
            }
            System.out.println(dimensionArray);
            System.out.println(dimensionList);
        }
        System.out.println(dimensionList);*/


        /*//对于每一个实例信息的维度，将所有的维度放到一个列表中
        String dimensions = "BlbId:er1;BlbPort:801";
        String[] dimensionArr = dimensions.split(";");
        List<Dimension> dimensionList = new ArrayList<>();
        for (String key : dimensionArr) {
            String dimensionName = key.split(":")[0];
            String dimensionValue = key.split(":")[1];
            Dimension dimension = new Dimension();
            dimension.setName(dimensionName);
            dimension.setValue(dimensionValue);
            dimensionList.add(dimension);
        }
        System.out.println(dimensionList);*/

        //对于多个实例信息，将每一个实例信息
        //对于每一个实例信息的维度，将所有的维度放到一个列表中
        //String dimensions = "BlbId:er1;BlbPort:801";
        /*String[] dimensions = {"BlbId:er1", "BlbId:er"};
        for (String dimensionStr : dimensions) {
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
            System.out.println(dimensionList);
        }*/
        /*[BlbId='er1', BlbPort='801']
        [BlbId='er', BlbPort='802']*/
        /*[BlbId='er1']
        [BlbId='er']*/


        //现在的维度列表
        /*String[] dimensions = {"BlbId:er1;BlbPort:801", "BlbId:er;BlbPort:802"};
        //对多个实例分别获取namespace分别请求指标数据
        for (String dimensionStr : dimensions) {
            // 将每个dimensions转换为instance和tags
            List<Dimension> bcmDimensions = getDimensions(dimensionStr);
            System.out.println(bcmDimensions);
            System.out.println(bcmDimensions.get(0));
            System.out.println(bcmDimensions.get(1));
        }
        System.out.println(dimensions.toString());
        System.out.println(Arrays.toString(dimensions));*/


        //查看dimension信息
        /*Dimension dimension1 = new Dimension();
        dimension1.setName("111");
        dimension1.setValue("222");
        System.out.println(dimension1);*/
        //111='222'

        /*String[] dimensions = {"BlbId:i-xxx1,port:80","BlbId:er2","BlbId:v-xxx"};
        for (String dimensionStr : dimensions) {
            if (!dimensionStr.contains("i-") && !dimensionStr.contains("v-")
                    && !dimensionStr.contains("ip-") && !dimensionStr.contains("rds-")) {
                System.out.println(dimensionStr);
            }
            *//*String[] dimensionArr = dimensionStr.split(";");
            List<Dimension> dimensionList = new ArrayList<>();
            for (String key : dimensionArr) {
                String dimensionName = key.split(":")[0];
                String dimensionValue = key.split(":")[1];
                Dimension dimension = new Dimension();
                dimension.setName(dimensionName);
                dimension.setValue(dimensionValue);
                dimensionList.add(dimension);
            }
            System.out.println(dimensionList);
            if (dimensionList.)*//*
        }*/


        /*StringBuilder transformNamespace = new StringBuilder();
        if (!StringBuilderUtils.isEmpty(transformNamespace)) {
            System.out.println("transformNamespace不为空");
        }*/
        /*StringBuilder transformNamespace = new StringBuilder();
        transformNamespace.append("123");
        if (transformNamespace.length() > 0
                && !"null".equals(transformNamespace.toString())
                && !"".equals(transformNamespace.toString())) {
            System.out.println(transformNamespace + "不为空");
        }
        if (transformNamespace.length() == 0
                || "null".equals(transformNamespace.toString())
                || "".equals(transformNamespace.toString())) {
            System.out.println(transformNamespace + "为空");
        }*/

        /*//从namespace中提取id信息
        String namespace = "i-Y33H4Efk___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95";
        int index = namespace.indexOf("___");
        System.out.println(index);
        String id = namespace.substring(0,index);
        System.out.println(id);*/

        //StringBuilder拼接字符串如何去掉最后一个字符？
       /* StringBuilder requestNamespace = new StringBuilder();
        String[] dimensions = {"i-xxx1","er2","v-xxx"};
        for (String dimensionStr : dimensions) {
            requestNamespace.append(dimensionStr + ",");
        }
        String requestNamespace1 = requestNamespace.toString().substring(0,requestNamespace.length() - 1);
        System.out.println(requestNamespace1);
        requestNamespace.deleteCharAt(requestNamespace.length() - 1);
        System.out.println(requestNamespace);*/


       //测试拼接转换字符串、请求字符串、最后一个字符去掉逗号
        /*StringBuilder requestNamespace = new StringBuilder();
        StringBuilder transformNamespace = new StringBuilder();
        String[] dimensions = {"ixxx1","ilong1","vxxx","ilong2","ilong3","i-long4"};
        for (String dimensionStr : dimensions) {
            String namespace = "";
            if (!dimensionStr.contains("i-")
                    && !dimensionStr.contains("v-")
                    && !dimensionStr.contains("ip-")
                    && !dimensionStr.contains("rds-")) {
                transformNamespace.append(dimensionStr + "long,");
            } else {
                requestNamespace.append(dimensionStr + "short,");
            }
        }
        System.out.println(transformNamespace.toString());
        System.out.println(requestNamespace.toString());
        if (transformNamespace.length() > 0
                && !"null".equals(transformNamespace.toString())
                && !"".equals(transformNamespace.toString())) {
            transformNamespace.deleteCharAt(transformNamespace.length() - 1);
            StringBuilder transformedNamespace = new StringBuilder();
            String[] a = transformNamespace.toString().split(",");
            for (String a1 : a){
                String namespace;
                namespace = a1 ;
                transformedNamespace.append(namespace + "long-short,");
            }
            System.out.println(transformedNamespace.toString());
            requestNamespace.append(transformedNamespace);
        }
        *//*if (StringUtils.isEmpty(requestNamespace)) {
            metricDataVo.setData(new ArrayList<>());
            return  metricDataVo;
        }*//*
        System.out.println(requestNamespace);
        requestNamespace.deleteCharAt(requestNamespace.length() - 1);
        System.out.println(requestNamespace);*/


        /*String[] dimensions = {"BlbId:i-xxx1;port:80","BlbId:er2","BlbId:v-xxx"};

        StringBuilder namespace = new StringBuilder();
        for (String dimensionStr : dimensions) {
            String[] dimensionArr = dimensionStr.split(";");
            for (String key : dimensionArr) {
                int index = key.indexOf(":");
                String name = key.substring(index + 1,key.length());
                if (name.startsWith("i-")
                        || name.startsWith("v-")
                        || name.startsWith("ip-")
                        || name.startsWith("rds-")) {
                    namespace.append(dimensionStr + ",");
                }
            }
        }
        System.out.println(namespace);


*/
       /*//测试substring
        String n = "123456789";
        String n1 = n.substring(3);
        System.out.println(n1);*/

        /*//测试截取字符串
        String dimensionStr = "InstanceId:i-xxx;port:80";
        String[] dimensionArr = dimensionStr.split(";");
        for (String key : dimensionArr) {
            int colonIndex = key.indexOf(":");
            String dimensionName = key.substring(0, colonIndex);
            String dimensionValue = key.substring(colonIndex + 1);
            System.out.println(dimensionName);
            System.out.println(dimensionValue);
            if (dimensionValue.startsWith("i-")
                    || dimensionValue.startsWith("v-")
                    || dimensionValue.startsWith("ip-")
                    || dimensionValue.startsWith("rds-")) {
                //InstanceName = ;
            }
        }*/

        /*//提取短id以及InstanceId
        String[] dimensions = {"BlbId:i-xxx1;port:80","BlbId:er2","BlbId:v-xxx"};
        for (String dimensionStr : dimensions) {
            if (isShortId(dimensionStr)) {
                //String dimensionStr = "InstanceId:i-xxx;port:80";
                String Instance = getInstanceNameAndShorId(dimensionStr);
                System.out.println(Instance);
            }
        }*/

        /*//提取短id
        String[] dimensions = {"BlbId:i-xxx1;port:80","BlbId:er2","BlbId:v-xxx"};
        for (String dimensionStr : dimensions) {
            if (isShortId(dimensionStr)) {
                String Instance = getShorId(dimensionStr);
                System.out.println(Instance);
            }
        }*/

        /*//如何提取长id
        String[] dimensions = {"BlbId:i-xxx1;port:80","BlbId:er2","BlbId:v-xxx"};
        String namespace = "i-Y33H4Efk___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95";
        String metricSeriesVoName = getMetriSeriesVoName(dimensions,"BCE_BCC", "bj", namespace);
        System.out.println(metricSeriesVoName);*/

        /*//从namespace中提取长id和短id
        String namespace = "14627897-2845-427c-8326-ed8f492fd4cc___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95";
        String id = getIdfromNamespace(namespace);
        System.out.println(id);*/



       /* //获取 BlbId:er2222222
        String[] dimensions = {"BlbId:i-xxx1;port:80","BlbId:er2222222","BlbId:v-xxx"};
        String metricSeriesVoName = "";
        HashMap<String,String> idMap = new HashMap<>();
        idMap.put("i-xx2","er2222222");
        // 响应数据中的namespace全部都是短id，请求数据中的namespace有短id有长id，要按照请求数据中的信息进行回显

        String shortId = "i-xx2";
        for (String dimensionStr : dimensions) {
            if (dimensionStr.contains(shortId)) {
                metricSeriesVoName = dimensionStr;
                System.out.println(metricSeriesVoName);
            } else {
                String longId = idMap.get(shortId);
                if (dimensionStr.contains(longId)) {
                    metricSeriesVoName = dimensionStr;
                    System.out.println(metricSeriesVoName);
                }
            }
        }*/

       //stringBuilder.append("aaaaa");
       /*if (StringUtils.isEmpty(stringBuilder)) {
           System.out.println(stringBuilder);
       }
       String s = "aaa";
       if (StringUtils.isEmpty(s)) {
           System.out.println(s);
       }*/
       /* StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("111");
        if (stringBuilder.length() > 0
                && !"null".equals(stringBuilder.toString())
                && !"".equals(stringBuilder.toString())) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }

        StringBuilder requestNamespace = new StringBuilder();
        requestNamespace.append("1");
        if (requestNamespace.length() == 0
                || "null".equals(requestNamespace.toString())
                || "".equals(requestNamespace.toString())) {
            System.out.println("为空");
        } else {
            System.out.println("不为空");
        }*/


        String transformNamespace = "14627897-2845-427c-8326-ed8f492fd4cc___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95,14627897-2845-427c-8326-ed8f492fd4bb___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95,14627897___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95,ed8f492fd4cc___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95";
        List<CloudResource> cloudResourceList = new ArrayList<>();
        CloudResource cloudResource1 = new CloudResource("14627897-2845-427c-8326-ed8f492fd4cc___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        Dimension dimension1 = new Dimension("TRANSFORM_NAME","i-Y33H4Efk___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        Dimension dimension2 = new Dimension("ORIGINAL_NAME","14627897-2845-427c-8326-ed8f492fd4cc___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        cloudResource1.getProperties().add(dimension1);
        cloudResource1.getProperties().add(dimension2);
        cloudResourceList.add(cloudResource1);
        CloudResource cloudResource2 = new CloudResource("14627897-2845-427c-8326-ed8f492fd4bb___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        Dimension dimension3 = new Dimension("TRANSFORM_NAME","i-Y___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        Dimension dimension4 = new Dimension("ORIGINAL_NAME","14627897-2845-427c-8326-ed8f492fd4bb___bjfsg.BCE_BCC.f5c47c08d1c84ad9804061980deb7c95");
        cloudResource2.getProperties().add(dimension3);
        cloudResource2.getProperties().add(dimension4);
        cloudResourceList.add(cloudResource2);
        Map<String, String> idMap = new HashMap<>();
        StringBuilder transformedNamespace = new StringBuilder();

        //查找在transformnamespace中存在，在cloudResouceList中不存在的长id

        // 将用户输入的长id转换为短id

        String[] transformNamespaces = transformNamespace.split(",");
        List<CloudResource> cloudResourceTransformedList = new ArrayList<>();
        StringBuilder cloudResourceNotTransformedList = new StringBuilder();
        // 找出没有得到短id映射信息的长id，按照长id拼接
        if (cloudResourceList.size() != transformNamespaces.length) {
            for (String trans : transformNamespaces) {
                boolean flag = false;
                for (CloudResource cloud : cloudResourceList) {
                    if (cloud.getName().equalsIgnoreCase(trans)) {
                        flag = true;
                        cloudResourceTransformedList.add(cloud);
                    }
                }
                if (!flag) {
                    cloudResourceNotTransformedList.append(trans + ",");
                }
            }
        }
        transformedNamespace.append(cloudResourceNotTransformedList);
        // 得到短id映射信息的长id，按照短id拼接，并存储其映射关系
        for (CloudResource cloudResource : cloudResourceTransformedList) {
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
                if (StringUtils.isNotEmpty(shortId) && StringUtils.isNotEmpty(longId)) {
                    idMap.put(shortId, longId);
                }
            }
        }
        System.out.println(transformedNamespace);

    }

    private static String getIdfromNamespace(String namespace) {
        int index = namespace.indexOf("___");
        String id = namespace.substring(0,index);
        return id;
    }

    private static String getMetriSeriesVoName(String[] dimensions, String product, String region,
                                               String namespace) {
        String metricSeriesVoName = "";
        // 响应数据中的namespace全部都是短id，请求数据中的namespace有短id有长id，要按照请求数据中的信息进行回显
        //String namespace = mergedNamespaceMetricDatum.getNamespace();
        int shortIndex = namespace.indexOf("___");
        String shortId = namespace.substring(0, shortIndex);
        for (String dimensionStr : dimensions) {
            int dimensionIndexStart = dimensionStr.indexOf(":");
            int dimensionIndexEnd = dimensionStr.indexOf(";");
            String dimensionId = dimensionStr.substring(dimensionIndexStart, dimensionIndexEnd);
            if (shortId.equalsIgnoreCase(dimensionId)) {
                metricSeriesVoName = dimensionStr;
                return metricSeriesVoName;
            }
        }
        // dimensions全部遍历完毕后如果还没有找到对应的短id，说明请求数据中为长id，就将短id进行转换为长id与请求数据中的信息匹配
        // 也是按照请求数据中的信息进行回显，如："InstanceId:xxx"
        /*CloudResource cloudResource;
        if (region.equalsIgnoreCase("sin")) {
            cloudResource = transformSinService.getTransformId(product, "Instance",namespace);
        } else {
            cloudResource = transformService.getTransformId(product, "Instance", namespace);
        }
        for (Dimension dimension : cloudResource.getProperties()) {
            if (dimension.getName().equalsIgnoreCase(ORIGINAL_NAME)) {
                metricSeriesVoName = dimension.getValue();
            }
        }*/

        int longIdIndex = namespace.indexOf("___");
        String longId = namespace.substring(0, longIdIndex);
        for (String dimensionStr : dimensions) {
            String[] dimensionArr = dimensionStr.split(";");
            for (String dimension : dimensionArr) {
                int colonIndex = dimension.indexOf(":");
                String dimensionValue = dimension.substring(colonIndex + 1);
                if (dimensionValue.equalsIgnoreCase(longId)) {
                    metricSeriesVoName = dimensionStr;
                }
            }
        }
        return metricSeriesVoName;
    }



    private static boolean isShortId(String dimensionStr) {
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

    private static String getInstanceNameAndShorId(String dimensionStr) {
        String InstanceName = "";
        String[] dimensionArr = dimensionStr.split(";");
        for (String dimension : dimensionArr) {
            int colonIndex = dimension.indexOf(":");
            String dimensionName = dimension.substring(0, colonIndex);
            String dimensionValue = dimension.substring(colonIndex + 1);
            if (dimensionValue.startsWith("i-")
                    || dimensionValue.startsWith("v-")
                    || dimensionValue.startsWith("ip-")
                    || dimensionValue.startsWith("rds-")) {
                InstanceName = dimension;
            }
        }
        return InstanceName;
    }

    private static String getShorId(String dimensionStr) {
        String InstanceName = "";
        String[] dimensionArr = dimensionStr.split(";");
        for (String dimension : dimensionArr) {
            int colonIndex = dimension.indexOf(":");
            String dimensionName = dimension.substring(0, colonIndex);
            String dimensionValue = dimension.substring(colonIndex + 1);
            if (dimensionValue.startsWith("i-")
                    || dimensionValue.startsWith("v-")
                    || dimensionValue.startsWith("ip-")
                    || dimensionValue.startsWith("rds-")) {
                InstanceName = dimensionValue;
            }
        }
        return InstanceName;
    }

   /* private static String getLongId(String dimensionStr) {
        String LongId = "";
        String[] dimensionArr = dimensionStr.split(";");
        for (String dimension : dimensionArr) {
            int colonIndex = dimension.indexOf(":");
            String dimensionName = dimension.substring(0, colonIndex);
            String dimensionValue = dimension.substring(colonIndex + 1);
            if (dimensionValue.equalsIgnoreCase("er2")) {
                longId = dimension;
            }
        }
        return InstanceName;
    }*/




        private List<Dimension> getDimensions(String dimensions){
            // 验证dimensions
            List<Dimension> dimensionList = string2Dimension(dimensions);
            return dimensionList;
        }

        public List<Dimension> string2Dimension (String dimensions){
            List<Dimension> dimensionsList = new ArrayList<>();
            String[] splitArray = dimensions.split(";");
        /*if (splitArray.length > DS_SIZE_LIMIT) {
            throw new SystemException(INVALID_PARAMETER_VALUE, DIMENSIONS_LIST_LIMIT, DS_SIZE_LIMIT);
        }*/
            for (String dimension : splitArray) {
                String[] split = dimension.split(":");
            /*if (split.length != 2) {
                throw new SystemException(INVALID_PARAMETER_VALUE, DIMENSIONS_WRONG_FORMAT, DS_PATTERN);
            }*/
                Dimension tDimension = new Dimension();
                String name = split[0];
                tDimension.setName(name);
                String value = split[1];
                tDimension.setValue(value);
                dimensionsList.add(tDimension);
            }
            return dimensionsList;
        }



}







class CloudResource {

    private String userId;
    private String serviceName;
    private String typeName;
    private String name;
    private String region;
    private List<Dimension> identifiers = new ArrayList<>();
    private List<Dimension> tags = new ArrayList<>();
    private List<Dimension> properties = new ArrayList<>();

    public CloudResource() {
    }
    public CloudResource(String name) {
        this.name = name;
    }

    public CloudResource(String userId, String serviceName, String typeName, String name, String region,
                         List<Dimension> identifiers, List<Dimension> tags, List<Dimension> properties) {
        this.userId = userId;
        this.serviceName = serviceName;
        this.typeName = typeName;
        this.name = name;
        this.region = region;
        this.identifiers = identifiers;
        this.tags = tags;
        this.properties = properties;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Dimension> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Dimension> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Dimension> getTags() {
        return tags;
    }

    public void setTags(List<Dimension> tags) {
        this.tags = tags;
    }

    public List<Dimension> getProperties() {
        return properties;
    }

    public void setProperties(List<Dimension> properties) {
        this.properties = properties;
    }
}






