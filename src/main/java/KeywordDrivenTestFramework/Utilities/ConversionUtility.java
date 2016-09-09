/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KeywordDrivenTestFramework.Utilities;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;

import static java.lang.System.out;
/**
 *
 * @author Brendan
 */
public class ConversionUtility
{
    public String convertPNGToBase64(String imageFilePath)
    {
        String base64ReturnString = "";

        try
        {
            out.println("[INFO] Converting error screenshot to Base64 format...");
            File image = new File(imageFilePath);

            FileInputStream imageInputStream = new FileInputStream(image);

            byte imageByteArray[] = new byte[(int) image.length()];

            imageInputStream.read(imageByteArray);

            base64ReturnString = Base64.encodeBase64String(imageByteArray);

            out.println("[INFO] Converting completed, image ready for embedding.");
        }
        catch(Exception ex)
        {
            out.println("[ERROR] Failed to convert image to Base64 format - " + ex.getMessage());
        }

        return base64ReturnString;
    }
}
