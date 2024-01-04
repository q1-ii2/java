package flyingbird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
//     定义地面图片
    public BufferedImage image;
    int x,y;
    public Ground(){
        try {
            image = ImageIO.read(getClass().getResource("ground.png"));
            x=0;
            y=500;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片未找到");
        }
    }
//   地面滚动
    public void step(){
        x--;
//          向左移动到一个位置时，让它返回原位
        if(x==-100){
            x=0;
        }
    }
}
