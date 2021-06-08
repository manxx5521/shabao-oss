package com.xiaoshabao.oss.controller.util;

/**
 * 路径处理
 * @author xv
 *
 */
public class PathConst {
  
  public static String getBasePath() {
    return PathConst.class.getResource("/static/demo").getPath();
  }
  
  

}
