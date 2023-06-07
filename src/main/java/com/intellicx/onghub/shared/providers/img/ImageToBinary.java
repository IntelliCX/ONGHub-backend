package com.intellicx.onghub.shared.providers.img;

import org.bouncycastle.util.encoders.Base64;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;

public class ImageToBinary {
    public static SerialBlob execute(String base64Image) throws SQLException {
        byte[] imageData = Base64.decode(base64Image);
        return new SerialBlob(imageData);
    }
}
