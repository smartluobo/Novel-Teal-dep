package com.ibay.mall.controller;

import com.ibay.mall.common.constant.CommonConstant;
import com.ibay.mall.common.exception.XmallUploadException;
import com.ibay.mall.pojo.common.Result;
import com.ibay.mall.utils.DateUtil;
import com.ibay.mall.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author allen
 */
@RestController
@Api(description = "图片上传统一接口")
public class ImageController {
	private static final Logger log = LoggerFactory.getLogger(ImageController.class);

	@Value("${IMAGE_SAVE_PATH}")
	private String imageSavePath;

	@RequestMapping(value = "/image/imageUpload", method = RequestMethod.POST)
	@ApiOperation(value = "WebUploader图片上传")
	public Result<String> uploadFile(@RequestParam("file") MultipartFile files, HttpServletRequest request) {

		String imagePath = null;
		if (files.isEmpty()) {
			throw new XmallUploadException("上传的文件不能为空");
		}
		try {
			imagePath = saveFile(files);
		} catch (Exception e) {
			log.error("文件上次失败");
		}
		return new ResultUtil<String>().setData(imagePath);
	}

//	@RequestMapping(value = "/kindeditor/imageUpload", method = RequestMethod.POST)
//	@ApiOperation(value = "KindEditor图片上传")
//	public KindEditorResult kindeditor(@RequestParam("imgFile") MultipartFile files, HttpServletRequest request) {
//
//		KindEditorResult kindEditorResult = new KindEditorResult();
//
//		if (files.isEmpty()) {
//			kindEditorResult.setError(1);
//			kindEditorResult.setMessage("上传文件不能为空");
//			return kindEditorResult;
//		}
//		// 转存文件
//		try {
//			String imagePath = saveFile(files);
//			kindEditorResult.setError(0);
//			kindEditorResult.setUrl(imagePath);
//			return kindEditorResult;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		kindEditorResult.setError(1);
//		kindEditorResult.setMessage("上传失败");
//		return kindEditorResult;
//	}

	/**
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public String saveFile(MultipartFile multipartFile) throws IOException {
        String secondDir = DateUtil.format(new Date(), "yyyyMM");
        long currentTime = System.currentTimeMillis();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String realFileName = currentTime + ext; // 新文件名

        File dest = new File(imageSavePath+File.separator+secondDir+File.separator + realFileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        multipartFile.transferTo(dest);
        String imageUrl = CommonConstant.IMAGE_URL_PREFIX+"/"+secondDir+"/"+realFileName;
		return imageUrl;
	}
}
