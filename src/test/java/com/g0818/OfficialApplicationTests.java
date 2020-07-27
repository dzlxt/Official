package com.g0818;


import com.g0818.Util.AuthUtil;
import com.g0818.mapper.UserMapper;
import com.g0818.pojo.admin.Users;
import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.invokeapi.Authentication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class OfficialApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testBcrypt(){
        String pwd = BCrypt.hashpw("654321",BCrypt.gensalt());
        //QueryWrapper qe = new QueryWrapper();
        //qe.eq("username","lxt");
        Users user = new Users();
        user.setUsername("admin");
        user.setPassword(pwd);
        user.setMoblephone("18081516663");
        userMapper.insert(user);
        System.out.println(pwd);
    }

    @Test
    void testnbiot(){

        String acc=null;
        String ssl=null;
        NorthApiClient northApiClient= AuthUtil.initApiClient();
        Authentication authentication = new Authentication(northApiClient);

        try {
            AuthOutDTO authOutDTO=authentication.getAuthToken();
            acc=authOutDTO.toString();
            if(acc!=null) {
                authentication.startRefreshTokenTimer();

            }
        } catch (NorthApiException e) {
            e.printStackTrace();
        }
        System.out.println(northApiClient.getClientInfo()+"*****"+acc+"******"+northApiClient.getVersion());
    }



}
