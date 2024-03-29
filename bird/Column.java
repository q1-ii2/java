package flyingbird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 1.每两个管道一出现
 * 2.管道出现随机位置
 * 3.图层问题
 */
public class Column {
//    管道图片
    public BufferedImage cImage;
//    坐标
    int x,y;
//    高度和宽度
    int width,height;
//    管道个数
    static int count=0;
//    两个管道之间的距离
    int distance=270;
//    随机值
    Random random=new Random();
//     管道缝隙
    int gap=144;
    public Column(){
        try {
            cImage = ImageIO.read(getClass().getResource("column.png"));
            width=cImage.getWidth();
            height=cImage.getHeight();
//            第x个管道：450+distance*count x为管道个数
            x=450+distance*count;
//            y坐标：-500~-200随机数从0开始
            y=random.nextInt(300)+100-height/2;
        } catch (IOException e) {
            e.printStackTrace();
        }
//        控制管道操作
        count++;
    }
//        管道移动
        public void step(){
//            从右往左移动
        x--;
//        从第一个管道---第三个管道
        if(x==width/2){
            x=x+distance*2;
            y=random.nextInt(300)+100-height/2;
        }
        }
}
