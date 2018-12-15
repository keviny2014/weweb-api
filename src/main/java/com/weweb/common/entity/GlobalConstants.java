package com.weweb.common.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wshen on 5/17/2017.
 */
@ConfigurationProperties("constants")
@Component
public class GlobalConstants {
	public static String uploadItemForumImagePath;
	public static String showItemForumImagePath;;
	public static String imageServerPath;
	public static void setImageServerPath(String imageServerPath) {
		GlobalConstants.imageServerPath = imageServerPath;
	}

	public static void setUploadItemForumImagePath(String uploadItemForumImagePath) {
		GlobalConstants.uploadItemForumImagePath = uploadItemForumImagePath;
	}

	public static void setShowItemForumImagePath(String showItemForumImagePath) {
		GlobalConstants.showItemForumImagePath = showItemForumImagePath;
	}
}
