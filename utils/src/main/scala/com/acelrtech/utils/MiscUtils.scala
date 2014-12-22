package com.acelrtech.utils

object MiscUtils {
  def stackTrace(exp: Throwable): String = {
    import java.io.PrintWriter
    import java.io.StringWriter
    
    val sw: StringWriter = new StringWriter();
    val pw: PrintWriter = new PrintWriter(sw)
    exp.printStackTrace(pw)
    sw.toString()
  }
}
