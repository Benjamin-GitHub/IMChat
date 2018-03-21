package com.ztesoft.controller;

import com.ztesoft.model.Response;
import com.ztesoft.util.common.Constants;
import com.ztesoft.util.exception.ExceptionUtil;
import com.ztesoft.util.json.GsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lym on 2018/3/19.
 */
@RestController
public class ImFileController {

    private static final Logger logger = Logger.getLogger(ImFileController.class);

    //默认文件保存路径
    @Value("${fileUpload.defaultUploadPath}")
    private String defaultUploadPath;

    //文件服务器地址前缀
    // - 使用tomcat或其他容器另外搭建的文件服务器（推荐，大文件可断点续传，视频可从任意地方开始播放）
    // - 使用下面定义的/download/file/接口提供下载服务(不用另外部署文件服务器，但不推荐，只适合图片或小文件)
    @Value("${fileUpload.fileServerUrl}")
    private String fileServerUrl;


    /**
     * 上传单个文件
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload/file")
    public String uploadFile(MultipartFile file, HttpServletRequest request) throws Exception {
        Map dataMap = new HashMap<>();

        if (file != null) {
            //取得当前上传文件的文件名称
            String fileName = file.getOriginalFilename();

            //如果名称不为“”,说明该文件存在，否则说明该文件不存在
            if (fileName.trim() != "") {
                //定义上传路径
                try {
                    //以日期、用户名、UUID建文件夹，避免文件数量超过linux系统限制+避免同名文件互相覆盖
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    String dateStr = sdf.format(new Date());
                    String userName = request.getHeader("userName");
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");

                    String folderPath = dateStr + "/" + userName + "/" + uuid + "/";
                    File fileDir = new File(defaultUploadPath + folderPath);
                    if (!fileDir.exists()) { //如果不存在 则创建
                        fileDir.mkdirs();
                    }

                    //存文件
                    String filePath = defaultUploadPath + folderPath + fileName;
                    File localFile = new File(filePath);
                    logger.info("开始保存用户" + userName + "上传的文件到路径: " + filePath);
                    file.transferTo(localFile);

                    dataMap.put("src", fileServerUrl + folderPath + fileName);
                    dataMap.put("name", fileName);
                    logger.info("文件保存成功" + GsonUtils.toJson(dataMap));

                } catch (Exception e) {
                    logger.error("保存文件失败", e);
                    return feedback(Constants.INF_CODE_ERROR, Constants.INF_DESC_ERROR, ExceptionUtil.getMessage(e));
                }
            }
        }
        return feedback(Constants.INF_CODE_SUCC, Constants.INF_DESC_SUCC, dataMap);
    }


    /**
     * 上传多个文件
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/upload/files")
    public String uploadFiles(HttpServletRequest request) throws Exception {
        List<Response> resultList = new ArrayList<>();

        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());

                if (file != null) {
                    Response response = GsonUtils.toObject(uploadFile(file, request), Response.class);
                    resultList.add(response);
                }
            }
        }
        return feedback(Constants.INF_CODE_SUCC, Constants.INF_DESC_SUCC, resultList);
    }


    private String feedback(String code,String desc,Object obj){
        Response response = new Response();
        response.setCode(code);
        response.setResultDesc(desc);
        response.setData(obj);
        return GsonUtils.toJson(response);
    }


    /**
     * 下载文件
     *
     * @param dateStr
     * @param userName
     * @param uuid
     * @param fileName
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/download/file/{dateStr}/{userName}/{uuid}/{fileName:.+}")
    public void downloadFile(@PathVariable("dateStr") String dateStr, @PathVariable("userName") String userName,
                             @PathVariable("uuid") String uuid, @PathVariable("fileName") String fileName,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        if (".".equals(dateStr) || ".".equals(userName) || ".".equals(uuid) ||
                "..".equals(dateStr) || "..".equals(userName) || "..".equals(uuid)) {
            //特殊文件路径，不允许访问
            throw new Exception("ILLEGAL ACCESS!");
        }

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            String folderPath = dateStr + "/" + userName + "/" + uuid + "/";
            String filePath = defaultUploadPath + folderPath + fileName;
            bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (Exception e) {
            logger.error("读取文件失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (Exception e) {
                    logger.error("输入流关闭失败");
                }
            }
        }
    }
}
