package com.zcr.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSwitch {

    public static List<Dimension> generateDimensions(String appName, String instanceName) {
        List<Dimension> dimensionList = new ArrayList<>();
        Dimension dimension = new Dimension();
        String dimensionName = "";
        switch (appName) {
            default:
                dimensionName = "InstanceId";
                break;
            case "BCE_CDS":
                dimensionName = "VolumeId";
                break;
            case "BCE_BOS":
                dimensionName = "BucketId";
                break;
            case "BCE_CFS":
                dimensionName = "FsId";
                break;
            case "BCE_SERVICE_ENDPOINT":
                dimensionName = "EndpointId";
                break;
            case "BCE_ENIC":
                dimensionName = "TapId";
                break;
            case "BCE_VPN":
                dimensionName = "ConnID";
                break;
            case "BCE_BLS":
                dimensionName = "TaskId";
                break;
            case "BCE_BMR":
                dimensionName = "ClusterId";
                break;
            case "BCE_BSC":
                dimensionName = "JobId";
                break;
            case "BCE_CBD":
                dimensionName = "WorkspaceId";
                break;
        }
        dimension.setName(dimensionName);
        dimension.setValue(instanceName);
        dimensionList.add(dimension);
        return dimensionList;
    }

    public static void main(String[] args) {
        List<Dimension> result = generateDimensions("BCE_BCC","12345");
        System.out.println(Arrays.toString(result.toArray()));
    }
}
