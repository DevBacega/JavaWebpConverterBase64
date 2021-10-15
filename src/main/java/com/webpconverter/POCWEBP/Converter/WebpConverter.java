package com.webpconverter.POCWEBP.Converter;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class WebpConverter {

    public void TransformImageToWebpBase64() {
        String IMAGE_URL = "https://moneyinvest.com.br/wp-content/uploads/2021/04/dogecoin-doge-alta-tiktok-desafio-challenge-valorizacao-preco-rali-sckit-1024x618-1.jpg";
        try {
            File image = this.DownloadImage(IMAGE_URL);
            Converter convert = new Converter(image.getAbsolutePath());
            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Webp);
            File webpTemp = File.createTempFile("TempImageWebp",".webp") ;
            String path = webpTemp.getPath();
            convert.convert(path, options);
            String base64 = ConvertImageToBase64(webpTemp);
            System.out.println("YOUR BASE64 STRING:"+base64);
            image.delete();
            webpTemp.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File DownloadImage( String URL ) throws IOException {
        URL imageURL = new URL(URL);
        File image = File.createTempFile("TempImage", ".png");
        FileUtils.copyURLToFile(imageURL, image);
        return image;
    }

    public String ConvertImageToBase64(File image) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
