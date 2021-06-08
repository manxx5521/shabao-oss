package com.xiaoshabao.oss.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoshabao.oss.controller.util.PathConst;

/**
 * 文件预览
 * @author xv
 */
@Controller
@RequestMapping("/oss/preview")
public class PreviewController {
  
  @GetMapping
  public String preview(ModelMap model, HttpServletRequest request, HttpServletResponse response, String fileName) {
    return "/preview/pdf";
  }
  
  @GetMapping("/file.pdf")
  public void getPreviewFile( HttpServletRequest request, HttpServletResponse response, String fileName) {
    String filePath = PathConst.getBasePath()+File.separator+"demo_pdf.pdf";
    response.reset();
    response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    response.setCharacterEncoding(Charset.forName("utf-8").displayName());
    response.setHeader("Content-Disposition", "attachment;filename=" + FilenameUtils.getName(filePath));
    try (
      BufferedInputStream bis= new BufferedInputStream(new FileInputStream(filePath));
      OutputStream os=response.getOutputStream();) {
      IOUtils.copy(bis, os);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
 
    
 


}
