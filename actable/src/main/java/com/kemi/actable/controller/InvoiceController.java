package com.kemi.actable.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.ocr_api20210707.Client;
import com.aliyun.ocr_api20210707.models.RecognizeInvoiceRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.kemi.actable.entity.InvoiceDetail;
import com.kemi.actable.entity.Invoices;
import com.kemi.actable.mapper.InvoiceMapper;
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
 * @date 2023/08/27  20:58
 */

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceMapper invoiceMapper;

    public void insertInvoices(JSONObject invoiceData) {
        Invoices invoices = new Invoices();
        invoices.setInvoiceNumber(invoiceData.getString("invoiceNumber"));
        invoices.setInvoiceCode(invoiceData.getString("invoiceCode"));
        invoices.setInvoiceType(invoiceData.getString("invoiceType"));
        invoices.setInvoiceDate(invoiceData.getString("invoiceDate"));
        invoices.setCheckCode(invoiceData.getString("checkCode"));
        invoices.setMachineCode(invoiceData.getString("machineCode"));
        invoices.setDrawer(invoiceData.getString("drawer"));
        invoices.setReviewer(invoiceData.getString("reviewer"));
        invoices.setRecipient(invoiceData.getString("recipient"));
        invoices.setPasswordArea(invoiceData.getString("passwordArea"));
        invoices.setSellerName(invoiceData.getString("sellerName"));
        invoices.setSellerTaxNumber(invoiceData.getString("sellerTaxNumber"));
        invoices.setSellerBankAccountInfo(invoiceData.getString("sellerBankAccountInfo"));
        invoices.setSellerContactInfo(invoiceData.getString("sellerContactInfo"));
        invoices.setPurchaserName(invoiceData.getString("purchaserName"));
        invoices.setPurchaserTaxNumber(invoiceData.getString("purchaserTaxNumber"));
        invoices.setTotalAmountInWords(invoiceData.getString("totalAmountInWords"));
        invoices.setTotalAmount(invoiceData.getDouble("totalAmount"));
        invoices.setInvoiceAmountPreTax(invoiceData.getDouble("invoiceAmountPreTax"));
        invoices.setInvoiceTax(invoiceData.getDouble("invoiceTax"));

//         发票详情
        List<InvoiceDetail> invoiceDetails = new ArrayList<>();
        JSONArray details = invoiceData.getJSONArray("invoiceDetails");
        for (int i = 0; i < details.length(); i++) {
            JSONObject detail = details.getJSONObject(i);
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setItemName(detail.getString("itemName"));
            invoiceDetail.setAmount(detail.getDouble("amount"));
            invoiceDetail.setQuantity(detail.getInt("quantity"));
            invoiceDetail.setUnitPrice(detail.getDouble("unitPrice"));
            invoiceDetail.setSpecification(detail.getString("specification"));
            invoiceDetail.setUnit(detail.getString("unit"));
            invoiceDetail.setAmount(detail.getDouble("amount"));
            invoiceDetail.setTaxRate(detail.getString("taxRate"));
            invoiceDetail.setTax(detail.getString("tax"));

            invoiceDetails.add(invoiceDetail);
        }
        invoices.setInvoiceDetails(invoiceDetails);
//        System.out.println(invoiceDetails);
        // 插入 Invoices 表中的数据
        invoiceMapper.insert(invoices);
// 获取刚刚插入的记录的 ID
        Long invoiceId = invoices.getId();
//        System.out.println("-------------------------");
//        System.out.println(invoiceId);
//        System.out.println("------------------------");

// 遍历 invoiceDetails 列表
        for (InvoiceDetail invoiceDetail : invoices.getInvoiceDetails()) {
            // 设置 Invoice_ID 属性
            invoiceDetail.setInvoice_ID(Math.toIntExact(invoiceId));
            // 插入 InvoiceDetails 表中的数据
            invoiceMapper.insertInvoiceDetail(invoiceDetail);
        }

    }

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId("LTAI5t9ifN6vhWJaEqpm69Y4")
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret("dKDdLe0IVEzeUIUK0uFgbmmojUhZfT");
        // Endpoint 请参考 https://api.aliyun.com/product/ocr-api
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new Client(config);
    }

    @RequestMapping("reg")
    public String recognition(MultipartFile file) {
        try {
            // Check if the image folder exists, and create it if it does not exist
            File imageFolder = new File("C:\\Users\\lenovo\\Desktop\\actable\\src\\main\\resources\\static\\image");
            if (!imageFolder.exists()) {
                imageFolder.mkdir();
            }

            // Save the uploaded file to the local image folder on your machine
            String fileName = file.getOriginalFilename();
            File dest = new File(imageFolder, fileName);
            file.transferTo(dest);

            Client client = createClient(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"), System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
            RecognizeInvoiceRequest recognizeInvoiceRequest = new RecognizeInvoiceRequest()
                    .setUrl("https://0ac8-210-30-104-106.ngrok-free.app/image/" + fileName);
            System.out.println(fileName);
            // 复制代码运行请自行打印 API 的返回值
            com.aliyun.ocr_api20210707.models.RecognizeInvoiceResponse response = client.recognizeInvoiceWithOptions(recognizeInvoiceRequest, new com.aliyun.teautil.models.RuntimeOptions());
//            System.out.println(com.aliyun.teautil.Common.toJSONString(response).toString());
            JSONObject data = new JSONObject(com.aliyun.teautil.Common.toJSONString(response).toString());
            JSONObject data1 = new JSONObject(data.getJSONObject("body").getString("data"));
            JSONObject invoiceData = data1.getJSONObject("data");

//// 发票号码
//            System.out.println(invoiceData.getString("invoiceNumber"));
//// 发票种类
//            System.out.println(invoiceData.getString("invoiceType"));
//// 校验码
//            System.out.println(invoiceData.getString("checkCode"));
//// 大写金额
//            System.out.println(invoiceData.getString("totalAmountInWords"));
//// 发票税额
//            System.out.println(invoiceData.getString("invoiceTax"));
//// 不含税金额
//            System.out.println(invoiceData.getString("invoiceAmountPreTax"));
//// 购买方名称
//            System.out.println(invoiceData.getString("purchaserName"));
//// 购买方税号
//            System.out.println(invoiceData.getString("purchaserTaxNumber"));
//// 购买方地址、电话
//            System.out.println(invoiceData.getString("purchaserContactInfo"));
//// 购买方开户行及账号
//            System.out.println(invoiceData.getString("purchaserBankAccountInfo"));
//// 销售方名称
//            System.out.println(invoiceData.getString("sellerName"));
//// 销售方税号
//            System.out.println(invoiceData.getString("sellerTaxNumber"));
//// 销售方地址、电话
//            System.out.println(invoiceData.getString("sellerContactInfo"));
//// 销售方开户行及账号
//            System.out.println(invoiceData.getString("sellerBankAccountInfo"));
//// 发票类型
//            System.out.println(invoiceData.getString("invoiceType"));

// 发票详情
            JSONArray invoiceDetails = invoiceData.getJSONArray("invoiceDetails");
            for (int i = 0; i < invoiceDetails.length(); i++) {
                JSONObject detail = invoiceDetails.getJSONObject(i);
//                System.out.println(detail.getString("itemName") + ": " + detail.getString("amount") + "元");
            }
            insertInvoices(invoiceData);
            return com.aliyun.teautil.Common.toJSONString(response);
        } catch (TeaException error) {
            // 如有需要，请打印 error
            return error.message;
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            return error.message;
        }
    }
}
