package com.weweb.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by wshen on 5/17/2017.
 */
public class FileUtils {
	public static List<FileEntity> upload(HttpServletRequest request, String filePath)
			throws IOException, ServletException {
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();
		List<FileEntity> fileEntities = new ArrayList<>();
		Set<Map.Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
		File dir = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		for (Map.Entry<String, MultipartFile> entry : entrySet) {
			FileEntity fileEntity = new FileEntity();
			fileEntity.setKey(entry.getKey());
			fileEntity.setFileName(saveFile(entry.getValue(), filePath));
			fileEntities.add(fileEntity);
		}
		return fileEntities;
	}

	private static String saveFile(MultipartFile file, String filePath) throws IOException {
		String fileName = UUID.randomUUID().toString() + getExtension(file.getOriginalFilename());
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath + fileName)));
		out.write(file.getBytes());
		out.flush();
		out.close();
		return fileName;
	}

	private static String getExtension(String fileName) {
		return Optional.of(fileName).get().substring(fileName.lastIndexOf("."));
	}

	public static class FileEntity {
		private String key;
		private String fileName;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	}
}
