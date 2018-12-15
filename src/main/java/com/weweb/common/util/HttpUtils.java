package com.weweb.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wshen on 2016/10/31.
 */

public class HttpUtils {
	private static Logger logger = LoggerFactory.getLogger("HttpUtils");

	public static String uploadRemoteFile(String url,Map<String,String> headers,Map<String,String> parameters,Map<String,File> files,String fileName) throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		String json=null;
		try {
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			headers.entrySet().forEach(s->httpPost.setHeader(s.getKey(),s.getValue()));
			parameters.entrySet().forEach(s->builder.addTextBody(s.getKey(),s.getValue()));
			files.entrySet().forEach(s->builder.addBinaryBody(s.getKey(),s.getValue(),ContentType.MULTIPART_FORM_DATA,null));
			HttpEntity multipart = builder.build();
			httpPost.setEntity(multipart);
			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity httpEntity=response.getEntity();
			json=EntityUtils.toString(httpEntity);
		}catch (IOException e){
			logger.error("uploadRemoteFile",e);
		}finally {
			client.close();
		}
		return json;
	}

}
