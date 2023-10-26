package com.zongshe.web;

import com.zongshe.dao.FaceDao;
import com.zongshe.pojo.User;
import com.zongshe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.DatatypeConverter;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;

@RestController
public class FaceController {

    @Autowired
    private UserService userService;
    @Autowired
    private FaceDao faceDao;

    @PostMapping("/face")
    public void handleImage(@RequestBody ImageData data) throws Exception {
        // 将Base64编码的图片数据转换为字节数组
        byte[] bytes = DatatypeConverter.parseBase64Binary(data.getImage());

        // 将字节数组转换为Blob
        Blob blob = new SerialBlob(bytes);

        // 获取手机号码
        String phoneNumber = data.getPhoneNumber();
        User user = userService.getUser(phoneNumber);
        faceDao.insert_face(user.getId(), blob, phoneNumber);
        // 保存Blob和手机号码到数据库，这里你需要根据你的数据库和数据模型来进行操作
        // 例如：
        // ImageModel imageModel = new ImageModel();
        // imageModel.setImage(blob);
        // imageModel.setPhoneNumber(phoneNumber);
        // imageRepository.save(imageModel);
    }

    public static class ImageData {
        private String image;
        private String phoneNumber;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}