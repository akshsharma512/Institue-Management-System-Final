package com.bmpl.ims.users.views;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.bmpl.ims.common.dao.CommonDAO;

interface WriteImage {
	String path = "";

	public static String dosave(String imageUrl, String filename) throws IOException {
		String newpath = CommonDAO.getFilePath();
		String destfile = newpath + "IMS" + File.separator + "Images" + File.separator;
		System.out.println(destfile);

		String path = "";
		String ext = "";
		BufferedImage image = null;
		File url = new File(imageUrl);
		image = ImageIO.read(url);
		System.out.println("Inside do save method");
		if (imageUrl.contains(".jpg")) {
			ImageIO.write(image, "jpg", new File(destfile + filename + ".jpg"));
			ext = ".jpg";
		} else if (imageUrl.contains(".jpeg")) {
			ImageIO.write(image, "jpeg", new File(destfile + filename + ".jpeg"));
			ext = ".jpeg";
		} else {
			ImageIO.write(image, "png", new File(destfile + filename + ".png"));
			ext = ".png";
		}

		File f = new File(destfile + filename + ext);
		File.pathSeparator.replaceAll(File.pathSeparator, File.pathSeparator);
		path = f.getAbsolutePath();

		return path.substring(path.indexOf("IMS"));

	}
}