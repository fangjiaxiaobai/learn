/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 *
 * 项目需求，家庭电影院，大概有一个这样的过程
直接用遥控器：统筹各设备开关
开投影仪
开音响
开DVD，选dvd
播放
观影结束后，关闭各种设备
 */
public class DemoTest {
    
    
    public static void main(String[] args) {
        HomeThreater homeThreater = new HomeThreater() ;
        homeThreater.ready();
        homeThreater.play();
        homeThreater.end();
    }
    
}
