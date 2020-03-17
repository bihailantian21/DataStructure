package com.zcr.test;

import java.util.ArrayList;
import java.util.List;

/**
 * BCC监控长短id修复
 */
public class MonitorIdResponse {


    List<ServerInfo> result;
    int totalCount ;

    public static class ServerInfo {
        private Long id;
        private int shortId ;
        private int longId ;
        private int userId ;
        private int resourceType ;
        private List<Dimension> properties = new ArrayList<>();
        private List<Dimension> tags = new ArrayList<>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getShortId() {
            return shortId;
        }

        public void setShortId(int shortId) {
            this.shortId = shortId;
        }

        public int getLongId() {
            return longId;
        }

        public void setLongId(int longId) {
            this.longId = longId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public List<Dimension> getProperties() {
            return properties;
        }

        public void setProperties(List<Dimension> properties) {
            this.properties = properties;
        }

        public List<Dimension> getTags() {
            return tags;
        }

        public void setTags(List<Dimension> tags) {
            this.tags = tags;
        }

        @Override
        public String toString() {
            return "ServerInfo{" +
                    "id=" + id +
                    ", shortId=" + shortId +
                    ", longId=" + longId +
                    ", userId=" + userId +
                    ", resourceType=" + resourceType +
                    ", properties=" + properties +
                    ", tags=" + tags +
                    '}';
        }
    }

    public List<ServerInfo> getResult() {
        return result;
    }

    public void setResult(List<ServerInfo> result) {
        this.result = result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "MonitorIdResponse{" +
                "result=" + result +
                ", totalCount=" + totalCount +
                '}';
    }

    public static void main(String[] args) {

            MonitorIdResponse.ServerInfo  model = new MonitorIdResponse.ServerInfo();
            model.setLongId(1);
            model.setShortId(2);
            model.setUserId(4);
            model.setResourceType(5);
            List<Dimension> tags = new ArrayList<>();
            Dimension osTag = new Dimension();
            osTag.setName("osType");
            osTag.setValue("Linux");
            tags.add(osTag);
            Dimension pciTtag = new Dimension();
            pciTtag.setName("pciType");
            pciTtag.setValue("sd");
            tags.add(pciTtag);
           /* if (InstanceType.KUNLUN_BCC.getIndex() == serverPO.getInstanceType()) {
                pciTtag.setValue(InstanceType.KUNLUN_BCC.getBillingValue());
                tags.add(pciTtag);
            } else if(InstanceType.GPU_BCC.getIndex() == serverPO.getInstanceType()) {
                pciTtag.setValue(InstanceType.GPU_BCC.getBillingValue());
                tags.add(pciTtag);
            }*/
            model.setProperties(new ArrayList<Dimension>());
            model.setTags(tags);

        System.out.println(model);
    }
}
