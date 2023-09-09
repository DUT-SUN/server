package com.kemi.actable.controller;

import com.kemi.actable.entity.Initerary;
import com.kemi.actable.entity.IniteraryRecord;
import com.kemi.actable.mapper.IniteraryMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/07  21:48
 */


@RestController
public class IniteraryController {
    @Autowired
    private IniteraryMapper initeraryMapper;

    public void insertIniterary(JSONObject initeraryData) {
        Initerary initerary = new Initerary();
        initerary.setServiceProvider(initeraryData.getString("serviceProvider"));
        initerary.setApplicationDate(initeraryData.getString("applicationDate"));
        initerary.setStartTime(initeraryData.getString("startTime"));
        initerary.setEndTime(initeraryData.getString("endTime"));
        initerary.setPhoneNumber(initeraryData.getString("phoneNumber"));
        initerary.setTotalAmount(initeraryData.getDouble("totalAmount"));

        // 行程记录
        List<IniteraryRecord> rideRecords = new ArrayList<>();
        JSONArray records = initeraryData.getJSONArray("rideDetails");
        for (int i = 0; i < records.length(); i++) {
            JSONObject record = records.getJSONObject(i);
            IniteraryRecord rideRecord = new IniteraryRecord();
            rideRecord.setNumber(record.getInt("Number"));
            rideRecord.setAmount(record.getDouble("amount"));
            rideRecord.setCarType(record.getString("carType"));
            rideRecord.setCity(record.getString("city"));
            rideRecord.setEndPlace(record.getString("endPlace"));
            rideRecord.setMileage(record.getDouble("mileage"));
            rideRecord.setPickUpTime(record.getString("pickUpTime"));
            rideRecord.setRemarks(record.getString("remarks"));
            rideRecord.setStartPlace(record.getString("startPlace"));

            rideRecords.add(rideRecord);
        }
        initerary.setRideRecords(rideRecords);

        // 插入 initerary 表中的数据
        initeraryMapper.insert(initerary);
        // 获取刚刚插入的记录的 ID
        Long initeraryId = initerary.getId();

        // 遍历 rideRecords 列表
        for (IniteraryRecord rideRecord : initerary.getRideRecords()) {
            // 设置 Initerary_ID 属性
            rideRecord.setIniterary_ID(Math.toIntExact(initeraryId));
            // 插入 IniteraryRecord 表中的数据
            initeraryMapper.insertIniteraryRecord(rideRecord);
        }
    }

    public static com.aliyun.ocr_api20210707.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId("LTAI5t9oPj9bRf8MiJeD1rrk")
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret("9PcJ9d1x3P7lPwcnTAOrJ1oyTogV2k");
        // Endpoint 请参考 https://api.aliyun.com/product/ocr-api
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

    /**
     * 使用STS鉴权方式初始化账号Client，推荐此方式。
     * @param accessKeyId
     * @param accessKeySecret
     * @param securityToken
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.ocr_api20210707.Client createClientWithSTS(String accessKeyId, String accessKeySecret, String securityToken) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("LTAI5tABzPM1cuBNHUtQ8b4C")
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret("PX57qwUMNJ97hCyLXPB0y5CTR4fpVI")
                // 必填，您的 Security Token
                .setSecurityToken("dpjr11Bjmkr84_5w-wYwYOR76viX2TKT1WjBOpXhKLOkZ9w-KpAVTB65KzeUYT6wReVJVM5VO9XWZ3NJ-i5CKTOk-HYDmI9nZUxnqs8f16d5N9_7-D7FaM_5Y9neK9fLeBw8lTBJvHV_1Hr1eTI8T-eflSGg03F815Z_fzDDY7P1AqwYkGz6jRo8feVGIIjW_7SOmRNbTDiC0KVdwTzSdnWeUURGUsYB8OSK9K2aiMQrt28kHKR_3-kkSkEV.")
                // 必填，表明使用 STS 方式
                .setType("sts");
        // Endpoint 请参考 https://api.aliyun.com/product/ocr-api
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }
    @RequestMapping("/initerary")
    public String main1(MultipartFile file) throws Exception {
        // Check if the image folder exists, and create it if it does not exist
        File imageFolder = new File("C:\\Users\\lenovo\\Desktop\\actable\\src\\main\\resources\\static\\image");
        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }

        // Save the uploaded file to the local image folder on your machine
        String fileName = file.getOriginalFilename();
        File dest = new File(imageFolder, fileName);
        file.transferTo(dest);

        // 请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID 和 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        com.aliyun.ocr_api20210707.Client client = IniteraryController.createClient(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"), System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
        com.aliyun.ocr_api20210707.models.RecognizeRideHailingItineraryRequest recognizeRideHailingItineraryRequest = new com.aliyun.ocr_api20210707.models.RecognizeRideHailingItineraryRequest()
                .setUrl(" https://f651-2001-da8-a800-afc0-3996-6168-2f18-1b96.ngrok-free.app/image/" + fileName);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        com.aliyun.ocr_api20210707.models.RecognizeRideHailingItineraryResponse resp = client.recognizeRideHailingItineraryWithOptions(recognizeRideHailingItineraryRequest, runtime);
        System.out.println(fileName);
        String respStr = com.aliyun.teautil.Common.toJSONString(resp);

        // 将接口返回的数据转换为 JSONObject 对象
        JSONObject initeraryData = new JSONObject(respStr);
        // 调用 insertIniterary 方法将数据存入数据库
        JSONObject data1 = new JSONObject(initeraryData .getJSONObject("body").getString("data"));
        JSONObject initeraryData1 = data1.getJSONObject("data");
        insertIniterary(initeraryData1);
        return respStr;
    }

}

