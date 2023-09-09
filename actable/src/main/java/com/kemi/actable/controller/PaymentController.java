package com.kemi.actable.controller;

import com.aliyun.ocr_api20210707.models.RecognizeFoodManageLicenseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aliyun.tea.*;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.ocr_api20210707.models.RecognizeInvoiceRequest;
import java.io.File;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/09/09  0:24
 */
@RestController
public class PaymentController {
    @Autowired
    private IniteraryController initeraryController;
    @RequestMapping("/payment")
    public static String main1(MultipartFile file) throws Exception {
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
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例使用环境变量获取 AccessKey 的方式进行调用，仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        com.aliyun.ocr_api20210707.Client client = IniteraryController.createClient(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"), System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
        com.aliyun.ocr_api20210707.models.RecognizeGeneralRequest recognizeGeneralRequest = new com.aliyun.ocr_api20210707.models.RecognizeGeneralRequest()
                .setUrl("https://f651-2001-da8-a800-afc0-3996-6168-2f18-1b96.ngrok-free.app/image/" + fileName);
        System.out.println(fileName);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        com.aliyun.ocr_api20210707.models.RecognizeGeneralResponse resp = client.recognizeGeneralWithOptions(recognizeGeneralRequest, runtime);
        String respStr = com.aliyun.teautil.Common.toJSONString(resp);
        System.out.println(respStr);
        return respStr;
    }
}
