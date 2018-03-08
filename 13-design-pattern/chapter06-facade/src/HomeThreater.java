/**
 *  这就是 门面
 *              遥控器
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class HomeThreater {
    
    private DVDPlayer dvdPlayer = new DVDPlayer();
    private Stereo stereo = new Stereo(); //印象
    
    public void ready() {
        stereo.open();
        dvdPlayer.open();
    }
    
    public void play() {
        dvdPlayer.play();
    }
    
    public void end() {
        dvdPlayer.end();
        stereo.end();
    }
}
